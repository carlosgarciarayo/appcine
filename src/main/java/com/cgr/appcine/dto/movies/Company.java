package com.cgr.appcine.dto.movies;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "company")
public class Company {

	private String id;
	private String idCompany;
	private String name;
	private String originCountry;
	
	
	
	
	public Company() {}
	
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
	@Override
	public String toString() {
		return "Company [id=" + id + ", idCompany=" + idCompany + ", name=" + name + ", originCountry=" + originCountry
				+ "]";
	}

	

	
	

	

}
