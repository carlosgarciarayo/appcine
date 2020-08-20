package com.cgr.appcine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgr.appcine.dto.movies.Companies;
import com.cgr.appcine.dto.movies.Company;
import com.cgr.appcine.dto.movies.Genres;
import com.cgr.appcine.dto.movies.Movie;
import com.cgr.appcine.dto.movies.ProductionCountry;
import com.cgr.appcine.repository.CompanyRepository;

@Service
public class CompanyService {
   
	
	
	@Autowired
	private CompanyRepository companyRepository;


	//Create operation
	public Company create(String companyId, String name, String originCountry) {
		
		return companyRepository.save(new Company(companyId, name, originCountry));

	}



}
