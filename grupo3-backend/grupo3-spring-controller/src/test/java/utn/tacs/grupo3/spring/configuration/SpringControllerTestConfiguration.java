package utn.tacs.grupo3.spring.configuration;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import utn.tacs.grupo3.spring.helper.TodayHelper;

@Configuration
@ComponentScan(basePackages = "utn.tacs.grupo3")
public class SpringControllerTestConfiguration {
	
	@Bean
	public TodayHelper todayHelper() {
		return () -> LocalDate.of(2019, Month.APRIL, 1);
	}

}
