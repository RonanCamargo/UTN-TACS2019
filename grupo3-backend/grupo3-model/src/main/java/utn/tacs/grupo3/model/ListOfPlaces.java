package utn.tacs.grupo3.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlaces {

	String id;
    private String listName;
    private List<Place> places;

    public ListOfPlaces() { }

    public ListOfPlaces(String listName) {
        this.places = new ArrayList<>();
        this.listName = listName;
    }

    public void addPlace(Place place) {
        places.add(place);
    }
    
    @Deprecated
    public boolean areTherePlacesInCommonWith(ListOfPlaces aListOfPlaces) {
        return places
                .stream()
                .anyMatch(place -> aListOfPlaces.getPlaces().contains(place));
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

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
