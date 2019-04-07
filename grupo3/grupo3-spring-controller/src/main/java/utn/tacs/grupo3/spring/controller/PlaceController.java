package utn.tacs.grupo3.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.repository.PlaceRepository;

@RestController
@RequestMapping("/lugar")
public class PlaceController {
	
	@Autowired
	private PlaceRepository lugarRepository;


	@GetMapping("/all")
	public List<Place> lugares(){
		return lugarRepository.allPlaces();
	}
	
	@GetMapping("/{nombre}")
	public List<Place> lugarPorNombre(@PathVariable("nombre") String nombre){
		return lugarRepository.placesByName(nombre);
	}
	
	@PostMapping(value = "/nuevo", params = {"nombre", "ubicacion"})
	public String crearLugar(@RequestParam("nombre") String nombre, @RequestParam("ubicacion") String ubicacion) {
		lugarRepository.createPlace(nombre, ubicacion);
		
		return "Lugar creado";
	}

}
