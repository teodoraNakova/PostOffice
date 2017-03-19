package town;

public class Parcel extends Mail{

	private static final double PARCEL_TAX = 2.0;
	private static final double LARGE_PARCEL_TAX = PARCEL_TAX + (PARCEL_TAX * 0.5);
	
	private int length;
	private int height;
	private int width;
	private boolean isFragile;
	
	public Parcel(String senderName, String senderAddress, String receiverName, String receiverAddress, 
			int length, int heigth, int width, boolean isFragile) {
		super(senderName, senderAddress, receiverName, receiverAddress, (isLargeParcel(length, heigth, width) || isFragile) ? LARGE_PARCEL_TAX : PARCEL_TAX);
		this.length = length;
		this.height = heigth;
		this.width = width;
		this.isFragile = isFragile;
	}
	
	private static boolean isLargeParcel(int length, int heigth, int width) {
		return length > 60 || heigth > 60 || width > 60;
	}
	
}
