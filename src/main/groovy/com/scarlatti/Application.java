package com.scarlatti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(PenguinRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Penguin("Jack", "Bauer"));
			repository.save(new Penguin("Chloe", "O'Brian"));
			repository.save(new Penguin("Kim", "Bauer"));
			repository.save(new Penguin("David", "Palmer"));
			repository.save(new Penguin("Michelle", "Dessler"));
			repository.save(new Penguin("Michelle", "Dessler"));

			// fetch all customers
			log.info("Penguins found with findAll():");
			log.info("-------------------------------");
			for (Penguin customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(penguin -> {
					log.info("Penguin found with findById(1L):");
					log.info("--------------------------------");
					log.info(penguin.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Penguin found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Penguin bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");

			// try something that should break
//			repository.findByFirstName("Jack");

			log.info("custom query: {}", repository.asdf());
		};
	}

}