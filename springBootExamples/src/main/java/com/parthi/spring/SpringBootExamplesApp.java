package com.parthi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/*// 
 * @EnableScheduling ensures Spring Boot background Task executor is created. 
 */
@EnableScheduling
public class SpringBootExamplesApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExamplesApp.class, args);
	}
}
