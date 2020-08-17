package com.cgr.appcine.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filmSheet")
public class Movie {

	@Id
	private String id;
	private String movieId;
	private String name;
	private String description;
	private String poster;
	private String status;
	private List<Genres> genres;

	public Movie(String name) {
		this.name = name;
	}

	public Movie(String movieId, String name, String description, String poster, String status, List<Genres> genres) {
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.poster = poster;
		this.status = status;
		this.genres = genres;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieId=" + movieId + ", name=" + name + ", description=" + description
				+ ", poster=" + poster + ", status=" + status + ", genres=" + genres + "]";
	}

}
