package com.cgr.appcine.dto.movies;

public class ProductionCountry {

	private String iso_3166_1;
	private String name;

	public String getIso_3166_1() {
		return iso_3166_1;
	}

	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductionCountries [iso_3166_1=" + iso_3166_1 + ", name=" + name + "]";
	}

}
