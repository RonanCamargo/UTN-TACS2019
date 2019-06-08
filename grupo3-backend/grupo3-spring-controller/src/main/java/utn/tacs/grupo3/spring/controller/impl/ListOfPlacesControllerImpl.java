package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.spring.controller.ListOfPlacesController;

@RestController
@RequestMapping("/users")
public class ListOfPlacesControllerImpl implements ListOfPlacesController {
    //TODO sacar repo en memoria
    private utn.tacs.grupo3.repository.UserRepository userRepository;
    
    @Autowired
    private UserRepository userRepoMongo;

    @Override
    @GetMapping("/{user-id}/list-of-places")
    public List<ListOfPlaces> listsOfListOfPlaces(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
        return userRepoMongo.userByUsername(userId).getListsOfPlaces();
//        		.userByUsername(userId).getListsOfPlaces();
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}")
    public void createListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
//        userRepository.userByUsername(userId).createListOfPlaces(listId);
    	userRepoMongo.createListOfPlaces(userId, listId);
    }

    @Override
    @GetMapping("/{user-id}/list-of-places/{list-id}")
    public ListOfPlaces listOfPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
//        return userRepository.userByUsername(userId).listOfPlacesByName(listId);
    	return userRepoMongo.findListOfPlaces(userId, listId);
    }

    @Override
    @DeleteMapping("/{user-id}/list-of-places/{list-id}")
    public void deleteListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
//        userRepository.userByUsername(userId).removeFromListsOfPlaces(userRepository.userByUsername(userId).listOfPlacesByName(listId));
    	userRepoMongo.deleteListOfPlaces(userId, listId);
    }

    @Override
    @PutMapping("/{user-id}/list-of-places/{list-id}")
    public void editListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName) throws ExceptionbyResourceNotFound {
//        userRepository.userByUsername(userId).listOfPlacesByName(listId).setListName(newName);
    	userRepoMongo.renameListOfPlaces(userId, listId, newName);
    }

}
