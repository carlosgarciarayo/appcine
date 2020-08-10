package com.cgr.appcine.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgr.appcine.model.FilmsSheet;


@Repository
public interface FilmRepository extends MongoRepository<FilmsSheet, String>{
   public FilmsSheet findByTitle(String title);
   public List<FilmsSheet> findByOutstanding(int outstanding);
 //https://www.youtube.com/watch?v=68K96tSADfg&t=552s

}