package com.abstractTeam.Model;


import java.io.Serializable;
import java.util.List;



public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String adresse;

	private int idPhoto;

	private int nbrTable;

	private String nom;

	private double note;

	private String specialite;

	private List<Commentaire> commentaires;

	private List<Livraison> livraisons;

	private List<Photo> photos;

	private List<Reservation> reservations;

	private Positiongeo positiongeo;


	private Restaurateur restaurateur;

	private List<Table> tables;
	
	private List<Menus> menus;

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	public Restaurant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public int getNbrTable() {
		return this.nbrTable;
	}

	public void setNbrTable(int nbrTable) {
		this.nbrTable = nbrTable;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getNote() {
		return this.note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Livraison> getLivraisons() {
		return this.livraisons;
	}

	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Positiongeo getPositiongeo() {
		return this.positiongeo;
	}

	public void setPositiongeo(Positiongeo positiongeo) {
		this.positiongeo = positiongeo;
	}

	public Restaurateur getRestaurateur() {
		return this.restaurateur;
	}

	public void setRestaurateur(Restaurateur restaurateur) {
		this.restaurateur = restaurateur;
	}

	public List<Table> getTables() {
		return this.tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}



}