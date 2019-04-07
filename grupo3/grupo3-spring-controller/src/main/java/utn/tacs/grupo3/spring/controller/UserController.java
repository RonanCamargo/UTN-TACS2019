package utn.tacs.grupo3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {
	
	@Autowired
	private UserRepository usuarioRepository;
	
	
	@GetMapping("/all")
	public List<User> usuarios(){
		return usuarioRepository.allUsers();
	}
	
	@GetMapping("/{nombre}")
	public List<User> usuarioPorNombre(@PathVariable("nombre") String nombre){
		return usuarioRepository.usersByFirstName(nombre);
	}
	
	@PostMapping(value = "/nuevo", params = {"nombre", "apellido"})
	public String crearUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido) {
		usuarioRepository.createUser(nombre, apellido);
		
		return "Usuario creado";
	}

}
