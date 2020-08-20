package com.cgr.appcine.model;

import java.util.List;

import com.cgr.appcine.dto.movies.Companies;
import com.cgr.appcine.dto.movies.Genres;
import com.cgr.appcine.dto.movies.ProductionCountry;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary {

	private String id;
	private String title;
	private String overview;
	private String poster_path;
	private String status;
	private List<Genres> genres;
	private List<Companies> production_companies;
	private String imdb_id;
	private List<ProductionCountry> production_countries;

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

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
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


	public List<Companies> getProduction_companies() {
		return production_companies;
	}

	public void setProduction_companies(List<Companies> production_companies) {
		this.production_companies = production_companies;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public List<ProductionCountry> getProduction_countries() {
		return production_countries;
	}

	public void setProduction_countries(List<ProductionCountry> production_countries) {
		this.production_countries = production_countries;
	}

	@Override
	public String toString() {
		return "MovieSummary [id=" + id + ", title=" + title + ", overview=" + overview + ", poster_path=" + poster_path
				+ ", status=" + status + ", genres=" + genres + ", production_companies=" + production_companies
				+ ", imdb_id=" + imdb_id + ", production_countries=" + production_countries + "]";
	}




	












}
