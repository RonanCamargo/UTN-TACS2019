package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ListOfPlaces> listOfPlacesByName(String name) {
        return listOfPlaces.stream().
                filter(listOfPlaces -> listOfPlaces.getListName().equalsIgnoreCase(name)).
                collect(Collectors.toList());
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

    public void setListOfPlaces(List<ListOfPlaces> listOfPlaces) {
        this.listOfPlaces = listOfPlaces;
    }

    public List<Place> getPlacesVisited() {
        return placesVisited;
    }

    public void setPlacesVisited(List<Place> placesVisited) {
        this.placesVisited = placesVisited;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }
}
