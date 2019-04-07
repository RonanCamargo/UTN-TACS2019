package utn.tacs.grupo3.model;

import java.util.List;

public class FavouritePlaces {
	
	private String listName;
	private List<Place> favouritePlaces;
	
	public FavouritePlaces() {}
				
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public List<Place> getFavouritePlaces() {
		return favouritePlaces;
	}
	public void setFavouritePlaces(List<Place> favouritePlaces) {
		this.favouritePlaces = favouritePlaces;
	}
	
	
	
}
