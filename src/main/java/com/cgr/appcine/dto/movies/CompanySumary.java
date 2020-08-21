package com.cgr.appcine.dto.movies;

public class CompanySumary {

	private String id;
	private String name;
	private String origin_country;
	private String description;
	private String headquarters;
	private String logo_path;
	private String homepage;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getLogo_path() {
		return logo_path;
	}
	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	@Override
	public String toString() {
		return "CompanySumary [id=" + id + ", name=" + name + ", origin_country=" + origin_country + ", description="
				+ description + ", headquarters=" + headquarters + ", logo_path=" + logo_path + ", homepage=" + homepage
				+ "]";
	}

	





}
