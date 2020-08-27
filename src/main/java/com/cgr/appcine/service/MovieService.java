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
import com.cgr.appcine.dto.movies.MovieSummary;
import com.cgr.appcine.dto.movies.ProductionCountry;
import com.cgr.appcine.dto.movies.SearchCompanySumary;
import com.cgr.appcine.dto.movies.SearchMovieSumary;
import com.cgr.appcine.repository.MovieRepository;

@Service
public class MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.language}")
	private String language;

	@Value("${api.key}")
	private String apiKey;

	// Create operation
	public Movie create(String movieId, String name, String description, String poster, String status,
			List<Genres> genres, List<Company> company, String imdbId, List<ProductionCountry> productionCountry) {

		return movieRepository.save(
				new Movie(movieId, name, description, poster, status, genres, company, imdbId, productionCountry));

	}

	// Optenemos el nombre de la pelicula
	public List<String> searchFilmName(String name) {

		//

		SearchMovieSumary searchMovieSumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&language=en-US&query=" + name
						+ "&page=1&include_adult=false",
				// "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" +
				// name,
				SearchMovieSumary.class);

		LOGGER.info("MOVIE SUMARY --->: {} ", searchMovieSumary);

		List<Movie> listMovies = searchMovieSumary.getResults();
		List<String> nameMovieList = new ArrayList<String>();

		String nameMovie = "";

		for (Movie c : listMovies) {

			nameMovie = c.getName();

			nameMovieList.add(nameMovie);

		}

		return nameMovieList;

	}

	// Optenemos el nombre de la pelicula
	public List<String> searchFilmId(String name) {

		SearchMovieSumary searchMovieSumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&language=en-US&query=" + name
						+ "&page=1&include_adult=false",
				// "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" +
				// name,
				SearchMovieSumary.class);

		LOGGER.info("MOVIE SUMARY --->: {} ", searchMovieSumary);

		List<Movie> listMovies = searchMovieSumary.getResults();
		List<String> idMovieList = new ArrayList<String>();

		String nameMovie = "";

		for (Movie c : listMovies) {

			nameMovie = c.getMovieId();

			idMovieList.add(nameMovie);

		}

		return idMovieList;

	}

	// Optenemos el cartel de la pelicula
	public List<String> searchPosterFilm(String name) {

		SearchMovieSumary searchMovieSumary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&language=en-US&query=" + name
						+ "&page=1&include_adult=false",
				// "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" +
				// name,
				SearchMovieSumary.class);

		LOGGER.info("MOVIE SUMARY --->: {} ", searchMovieSumary);

		List<Movie> listPosterMovies = searchMovieSumary.getResults();
		List<String> posterMovieList = new ArrayList<String>();

		String posterMovie = "";

		for (Movie c : listPosterMovies) {

			posterMovie = c.getPoster();

			posterMovieList.add(posterMovie);

		}

		return posterMovieList;

	}



	//Recuperamos la pelicula por el id de la base de datos de mongo
	public Movie getByMovieId(Integer movieId) {
		return movieRepository.findByMovieId(movieId);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// Retrieve operation
//	public List<Movie> getAll() {
//		return movieRepository.findAll();
//	}	
	
	
//	public Movie getByName(String name) {
//		return movieRepository.findByName(name);
//	}
//	//Update operation
//	public Movie update(String name, String description, int outstanding) {
//		Movie movie = movieRepository.findByName(name);
//		movie.setName(name);
//		//movie.setOutstanding(outstanding);
//		return movieRepository.save(movie);
//	}
//	//Delete operation
//	public void deleteAll() {
//		movieRepository.deleteAll();
//	}
//	public void delete(String name) {
//		Movie movie = movieRepository.findByName(name);
//		movieRepository.delete(movie);
//	}

}
