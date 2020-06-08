package com.cgr.appcine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserProfilesPK implements Serializable{

	@Column(name = "ID_USER")
	private Integer idUsuario;
	
	@Column(name = "ID_PROFILE")
	private Integer idPerfil;

	public UserProfilesPK() {
	}

	public UserProfilesPK(Integer idUsuario, Integer idPerfil) {
		this.idUsuario = idUsuario;
		this.idPerfil = idPerfil;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
	
	
	
	
}
