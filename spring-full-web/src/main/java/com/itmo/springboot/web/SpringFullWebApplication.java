package com.itmo.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.itmo.springboot.repo")
@EntityScan("com.itmo.springboot.web.model")
public class SpringFullWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFullWebApplication.class, args);
	}

}
