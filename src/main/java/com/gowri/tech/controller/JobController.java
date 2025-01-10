package com.gowri.tech.controller;

import org.slf4j.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author -NaveenWodeyar
 * @date -26-Oct-2024
 * @time - 12:54:31 pm
 * @location -
 */

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private static final Logger log = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@GetMapping
	public String testConnection() {
		log.info("test connection");
		return "Connected,,";
	}

	@PostMapping("/importCustomers")
	public void importCsvToDBJob() {
		final JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
				.toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
	
}
