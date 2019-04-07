package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
	
	private List<User> usuarios;
	
	public UserRepository() {
		usuarios = new ArrayList<User>();
		usuarios.add(new User("Juan", "Perez",2,3,"s"));
		usuarios.add(new User("Jose", "Gonzalez",2,3,"s"));
	}

	public List<User> usuarios(){
		return usuarios;
	}
	
	public List<User> usuariosByNombre(String nombre){
		return usuarios.stream().
				filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre)).
				collect(Collectors.toList());
	}
	
	public void crearUsuario(String nombre, String apellido) {
		usuarios.add(new User(nombre, apellido,2,3,"s"));
	}

}
