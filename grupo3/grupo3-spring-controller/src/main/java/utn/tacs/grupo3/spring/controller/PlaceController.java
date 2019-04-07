package utn.tacs.grupo3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.PlaceRepository;

import java.util.List;

@RestController
@RequestMapping("/lugar")
public class PlaceController {
	
	@Autowired
	private PlaceRepository lugarRepository;


	@GetMapping("/all")
	public List<Place> lugares(){
		return lugarRepository.lugares();
	}
	
	@GetMapping("/{nombre}")
	public List<Place> lugarPorNombre(@PathVariable("nombre") String nombre){
		return lugarRepository.lugaresByNombre(nombre);
	}
	
	@PostMapping(value = "/nuevo", params = {"nombre", "ubicacion"})
	public String crearLugar(@RequestParam("nombre") String nombre, @RequestParam("ubicacion") String ubicacion) {
		lugarRepository.crearLugar(nombre, ubicacion);
		
		return "Lugar creado";
	}

}
