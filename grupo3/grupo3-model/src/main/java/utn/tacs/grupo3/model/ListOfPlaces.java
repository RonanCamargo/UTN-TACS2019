package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlaces {

    private String listName;
    private List<Place> favouritePlaces;

    public ListOfPlaces() {
    }

    public ListOfPlaces(String listName) {
        favouritePlaces = new ArrayList<>();
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Place> getFavouritePlaces() {
        return favouritePlaces;
    }

    public void addPlace(Place place) {
        favouritePlaces.add(place);
    }

    public boolean areTherePlacesInCommonWith(ListOfPlaces aListOfPlaces) {
        return favouritePlaces
                .stream()
                .anyMatch(place -> aListOfPlaces.getFavouritePlaces().contains(place));
    }
}