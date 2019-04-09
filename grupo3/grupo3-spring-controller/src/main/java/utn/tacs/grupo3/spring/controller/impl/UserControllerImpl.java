package utn.tacs.grupo3.spring.controller.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.FavouritePlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.controller.UserController;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@GetMapping
	public List<User> users(){
		return userRepository.allUsers();
	}
	
	@Override
	@PostMapping
	public String createUser(@RequestBody User user) {
		userRepository.createUser(user);
		
		return "Usuario creado correctamente.";
	}
	
	@Override
	@GetMapping("/{user-id}")
	public User userById(@PathVariable("user-id") String userId) {
		return userRepository.usersByFirstName(userId).get(0);
	}
	
	@Override
	@GetMapping("/{user-id}/favourite-places")
	public List<String> listsOfFavouritePlaces(){
		return Arrays.asList("Cine");
	}
	
	@Override
	@GetMapping("/{user-id}/favourite-places/{list-id}")
	public List<FavouritePlaces> favouritePlacesListById(){
		return Arrays.asList(new FavouritePlaces());
	}
	
	@Override
	@DeleteMapping("/{user-id}/favourite-places/{list-id}")
	public String deleteFavouritePlacesList() {
		return "Lista eliminada correctamente.";
	}
	
	@Override
	@PutMapping("/{user-id}/favourite-places/{list-id}")
	public String editFavouritePlacesList() {
		return "Lista modificada correctamente.";
	}
	
	@Override
	@PostMapping("/{user-id}/favourite-places/{list-id}/{place-id}")
	public String registerFavouritePlaceInList() {
		return "Lugar registrado correctamente.";
	}
	
	@Override
	@GetMapping("/places-in-common")
	public List<Place> placesInCommon(){
		return Arrays.asList(new Place("Cine", "123"));
	}
}
