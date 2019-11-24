package com.example.cleanarch.configurations;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfiguration {

	private SqlSessionFactory sqlSessionFactory;
	private PropertiesConfiguration properties;
	
	@Autowired
	public DatabaseConfiguration(SqlSessionFactory sqlFactory, PropertiesConfiguration properties) {
		this.sqlSessionFactory = sqlFactory;
		this.properties = properties;
	}
	
	@Bean
	public void configure() {
		
		DataSource dataSource = new PooledDataSource(
				this.properties.getDatasource().getDriver(),
				this.properties.getDatasource().getUrl(),
				this.properties.getDatasource().getUsername(),
				this.properties.getDatasource().getPassword()
			);
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		
		Environment environment = new Environment(this.properties.getEnvironment(), transactionFactory, dataSource);
		
		Configuration configuration = new Configuration(environment);
		
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}	
}
