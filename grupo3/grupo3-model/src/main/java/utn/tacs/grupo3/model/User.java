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

    public User() {
    }

    public User(String firstName, String lastName, LocationCoordinates locationCoordinates, String lastAccess) {
        listOfPlaces = new ArrayList<>();
        placesVisited = new ArrayList<>();

        this.firstName = firstName;
        this.lastName = lastName;
        this.locationCoordinates = locationCoordinates;
        this.lastAccess = lastAccess;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<ListOfPlaces> getListOfPlaces() {
        return listOfPlaces;
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

    public boolean havePlacesInCommonWith(Place aPlace) {
        return listOfPlaces.stream().anyMatch(listPlaces -> listPlaces.getFavouritePlaces().contains(aPlace));
    }

    public int amountOfPlacesLists() {
        return listOfPlaces.size();
    }

    public int amountOfPlacesVisited() {
        return placesVisited.size();
    }

    public String getLastAccess() {
        return lastAccess;
    }
}
