package com.sn.senforgeSpring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class Role implements Serializable {
	
    @Id @GeneratedValue  ( strategy=GenerationType.IDENTITY )
	private Long id;
    @NotNull
    @Size(min=3, max=11)
	private String libelle;
	@OneToMany(mappedBy="role")
    private List<User> users = new ArrayList<User>();


	private static final long serialVersionUID = 1L;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
