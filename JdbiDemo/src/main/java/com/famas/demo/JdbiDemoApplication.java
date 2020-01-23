package com.famas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.famas")
public class JdbiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbiDemoApplication.class, args);
	}

}
