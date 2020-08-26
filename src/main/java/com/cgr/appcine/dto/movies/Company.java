package com.cgr.appcine.dto.movies;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "company")
public class Company implements Serializable {


	
	private static final long serialVersionUID = 2537362631674477586L;
	
	private String id;
	private String idCompany;
	private String name;
	
	@JsonProperty("origin_country")
	private String originCountry;
	
	@JsonProperty("logo_path")
	private String logoPath;
	
	private String homepage;

	public Company() {}

	public Company(String id, String idCompany, String name, String originCountry, String logoPath, String homepage) {
		super();
		this.id = id;
		this.idCompany = idCompany;
		this.name = name;
		this.originCountry = originCountry;
		this.logoPath = logoPath;
		this.homepage = homepage;
	}


	public Company(String idCompany, String name, String originCountry) {
		this.idCompany = idCompany;
		this.name = name;
		this.originCountry = originCountry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
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
		return "Company [id=" + id + ", idCompany=" + idCompany + ", name=" + name + ", originCountry=" + originCountry
				+ ", logoPath=" + logoPath + ", homepage=" + homepage + "]";
	}







}