package com.EECS.demo.app1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
public class Course1Application {

	public static void main(String[] args) {
		SpringApplication.run(Course1Application.class, args);
	}

	@Bean
	public String basicMessage()
	{
		System.out.println("inside basicMessage");
		return "hello";
	}

	@Bean
	public String compoundMessage(String basicMessage)
	{
		System.out.println("inside compoundMessage received: " + basicMessage);
		return basicMessage + ", Spring!";
	}

	@Bean
	public int characterCount(@Qualifier("basicMessage")String message)
	{
		return message.length();
	}
}
