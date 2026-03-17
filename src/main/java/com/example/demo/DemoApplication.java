package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
    	jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS products (id SERIAL, name VARCHAR(255))");

		ProductService productService = context.getBean(ProductService.class);

        System.out.println("--- Starting addProduct ---");
        productService.addProduct("Laptop Gaming");
        System.out.println("--- Finished addProduct ---");

		// access to http://localhost:8080/h2-console
		// JDBC URL: jdbc:h2:mem:testdb
		// add to pom.xml: spring-boot-starter-web to keep application running and access h2-console
	}

}
