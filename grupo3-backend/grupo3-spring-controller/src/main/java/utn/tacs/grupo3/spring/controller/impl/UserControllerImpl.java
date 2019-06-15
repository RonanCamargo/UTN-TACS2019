package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.service.UserService;
import utn.tacs.grupo3.spring.controller.UserController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
    
    @Override
    @GetMapping
    public List<User> users() {
        return userService.allUsers();
    }

    @Override
    @PutMapping("/{user-id}/{list-id}/places-visited/{place-id}")
    public void markAsVisitedAPlace(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
    	userService.markAPlaceInAUserListAsVisited(userId, listId, placeId);
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}/{place-id}")
    public void registerPlaceInListOfPlaces(
    		@PathVariable("user-id") String userId, 
    		@PathVariable("list-id") String listId, 
    		@PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
    	userService.registerAPlaceInAUserList(userId, listId, placeId);
    }
}
