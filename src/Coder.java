import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Coder {
	private ArrayList<String> reference = new ArrayList<>();
	private String filename = "Reference.txt";

	{
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while (br.ready()) {
				reference.add(br.readLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String encode(String plainText) {
		String encodedText = "";
		while (!reference.contains(encodedText)) {
			System.out.println(reference.toString());
			encodedText = Keyboard.readString("Please enter a letter to encode using letters above: ");
		}
		
		int indexOffset = reference.indexOf(encodedText);
		int newIndexCurrentChar;

		for (int i = 0; i < plainText.length(); i++) {
			int indexCurrentChar = reference.indexOf(plainText.charAt(i) + "");

			if (indexCurrentChar < 0) {
				encodedText = encodedText + plainText.charAt(i);
			} else {
				newIndexCurrentChar = indexCurrentChar - indexOffset;

				if (newIndexCurrentChar < 0) {
					newIndexCurrentChar = reference.size() + newIndexCurrentChar;
					encodedText = encodedText + reference.get(newIndexCurrentChar);

				} else if (newIndexCurrentChar >= reference.size()) {
					newIndexCurrentChar = newIndexCurrentChar - reference.size();
					encodedText = encodedText + reference.get(newIndexCurrentChar);

				} else {
					encodedText = encodedText + reference.get(newIndexCurrentChar);
				}
			}
		}

		return encodedText;
	}

	public String decode(String encodedText) {
		String plainText = "";
		int indexOffset = reference.indexOf(encodedText.charAt(0) + "");
		int newIndexCurrentChar;

		for (int i = 1; i < encodedText.length(); i++) {
			int indexCurrentChar = reference.indexOf(encodedText.charAt(i) + "");

			if (indexCurrentChar < 0) {
				plainText = plainText + encodedText.charAt(i);
			} else {
				newIndexCurrentChar = indexCurrentChar + indexOffset;

				if (newIndexCurrentChar < 0) {
					newIndexCurrentChar = reference.size() + newIndexCurrentChar;
					plainText = plainText + reference.get(newIndexCurrentChar);

				} else if (newIndexCurrentChar >= reference.size()) {
					newIndexCurrentChar = newIndexCurrentChar - reference.size();
					plainText = plainText + reference.get(newIndexCurrentChar);

				} else {
					plainText = plainText + reference.get(newIndexCurrentChar);
				}
			}
		}

		return plainText;
	}
}
