package com.cgr.appcine.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cgr.appcine.model.Movie;
import com.cgr.appcine.model.MovieSummary;
import com.cgr.appcine.model.Profiles;
import com.cgr.appcine.model.User;
import com.cgr.appcine.service.CategoryService;
import com.cgr.appcine.service.FilmService;
import com.cgr.appcine.service.MovieService;
import com.cgr.appcine.service.ProfilesService;
import com.cgr.appcine.service.UserService;
import com.cgr.appcine.util.Utileria;

@Controller
@RequestMapping(path = "/admin")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserService userSerice;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProfilesService profilesService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.language}")
	private String language;

	
	
	@RequestMapping(path = "/dashboard")
	public String dashboard() {
		
		return "admin/dashboard.html";
	}
	
	@RequestMapping(path = "/movie-form")
	public String movieForm() {
		
		return "admin/movieForm.html";
	}
	
	
	@GetMapping(path = "/save-movie/{movieId}")
	public String getMovieInfo(@PathVariable("movieId") String movieId, Model model) {

		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" 
									+ apiKey + "&language=" + language,	MovieSummary.class);

		LOGGER.info("movieSummary -->" + movieSummary);

		Movie movie = movieService.create(movieId, movieSummary.getTitle(), movieSummary.getOverview(),	movieSummary.getPoster_path());

		model.addAttribute("mov", movie);

		return "film/filmSheet";

	}

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

		// LOGGER.info("ID del perfil --> {}" + idPerfil);

		// Recuperamos el password en texto plano
		String pwdPlano = user.getPassword();

		// Encriptamos el pwd BCryptPasswordEncoder
		String pwdEncriptado = passwordEncoder.encode(pwdPlano);

		// Hacemos un set al atributo password (ya viene encriptado)
		user.setPassword(pwdEncriptado);
		// user.setStatus(1); // Activado por defecto
		// user.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del
		// servidor

		// Creamos el Perfil que le asignaremos al usuario nuevo
		Profiles perfil = new Profiles();
		// perfil.setId(3); // Perfil USUARIO
		// user.agregar(perfil);

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

	Page<User> listaPage;

	@GetMapping(path = "/lista-de-usuarios")
	public String mostrarIndexPaginado(Model model, Pageable page) {

		model.addAttribute("listaUser", userSerice.searchAll(page));
		LOGGER.info("LISTAS DE USUARIOS --> {}" + listaPage);

		return "admin/tablesUser";

	}

	List<User> listUser = new ArrayList();

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

		// model.addAttribute("categoryList", cat);
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
