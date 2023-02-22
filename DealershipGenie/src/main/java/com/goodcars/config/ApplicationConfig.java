package com.goodcars.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EntityScan(basePackages = "com.goodcars.entity")

@EnableJpaRepositories(basePackages = "com.goodcars.repo")

public class ApplicationConfig {
    

}
