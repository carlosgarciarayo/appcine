package com.cgr.appcine.model;

public class Movie {
    
	
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
		return "Movie [movieId=" + movieId + ", name=" + name + ", description=" + description + ", poster=" + poster
				+ "]";
	}


    
    
}
