package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlaces {

    private String listName;
    private List<Place> places;

    public ListOfPlaces() {
    }

    public ListOfPlaces(String listName) {
        places = new ArrayList<>();
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public boolean areTherePlacesInCommonWith(ListOfPlaces aListOfPlaces) {
        return places
                .stream()
                .anyMatch(place -> aListOfPlaces.getPlaces().contains(place));
    }
}
