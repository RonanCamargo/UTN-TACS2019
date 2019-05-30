package utn.tacs.grupo3.mongo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {
	
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("localhost");
	}
	
//	@Bean
//	public MongoDbFactory mongoDbFactory() {
//		return new SimpleMongoDbFactory(mongoClient(), "grupo3-mongodb");
//	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "grupo3-mongodb");
	}

}
