package com.cgr.appcine.dto.movies;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filmSheet")
public class Movie implements Serializable {
	/*
	 * DTO para la persitencia en la base de datos
	 */
	private static final long serialVersionUID = 489038112756874520L;

	private String movieId;
	private String name;
	private String description;
	private String poster;
	private String status;
	private List<Genres> genres;
	private List<Company> company;
	private String imdbId;
	private List<ProductionCountry> productionCountry;

	public Movie(String movieId, String name, String description, String poster, String status, List<Genres> genres,
			List<Company> company, String imdbId, List<ProductionCountry> productionCountry) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.poster = poster;
		this.status = status;
		this.genres = genres;
		this.company = company;
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

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
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
				+ ", status=" + status + ", genres=" + genres + ", company=" + company + ", imdbId=" + imdbId
				+ ", productionCountry=" + productionCountry + "]";
	}

}
