package com.gowri.tech.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.gowri.tech.entity.Customer;
import com.gowri.tech.repo.Customerrepository;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private final Customerrepository customerRepository;

    public SpringBatchConfig(Customerrepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Value("${FILE.LOCATOR}")
    private String fileLocation;

    @Bean
    FlatFileItemReader<Customer> reader() {
        final FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(fileLocation));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        final DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        final BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    RepositoryItemWriter<Customer> writer() {
        final RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepository);
        writer.setMethodName("save");
        return writer;
    }

//    @Bean
//    Step step1(org.springframework.batch.core.job.builder.JobBuilder jobBuilder, org.springframework.batch.core.step.builder.StepBuilder stepBuilder) {
//        return stepBuilder.get("csv-step")
//                .<Customer, Customer>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .taskExecutor(taskExecutor())
//                .build();
//    }
//
//    @Bean
//    Job runJob(org.springframework.batch.core.job.builder.JobBuilder jobBuilder) {
//        return jobBuilder.get("importCustomers")
//                .flow(step1(null, null)) 
//                .end()
//                .build();
//    }

    @Bean
    TaskExecutor taskExecutor() {
        final SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
