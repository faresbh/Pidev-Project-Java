package com.abstractTeam.Controller;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Bonplan;
import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Restaurant;

public class RestaurantDao {
	
	public int deleteRestaurant(int id){
	     int resultat = 0;
		String requete = "delete from restaurants where id= "+id;
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	             resultat = ps.executeUpdate();
	           
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	          System.out.println("erreur lors de la recherche du bn "+ex.getMessage());
	        }
			return resultat;
	    }
	
	
	public Restaurant getRestoById(int id){
		Restaurant resto=new Restaurant();
		String requete="select * from restaurants where id="+id;
		   try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	            Restaurant stock =new Restaurant();
	            while(resultat.next()){
	              
	                stock.setId(id);
	                stock.setNom(resultat.getString(2));
	                stock.setAdresse(resultat.getString(3));
	                stock.setNbrTable(resultat.getInt(4));
	                

	             
	            }
	            return stock;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
		
		
	
	
	
	}
	 public int insertRestaurant(Restaurant d){
int a=0;
	        String requete = "insert into restaurants (nom,adresse,nbrTable,specialite,id_geo,id_restaurateur) values (?,?,?,?,?,?)";
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
	           PositiongeoC c=new PositiongeoC();
	            ps.setString(1, d.getNom());
	            ps.setString(2, d.getAdresse());
	            ps.setInt(3, d.getNbrTable());
	            ps.setString(4, d.getSpecialite());
	            ps.setInt(5, c.insertPositiongeo(d.getPositiongeo()));
	            ps.setInt(6, d.getRestaurateur().getId());
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()){
	            	System.out.println("a :"+a);
	                	a=rs.getInt(1);
	            }
	            rs.close();
	            ps.close();
	            System.out.println("Ajout effectuée avec succès");
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors de l'insertion "+ex.getMessage());
	        }
	        return a;
	    }
	   public List<Restaurant> getAllRestaurants (int idRestaurateur){


	        List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();

	        String requete = "select * from restaurants where id_restaurateur="+idRestaurateur;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);

	            while(resultat.next()){
	            	Restaurant restaurant =new Restaurant();
	                restaurant.setId(resultat.getInt(1));
	                restaurant.setNom(resultat.getString(2));

	                listeRestaurants.add(restaurant);
	            }
	            return listeRestaurants;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
	            return null;
	        }
	    }
	   public List<Restaurant> getAllRestaurants2 (){


	        List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();

	        String requete = "select * from restaurants";
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);

	            while(resultat.next()){
	            	Restaurant restaurant =new Restaurant();
	                restaurant.setId(resultat.getInt(1));
	                restaurant.setNom(resultat.getString(2));

	                listeRestaurants.add(restaurant);
	            }
	            return listeRestaurants;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
	            return null;
	        }
	    }
	public List<Restaurant> rechercheRestaurant(Restaurant restaurant) {
		List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();

        String requete = "select * from restaurants where nom LIKE '%"+restaurant.getNom()+"%' && adresse LIKE '%"+restaurant.getAdresse()+"%' && specialite LIKE '%"+restaurant.getSpecialite()+"%'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
            	Restaurant restaurant1 =new Restaurant();
                restaurant1.setId(resultat.getInt(1));
                restaurant1.setNom(resultat.getString(2));
                restaurant1.setAdresse(resultat.getString(3));
                restaurant1.setNbrTable(resultat.getInt(4));
                restaurant1.setSpecialite(resultat.getString(5));
                NoteRestoDAO noteRestoDAO=new NoteRestoDAO();
              
                
                
                restaurant1.setNote( noteRestoDAO.calculMoy(resultat.getInt(1)));
                PhotoDao photoDao=new PhotoDao();
                List<Photo> photos=photoDao.AllPhotoByResto(resultat.getInt(1));
                restaurant1.setPhotos(photos);
                
//                restaurant1.set
//                restaurant1.setp
                listeRestaurants.add(restaurant1);
            }
            return listeRestaurants;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
		
	}


}
