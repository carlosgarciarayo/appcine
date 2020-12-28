package com.cgr.appcine.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cgr.appcine.model.Category;
import com.cgr.appcine.service.CategoryService;

@Controller
@RequestMapping(path = "/admin/categorias")
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	CategoryService categoryService;

	//Page<Category> listaPage;

	@GetMapping(path = "/lista")
	public String mostrarIndexPaginado(Model model, Pageable page) {

		listaPage = categoryService.buscarTodas(page);

		model.addAttribute("categoryList", listaPage);

		return "admin/tablesCategory";

	}

	@GetMapping(path = "/create")
	public String categoryForm() {

		return "admin/categoryForm";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String categoryForm(Category category) {

		categoryService.saveCategory(category);

		return "redirect:lista";

	}

	@GetMapping(path = "/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes attributes) {

		categoryService.deleteCategory(id);
		attributes.addFlashAttribute("msg", "La categoria fue eliminada");

		return "redirect:/categorias/lista";

	}

	@GetMapping(path = "/deleteAll")
	public String deleteCategoryAll() {

		categoryService.deleteCategoryAll();

		return "redirect:lista";

	}

	@GetMapping(path = "/buscar")
	public String formSearch() {

		return "category/search";

	}

	@PostMapping(path = "/encontrar")
	public String findByName(@RequestParam("name") String name, Model model) {

		List<Category> listCat = categoryService.findByName(name);

		model.addAttribute("categoryList", listCat);

		return "admin/tablesCategory";

	}

	
	
	@GetMapping(path = "/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {

		Category cat = categoryService.findById(id);

		//model.addAttribute("categoryList", cat);
		model.addAttribute("categoryListId", cat.getId());
		model.addAttribute("categoryList", cat.getName());
		model.addAttribute("categoryListDes", cat.getDescription());

		LOGGER.info("LISTAS DE CATEGORIAS --> {}" + cat);

		return "admin/categoryFormEdit";

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
