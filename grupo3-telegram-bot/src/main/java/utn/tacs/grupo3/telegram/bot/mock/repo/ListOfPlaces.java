package utn.tacs.grupo3.telegram.bot.mock.repo;

import java.util.List;

public class ListOfPlaces {
	
	private String listName;
	private List<Place> places;
			
	public ListOfPlaces(String listName, List<Place> places) {
		super();
		this.listName = listName;
		this.places = places;
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

	
}
