package com.deepak.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.deepak.springdemo.modals.StudentModal;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		// 1st way of creating object
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		
		StudentModal student = context.getBean(StudentModal.class);
		System.out.println(student);
	}

}
