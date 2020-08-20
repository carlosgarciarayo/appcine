package com.cgr.appcine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgr.appcine.dto.movies.Company;
import com.cgr.appcine.model.FilmsSheet;
import com.cgr.appcine.model.Movie;


@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{}