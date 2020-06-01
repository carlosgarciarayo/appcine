package com.cgr.appcine.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.cgr.appcine.model.Category;
import com.cgr.appcine.model.Profiles;
import com.cgr.appcine.model.User;
import com.cgr.appcine.repository.CategoryRepository;
import com.cgr.appcine.repository.UserRepository;
	




@Service
public class UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CategoryRepository categoryRepository;

	List<User> listUser = new ArrayList();
	
	
	
	public void saveUser(User user) {

		userRepository.save(user);

	}
	
	public List<User> listUser(){

		
		listUser = userRepository.findAll();
		
		return listUser;
		
	}
	

	public Page<User> searchAll(Pageable page){

		return userRepository.findAll(page);

	}

	
	public Page<User> searchAllPagOrdenadosDescending() {

		return userRepository.findAll(PageRequest.of(0, 5,Sort.by("name").descending()));

		
	}
	public Page<User> searchAllPagOrdenadosAscending() {

		return userRepository.findAll(PageRequest.of(0, 5,Sort.by("name").ascending()));

		
	}
	
	
	public void userDelete(Integer id) {
		
		userRepository.deleteById(id);
		
		
	}
	
	
	public List<User> findByNameLike(String name){
		
		listUser = userRepository.findByNameLike(name+"%");
		
		return listUser;
	}
	
	
	public List<Category> listCategory(){
		
		return categoryRepository.findAll();
		
	}

	
	public User findById(int id) {
		
		return userRepository.findById(id);
		
	}
	
	
	
	public void saveProfile(List<Profiles> temporalProfiles) {
		
		
		
		
	}
	
	
	

	
	


	
	
	
	
	
	
}
