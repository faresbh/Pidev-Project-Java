package com.abstractTeam.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idReservation;

	private String choix;

	private String etat;
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	private Date date;

	//bi-directional many-to-many association to Bonplan
	
	private List<Bonplan> bonplans;

	
	private List<Plat> plats;


	private Client client;

	
	private Facture facture;


	private Restaurant restaurant;

	public Reservation() {
	}

	public int getIdReservation() {
		return this.idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public String getChoix() {
		return this.choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Bonplan> getBonplans() {
		return this.bonplans;
	}

	public void setBonplans(List<Bonplan> bonplans) {
		this.bonplans = bonplans;
	}

	public List<Plat> getPlats() {
		return this.plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
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

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}