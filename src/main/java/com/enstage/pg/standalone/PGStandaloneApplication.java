package com.enstage.pg.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.enstage.pg.standalone.dao")
public class PGStandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PGStandaloneApplication.class, args);
		
		
	}

}
