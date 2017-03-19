package citizen;

import java.util.ArrayList;

import town.Mail;
import town.Parcel;

public class Postman extends Citizen implements Runnable {

	private int experience;
	private ArrayList<Mail> mail;

	public Postman(String name, int experience) {
		super(name);
		this.experience = experience;
		this.mail = new ArrayList<Mail>();
	}

	public synchronized void addMailToBag(Mail mail) {
		this.mail.add(mail);
	}

	@Override
	public void run() {
		while (mail.size() > 0) {
			Mail m = mail.get(0);
			mail.remove(0);
			if (m instanceof Parcel) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
