package com.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineBookStoreApplication {

	 static final Logger logger = LoggerFactory.getLogger(OnlineBookStoreApplication.class);

	public static void main(String[] args) {
		
		logger.debug("this is a debug message");
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	      
	      
		SpringApplication.run(OnlineBookStoreApplication.class, args);
	}

}
