package com.abstractTeam.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class Livraison implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idLivraison;
private String etat;

	private Date dateLivraison;

	private String description;


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	private Client client;

	private Facture facture;

	
	private List<Plat> plats;

	
	private Restaurant restaurant;

	public Livraison() {
	}

	public int getIdLivraison() {
		return this.idLivraison;
	}

	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}

	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Facture getFacture() {
		return this.facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public List<Plat> getPlats() {
		return this.plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}