package com.config;

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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.EntityClass;

@Configuration
@EnableBatchProcessing
public class CsvBatchConfig 
{
	@Autowired
	private Repository repository;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
    // Create Reader
	
   @Bean
   public FlatFileItemReader<EntityClass> flatFileItemReader()
	{
		FlatFileItemReader<EntityClass> filereader=new
				FlatFileItemReader<>();
		
		filereader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		filereader.setName("csv-reader");
		filereader.setLinesToSkip(1);
		filereader.setLineMapper(linemapper());
		return filereader;
	}
	private LineMapper<EntityClass> linemapper() {

		DefaultLineMapper<EntityClass> lineMapper=new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");
		
		BeanWrapperFieldSetMapper<EntityClass> feildsetwrapper=new
				BeanWrapperFieldSetMapper<>();
		feildsetwrapper.setTargetType(EntityClass.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(feildsetwrapper);
		return lineMapper;
	}
	
	//create process
	@Bean
	public CustomerProcess customerProcess()
	{
		return new CustomerProcess();
	}
	
	//create writer
	@Bean
	public RepositoryItemWriter<EntityClass> repositoryItemWriter()
	{
		RepositoryItemWriter<EntityClass> repositoryItemWriter=new 
				RepositoryItemWriter<>();
		
		repositoryItemWriter.setRepository((CrudRepository<EntityClass, ?>) repository);
		repositoryItemWriter.setMethodName("save");
		
		return repositoryItemWriter;
	}
	
	@Bean
	public Step step()
	{
		return stepBuilderFactory.get("step-1").<EntityClass,EntityClass>chunk(0)
				            .reader(flatFileItemReader())
				            .processor(customerProcess())
				            .writer(repositoryItemWriter())
				            .build();
	}
	
	@Bean
	public Job job()
	{
		return jobBuilderFactory.get("Customer-jobs")
				      .flow(step())
				      .end()
				      .build();
	}
	

}