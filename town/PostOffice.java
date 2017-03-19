package town;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import citizen.Collector;
import citizen.Postman;

public class PostOffice {

	private static ArrayList<Postman> postmen;
	private static ArrayList<Collector> collectors;
	private static ArrayList<Mail> storage;
	private static ConcurrentHashMap<LocalDateTime, Mail> archive;
	private static Object lock = new Object();
	
	public PostOffice() {
		this.postmen = new ArrayList<Postman>();
		this.collectors = new ArrayList<Collector>();
		this.storage = new ArrayList<Mail>();
		this.archive = new ConcurrentHashMap<LocalDateTime, Mail>();
	}
	
	public void addPostmanToPostoffice(Postman postman) {
		postmen.add(postman);
	}
	
	public void addCollectorToPostoffice(Collector collector) {
		collectors.add(collector);
	}
	
	public static void addMailToStorage(Mail mail) {
		synchronized (lock) {
			storage.add(mail);
		}
		archive.put(LocalDateTime.now(), mail);
		ExecutorService es = Executors.newFixedThreadPool(10);
		if(storage.size() < 50) {
			for(Collector collector : collectors) {
				es.execute(collector);
			}
		}
		if(storage.size() > 50) {
			for(Postman postman : postmen) {
				int rnd = new Random().nextInt(storage.size());
				postman.addMailToBag(storage.get(rnd));
				storage.remove(rnd);
				es.execute(postman);
				if(storage.size() <= 0) {
					break;
				}
			}
		}
		es.shutdown();
	}
}
