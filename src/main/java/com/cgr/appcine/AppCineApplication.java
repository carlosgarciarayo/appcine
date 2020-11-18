package com.cgr.appcine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cgr.appcine.service.UserService;

@SpringBootApplication
public class AppCineApplication {

	//prueba
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AppCineApplication.class, args);
	
	
	}
	
	public void run(String... args) throws Exception {


	}

}
