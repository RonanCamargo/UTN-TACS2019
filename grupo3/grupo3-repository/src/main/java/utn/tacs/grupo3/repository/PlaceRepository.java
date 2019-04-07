package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlaceRepository {

	private List<Place> lugares;

	public PlaceRepository() {
		lugares = new ArrayList<Place>();
		lugares.add(new Place("McDonalds Callao", "Av. Callao 131"));
		lugares.add(new Place("On Tap Retiro ", "Marcelo Torcuato de Alvear 834"));
	}

	public List<Place> lugares(){
		return lugares;
	}
	
	public List<Place> lugaresByNombre(String nombre){
		return lugares.stream().
				filter(lugar -> lugar.getName().equalsIgnoreCase(nombre)).
				collect(Collectors.toList());
	}
	
	public void crearLugar(String nombre, String ubicacion) {
		lugares.add(new Place(nombre, ubicacion));
	}

}
