package com.cgr.appcine.model;

public class MovieSummary {

    private String id;
    private String title;
    private String overview;
    private String poster_path;
    

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

	@Override
	public String toString() {
		return "MovieSummary [id=" + id + ", title=" + title + ", overview=" + overview + ", poster_path=" + poster_path
				+ "]";
	}

    
    
}
