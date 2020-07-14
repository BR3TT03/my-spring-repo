package com.auasms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.auasms.app")
@SpringBootApplication
public class AuaSmsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuaSmsServiceApplication.class, args);
	}

}
