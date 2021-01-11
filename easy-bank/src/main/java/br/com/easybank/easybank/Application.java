package br.com.easybank.easybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"br.com.easybank.easybank.repositories"})
@EntityScan(basePackages = {"br.com.easybank.easybank.models"})
@ComponentScan(basePackages = {"br.com.easybank.easybank"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}