package com.gowri.tech;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class BatchProcessingApplication {

    private static final Logger logger = LoggerFactory.getLogger(BatchProcessingApplication.class);

    @Value("${spring.application.name:Application}")
    private String appName;  

    public static void main(String[] args) {
        var context = SpringApplication.run(BatchProcessingApplication.class, args);
        var env = context.getEnvironment();

        var appName = env.getProperty("spring.application.name", "Application");
        var port = env.getProperty("server.port", "8080");
        var activeProfiles = String.join(", ", env.getActiveProfiles());

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        logger.info("[{}] ***************************************", timestamp);
        logger.info("[{}] Application Name: {}", timestamp, appName);
        logger.info("[{}] Port Number: {}", timestamp, port);
        logger.info("[{}] Active Profiles: {}", timestamp, activeProfiles.isEmpty() ? "None" : activeProfiles);
        logger.info("[{}] ***************************************", timestamp);
    }

    @Scheduled(cron = "0 0/4 * * * *")  
    public void printAppNameEveryFourMinutes() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info("[{}] Application Name: {}", timestamp, appName); 
    }
}
