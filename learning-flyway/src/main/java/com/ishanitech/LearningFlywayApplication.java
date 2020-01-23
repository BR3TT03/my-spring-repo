package com.ishanitech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ishanitech.repository.BookRepository;
import com.ishanitech.service.RemoteApiCaller;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LearningFlywayApplication {
	Logger log = LoggerFactory.getLogger(LearningFlywayApplication.class);
	@Autowired
	RemoteApiCaller remoteApiCaller;
	
	public static void main(String[] args) {
		SpringApplication.run(LearningFlywayApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BookRepository repository) {
		remoteApiCaller.getAllUsers();
		return r -> log.info(repository.findAll().toString());
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
