package com.example.cleanarch.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	
	private PropertiesConfiguration properties;
	private DatabaseConfiguration database;
	
	@Autowired
	public ApplicationConfiguration(PropertiesConfiguration properties, DatabaseConfiguration database) {
		this.properties = properties;
		this.database = database;
	}
	
}
