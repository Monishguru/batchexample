package com.monish.batchexample.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.monish.batchexample.listener.JobCompletionListener;
import com.monish.batchexample.steps.Processor;
import com.monish.batchexample.steps.Reader;
import com.monish.batchexample.steps.Writer;

@Configuration
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderfactory;
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("testJob").
				incrementer(new RunIdIncrementer()).
				listener(listener()).flow(testStep()).end().build();
	
	}

	private Step testStep() {
		// TODO Auto-generated method stub
		
		 return stepBuilderfactory.get("testStep").<String, String> chunk(2).
		 reader(new Reader()).processor(new Processor()).writer(new Writer()).build();
		 
	}

	private JobExecutionListener listener() {
		// TODO Auto-generated method stub
		
		return new JobCompletionListener();
	}

}
