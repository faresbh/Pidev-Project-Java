package com.abstractTeam.Model;

import java.io.Serializable;
import java.util.List;


public class Menus implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String label;


	private List<Plat> plats;

	public Menus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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