package com.smart.app.weighing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.smart.app.weighing.dao"})
public class WeighingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeighingApplication.class, args);
	}

}

