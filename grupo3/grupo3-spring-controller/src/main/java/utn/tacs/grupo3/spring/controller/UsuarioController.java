package utn.tacs.grupo3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.Usuario;
import utn.tacs.grupo3.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/all")
	public List<Usuario> usuarios(){
		return usuarioRepository.usuarios();
	}
	
	@GetMapping("/{nombre}")
	public List<Usuario> usuarioPorNombre(@PathVariable("nombre") String nombre){
		return usuarioRepository.usuariosByNombre(nombre);
	}
	
	@PostMapping(value = "/nuevo", params = {"nombre", "apellido"})
	public String crearUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido) {
		usuarioRepository.crearUsuario(nombre, apellido);
		
		return "Usuario creado";
	}

}
