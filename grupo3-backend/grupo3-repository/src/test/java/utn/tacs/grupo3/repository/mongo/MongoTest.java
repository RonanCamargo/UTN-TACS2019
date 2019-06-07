package utn.tacs.grupo3.repository.mongo;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.mongo.configuration.MongoConfiguration;
import utn.tacs.grupo3.repository.mongo.UserRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfiguration.class})
public class MongoTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserRepositoryImpl userMongoRepo;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Test
//	public void saveUserTest() {
//		User user = new User();
//		user.initialize();
//		user.setUsername("ronan");
//		
//		User savedUser = mongoTemplate.save(user);
//		
//		Assert.assertNotNull(savedUser);
//		Assert.assertNotNull(savedUser.getId());
//		Assert.assertEquals(user.getUsername(), savedUser.getUsername());
//	}
//
//	@Test
//	public void getUserByUsernameTest() {
//		User ronan = userMongoRepo.getUserByUsername("ronan");
//		
//		Assert.assertNotNull(ronan);
//		Assert.assertEquals("ronan", ronan.getUsername());
//	}
//	
//	@Test
//	public void createListOfPlaces() {
//		User ronan = userMongoRepo.addList("ronan", "Universidades");
//		
//		Assert.assertTrue(ronan.getListsOfPlaces().stream().anyMatch(list -> list.getListName().equals("Universidades")));
//	}
//	
//	@Test
//	public void addPlaceToListAndSave() {
//		User ronan = userMongoRepo.getUserByUsername("ronan");
//		ListOfPlaces universidades = ronan.getListsOfPlaces().stream().filter(list -> list.getListName().equals("Universidades")).collect(Collectors.toList()).get(0);
//		
//		Place place = new Place("UTN Medrano", "Av. Medrano 951");
//		place.setLatitude(1234.4f);
//		place.setLongitude(1234.4f);
//		place.setFoursquareId("as34asdfsd45");		
//		
//		universidades.getPlaces().add(place);
//		
//		userMongoRepo.save(ronan);
//		
//		RegisteredPlace registeredPlace = new RegisteredPlace();
//		registeredPlace.setFoursquareId(place.getFoursquareId());
//
//		registeredPlace.setName(place.getName());
//		registeredPlace.setAddress(place.getAddress());
//		registeredPlace.setRegistrationDate(LocalDate.now());
//	
//
//		
//		mongoTemplate.save(registeredPlace);		
//		
//	}
//	
//	@Test
//	public void saveSamePlace() {
//		User ronan = userMongoRepo.getUserByUsername("ronan");
//		ListOfPlaces universidades = ronan.getListsOfPlaces().stream().filter(list -> list.getListName().equals("Universidades")).collect(Collectors.toList()).get(0);
//		
//		Place place = new Place("UTN Campus", "Av. asdasd 951");
//		place.setLatitude(1234.4f);
//		place.setLongitude(1234.4f);
//		place.setFoursquareId("asdadfsfas34asdfsd45");		
//		
//		universidades.getPlaces().add(place);
//		
//		userMongoRepo.save(ronan);
//		
//		RegisteredPlace registeredPlace = new RegisteredPlace();
//		registeredPlace.setFoursquareId(place.getFoursquareId());
////		registeredPlace.setLatitude(place.getLatitude());
////		registeredPlace.setLongitude(place.getLongitude());
//		registeredPlace.setName(place.getName());
//		registeredPlace.setAddress(place.getAddress());
//		registeredPlace.setRegistrationDate(LocalDate.now());
//		
//		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("foursquareId").is(place.getFoursquareId()));
//		
//		if (!mongoTemplate.exists(query, RegisteredPlace.class)) {
//			mongoTemplate.save(registeredPlace);
//		}
//	
		
//	}

}
