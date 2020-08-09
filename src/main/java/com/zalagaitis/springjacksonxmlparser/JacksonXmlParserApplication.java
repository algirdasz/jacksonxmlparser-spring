package com.zalagaitis.springjacksonxmlparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JacksonXmlParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacksonXmlParserApplication.class, args);
	}
}
