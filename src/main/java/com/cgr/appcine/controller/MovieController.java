package com.cgr.appcine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cgr.appcine.dto.movies.Company;
import com.cgr.appcine.dto.movies.CompanySumary;
import com.cgr.appcine.dto.movies.Movie;
import com.cgr.appcine.dto.movies.MovieSummary;
import com.cgr.appcine.dto.movies.SearchCompanySumary;
import com.cgr.appcine.service.CompanyService;
import com.cgr.appcine.service.MovieService;

@Controller
@RequestMapping(path = "/admin/movie")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieService movieService;

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.language}")
	private String language;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CompanyService companyService;

	@GetMapping(path = "/save-movie/{movieId}")
	public String getMovieInfo(@PathVariable("movieId") String movieId, Model model) {

		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&language=" + language,
				MovieSummary.class);

		LOGGER.info("movieSummary -->" + movieSummary);

		Movie movie = movieService.create(movieId, movieSummary.getTitle(), movieSummary.getOverview(),
				movieSummary.getPosterPath(), movieSummary.getStatus(), movieSummary.getGenres(),
				movieSummary.getProductionCompany(), movieSummary.getImdbId(), movieSummary.getProductionCountry());

		model.addAttribute("mov", movie);

		return "film/filmSheet";

	}

	@GetMapping(path = "/save-company/{companyId}")
	public Company getCompanyInfo(@PathVariable("companyId") String companyId) {

		CompanySumary companySumary = restTemplate.getForObject("https://api.themoviedb.org/3/company/" + companyId + "?api_key=" + apiKey, CompanySumary.class);

		LOGGER.info("companySumary -->" + companySumary);

		Company company = companyService.create(companyId, companySumary.getName(), companySumary.getOrigin_country());

		LOGGER.info("COMPANY ------>" + company);

		return company;

	}

	
	public SearchCompanySumary searchCompany(String name) {

		SearchCompanySumary searchCompanySumary = restTemplate.getForObject("https://api.themoviedb.org/3/search/company?api_key=" + apiKey + "&query=" + name,	SearchCompanySumary.class);	
		LOGGER.info("searchSumaryCompany -->" + searchCompanySumary);
		
		return searchCompanySumary;

	}

	
	@GetMapping(path = "/search-company/{name}")
	public String movieForm(@PathVariable("name") String name, Model model) {
		
		SearchCompanySumary resultSearch = searchCompany(name);

		model.addAttribute("resultSearch", resultSearch);
		
		LOGGER.info("RESULTADO DE LA BUSQUEDA -->" + resultSearch);

		return "film/movieForm.html";
	}
	
	
	
	@RequestMapping(path = "/form")
	public String movieFormView() {
		

		return "film/movieForm.html";
	}

//	@GetMapping(path = "/ficha-pelicula")
//	public String categoryForm() {
//
//		return "film/filmSheet";
//
//	}
//
//	@RequestMapping("/create")
//	public String create(@RequestParam String title, @RequestParam String description, @RequestParam int outstanding, @RequestParam int status) {
//		FilmsSheet filmsSheet = filmService.create(title, description, outstanding,status);
//		return filmsSheet.toString();
//	}
//	
//	@RequestMapping("/get")
//	public FilmsSheet getFilmsSheet(@RequestParam String title) {
//		return filmService.getByTitle(title);
//	}
//	@RequestMapping("/getAll")
//	public List<FilmsSheet> getAll(){
//		return filmService.getAll();
//	}
//	@RequestMapping("/update")
//	public String update(@RequestParam String title, @RequestParam String description, @RequestParam int outstanding) {
//		FilmsSheet filmsSheet = filmService.update(title, description, outstanding);
//		return filmsSheet.toString();
//	}
//	@RequestMapping("/delete")
//	public String delete(@RequestParam String title) {
//		filmService.delete(title);
//		return "Deleted " + title;
//	}
//	@RequestMapping ("/deleteAll")
//	public String deleteAll() {
//		filmService.deleteAll();
//		return "Deleted all records";
//	}

}
