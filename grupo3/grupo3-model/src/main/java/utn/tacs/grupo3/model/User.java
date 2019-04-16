package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String firstName;
	private String lastName;
	private LocationCoordinates locationCoordinates;
	private List<ListOfPlaces> listOfPlaces;
	private List<Place> placesVisited;
	private String lastAccess;

	public User() {}

	public User(String firstName, String lastName, LocationCoordinates locationCoordinates, List<ListOfPlaces> listOfPlaces, List<Place> placesVisited, int i, int i1, String lastAccess) {
		listOfPlaces = new ArrayList<>();
		placesVisited = new ArrayList<>();

		this.firstName = firstName;
		this.lastName = lastName;
		this.locationCoordinates = locationCoordinates;
		this.listOfPlaces = listOfPlaces;
		this.placesVisited = placesVisited;
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

	public LocationCoordinates getLocationCoordinates() {
		return locationCoordinates;
	}

	public void setLocationCoordinates(LocationCoordinates locationCoordinates) {
		this.locationCoordinates = locationCoordinates;
	}

	public List<ListOfPlaces> getListOfPlaces() {
		return listOfPlaces;
	}

	public void setListOfPlaces(List<ListOfPlaces> listOfPlaces) {
		this.listOfPlaces = listOfPlaces;
	}

	public List<Place> getPlacesVisited() {
		return placesVisited;
	}

	public void setPlacesVisited(List<Place> placesVisited) {
		this.placesVisited = placesVisited;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public void createListOfPlaces(String name) {
		listOfPlaces.add(new ListOfPlaces(name));

	}

	public void removeFromListsOfPlaces(ListOfPlaces aListOfPlaces) {
		listOfPlaces.remove(aListOfPlaces);
	}

	public void markAsVisited(Place aPlace) {
		placesVisited.add(aPlace);
	}
}
