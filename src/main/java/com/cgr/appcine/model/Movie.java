package com.cgr.appcine.model;

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

	
	public Movie(String movieId, String name, String description, String poster) {
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.poster = poster;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieId=" + movieId + ", name=" + name + ", description=" + description
				+ ", poster=" + poster + "]";
	}

}
