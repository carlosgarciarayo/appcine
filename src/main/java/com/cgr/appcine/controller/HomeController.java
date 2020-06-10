package com.cgr.appcine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"home","/",""})
public class HomeController {

	

	
	@GetMapping("/catelera")
	public String home() {
		
		return "templates/index";
	}
	
	@GetMapping("/registrarse")
	public String regsitration() {
		
		return "admin/login";
	}

	
}
