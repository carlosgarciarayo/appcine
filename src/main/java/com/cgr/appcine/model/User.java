package com.cgr.appcine.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	

	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "EMAIL")
	private String email;
	
	
	@Column(name = "ABOUT_ME")
	private String aboutMe;
	
	@Transient
	@Column(name = "REGISTRATION_DATE")
	private Date registration;
	
	@OneToOne
	@JoinColumn(name = "ID_CATEGORY")
	private Category category;
	
	@OneToOne
	@JoinColumn(name = "ID_ADDRESS")
	private UserAddress userAddress;
	
	@Column(name = "AVATAR")
	private String avatar;
	
	
	@Column(name = "AGE")
	private Integer age;
	
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name = "pk_user_profile",
	joinColumns = @JoinColumn (name="ID_USER"),
	inverseJoinColumns = @JoinColumn(name="ID_PROFILE") )
	private List<Profiles> profiles;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}


	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public List<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profiles> profiles) {
		this.profiles = profiles;
	}

	
	public void saveProfiles(Profiles temProfiles) {
		
		if(profiles == null){
			profiles = new LinkedList<Profiles>();
		}
		
		profiles.add(temProfiles);		
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", status=" + status + ", aboutMe=" + aboutMe + ", registration=" + registration
				+ ", category=" + category + ", userAddress=" + userAddress + ", avatar=" + avatar + ", age=" + age
				+ ", profiles=" + profiles + "]";
	}
	

	
	
	
}
