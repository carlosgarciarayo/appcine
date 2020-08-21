package com.cgr.appcine.dto.movies;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary implements Serializable {

	/*
	 * DTO que recoge el json de la peticion atraeves de resTemplate
	 */
	private static final long serialVersionUID = 2471291748360018188L;

	private String id;
	
	private String title;
	
	private String overview;

	@JsonProperty("poster_path")
	private String posterPath;

	private String status;
	private List<Genres> genres;

	@JsonProperty("production_companies")
	private List<Company> productionCompany;

	@JsonProperty("imdb_id")
	private String imdbId;

	@JsonProperty("production_countries")
	private List<ProductionCountry> productionCountry;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
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

	public List<Company> getProductionCompany() {
		return productionCompany;
	}

	public void setProductionCompany(List<Company> productionCompany) {
		this.productionCompany = productionCompany;
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
		return "MovieSummary [id=" + id + ", title=" + title + ", overview=" + overview + ", posterPath=" + posterPath
				+ ", status=" + status + ", genres=" + genres + ", productionCompany=" + productionCompany + ", imdbId="
				+ imdbId + ", productionCountry=" + productionCountry + "]";
	}

}
