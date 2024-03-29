package model;

public class TouristPlace {
	String name;
	String destination;
	String rank;
	
	//Constructors
	public TouristPlace(String name, String destination, String rank) {
		this.name = name;
		this.destination = destination;
		this.rank = rank;
	}
	
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
		
}