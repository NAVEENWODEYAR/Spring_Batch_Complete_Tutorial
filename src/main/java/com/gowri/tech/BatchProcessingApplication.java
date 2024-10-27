package com.gowri.tech;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableBatchProcessing
public class BatchProcessingApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(BatchProcessingApplication.class, args);
        Environment env = context.getEnvironment();

        String appName = env.getProperty("spring.application.name", "Application");
        String port = env.getProperty("server.port", "8080");
        String activeProfiles = String.join(", ", env.getActiveProfiles());

        System.out.println("Application Name: " + appName);
        System.out.println("Port Number: " + port);
        System.out.println("Active Profiles: " + (activeProfiles.isEmpty() ? "None" : activeProfiles));
        System.out.println("***************************************");
    }
}
