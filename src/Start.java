
public class Start {

	public static void main(String[] args) {
		Coder coder = new Coder();

		String prompt = Keyboard.readString("Please enter words to encode (in UPPER CASE): ");
		String encodedText = coder.encode(prompt);
		String plainText=coder.decode(encodedText);

		System.out.println(encodedText);
		System.out.println(plainText);
	}

}
