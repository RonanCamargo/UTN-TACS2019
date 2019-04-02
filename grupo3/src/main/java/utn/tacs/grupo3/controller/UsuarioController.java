package utn.tacs.grupo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Usuario;
import utn.tacs.grupo3.repository.UsuarioRepository;

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
