package com.softwarecrafter.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author roman (rzett) from software-crafter.com
 */

@EnableJpaRepositories("com.softwarecrafter.springbootsample.persistence.repo")
@EntityScan("com.softwarecrafter.springbootsample.persistence.model")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

}
