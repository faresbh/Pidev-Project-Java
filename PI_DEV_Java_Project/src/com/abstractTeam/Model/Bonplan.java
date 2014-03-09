package com.abstractTeam.Model;

import java.io.Serializable;


/**
 * The persistent class for the bonplans database table.
 * 
 */

public class Bonplan implements Serializable {
	private static final long serialVersionUID = 1L;

	private double prix;
	private String type;
	private String nom;
	private String date;
	private int id;
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double object) {
		this.prix = object;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	private String description;


	public Bonplan() {
	}

	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}