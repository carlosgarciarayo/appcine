package com.cgr.appcine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgr.appcine.model.FilmsSheet;
import com.cgr.appcine.model.Movie;
import com.cgr.appcine.repository.MovieRepository;

@Service
public class MovieService {
   
	@Autowired
	private MovieRepository movieRepository;
	
	//Create operation
	public Movie create(String movieId, String name, String description, String poster) {
		return movieRepository.save(new Movie(movieId, name, description,poster));
	}
	//Retrieve operation
	public List<Movie> getAll(){
		return movieRepository.findAll();
	}
	public Movie getByName(String name) {
		return movieRepository.findByName(name);
	}
	//Update operation
	public Movie update(String name, String description, int outstanding) {
		Movie movie = movieRepository.findByName(name);
		movie.setName(name);
		//movie.setOutstanding(outstanding);
		return movieRepository.save(movie);
	}
	//Delete operation
	public void deleteAll() {
		movieRepository.deleteAll();
	}
	public void delete(String name) {
		Movie movie = movieRepository.findByName(name);
		movieRepository.delete(movie);
	}
}
