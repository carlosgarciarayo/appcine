package com.cgr.appcine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

		LOGGER.info("MOVIE SUMARY --->: {} ",  movieSummary);

		Movie movie = movieService.create(movieId, movieSummary.getTitle(), movieSummary.getOverview(),
				movieSummary.getPosterPath(), movieSummary.getStatus(), movieSummary.getGenres(),
				movieSummary.getProductionCompany(), movieSummary.getImdbId(), movieSummary.getProductionCountry());

		model.addAttribute("mov", movie);

		return "film/filmSheet";

	}

	@GetMapping(path = "/save-company/{companyId}")
	public Company getCompanyInfo(@PathVariable("companyId") String companyId) {

		CompanySumary companySumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/company/" + companyId + "?api_key=" + apiKey, CompanySumary.class);

		LOGGER.info("COMPANY-SUMARY --->: {} ", companySumary);

		Company company = companyService.create(companyId, companySumary.getName(), companySumary.getOrigin_country());

		LOGGER.info("COMPANY--->: {} ", company);

		return company;

	}

	@GetMapping(path = "/search-company/")
	public String movieForm(@RequestParam(name = "name") String name, Model model) {


		List<String> resultSearch = companyService.searchCompanyName(name);
		List<String> resultSearchPoster = companyService.searchCompanyPoster(name);
		List<String> resultCompanyHomePage = companyService.searchCompanyHomePage(name);
		
		model.addAttribute("resultSearch", resultSearch);
		LOGGER.info("RESULTADO DE LA BUSQUEDA -->: {} ", resultSearch);
		
		model.addAttribute("resultSearchPoster", resultSearchPoster);
		LOGGER.info("RESULTADO DE LA BUSQUEDA DEL POSTER -->: {} ", resultSearchPoster);
		
		model.addAttribute("resultCompanyHomePage", resultCompanyHomePage);
		LOGGER.info("RESULTADO DE LA BUSQUEDA DE LA HOME PAGE -->: {} ", resultCompanyHomePage);

		return "film/movieFormSearch.html";
	}

	@RequestMapping(path = "/form")
	public String movieFormView() {

		return "film/movieForm.html";
	}
	
	


}
