package com.goodcars.DealershipGenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.goodcars")
public class DealershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealershipApplication.class, args);
	}

}
