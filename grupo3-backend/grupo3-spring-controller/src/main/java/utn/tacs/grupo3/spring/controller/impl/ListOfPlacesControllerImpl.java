package utn.tacs.grupo3.spring.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

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

import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.service.ListOfPlacesService;
import utn.tacs.grupo3.service.exception.ApiTacsException;
import utn.tacs.grupo3.spring.controller.ListOfPlacesController;
import utn.tacs.grupo3.spring.controller.response.Response;

@RestController
@RequestMapping("/users")
public class ListOfPlacesControllerImpl implements ListOfPlacesController {
	private static final Logger logger = Logger.getLogger(ListOfPlacesControllerImpl.class.getName());

	@Autowired
    private ListOfPlacesService listOfPlacesService;

    @Override
    @GetMapping("/{user-id}/list-of-places")
    public Response listsOfListOfPlaces(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
    	try {
    		return new Response(HttpStatus.OK, listOfPlacesService.allUserListsOfPlaces(userId));
    	} catch (ApiTacsException e) {
    		return new Response(e.getHttpStatus(), e.getMessage());
    	} catch (Exception e) {
    		logger.log(Level.WARNING, e.getMessage(), e);
    		return new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    	}        
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}")
    public Response createListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
    	try {
    		listOfPlacesService.createListOfPlaces(userId, listId);
			return new Response(HttpStatus.OK, "List successfully created");
		} catch (ApiTacsException e) {
    		return new Response(e.getHttpStatus(), e.getMessage());
    	} catch (Exception e) {
    		logger.log(Level.WARNING, e.getMessage(), e);
    		return new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    	}
    }

    @Override
    @GetMapping("/{user-id}/list-of-places/{list-id}")
    public Response listOfPlacesListById(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
    	try {
			return new Response(HttpStatus.OK, listOfPlacesService.userListOfPlacesByName(userId, listId));
		} catch (ApiTacsException e) {
    		return new Response(e.getHttpStatus(), e.getMessage());
    	} catch (Exception e) {
    		logger.log(Level.WARNING, e.getMessage(), e);
    		return new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    	}
    }

    @Override
    @DeleteMapping("/{user-id}/list-of-places/{list-id}")
    public Response deleteListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId) throws ExceptionbyResourceNotFound {
    	try {
    		listOfPlacesService.deleteUserListOfPlaces(userId, listId);
    		return new Response(HttpStatus.OK, "List of places successfully deleted");
		} catch (ApiTacsException e) {
    		return new Response(e.getHttpStatus(), e.getMessage());
    	} catch (Exception e) {
    		logger.log(Level.WARNING, e.getMessage(), e);
    		return new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    	}
    }

    @Override
    @PutMapping("/{user-id}/list-of-places/{list-id}")
    public Response editListOfPlacesList(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @RequestParam("new-name") String newName) throws ExceptionbyResourceNotFound {
    	try {
    		listOfPlacesService.renameListOfPlaces(userId, listId, newName);
    		return new Response(HttpStatus.OK, "List of places successfully renamed");
		} catch (ApiTacsException e) {
    		return new Response(e.getHttpStatus(), e.getMessage());
    	} catch (Exception e) {
    		logger.log(Level.WARNING, e.getMessage(), e);
    		return new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    	}
    }

}
