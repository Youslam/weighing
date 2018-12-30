package com.smart.app.weighing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.smart.app.weighing.auth.service", "com.smart.app.weighing.dao"})
//@EntityScan("com.smart.app.weighing.model")
public class WeighingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeighingApplication.class, args);
	}

}

