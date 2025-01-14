package com.example.spring_personal_finance_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO: Enable SecurityAutoConfiguration and figure out to edit the default login page
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringPersonalFinanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPersonalFinanceTrackerApplication.class, args);
	}

}
