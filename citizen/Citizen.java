package citizen;

public abstract class Citizen {

	private String name;

	public Citizen(String name) {
		this.setName(name);
	}
	
	private void setName(String name) {
		if(name == null || name.isEmpty()) {
			this.name = "Unknown";
		}
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
