package com.example.cleanarch.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.cleanarch.configurations.entities.DatabaseProperties;

@Component
@PropertySource("classpath:application.yaml")
@ConfigurationProperties(prefix = "spring")
public class PropertiesConfiguration {

	private String environment;
	private DatabaseProperties datasource;

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setDatasource(DatabaseProperties datasource) {
		this.datasource = datasource;
	}

	public String getEnvironment() {
		return this.environment;
	}
	
	public DatabaseProperties getDatasource() {
		return datasource;
	}
	
}
