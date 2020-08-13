package com.cgr.appcine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgr.appcine.model.FilmsSheet;
import com.cgr.appcine.service.FilmService;



//@Controller
@RestController
public class filmController {

	@Autowired
	private FilmService filmService;
	
	@GetMapping(path = "/ficha-pelicula")
	public String categoryForm() {

		return "films/filmSheet";

	}

	@RequestMapping("/create")
	public String create(@RequestParam String title, @RequestParam String description, @RequestParam int outstanding, @RequestParam int status) {
		FilmsSheet filmsSheet = filmService.create(title, description, outstanding,status);
		return filmsSheet.toString();
	}
	
	@RequestMapping("/get")
	public FilmsSheet getFilmsSheet(@RequestParam String title) {
		return filmService.getByTitle(title);
	}
	@RequestMapping("/getAll")
	public List<FilmsSheet> getAll(){
		return filmService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String title, @RequestParam String description, @RequestParam int outstanding) {
		FilmsSheet filmsSheet = filmService.update(title, description, outstanding);
		return filmsSheet.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String title) {
		filmService.delete(title);
		return "Deleted " + title;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		filmService.deleteAll();
		return "Deleted all records";
	}
	
}
