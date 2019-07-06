package com.isi.sn.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import com.isi.sn.demo.entities.Roles;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterForm {
	/*@NotEmpty
	@Size(min=4,max=10)*/
	private String ancienMp;
	/*@NotEmpty
	@Size(min=4,max=10)*/
	private String nouvMp;
/*	@NotEmpty
	@Size(min=4,max=10)*/
	private String confirMp;
/*	
	@NotEmpty
	@Size(min=2,max=10)*/
	private String nom;
	/*@NotEmpty
	@Size(min=2,max=10)*/
	private String prenom;
	/*@NotEmpty
	@Size(min=2,max=10)*/
	private String telephone;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	/*@NotNull
	@Past*/
	private Date date;
	@Column(unique=true)
	/*@NotEmpty
	@Size(min=2,max=10)*/
	private String matricule;
	private String password;

	private Boolean enabled;
	/*@Email
	@NotNull*/
	private String email;
	
	
	ArrayList<Roles> role=new ArrayList<Roles>();

	@JsonProperty("role")
	private void convertedRole(Integer roles[]) {
		/*for(int i=0;i<roles.length;i++) {
			Roles r=new Roles();
			Long id=roles[i].longValue();
			System.out.println("Id"+id);
			r.setId(id);
			System.out.println("role"+r.getId());
			this.role.add(r);
		}*/
	}


	public String getAncienMp() {
		return ancienMp;
	}
	public void setAncienMp(String ancienMp) {
		this.ancienMp = ancienMp;
	}
	public String getNouvMp() {
		return nouvMp;
	}
	public void setNouvMp(String nouvMp) {
		this.nouvMp = nouvMp;
	}
	public String getConfirMp() {
		return confirMp;
	}
	public void setConfirMp(String confirMp) {
		this.confirMp = confirMp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	

}
