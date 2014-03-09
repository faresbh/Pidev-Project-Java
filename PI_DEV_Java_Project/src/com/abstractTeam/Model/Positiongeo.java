package com.abstractTeam.Model;

import java.io.Serializable;




public class Positiongeo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idGeo;

	private double abs;

	private double ord;


	private Client client;

	private Restaurant restaurant;

	public Positiongeo() {
	}

	public int getIdGeo() {
		return this.idGeo;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setIdGeo(int idGeo) {
		this.idGeo = idGeo;
	}

	public double getAbs() {
		return this.abs;
	}

	public void setAbs(double abs) {
		this.abs = abs;
	}

	public double getOrd() {
		return this.ord;
	}

	public void setOrd(double ord) {
		this.ord = ord;
	}



}