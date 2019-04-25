package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.controller.ListOfPlacesController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ListOfPlacesControllerImpl implements ListOfPlacesController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @GetMapping("/{user-id}/list-of-places")
    public List<ListOfPlaces> listsOfListOfPlaces(@PathVariable("user-id") String userId) {
        return userRepository.usersByFirstName(userId).get(0).getListOfPlaces();
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}")
    public String createListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        userRepository.usersByFirstName(userId).get(0).createListOfPlaces(listId);
        return "Lista creada correctamente.";
    }

    @Override
    @GetMapping("/{user-id}/list-of-places/{list-id}")
    public List<ListOfPlaces> listOfPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        return userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId);
    }

    @Override
    @DeleteMapping("/{user-id}/list-of-places/{list-id}")
    public String deleteListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        userRepository.usersByFirstName(userId).get(0).removeFromListsOfPlaces(userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId).get(0));
        return "Lista eliminada correctamente.";
    }

    @Override
    @PutMapping("/{user-id}/list-of-places/{list-id}")
    public String editListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName) {
        userRepository.usersByFirstName(userId).get(0).listOfPlacesByName(listId).get(0).setListName(newName);
        return "Lista modificada correctamente.";
    }

}
