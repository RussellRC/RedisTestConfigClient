package com.rusell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class Application {

    @Autowired
    Environment environment;
    
    @RequestMapping("/")
    @RefreshScope
    public String home() {
        return "Hello World " + environment.getProperty("com.russell.random.1");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}