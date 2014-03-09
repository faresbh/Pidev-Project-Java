package com.abstractTeam.Model;

import java.io.Serializable;


public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String description;

	private String url;

	private Bonplan bonplan;


	private Plat plat;

	private Restaurant restaurant;
	private Ingredient ingredient;

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Photo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Bonplan getBonplan() {
		return this.bonplan;
	}

	public void setBonplan(Bonplan bonplan) {
		this.bonplan = bonplan;
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