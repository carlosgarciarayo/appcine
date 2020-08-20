package com.cgr.appcine.dto.movies;

public class CompanySumary {

	private String id;
	private String name;
	private String origin_country;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin_country() {
		return origin_country;
	}

	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}

	@Override
	public String toString() {
		return "SearchCompanySumary [id=" + id + ", name=" + name + ", origin_country=" + origin_country + "]";
	}





}
