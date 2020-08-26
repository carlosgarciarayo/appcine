package com.cgr.appcine.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cgr.appcine.controller.MovieController;
import com.cgr.appcine.dto.movies.Company;
import com.cgr.appcine.dto.movies.Genres;
import com.cgr.appcine.dto.movies.Movie;
import com.cgr.appcine.dto.movies.ProductionCountry;
import com.cgr.appcine.dto.movies.SearchCompanySumary;
import com.cgr.appcine.repository.CompanyRepository;

@Service
public class CompanyService {
   
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	
	@Autowired
	private CompanyRepository companyRepository;


	
	@Value("${api.url-imag}")
	private String urlImg;

	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Create operation
	public Company create(String companyId, String name, String originCountry) {
		
		return companyRepository.save(new Company(companyId, name, originCountry));

	}

	// Optenemos la pagina web de la compañia de la compañia
	public List<String> searchCompanyHomePage (String name) {
		
		SearchCompanySumary searchCompanySumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/company?api_key=" + apiKey + "&query=" + name,
				SearchCompanySumary.class);
		
		LOGGER.info("searchSumaryCompany -->: {}",searchCompanySumary);

		List<Company> listCom = searchCompanySumary.getResults();
		List<String> homePageCompnayList = new ArrayList<String>();
		
		String homePageCompnay = "";

		for (Company c : listCom) {
			


			homePageCompnay = c.getHomepage();
			homePageCompnayList.add(homePageCompnay);

				LOGGER.info("POSTER-->: {}",homePageCompnayList);
			
		}

		return homePageCompnayList;

	}
	
	
	// Optenemos el logo de la compañia
	public List<String> searchCompanyPoster(String name) {

		SearchCompanySumary searchCompanySumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/company?api_key=" + apiKey + "&query=" + name,
				SearchCompanySumary.class);
		
		LOGGER.info("searchSumaryCompany -->: {}",searchCompanySumary);

		List<Company> listCom = searchCompanySumary.getResults();
		List<String> logoPathCompnayList = new ArrayList<String>();

		String companyPoster = "";

		for (Company c : listCom) {

			if (c.getLogoPath() == null) {

				logoPathCompnayList.add(urlImg);

			} else {

				companyPoster = c.getLogoPath();
				logoPathCompnayList.add(companyPoster);

				LOGGER.info("POSTER-->: {}",logoPathCompnayList);
			}
		}

		return logoPathCompnayList;

	}

	// Optenemos el nombre de la compañia
	public List<String> searchCompanyName(String name) {

		SearchCompanySumary searchCompanySumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/company?api_key=" + apiKey + "&query=" + name,
				SearchCompanySumary.class);
		
		LOGGER.info("SEARCH_COMPANY_SUMARY -->: {} ",searchCompanySumary);

		List<Company> listCom = searchCompanySumary.getResults();
		List<String> nameCompnayList = new ArrayList<String>();

		String nameCompany = "";

		for (Company c : listCom) {

			nameCompany = c.getName();

			nameCompnayList.add(nameCompany);

		}

		return nameCompnayList;

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
