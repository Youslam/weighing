package com.smart.app.weighing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WeighingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WeighingApplication.class, args);
	}

	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(WeighingApplication.class);
	 }
}

