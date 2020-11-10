package com.jacaranda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.jacaranda.controller", "com.jacaranda.service"})
@EntityScan
@EnableJpaRepositories

public class JacarandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacarandaApplication.class, args);
		
	}

}
