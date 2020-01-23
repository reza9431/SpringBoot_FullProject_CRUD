package net.fullproject.spring_fullproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"net.fullproject.spring_fullproject"})
@EnableAutoConfiguration
public class SpringFullprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFullprojectApplication.class , args);
    }

}
