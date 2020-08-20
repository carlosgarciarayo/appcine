package com.cgr.appcine.model;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cgr.appcine.dto.movies.Companies;
import com.cgr.appcine.dto.movies.Genres;
import com.cgr.appcine.dto.movies.ProductionCountry;

@Document(collection = "filmSheet")
public class Movie {

	private String movieId;
	private String name;
	private String description;
	private String poster;
	private String status;
	private List<Genres> genres;
	private List<Companies> companies;
	private String imdbId;
	private List<ProductionCountry> productionCountry;
	




	public Movie(String movieId, String name, String description, String poster, String status, List<Genres> genres,
			List<Companies> companies, String imdbId, List<ProductionCountry> productionCountry) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.poster = poster;
		this.status = status;
		this.genres = genres;
		this.companies = companies;
		this.imdbId = imdbId;
		this.productionCountry = productionCountry;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Genres> getGenres() {
		return genres;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

	public List<Companies> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Companies> companies) {
		this.companies = companies;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public List<ProductionCountry> getProductionCountry() {
		return productionCountry;
	}

	public void setProductionCountry(List<ProductionCountry> productionCountry) {
		this.productionCountry = productionCountry;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", description=" + description + ", poster=" + poster
				+ ", status=" + status + ", genres=" + genres + ", companies=" + companies + ", imdbId=" + imdbId
				+ ", productionCountry=" + productionCountry + "]";
	}






	
	

	
	


}
