package com.abstractTeam.Model;

public class Note {
	
	int id;
	Client client;
	Restaurant restaurant;
	Plat plat;
	float note;
	public Note() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}

}
