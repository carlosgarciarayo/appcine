package com.cgr.appcine.model;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filmSheet")
public class FilmsSheet {

	@Id
	private String id;
	private String title;
	private String description;
	private int releaseDate;
	private double rentalPrice;
	private int status;
	private int outstanding;
	private String image;
	private String details;

	public FilmsSheet() {
	}

	public FilmsSheet(String title, String description, int outstanding) {
		this.title = title;
		this.description = description;
		this.outstanding = outstanding;
	}
	public FilmsSheet(String title, String description, int outstanding,int status) {
		this.title = title;
		this.description = description;
		this.outstanding = outstanding;
		this.status = status;
	}

	public FilmsSheet(String id, String title, String description, int releaseDate, double rentalPrice, int status,
			int outstanding, String image, String details) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.rentalPrice = rentalPrice;
		this.status = status;
		this.outstanding = outstanding;
		this.image = image;
		this.details = details;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(int outstanding) {
		this.outstanding = outstanding;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "FilmsSheet [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate="
				+ releaseDate + ", rentalPrice=" + rentalPrice + ", status=" + status + ", outstanding=" + outstanding
				+ ", image=" + image + ", details=" + details + "]";
	}

}
