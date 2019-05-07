package utn.tacs.grupo3.telegram.bot.mock.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfPlacesRepo {
	
	private static List<ListOfPlaces> LISTS;
	
	static {
		LISTS = new ArrayList<ListOfPlaces>();
		ListOfPlaces listUniversidades = new ListOfPlaces(
				"Universidades",
				List.of(
						new Place("UTN Medrano", "UTN FRBA - Sede Medrano", -34.598359f, -58.419878f),
						new Place("UTN Campus", "UTN FRBA - Sede Campus", -34.659606f, -58.468083f)
						));
		ListOfPlaces listComida = new ListOfPlaces(
				"Comida",
				List.of(
						new Place("TDN", "Tierra de Nadie", 12.0f, 25.0f),
						new Place("TDN La villa", "Viva la villa", 12.0f, 25.0f)
						));
		
		LISTS.add(listUniversidades);
		LISTS.add(listComida);
	}
	
	public static List<String> listNames(){
		return LISTS.stream().map(list -> list.getListName()).collect(Collectors.toList());
	}
	
	public static List<Place> places(String listName){
		return LISTS.stream().filter(list -> list.getListName().equalsIgnoreCase(listName)).findFirst().get().getPlaces();
	}
	
	public static Place placeByName(String placeName, List<Place> places) {
		for (Place place : places) {
			if (place.getName().equalsIgnoreCase(placeName)) {
				return place;
			}
		}
		return null;
	}

}
