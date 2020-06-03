package com.cgr.appcine.model.films;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "GENDER")
public class GenderFilm {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idGender")
	private Integer idGender;
	
	@Column(name = "gender")
	private String gender;

	

	public Integer getIdGender() {
		return idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}

	
