package com.cgr.appcine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cgr.appcine.service.MovieService;

@Controller
public class HomeController {

	

	@Autowired
	private MovieService movieService;
	
	
	

	@GetMapping(path = "/")
	public String homeFichaPeliculas(Model model) {
		
		
		model.addAttribute("movieId", movieService.getByMovieId(5));
		
		
		
		
		
		return "index.html";
	}
	

	
}
