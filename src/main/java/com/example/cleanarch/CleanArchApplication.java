package com.example.cleanarch;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cleanarch.services.ApplicationService;

@SpringBootApplication
public class CleanArchApplication {

	private ApplicationService applicationService;
	
	public CleanArchApplication(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CleanArchApplication.class, args);
	}
	
	@Bean
	public void run() {
		
		try {
			this.applicationService.execute();
			
		} catch (Exception e) {
			
			LoggerFactory.getLogger(CleanArchApplication.class).error(e.getMessage());
		}
	}
}
