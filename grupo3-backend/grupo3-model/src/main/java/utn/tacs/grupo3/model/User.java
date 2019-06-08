package utn.tacs.grupo3.model;

import utn.tacs.grupo3.model.exception.ExceptionbyListOfPlaceNotFound;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

	private String id;

	private String username;
	private String password;
	@Deprecated
	private String role;
	
	private Role roleEnum;

	private String firstName;
    private String lastName;
    private List<ListOfPlaces> listsOfPlaces;
    @Deprecated
    private List<Place> placesVisited;
    private LocalDateTime lastAccess;

    public User() {
    	
    }

    @Deprecated
    public User(String firstName, String lastName, String username, String password, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.listsOfPlaces = new ArrayList<>();
        this.placesVisited = new ArrayList<>();
        this.role = role;
        this.password = password;
    }

    public void initialize() {
        this.listsOfPlaces = new ArrayList<>();
        this.placesVisited = new ArrayList<>();
        setRol("USER");
        setLastAccess(null);
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Deprecated
	public boolean havePlacesInCommonWith(Place aPlace) {
        return listsOfPlaces.stream().anyMatch(listPlaces -> listPlaces.getPlaces().contains(aPlace));
    }

	@Deprecated
    public void createListOfPlaces(String name) {
        listsOfPlaces.add(new ListOfPlaces(name));
    }

	@Deprecated
    public void removeFromListsOfPlaces(ListOfPlaces aListOfPlaces) {
        listsOfPlaces.remove(aListOfPlaces);
    }

	@Deprecated
    public void markAsVisited(Place aPlace) {
        placesVisited.add(aPlace);
    }

	@Deprecated
    public int amountOfPlacesLists() {
        return listsOfPlaces.size();
    }

	@Deprecated
    public int amountOfPlacesVisited() {
        return placesVisited.size();
    }

	@Deprecated
    public List<ListOfPlaces> listsOfPlacesByName(String name) {
        return listsOfPlaces.stream().
                filter(listOfPlaces -> listOfPlaces.getListName().equalsIgnoreCase(name)).
                collect(Collectors.toList());
    }

	@Deprecated
    public ListOfPlaces listOfPlacesByName(String name) throws ExceptionbyResourceNotFound {
        return listsOfPlacesByName(name)
                .stream().findFirst()
                .orElseThrow(() -> new ExceptionbyListOfPlaceNotFound(name));
    }

	@Deprecated
    public void registerAPlaceinAListOfPlaces(String listId, Place place) throws ExceptionbyResourceNotFound {
        listOfPlacesByName(listId).addPlace(place);
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getPassword() {
        return "{noop}" + this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Deprecated
    public String getRol() {
        return role;
    }

    @Deprecated
    public void setRol(String rol) {
        this.role = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean areThereEmptyFieldsToSignUp() {
        return username == null || password == null || firstName == null || lastName == null;
    }

    public List<ListOfPlaces> getListsOfPlaces() {
        return listsOfPlaces;
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

    public void setListsOfPlaces(List<ListOfPlaces> listsOfPlaces) {
        this.listsOfPlaces = listsOfPlaces;
    }

    public List<Place> getPlacesVisited() {
        return placesVisited;
    }

    public void setPlacesVisited(List<Place> placesVisited) {
        this.placesVisited = placesVisited;
    }
    public Role getRole() {
	}
		return roleEnum;

	public void setRole(Role role) {
	}
		this.roleEnum = role;

}
