package com.cgr.appcine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "USER_PROFILE")
public class UserProfiles implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Integer idUser;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PROFILES")
	private Integer idProfiles;


	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public Integer getIdProfiles() {
		return idProfiles;
	}


	public void setIdProfiles(Integer idProfiles) {
		this.idProfiles = idProfiles;
	}


	@Override
	public String toString() {
		return "UserProfiles [idUser=" + idUser + ", idProfiles=" + idProfiles + "]";
	}
	
	

}
