
public class Word {
	private String plainText;
	private String encodedText;
	
	public Word(String plainText, String encodedText) {
		this.plainText = plainText;
		this.encodedText = encodedText;
	}

	public String getPlainText() {
		return plainText;
	}

	public String getEncodedText() {
		return encodedText;
	}
}
