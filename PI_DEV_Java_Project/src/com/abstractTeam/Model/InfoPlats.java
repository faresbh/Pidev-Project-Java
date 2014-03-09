package com.abstractTeam.Model;

import java.io.Serializable;

public class InfoPlats implements Serializable {
	public InfoPlats() {

	}

	private static final long serialVersionUID = 1L;

	private int id;
	private Reservation reservation;
	private Livraison livraison;
	private Plat plats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public Plat getPlats() {
		return plats;
	}

	public void setPlats(Plat plats) {
		this.plats = plats;
	}

}