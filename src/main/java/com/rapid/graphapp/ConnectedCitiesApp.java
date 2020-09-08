package com.rapid.graphapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan({"com.rapid.rest", "com.rapid.service"})

public class ConnectedCitiesApp {

	public static void main(String[] args) {
		
		SpringApplication.run(ConnectedCitiesApp.class, args);

	}

}
