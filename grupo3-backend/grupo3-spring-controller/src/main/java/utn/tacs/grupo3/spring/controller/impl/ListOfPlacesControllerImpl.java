package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.service.ListOfPlacesService;
import utn.tacs.grupo3.spring.controller.ListOfPlacesController;
import utn.tacs.grupo3.spring.controller.response.Response;
import utn.tacs.grupo3.spring.controller.response.ResponseHandler;

@RestController
@RequestMapping("/users")
public class ListOfPlacesControllerImpl implements ListOfPlacesController {
	
	@Autowired
    private ListOfPlacesService listOfPlacesService;
	
	@Autowired
	private ResponseHandler responseHandler;

    @Override
    @GetMapping("/{user-id}/list-of-places")
    public Response listsOfListOfPlaces(@PathVariable("user-id") String userId){
    	return responseHandler.handle(
    			() -> new Response(
    					HttpStatus.OK,
    					"All users lists of places",
    					listOfPlacesService.allUserListsOfPlaces(userId)));
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}")
    public Response createListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId){
    	return responseHandler.handle(()->{
    		listOfPlacesService.createListOfPlaces(userId, listId);
    		return new Response(HttpStatus.OK, "List successfully created");
    	});
    }

    @Override
    @GetMapping("/{user-id}/list-of-places/{list-id}")
    public Response listOfPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId){
    	return responseHandler.handle(
    			() -> new Response(HttpStatus.OK, listOfPlacesService.userListOfPlacesByName(userId, listId).toString()));
    }

    @Override
    @DeleteMapping("/{user-id}/list-of-places/{list-id}")
    public Response deleteListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId){
    	return responseHandler.handle(
    			() -> {
    				listOfPlacesService.deleteUserListOfPlaces(userId, listId);
    				return new Response(HttpStatus.OK, "List successfully deleted");
    			});
    }

    @Override
    @PutMapping("/{user-id}/list-of-places/{list-id}")
    public Response editListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName){
    	return responseHandler.handle(
    			() -> {
    				listOfPlacesService.renameListOfPlaces(userId, listId, newName);
    				return new Response(HttpStatus.OK, "List successfully renamed");
    			});
    }

}
