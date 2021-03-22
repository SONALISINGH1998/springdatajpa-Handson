package com.cognizant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Attempt;
import com.cognizant.service.AttemptService;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


@SpringBootApplication
public class QuizApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizApplication.class);
	private static AttemptService attemptService;
	public static void main(String[] args) {
	
		ApplicationContext context = SpringApplication.run(QuizApplication.class, args);
		attemptService = context.getBean(AttemptService.class);
		LOGGER.info("Inside main"); 
		testGetAttempt();
	}
	
	public static void testGetAttempt() {
		Attempt a=attemptService.getAttemptById();
		System.out.println(a);
		}

}
