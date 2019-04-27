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
        return userRepository.userByFirstName(userId).getListOfPlaces();
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}")
        public String createListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        userRepository.userByFirstName(userId).createListOfPlaces(listId);
        return "Lista creada correctamente.";
    }

    @Override
    @GetMapping("/{user-id}/list-of-places/{list-id}")
    public List<ListOfPlaces> listOfPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        return userRepository.userByFirstName(userId).listsOfPlacesByName(listId);
    }

    @Override
    @DeleteMapping("/{user-id}/list-of-places/{list-id}")
    public String deleteListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) {
        userRepository.userByFirstName(userId).removeFromListsOfPlaces(userRepository.userByFirstName(userId).listOfPlacesByName(listId));
        return "Lista eliminada correctamente.";
    }

    @Override
    @PutMapping("/{user-id}/list-of-places/{list-id}")
    public String editListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName) {
        userRepository.userByFirstName(userId).listOfPlacesByName(listId).setListName(newName);
        return "Lista modificada correctamente.";
    }

}
