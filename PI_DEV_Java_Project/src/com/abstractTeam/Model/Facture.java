package com.abstractTeam.Model;

import java.io.Serializable;
import java.util.List;



public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;


	private int idFacture;

	private String description;

	private double somme;

	
	private List<Livraison> livraisons;


	private List<Reservation> reservations;

	public Facture() {
	}

	public int getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSomme() {
		return this.somme;
	}

	public void setSomme(double somme) {
		this.somme = somme;
	}

	public List<Livraison> getLivraisons() {
		return this.livraisons;
	}

	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}