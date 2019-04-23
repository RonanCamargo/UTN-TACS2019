package utn.tacs.grupo3.spring.controller.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import utn.tacs.grupo3.model.ListOfPlaces;
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
    public List<User> users() {
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
    public List<String> listsOfFavouritePlaces() {
        return Arrays.asList("Cine");
    }

    @Override
    @PostMapping("/{user-id}/favourite-places/{list-id}")
    public String createPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        userRepository.usersByFirstName(userId).get(0).createListOfPlaces(listId);
        return "Lista creada correctamente.";
    }

    @Override
    @GetMapping("/{user-id}/favourite-places/{list-id}")
    public List<ListOfPlaces> favouritePlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        return userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId);
    }

    @Override
    @DeleteMapping("/{user-id}/favourite-places/{list-id}")
    public String deleteFavouritePlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        userRepository.usersByFirstName(userId).get(0).removeFromListsOfPlaces(userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId).get(0));
        return "Lista eliminada correctamente.";
    }

    @Override
    @PutMapping("/{user-id}/favourite-places/{list-id}")
    public String editFavouritePlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName) {
        userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId).get(0).setListName(newName);
        return "Lista modificada correctamente.";
    }

    @Override
    @PutMapping("/{user-id}/places-visited/{place-id}")
    public String markAsVisitedAPlace(@PathVariable("user-id") String userId, @PathVariable("place-id") String placeId) {
        Place place = new Place(placeId, "");
        userRepository.usersByFirstName(userId).get(0).markAsVisited(place);
        return "lugar marcado como visitado.";

    }

    @Override
    @PostMapping("/{user-id}/favourite-places/{list-id}/{place-id}")
    public String registerFavouritePlaceInList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @PathVariable("place-id") String placeId) {
        Place place = new Place(placeId, "");
        userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId).get(0).addPlace(place);
        return "Lugar registrado correctamente.";
    }

    @Override
    @GetMapping("/places-in-common")
    public boolean placesInCommon(@RequestParam("user-1") String user1, @RequestParam("user-2") String user2) {
        return false;
    }
}
