package com.abstractTeam.Model;

import java.io.Serializable;



public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

private String statut;
	public String getStatut() {
	return statut;
}

public void setStatut(String statut) {
	this.statut = statut;
}

	private int idCommentaire;

	private String message;

	private Bonplan bonplan;
	public Bonplan getBonplan() {
		return bonplan;
	}

	public void setBonplan(Bonplan bonplan) {
		this.bonplan = bonplan;
	}

	private Client client;


	private Plat plat;


	private Restaurant restaurant;

	public Commentaire() {
	}

	public int getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Plat getPlat() {
		return this.plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}