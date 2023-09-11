package cgg.sprinboot.rest.springbootrestvalidation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootrestvalidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestvalidationApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
