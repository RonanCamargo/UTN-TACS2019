package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.Lugar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LugarRepository {

	private List<Lugar> lugares;

	public LugarRepository() {
		lugares = new ArrayList<Lugar>();
		lugares.add(new Lugar("McDonalds Callao", "Av. Callao 131"));
		lugares.add(new Lugar("On Tap Retiro ", "Marcelo Torcuato de Alvear 834"));
	}

	public List<Lugar> lugares(){
		return lugares;
	}
	
	public List<Lugar> lugaresByNombre(String nombre){
		return lugares.stream().
				filter(lugar -> lugar.getNombre().equalsIgnoreCase(nombre)).
				collect(Collectors.toList());
	}
	
	public void crearLugar(String nombre, String ubicacion) {
		lugares.add(new Lugar(nombre, ubicacion));
	}

}
