package utn.tacs.grupo3.model;

public class User {
	
	private String firstName;
	private String lastName;
	private int numberOfLists;
	private int numberOfVisitedPlaces;
	private String lastAccess;
	

	public User(String firstName, String lastName, int numberOfLists, int numberOfVisitedPlaces, String lastAccess) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberOfLists = numberOfLists;
		this.numberOfVisitedPlaces = numberOfVisitedPlaces;
		this.lastAccess = lastAccess;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getNumberOfLists() {
		return numberOfLists;
	}
	public void setNumberOfLists(int numberOfLists) {
		this.numberOfLists = numberOfLists;
	}
	public int getNumberOfVisitedPlaces() {
		return numberOfVisitedPlaces;
	}
	public void setNumberOfVisitedPlaces(int numberOfVisitedPlaces) {
		this.numberOfVisitedPlaces = numberOfVisitedPlaces;
	}
	public String getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}
	





}
