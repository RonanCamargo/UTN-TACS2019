package utn.tacs.grupo3.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.repository.exception.DocumentNotFoundException;
import utn.tacs.grupo3.repository.mongo.KeyValue;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.service.ListOfPlacesService;
import utn.tacs.grupo3.service.exception.ApiTacsException;

@Service
public class ListOfPlacesServiceImpl implements ListOfPlacesService{

	@Autowired
    private UserRepository userRepository;

	@Override
	public List<ListOfPlaces> allUserListsOfPlaces(String username) {
		try {
			return userRepository.userByUsername(username).getListsOfPlaces();			
		} catch (DocumentNotFoundException e) {
			throw new ApiTacsException("Username not found", HttpStatus.NOT_FOUND, e);
		}
	}

	@Override
	public void createListOfPlaces(String username, String listName) {
		checkIfUserNotExists(username);
		
		if (listExists(username, listName)) {
			throw new ApiTacsException("User already has a list named ["+listName+"]", HttpStatus.CONFLICT);
		}
		
		userRepository.createListOfPlaces(username, listName);		
	}

	@Override
	public ListOfPlaces userListOfPlacesByName(String username, String listName) {
		checkIfUserNotExists(username);
		
		return userRepository.findListOfPlaces(username, listName);
	}

	@Override
	public void deleteUserListOfPlaces(String username, String listName) {
		checkIfUserNotExists(username);
		if (!listExists(username, listName)) {
			throw new ApiTacsException("User does not have a list named ["+listName+"]", HttpStatus.NOT_FOUND);
		}
		userRepository.deleteListOfPlaces(username, listName);
	}

	@Override
	public void renameListOfPlaces(String username, String listName, String newName) {
		checkIfUserNotExists(username);
		if (!listExists(username, listName)) {
			throw new ApiTacsException("User does not have a list named ["+listName+"]", HttpStatus.NOT_FOUND);
		}

		userRepository.renameListOfPlaces(username, listName, newName);		
	}
	
	private boolean listExists(String username, String listName) {
		return userRepository.existsBy(Arrays.asList(
				KeyValue.pair("username", username),
				KeyValue.pair("listsOfPlaces.listName", listName)));
	}

	private void checkIfUserNotExists(String username) {
		if (!userRepository.existsBy("username", username)) {
			throw new ApiTacsException("User not exists ["+username+"]", HttpStatus.NOT_FOUND);
		}
	}

}
