package com.gowri.tech.config;

import java.time.LocalDateTime;
import java.util.Date;
import org.slf4j.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.context.annotation.Configuration;

/**
 * @author -NaveenWodeyar
 * @date -18-Dec-2024
 * @time - 10:46:09 pm
 * @location -
 */
@Configuration
public class QuartzJob implements Job{
	
	private static final Logger log = LoggerFactory.getLogger(QuartzJob.class);

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void execute(JobExecution execution) {
		log.info("Started::Job{}",LocalDateTime.now());
		System.out.println("\nQuartz_Config\n");
		System.out.println(new Date());
		log.info("Completed::Job{}",LocalDateTime.now());
	}

}
