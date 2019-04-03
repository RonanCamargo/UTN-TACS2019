package utn.tacs.grupo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"utn.tacs.grupo3"})
public class Grupo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo3Application.class, args);
	}
	
}
