package com.cgr.appcine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgr.appcine.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByName(String name);
	Category findById(int id);
	
	
	
}
