package com.cgr.appcine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgr.appcine.model.FilmsSheet;
import com.cgr.appcine.repository.FilmRepository;

@Service
public class FilmService {
   
	@Autowired
	private FilmRepository filmRepository;
	
	//Create operation
	public FilmsSheet create(String title,String description, int outstanding, int status) {
		return filmRepository.save(new FilmsSheet(title, description, outstanding,status));
	}
	//Retrieve operation
	public List<FilmsSheet> getAll(){
		return filmRepository.findAll();
	}
	public FilmsSheet getByTitle(String title) {
		return filmRepository.findByTitle(title);
	}
	//Update operation
	public FilmsSheet update(String title, String description, int outstanding) {
		FilmsSheet p = filmRepository.findByTitle(title);
		p.setTitle(title);
		p.setOutstanding(outstanding);
		return filmRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		filmRepository.deleteAll();
	}
	public void delete(String title) {
		FilmsSheet FilmsSheet = filmRepository.findByTitle(title);
		filmRepository.delete(FilmsSheet);
	}
}
