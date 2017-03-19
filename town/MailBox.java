package town;

import java.util.ArrayList;

public class MailBox {

	private ArrayList<Letter> letters;
	
	protected MailBox() {
		letters = new ArrayList<Letter>();
	}
	
	public synchronized void acceptLetter(Letter letter) {
		this.letters.add(letter);
	}
	
	public ArrayList<Letter> getLetters() {
		return letters;
	}
}
