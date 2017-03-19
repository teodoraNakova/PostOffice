package town;

import java.util.ArrayList;

import citizen.CommonPerson;

public class Town {

	private String name;
	private static ArrayList<MailBox> mailBoxes = new ArrayList<MailBox>();
	private static ArrayList<CommonPerson> commonPeople;
	private PostOffice postOffice;
	
	public Town(String name, PostOffice postOffice) {
		this.name = name;
		for(int i = 0; i < 25; i++) {
			mailBoxes.add(new MailBox());
		}
		this.commonPeople = new ArrayList<CommonPerson>();
		this.postOffice = postOffice;
	}
	
	public static ArrayList<MailBox> getMailBoxes() {
		return mailBoxes;
	}
	
	public void addPersonToTown(CommonPerson person) {
		this.commonPeople.add(person);
	}
	
	public static ArrayList<CommonPerson> getCommonPeople() {
		return commonPeople;
	}
}
