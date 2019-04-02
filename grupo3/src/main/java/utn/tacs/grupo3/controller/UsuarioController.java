package utn.tacs.grupo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Usuario;
import utn.tacs.grupo3.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> usuarios(){
		return usuarioRepository.usuarios();
	}

}
