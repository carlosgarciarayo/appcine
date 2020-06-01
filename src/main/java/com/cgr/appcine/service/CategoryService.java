package com.cgr.appcine.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgr.appcine.controller.UserController;
import com.cgr.appcine.model.Category;
import com.cgr.appcine.model.User;
import com.cgr.appcine.repository.CategoryRepository;

@Service
public class CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> findAl() {

		return categoryRepository.findAll();

	}

	public void saveCategory(Category category) {

		categoryRepository.save(category);

	}

	public void deleteCategory(Integer id) {

		categoryRepository.deleteById(id);

	}

	public void deleteCategoryAll() {

		categoryRepository.deleteAll();

	}

//	public List<Category> findByNombre(String name) {
//
//		List<Category> listCat = categoryRepository.findAll();
//		
//		List<Category> encontrada = new ArrayList();
//		
//		for (Category cat : listCat) {
//
//			if (cat.getName() != null && cat.getName().equals(name)) {
//
//				encontrada.add(cat);
//
//			}
//
//		}
//		return encontrada;
//
//	}

	public List<Category> findByName(String name) {

		List<Category> listaName = categoryRepository.findByName(name);

		List<Category> encontrada = new ArrayList();

		for (Category c : listaName) {

			if (c.getName() != null && c.getName().equals(name)) {

				encontrada.add(c);
			}

		}

		return encontrada;
	}

	public Page<Category> buscarTodas(Pageable page){

		return categoryRepository.findAll(page);

	}

	
	public Category findById(int id){
		
		return categoryRepository.findById(id);
		
		
	}



}
