package utn.tacs.grupo3.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.Usuario;

@Repository
public class UsuarioRepository {
	
	public List<Usuario> usuarios(){
		return Arrays.asList(
				new Usuario("Juan","Perez"),
				new Usuario("Jose","Gonzalez"));
	}

}
