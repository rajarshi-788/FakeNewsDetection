package com.fakenews.detector.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Value("${spring.datasource.username}")
	private String dataSourceUsername;

	@Value("${spring.datasource.password}")
	private String dataSourcePassword;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// Oracle JDBC driver
		dataSource.setDriverClassName(driverClassName);

		// For Oracle 10g XE: SID = XE
		dataSource.setUrl(dataSourceUrl);

		// DB credentials
		dataSource.setUsername(dataSourceUsername); // replace with your user
		dataSource.setPassword(dataSourcePassword); // replace with your password

		return dataSource;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
