package com.abstractTeam.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Photo;

public class PhotoDao {
	
	public List<Photo> AllPhotoByIngredients (int id){

		boolean ok=false;
			        List<Photo> listePhoto = null;

			        String requete = "select * from photos where idIngredient ="+id;
			        try {
			           Statement statement = MyConnection.getInstance()
			                   .createStatement();
			            ResultSet resultat = statement.executeQuery(requete);

			            while(resultat.next()){
			            	if(!ok){
			            		ok=true;
			            		listePhoto=new ArrayList<Photo>();
			            	}
			            	System.out.println("d5al");
			            	Photo photo=new Photo();
			            	photo.setId(resultat.getInt(1));
			            	photo.setUrl(resultat.getString(2));
			            	photo.setDescription(resultat.getString(3));
			            	listePhoto.add(photo);
			            	
			            }
			            return listePhoto;
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
			            return null;
			        }
			    }
	
	
	public  List<Photo> AllPhotoByResto (int id){

		boolean ok=false;
			        List<Photo> listePhoto = null;

			        String requete = "select * from photos where id_resto="+id;
			        try {
			           Statement statement = MyConnection.getInstance()
			                   .createStatement();
			            ResultSet resultat = statement.executeQuery(requete);

			            while(resultat.next()){
			            	if(!ok){
			            		ok=true;
			            		listePhoto=new ArrayList<Photo>();
			            	}
			            	Photo photo=new Photo();
			            	photo.setId(resultat.getInt(1));
			            	photo.setUrl(resultat.getString(2));
			            	photo.setDescription(resultat.getString(3));
			            	listePhoto.add(photo);
			            	
			            }
			            return listePhoto;
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
			            return null;
			        }
			    }
	
	public List<Photo> AllPhotoByPlat (int id){

		boolean ok=false;
			        List<Photo> listePhoto = null;

			        String requete = "select * from photos where idPlat ="+id;
			        try {
			           Statement statement = MyConnection.getInstance()
			                   .createStatement();
			            ResultSet resultat = statement.executeQuery(requete);

			            while(resultat.next()){
			            	if(!ok){
			            		ok=true;
			            		listePhoto=new ArrayList<Photo>();
			            	}
			            	Photo photo=new Photo();
			            	photo.setId(resultat.getInt(1));
			            	photo.setUrl(resultat.getString(2));
			            	photo.setDescription(resultat.getString(3));
			            	listePhoto.add(photo);
			            	
			            }
			            return listePhoto;
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
			            return null;
			        }
			    }
	
	
	public int insertPhotoResto(Photo d,int idResto){
		int a=0;
		
			        String requete = "insert into photos (url,description,id_resto) values (?,?,?)";
			        try {
			        	
			            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, d.getUrl());
			            ps.setString(2, d.getDescription());
			            ps.setInt(3, idResto);
			            ps.executeUpdate();
			            ResultSet rs = ps.getGeneratedKeys();
			            if (rs.next()){
			                	a=rs.getInt(1);
			            }
//			            ps.setDouble(7, d.getNote());
			          
			            System.out.println("Ajout effectuée avec succès");
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors de l'insertion "+ex.getMessage());
			        }
			        System.out.println(a+"ajout aaaaa");
			        return a;
			    }
	public int insertPhotoIngredient(Photo d,int idIngredient){
		int a=0;
		
			        String requete = "insert into photos (url,description,idIngredient) values (?,?,?)";
			        try {
			        	
			            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, d.getUrl());
			            ps.setString(2, d.getDescription());
			            ps.setInt(3, idIngredient);
			            ps.executeUpdate();
			            ResultSet rs = ps.getGeneratedKeys();
			            if (rs.next()){
			                	a=rs.getInt(1);
			            }
			          
			            System.out.println("Ajout effectuée avec succès");
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors de l'insertion "+ex.getMessage());
			        }
			        return a;
			    }
	
	public int insertPhotoPlat(Photo d,int idPlat){
		int a=0;
		
			        String requete = "insert into photos (url,description,idPlat) values (?,?,?)";
			        try {
			        	
			            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, d.getUrl());
			            ps.setString(2, d.getDescription());
			            ps.setInt(3, idPlat);
			            ps.executeUpdate();
			            ResultSet rs = ps.getGeneratedKeys();
			            if (rs.next()){
			                	a=rs.getInt(1);
			            }
			          
			            System.out.println("Ajout effectuée avec succès");
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors de l'insertion "+ex.getMessage());
			        }
			        return a;
			    }


}
