package com.cgr.appcine.dto.movies;

public class Companies {

	private String name;
	private String id;
	private String logoPath;
	private String originCountry;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	@Override
	public String toString() {
		return "ProductionCompanies [name=" + name + ", id=" + id + ", logoPath=" + logoPath + ", originCountry="
				+ originCountry + "]";
	}

}
