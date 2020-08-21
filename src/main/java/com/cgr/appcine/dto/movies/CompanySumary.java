package com.cgr.appcine.dto.movies;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder (alphabetic = true) 
public class CompanySumary implements Serializable{

	private static final long serialVersionUID = 3346611926581625371L;
	
	
	private String id;
	private String name;
	private String origin_country;
	private String description;
	private String headquarters;
	private String logoPath;
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
	
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
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
				+ description + ", headquarters=" + headquarters + ", logoPath=" + logoPath + ", homepage=" + homepage
				+ "]";
	}


	





}
