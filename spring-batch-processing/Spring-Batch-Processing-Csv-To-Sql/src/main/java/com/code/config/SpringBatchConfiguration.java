package com.code.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.code.entity.Customer;
import com.code.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfiguration {

	@Autowired
	private JobBuilderFactory jobFactory;

	@Autowired
	private StepBuilderFactory stepFactory;

	@Autowired
	private CustomerRepository repository;

	@Bean
	public FlatFileItemReader<Customer> reader() {

		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader();
		// load csv file
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));

		itemReader.setName("csvReader");

		// skiped first line of csv file because it contain header info
		itemReader.setLinesToSkip(1);

		itemReader.setLineMapper(lineMapper());

		return itemReader;
	}

	// how to read data from csv file,how to map
	private LineMapper<Customer> lineMapper() {

		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

//***************************************************************************************

		// read csv file which is ,(comma)seperated value
		DelimitedLineTokenizer delimited = new DelimitedLineTokenizer();

		delimited.setDelimiter(",");
		delimited.setStrict(false);

		delimited.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

//***************************************************************************************

		// delimted mapped to the Customer Object
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class);

		lineMapper.setLineTokenizer(delimited);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	@Bean
	public CustomerProcessor processor() {

		return new CustomerProcessor();

	}

	@Bean
	public RepositoryItemWriter<Customer> writer() {

		// use my repository and save method to writer data from csv to my database
		RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
		// repository is reference variable here which is extends jpaRespository
		writer.setRepository(repository);
		// save represent here method which is present in side jpaRepository
		writer.setMethodName("save");

		return writer;
	}

	@Bean
	public Step step1() {
		// csv-step is name of step we can give any name
		return stepFactory.get("csv-step").<Customer, Customer>chunk(10).
				reader(reader()).
				processor(processor()).
				writer(writer()).
				taskExecutor(taskExecutor()).
				build();
	}

	@Bean
	public Job jobRun() {

		return jobFactory.get("importCustomers").flow(step1()).end().build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
	
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}

}
