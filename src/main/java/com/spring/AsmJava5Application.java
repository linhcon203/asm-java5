package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsmJava5Application {

	public static void main(String[] args) {
		SpringApplication.run(AsmJava5Application.class, args);
	}

}
