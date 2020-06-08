package com.cgr.appcine.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profiles implements Serializable {

	@Id
	@Column(name = "ID_PROFILE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProfile;

	@Column(name = "TYPE_PROFILE")
	private String typeProfile;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pk_user_profile", 
	joinColumns = @JoinColumn(name = "ID_PROFILE"), 
	inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private List<User> users;

	public Profiles() {

	}

	public Profiles(Integer idProfile, String typeProfile) {

		this.idProfile = idProfile;
		this.typeProfile = typeProfile;
	}

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getTypeProfile() {
		return typeProfile;
	}

	public void setTypeProfile(String typeProfile) {
		this.typeProfile = typeProfile;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

}
