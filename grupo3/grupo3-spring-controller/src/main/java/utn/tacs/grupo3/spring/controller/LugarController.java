package utn.tacs.grupo3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.Lugar;
import utn.tacs.grupo3.model.Usuario;
import utn.tacs.grupo3.repository.LugarRepository;

import java.util.List;

@RestController
@RequestMapping("/lugar")
public class LugarController {
	
	@Autowired
	private LugarRepository lugarRepository;


	@GetMapping("/all")
	public List<Lugar> lugares(){
		return lugarRepository.lugares();
	}
	
	@GetMapping("/{nombre}")
	public List<Lugar> lugarPorNombre(@PathVariable("nombre") String nombre){
		return lugarRepository.lugaresByNombre(nombre);
	}
	
	@PostMapping(value = "/nuevo", params = {"nombre", "ubicacion"})
	public String crearLugar(@RequestParam("nombre") String nombre, @RequestParam("ubicacion") String ubicacion) {
		lugarRepository.crearLugar(nombre, ubicacion);
		
		return "Lugar creado";
	}

}
