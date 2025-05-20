package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("net.javaguides.springboot.model")
@EnableJpaRepositories("net.javaguides.springboot.repository")
public class FullstackDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackDesafioApplication.class, args);
	}

}
