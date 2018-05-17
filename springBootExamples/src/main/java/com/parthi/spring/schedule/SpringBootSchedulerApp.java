package com.parthi.spring.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.parthi.spring.SpringBootExamplesApp;

@SpringBootApplication
/*// 
 * @EnableScheduling ensures Spring Boot background Task executor is created. 
 */
@EnableScheduling
public class SpringBootSchedulerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExamplesApp.class, args);
	}
}
