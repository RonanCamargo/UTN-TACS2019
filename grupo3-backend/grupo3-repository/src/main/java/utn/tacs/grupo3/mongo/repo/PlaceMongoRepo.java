package utn.tacs.grupo3.mongo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.RegisteredPlace;

@Repository
public class PlaceMongoRepo {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public RegisteredPlace save(RegisteredPlace registeredPlace) {
		return mongoTemplate.save(registeredPlace);
	}

}
