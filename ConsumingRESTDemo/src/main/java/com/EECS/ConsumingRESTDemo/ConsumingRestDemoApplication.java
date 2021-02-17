package com.EECS.ConsumingRESTDemo;

import com.EECS.ConsumingRESTDemo.entity.Joke;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;

@SpringBootApplication
public class ConsumingRestDemoApplication {
	private static final Logger log = LoggerFactory.getLogger(ConsumingRestDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception
	{
		return args ->{
			Joke joke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke",Joke.class);
			log.info(joke.toString());
		};
	}
}
