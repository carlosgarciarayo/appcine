package com.cgr.appcine.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cgr.appcine.model.Profiles;
import com.cgr.appcine.model.User;
import com.cgr.appcine.service.CategoryService;
import com.cgr.appcine.service.ProfilesService;
import com.cgr.appcine.service.UserService;
import com.cgr.appcine.util.Utileria;

@Controller
@RequestMapping(path = "/admin")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userSerice;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProfilesService profilesService;

	List<User> listUser = new ArrayList();

	Page<User> listaPage;

	@GetMapping(path = "/formulario-registro")
	public String formRegistre(User user, Model model) {

		model.addAttribute("category", categoryService.findAl());
		model.addAttribute("profiles", profilesService.findAll());

		return "admin/userForm";
	}

	@PostMapping(path = "/save")
	public String UserSave(User user, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {

		if (result.hasErrors()) {
			return "admin/userForm";

		}

		if (!multiPart.isEmpty()) {

			String route = "/home/carlos/git/appcine/src/main/resources/static/admin/assets/img/faces/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, route);

			if (nombreImagen != null) {
				user.setAvatar(nombreImagen);

			}
		}

		//LOGGER.info("ID del perfil --> {}" + idPerfil);

		
		userSerice.saveUser(user);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		
		LOGGER.info("USUARIO --> {}" + user);

		return "redirect:/admin/lista-de-usuarios";

	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	public String categoryForm(User user) {

		userSerice.saveUser(user);

		return "redirect:/admin/lista-de-usuarios";

	}

	@GetMapping(path = "/delete/{id}")
	public String UserDelete(@PathVariable("id") Integer id) {

		userSerice.userDelete(id);

		return "redirect:/admin/lista-de-usuarios";

	}

//	@GetMapping(path = "/lista-de-usuarios")
//	public String UserList(Model model) {
//
//		listUser = userSerice.listUser();
//		
//		model.addAttribute("listaUser", listUser);
//		LOGGER.info("listaUsuarios --> {}" + listUser);
//
//		
//		return "admin/tablesUser";
//	}

	@GetMapping(path = "/lista-de-usuarios")
	public String mostrarIndexPaginado(Model model, Pageable page) {

		model.addAttribute("listaUser", userSerice.searchAll(page));
		LOGGER.info("LISTAS DE USUARIOS --> {}" + listaPage);

		return "admin/tablesUser";

	}

	@GetMapping(path = "/lista-de-usuarios/order")
	public String searchAllOrderByName(Model model) {

		model.addAttribute("listaUser", userSerice.searchAllPagOrdenadosAscending());

		LOGGER.info("Usuario ordenados --> {}" + listUser);

		return "admin/tablesUserOrden";
	}

	@GetMapping(path = "/lista-de-usuarios/orderUp")
	public String searchAllOrderByNameDesc(Model model) {

		model.addAttribute("listaUser", userSerice.searchAllPagOrdenadosDescending());

		LOGGER.info("Usuario ordenados --> {}" + listUser);

		return "admin/tablesUserOrden";
	}

	@PostMapping(path = "/buscar")
	public String findByName(@RequestParam("name") String name, Model model) {

		listUser = userSerice.findByNameLike(name);

		model.addAttribute("listaUsuarios", listUser);

		return "admin/tablesUser";
	}

	@GetMapping(path = "/ficha-user")
	public String profielUser(Model model) {

		listUser = userSerice.listUser();

		model.addAttribute("listaUsuarios", listUser);

		return "admin/user";
	}

	@GetMapping(path = "/ficha-user/{id}")
	public String profielUserDetalle(@PathVariable("id") int id, Model model) {

		User user = userSerice.findById(id);

		model.addAttribute("usu", user);

		return "admin/detalle";
	}

	@GetMapping(path = "/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {

		model.addAttribute("listaUsuarios", userSerice.findById(id));

		return "admin/userForm";

	}

	@GetMapping(path = "/editUser/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {

		User user = userSerice.findById(id);


		//model.addAttribute("categoryList", cat);
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("aboutMe", user.getAboutMe());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("avatar", user.getAvatar());
		model.addAttribute("age", user.getAge());
		model.addAttribute("category", user.getCategory().getId());
		LOGGER.info("LISTAS DE CATEGORIAS --> {}" + user);

		return "admin/userFormEdit";

	}

}
