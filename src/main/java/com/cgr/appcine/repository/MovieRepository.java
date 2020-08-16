package com.cgr.appcine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cgr.appcine.model.Movie;


@Repository
public interface MovieRepository extends MongoRepository<Movie, String>{
   
	public Movie findByName(String name);
 
   // public List<Movie> findByOutstanding(int outstanding);
 //https://www.youtube.com/watch?v=68K96tSADfg&t=552s

}