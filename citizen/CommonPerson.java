package citizen;

import java.util.Random;

import town.Letter;
import town.Mail;
import town.MailBox;
import town.Parcel;
import town.PostOffice;
import town.Town;

public class CommonPerson extends Citizen implements Runnable {

	public CommonPerson(String name) {
		super(name);
	}

	private synchronized void dropLetterInMailBox(Letter letter, int mailBoxNumber) {
		MailBox mailBox = Town.getMailBoxes().get(mailBoxNumber);
		mailBox.acceptLetter(letter);
	}

	private synchronized void dropMailInPostOffice(Mail mail) {
		PostOffice.addMailToStorage(mail);
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			Letter letter = new Letter(this.getName(), "Sofia", "Someone", "Plovdiv");
			Parcel parcel = new Parcel(this.getName(), "Sofia", "Someone", "Plovdiv", 45, 12, 2, false);
			if (new Random().nextBoolean()) {
				dropLetterInMailBox(letter, new Random().nextInt(Town.getMailBoxes().size()));
				continue;
			}
			dropMailInPostOffice(letter);
			dropMailInPostOffice(parcel);
		}
	}
}
