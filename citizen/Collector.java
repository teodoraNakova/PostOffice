package citizen;

import java.util.ArrayList;

import town.Letter;
import town.MailBox;
import town.PostOffice;
import town.Town;

public class Collector extends Citizen implements Runnable {

	private ArrayList<Letter> letters;

	public Collector(String name) {
		super(name);
		this.letters = new ArrayList<Letter>();
	}

	@Override
	public void run() {
		for (MailBox box : Town.getMailBoxes()) {
			if (box.getLetters().size() > 0) {
				Letter l = box.getLetters().get(0);
				box.getLetters().remove(0);
				PostOffice.addMailToStorage(l);
			}
		}
	}
}
