package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
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
    public List<ListOfPlaces> listsOfListOfPlaces(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
        return userRepository.userByUsername(userId).getListsOfPlaces();
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}")
    public String createListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
        userRepository.userByUsername(userId).createListOfPlaces(listId);
        return "Lista creada correctamente.";
    }

    @Override
    @GetMapping("/{user-id}/list-of-places/{list-id}")
    public ListOfPlaces listOfPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
        return userRepository.userByUsername(userId).listOfPlacesByName(listId);
    }

    @Override
    @DeleteMapping("/{user-id}/list-of-places/{list-id}")
    public String deleteListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
        userRepository.userByUsername(userId).removeFromListsOfPlaces(userRepository.userByUsername(userId).listOfPlacesByName(listId));
        return "Lista eliminada correctamente.";
    }

    @Override
    @PutMapping("/{user-id}/list-of-places/{list-id}")
    public String editListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName) throws ExceptionbyResourceNotFound {
        userRepository.userByUsername(userId).listOfPlacesByName(listId).setListName(newName);
        return "Lista modificada correctamente.";
    }

}
