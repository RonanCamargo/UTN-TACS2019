package utn.tacs.grupo3.service.validation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import utn.tacs.grupo3.repository.mongo.KeyValue;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.service.exception.ApiTacsException;

@Component
public class ServiceValidation {
	
	@Autowired
	private UserRepository userRepository;
	
	public void checkIfListExists(String username, String listName) {
		if (userRepository.existsBy(Arrays.asList(
				KeyValue.pair("username", username),
				KeyValue.pair("listsOfPlaces.listName", listName)))) {
			throw new ApiTacsException("User already has a list named ["+listName+"]", HttpStatus.CONFLICT);
		}
	}
	
	public void checkIfListNotExists(String username, String listName) {
		if (userRepository.existsBy(Arrays.asList(
				KeyValue.pair("username", username),
				KeyValue.pair("listsOfPlaces.listName", listName)))) {
			throw new ApiTacsException("User does not have a list named ["+listName+"]", HttpStatus.NOT_FOUND);
		}
	}	

	public void checkIfUserNotExists(String username) {
		if (!userRepository.existsBy("username", username)) {
			throw new ApiTacsException("User not exists ["+username+"]", HttpStatus.NOT_FOUND);
		}
	}
}
