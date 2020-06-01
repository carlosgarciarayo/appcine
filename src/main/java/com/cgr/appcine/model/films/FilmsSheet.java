package com.cgr.appcine.model.films;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cgr.appcine.model.Category;

@Entity(name = "FILM_SHEET")
public class FilmsSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "RELEASE_DATE")
	private int releaseDate;

	@Column(name = "RENTAL_PRICE")
	private double rentalPrice;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "OUTSTANDING")
	private int outstanding;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "DETAILS")
	private String details;

	@OneToOne
	@JoinColumn(name = "ID_CATEGORY")
	private GenderFilm genderFilm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public GenderFilm getGenderFilm() {
		return genderFilm;
	}

	public void setGenderFilm(GenderFilm genderFilm) {
		this.genderFilm = genderFilm;
	}

	@Override
	public String toString() {
		return "FilmsSheet [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate="
				+ releaseDate + ", rentalPrice=" + rentalPrice + ", status=" + status + ", outstanding=" + outstanding
				+ ", image=" + image + ", details=" + details + ", genderFilm=" + genderFilm + "]";
	}

}
