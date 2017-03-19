import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import citizen.Collector;
import citizen.CommonPerson;
import citizen.Postman;
import town.PostOffice;
import town.Town;


public class Demo {

	public static void main(String[] args) {
		
		Random r = new Random();
		PostOffice varnaPostOffice = new PostOffice();
		Town varna = new Town("Varna", varnaPostOffice);
		ArrayList<String> randomNames = new ArrayList<String>();
		fillWithNames(randomNames);
		for(int i = 0; i < 100; i++) {
			int randomNamesSize = randomNames.size();
			CommonPerson person = new CommonPerson(randomNames.get(generateRandomNumber(randomNamesSize)));
			varna.addPersonToTown(person);
			Postman postman = new Postman(randomNames.get(generateRandomNumber(randomNamesSize)), r.nextInt(5) + 5);
			varnaPostOffice.addPostmanToPostoffice(postman);
			Collector collector = new Collector(randomNames.get(generateRandomNumber(randomNamesSize)));
			varnaPostOffice.addCollectorToPostoffice(collector);
		}
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		ArrayList<CommonPerson> commonPeople = Town.getCommonPeople();
		for(CommonPerson person : commonPeople) {
			es.execute(person);
		}
	    es.shutdown();	
	}
	
	private static int generateRandomNumber(int max) {
		return new Random().nextInt(max);
	}

	private static void fillWithNames(ArrayList<String> randomNames) {
		randomNames.add("Ivan Ivanov");
		randomNames.add("Georgi Pyrvanov");
		randomNames.add("Nikoleta Getova");
		randomNames.add("Plamen Atanasov");
		randomNames.add("Temenujka Kabzimalska");
		randomNames.add("Aneliq Radulova");
		randomNames.add("Bojidar Stoichkov");
		randomNames.add("Nikola Kanalev");	
	}
}
