package utn.tacs.grupo3.repository.mongo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import utn.tacs.grupo3.model.Role;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.mongo.configuration.MongoConfiguration;
import utn.tacs.grupo3.repository.exception.DocumentNotUniqueException;
import utn.tacs.grupo3.repository.exception.UserNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfiguration.class})
public class MongoUserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MongoOperations mongoOps;
	
	private User juan;
	
	@Before
	public void setUp() {
		if (!mongoOps.collectionExists(User.class)) {
			mongoOps.createCollection(User.class);
		}		
		
		juan = new User();
		juan.setRole(Role.USER);
		juan.setFirstName("Juan");
		juan.setLastName("Perez");
		juan.setUsername("JPerez1");		
	}
	
	@After
	public void tearDown() {
		if (mongoOps.collectionExists(User.class)) {
			mongoOps.dropCollection(User.class);			
		}
	}
	
	@Test
	public void saveUserTest() {		
		User savedUser = userRepository.save(juan);
		
		Assert.assertNotNull(savedUser);
		Assert.assertEquals(juan.getRole(), savedUser.getRole());
		Assert.assertEquals(juan.getFirstName(), savedUser.getFirstName());
		Assert.assertEquals(juan.getLastName(), savedUser.getLastName());
		Assert.assertEquals(juan.getUsername(), savedUser.getUsername());
		Assert.assertTrue(savedUser.getListsOfPlaces().isEmpty());
	}
	
	@Test
	public void usernameAlreadyExistsTest() {
		userRepository.save(juan);		
		boolean exists = userRepository.existsBy("username", "JPerez1");
		
		Assert.assertTrue(exists);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void usernameNotFoundTest() {
		userRepository.userByUsername("pepe");
	}
	
	@Test(expected = DocumentNotUniqueException.class)
	public void createDuplicatedListOfPlacesTest() {
		userRepository.save(juan);
		userRepository.createListOfPlaces("JPerez1", "Universidades");
		userRepository.createListOfPlaces("JPerez1", "Universidades");		
	}
	
	@Test
	public void deleteListOfPlacesTest() {
		userRepository.save(juan);
		userRepository.createListOfPlaces("JPerez1", "Bancos");
		userRepository.deleteListOfPlaces("JPerez1", "Bancos");
		userRepository.createListOfPlaces("JPerez1", "Bancos");
		userRepository.createListOfPlaces("JPerez1", "Universidades");
	}
	
	@Test
	public void renameListOfPlacesTest() {
		userRepository.save(juan);
		userRepository.createListOfPlaces("JPerez1", "Bancos");
		userRepository.createListOfPlaces("JPerez1", "Universidades");

		userRepository.renameListOfPlaces("JPerez1", "Bancos", "B4nc0s");
	}
	
	

}
