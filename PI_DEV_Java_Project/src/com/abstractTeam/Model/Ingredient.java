package com.abstractTeam.Model;

import java.io.Serializable;
import java.util.List;



public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String description;

	private int idPlat;

	private String label;

	//bi-directional many-to-many association to Plat
	
	private List<Plat> plats;
	private List<Photo> photos;
	

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Ingredient() {
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

	public int getIdPlat() {
		return this.idPlat;
	}

	public void setIdPlat(int idPlat) {
		this.idPlat = idPlat;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Plat> getPlats() {
		return this.plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

}