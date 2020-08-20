package com.cgr.appcine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgr.appcine.dto.movies.Movie;


@Repository
public interface MovieRepository extends MongoRepository<Movie, String>{
	
	public Movie findByName(String name);


}