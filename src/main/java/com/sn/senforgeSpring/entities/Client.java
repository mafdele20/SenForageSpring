package com.sn.senforgeSpring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Client implements Serializable{
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String nomF;
	@ManyToOne
	private Village village = new Village();
	private String telephone;
    private static final long serialVersionUID = 1L;
	public Client() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomF() {
		return nomF;
	}

	public void setNomF(String nomF) {
		this.nomF = nomF;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	}

