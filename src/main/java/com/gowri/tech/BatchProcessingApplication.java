package com.gowri.tech;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchProcessingApplication {

    private static final Logger logger = LoggerFactory.getLogger(BatchProcessingApplication.class);

    public static void main(String[] args) {
        var context = SpringApplication.run(BatchProcessingApplication.class, args);
        var env = context.getEnvironment();

        var appName = env.getProperty("spring.application.name", "Application");
        var port = env.getProperty("server.port", "8080");
        var activeProfiles = String.join(", ", env.getActiveProfiles());

        // Manually adding a timestamp to the log message
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        logger.info("[{}] Application Name: {}", timestamp, appName);
        logger.info("[{}] Port Number: {}", timestamp, port);
        logger.info("[{}] Active Profiles: {}", timestamp, activeProfiles.isEmpty() ? "None" : activeProfiles);
        logger.info("[{}] ***************************************", timestamp);
    }
}
