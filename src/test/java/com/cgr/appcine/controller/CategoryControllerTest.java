package com.cgr.appcine.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.cgr.appcine.model.Category;

import junit.framework.Assert;



public class CategoryControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryControllerTest.class);
	
	@InjectMocks
	private CategoryController categoryController;

	
//	@Before
//	public void setUp() throws Exception {		
//		MockitoAnnotations.initMocks(this);
//	}
//	
	
	@Test
	public void testCategoryList() throws Exception {

		LOGGER.info("Executing the test...");
		
		Category category = new Category();

		List<Category> listCa = new ArrayList<>();
		
		
		category.setName("Carlos");
		category.setDescription("DEsc");
		
		listCa.add(category);


		// Mockito.when(jdbcUtils.pagingQueryForList("bbddEDPF.executeSelect", 1,5000)).thenReturn(listBBDD);
		
		assertNotNull(listCa);
	
	
	}

//	@Test
//	public void testCategoryForm() throws Exception {
//		throw new RuntimeException("not yet implemented");
//	}
//
//	@Test
//	public void testCategoryFormStringString() throws Exception {
//		throw new RuntimeException("not yet implemented");
//	}

}
