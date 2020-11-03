package com.sn.senforgeSpring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


@Entity
public class User implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	 private Long id;
    @NotNull
    @Size(min=2, max=12)
	 private String nom;
    @NotNull
    @Size(min=3, max=12)
	 private String prenom;
    @NotNull
	 private String email;
    @NotNull
    @Size(min=9, max=9)
	 private String password;
	@ManyToOne
	 private Role role = new Role();
	 private static final long serialVersionUID = 1L;
	 public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}
    public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
 
}

