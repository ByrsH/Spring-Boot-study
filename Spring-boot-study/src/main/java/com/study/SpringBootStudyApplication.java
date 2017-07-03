package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}
}
