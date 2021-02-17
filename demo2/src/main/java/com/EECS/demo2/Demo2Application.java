package com.EECS.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Bean
	public String message()
	{
		System.out.println("Bean message created");
		return "Hello Spring!";
	}

	@Bean
	public String uppercaseMessage(MessageService messageService)
	{
		System.out.println("Bean uppercaseMessage created");
		return messageService.uppercase();
	}

	@Bean
	public String lowercaseMessage(MessageService messageService)
	{
		System.out.println("Bean lowercaseMessage created");
		return messageService.lowercase();
	}
}
