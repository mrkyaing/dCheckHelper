package com.prodev.job.scheduler.prodevict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProdevictApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdevictApplication.class, args);
	}

}
