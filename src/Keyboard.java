import java.util.Scanner;

public class Keyboard {

	public static String readString(String prompt) {
		System.out.print(prompt);
		Scanner input = new Scanner(System.in);
		prompt = input.nextLine();
		return prompt;
	}
}
