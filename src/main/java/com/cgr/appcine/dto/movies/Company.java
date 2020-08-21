package com.cgr.appcine.dto.movies;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "company")
public class Company {

	private String id;
	private String idCompany;
	private String name;
	private String origin_country;
	private String logo_path;

	public Company() {
	}

	public Company(String id, String idCompany, String name, String origin_country, String logo_path) {

		this.id = id;
		this.idCompany = idCompany;
		this.name = name;
		this.origin_country = origin_country;
		this.logo_path = logo_path;
	}

	public Company(String idCompany, String name, String origin_country) {
		this.idCompany = idCompany;
		this.name = name;
		this.origin_country = origin_country;
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

	public String getOrigin_country() {
		return origin_country;
	}

	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", idCompany=" + idCompany + ", name=" + name + ", origin_country="
				+ origin_country + ", logo_path=" + logo_path + "]";
	}



}