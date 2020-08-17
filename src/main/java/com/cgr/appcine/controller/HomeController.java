package com.cgr.appcine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	


	@RequestMapping(path = "/peliculasFicha")
	public String homeFichaPeliculas() {
		
		return "sinUsar/dashboard.html";
	}
	
}
