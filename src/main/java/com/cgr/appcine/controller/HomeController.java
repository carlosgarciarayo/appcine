package com.cgr.appcine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	


	@RequestMapping(path = "/peliculasFicha")
	public String homeFichaPeliculas() {
		
		return "admin/movieForm.html";
	}
	
}
