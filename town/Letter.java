package town;

public class Letter extends Mail {
	
	private static final double LETTER_TAX = 0.5;

	public Letter(String senderName, String senderAddress, String receiverName, String receiverAddress) {
		super(senderName, senderAddress, receiverName, receiverAddress, LETTER_TAX);
	}
	
}
