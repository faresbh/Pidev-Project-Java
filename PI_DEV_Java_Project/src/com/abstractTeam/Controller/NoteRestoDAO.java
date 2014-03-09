package com.abstractTeam.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Note;

public class NoteRestoDAO {
	
	
	public float calculMoy(int id){
		System.out.println("clcul moy Resto");
		float somme=0f;
		System.out.println("nbre resto "+DisplayAllResto(id).size());
		for(Note note :DisplayAllResto(id))
			
		
		{
			
			somme+=note.getNote();
			
		}
		return somme/DisplayAllResto(id).size();
		}
	
	
	 public List<Note> DisplayAllResto  (int id){


	        List<Note> listenote = new ArrayList<Note>();

	        String requete = "select * from notesr where id_restaurant ="+id;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         RestaurantDao platDao=new RestaurantDao();
	            while(resultat.next()){
	                Note stock =new Note();
	                stock.setId(resultat.getInt(1));
	                stock.setNote(resultat.getFloat(4));
	                stock.setRestaurant(platDao.getRestoById(resultat.getInt(3)));

	                listenote.add(stock);
	            }
	            return listenote;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
	    }
	 public List<Note> DisplayAllPlats  (int id){


	        List<Note> listenote = new ArrayList<Note>();

	        String requete = "select * from notes where id_plat ="+id;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         RestaurantDao platDao=new RestaurantDao();
	            while(resultat.next()){
	                Note stock =new Note();
	                stock.setId(resultat.getInt(1));
	                stock.setNote(resultat.getFloat(4));
	                stock.setRestaurant(platDao.getRestoById(resultat.getInt(3)));

	                listenote.add(stock);
	            }
	            return listenote;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
	    }

}
