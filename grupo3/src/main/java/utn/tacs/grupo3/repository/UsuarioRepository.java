package utn.tacs.grupo3.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.Usuario;

@Repository
public class UsuarioRepository {
	
	private List<Usuario> usuarios;
	
	public UsuarioRepository() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Juan", "Perez",2,3,"s"));
		usuarios.add(new Usuario("Jose", "Gonzalez",2,3,"s"));
	}

	public List<Usuario> usuarios(){
		return usuarios;
	}
	
	public List<Usuario> usuariosByNombre(String nombre){
		return usuarios.stream().
				filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre)).
				collect(Collectors.toList());
	}
	
	public void crearUsuario(String nombre, String apellido) {
		usuarios.add(new Usuario(nombre, apellido,2,3,"s"));
	}

}
