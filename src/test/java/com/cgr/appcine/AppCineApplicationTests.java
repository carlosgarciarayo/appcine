package com.cgr.appcine;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgr.appcine.model.Category;

@SpringBootTest
class AppCineApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCategoryList() throws Exception {

		//LOGGER.info("Executing the test...");
		
		Category category = new Category();

		List<Category> listCa = new ArrayList<>();
		
		
		category.setName("Carlos");
		category.setDescription("DEsc");
		
		listCa.add(category);


		// Mockito.when(jdbcUtils.pagingQueryForList("bbddEDPF.executeSelect", 1,5000)).thenReturn(listBBDD);
		
		assertNotNull(listCa);
	
	
	}

}
