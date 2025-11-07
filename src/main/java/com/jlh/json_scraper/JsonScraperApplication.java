package com.jlh.json_scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonScraperApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(JsonScraperApplication.class, args);
		Logger logger = LoggerFactory.getLogger("Startup");
		logger.info("Starting scrapers...");
		ScraperController.getInstance();
		logger.info("Scrapers initialized.");
		
	}

	

}
