package com.cgr.appcine.dto.movies;

import java.util.List;


public class SearchCompanySumary  {

	/*
	 * DTO que recoge el json de la peticion
	 */
	private String id;
	private List<Company> results;
	private String total_pages;
	private String total_results;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Company> getResults() {
		return results;
	}

	public void setResults(List<Company> results) {
		this.results = results;
	}

	public String getTotal_results() {
		return total_results;
	}

	public void setTotal_results(String total_results) {
		this.total_results = total_results;
	}

	public String getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}

	@Override
	public String toString() {
		return "SearchCompanySumary [id=" + id + ", results=" + results + ", total_pages=" + total_pages
				+ ", total_results=" + total_results + "]";
	}





}
