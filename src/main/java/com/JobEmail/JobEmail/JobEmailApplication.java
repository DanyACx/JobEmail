package com.JobEmail.JobEmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JobEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobEmailApplication.class, args);
	}

}
