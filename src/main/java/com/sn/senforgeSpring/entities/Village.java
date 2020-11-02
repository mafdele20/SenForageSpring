package com.sn.senforgeSpring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Village implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String nomV;
	@OneToMany(mappedBy="village")
    private List<Client> clients = new ArrayList<Client>();

	private static final long serialVersionUID = 1L;
	public Village() {
		super();
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomV() {
		return nomV;
	}
	public void setNomV(String nomV) {
		this.nomV = nomV;
	}
	

}
