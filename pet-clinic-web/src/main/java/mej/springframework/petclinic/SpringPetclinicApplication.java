package mej.springframework.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan()
public class SpringPetclinicApplication {
	///*/*
	public static void main(String[] args) {
		SpringApplication.run(SpringPetclinicApplication.class, args);
	}

}
