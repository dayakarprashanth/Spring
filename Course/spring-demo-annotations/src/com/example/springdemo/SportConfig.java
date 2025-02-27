
package com.example.springdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define the bean for our sad fortune service 
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
		
	}
	
	//define bean for our swim Coach and inject dependency
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortuneService());
	}
	
}
