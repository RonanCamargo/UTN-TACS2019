package utn.tacs.grupo3.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String firstName;
    private String lastName;
    private List<ListOfPlaces> listOfPlaces;
    private List<Place> placesVisited;
    private LocalDateTime lastAccess;

    public User() {
    }

    public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
        this.listOfPlaces = new ArrayList<>();
        this.placesVisited = new ArrayList<>();

	}

	public User(String firstName, String lastName, LocalDateTime lastAccess) {
        listOfPlaces = new ArrayList<>();
        placesVisited = new ArrayList<>();

        this.firstName = firstName;
        this.lastName = lastName;
        this.lastAccess = lastAccess;
    }

    public boolean havePlacesInCommonWith(Place aPlace) {
    	return listOfPlaces.stream().anyMatch(listPlaces -> listPlaces.getPlaces().contains(aPlace));
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
    
    public int amountOfPlacesLists() {
    	return listOfPlaces.size();
    }
    
    public int amountOfPlacesVisited() {
    	return placesVisited.size();
    }

    public List<ListOfPlaces> listsOfPlacesByName(String name) {
        return listOfPlaces.stream().
                filter(listOfPlaces -> listOfPlaces.getListName().equalsIgnoreCase(name)).
                collect(Collectors.toList());
    }

	public ListOfPlaces listOfPlacesByName(String listId) {
		return listsOfPlacesByName(listId).get(0);
	}

	public void registerAPlaceinAListOfPlaces(String listId, Place place) {
		listsOfPlacesByName(listId).get(0).addPlace(place);
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

	public LocalDateTime getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(LocalDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

}
