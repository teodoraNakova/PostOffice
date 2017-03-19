package town;

public abstract class Mail {

	private String senderName;
	private String senderAddress;
	private String receiverName;
	private String receiverAddress;
	private double tax;
	
	public Mail(String senderName, String senderAddress, String receiverName, String receiverAddress, double tax) {
		try {
			this.setSenderAddress(senderAddress);	
			this.setReceiverAddress(receiverAddress);
		} 
		catch(InvalidAddressException e) {
			System.out.println(e.getMessage());
		}
	    this.setSenderName(senderName);
		this.setReceiverName(receiverName);
		this.tax = tax;
	}
	
	private void setSenderAddress(String senderAddress) throws InvalidAddressException {
		if(validateAddress(senderAddress)) {
			throw new InvalidAddressException();
		}
		this.senderAddress = senderAddress;
	}
	
	private void setReceiverAddress(String receiverAddress) throws InvalidAddressException {
		if(validateAddress(receiverAddress)) {
			throw new InvalidAddressException();
		}
		this.receiverAddress = receiverAddress;
	}
	
	private void setSenderName(String senderName) {
		if(validateName(senderName)) {
			this.senderName = "Unknown";
		}
		this.senderName = senderName;
	}
	
	private void setReceiverName(String receiverName) {
		if(validateName(receiverName)) {
			this.receiverName = "Unknown";
		}
		this.receiverName = receiverName;
	}
	
	private boolean validateAddress(String text) {
		return text == null || text.isEmpty();
	}
	
	private boolean validateName(String name) {
		return name == null || name.isEmpty();
	}
	
	private class InvalidAddressException extends Exception {
		
		private InvalidAddressException() {
			super("Invalid address for mail, cannot porceed sending.");
		}
	}
}
