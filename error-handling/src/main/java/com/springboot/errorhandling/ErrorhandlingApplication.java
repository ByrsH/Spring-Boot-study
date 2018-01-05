package com.springboot.errorhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "com.springboot")
public class ErrorhandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorhandlingApplication.class, args);
	}
}
