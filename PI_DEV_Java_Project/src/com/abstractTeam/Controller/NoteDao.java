package com.abstractTeam.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Restaurant;

public class NoteDao {

	
	
	 public List<Note> DisplayAllnotePlat2 (int id){


	        List<Note> listenote = new ArrayList<Note>();

	        String requete = "select * from notes where id_plat ="+id;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         PlatDao platDao=new PlatDao();
	            while(resultat.next()){
	                Note stock =new Note();
	                stock.setId(resultat.getInt(1));
	                stock.setNote(resultat.getFloat(5));
	                stock.setPlat(platDao.getPlatById(resultat.getInt(4)));

	                listenote.add(stock);
	            }
	            return listenote;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
	    }
	public float calculMoy(int id){
		System.out.println("clcul moy");
		float somme=0f;
		for(Note note :DisplayAllnotePlat(id))
			
		
		{
			System.out.println(note.getPlat().getId());
			somme+=note.getNote();
			
		}
		return somme/DisplayAllnotePlat(id).size();
		
	}
	
	 public int insertRestaurant(Note d){
		 int a=0;
		 	        String requete = "insert into notesr (id_client,id_restaurant,note) values (?,?,?)";
		 	        try {
		 	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
		 	           PositiongeoC c=new PositiongeoC();
		 	            ps.setInt(1, d.getClient().getIdClient());
		 	            ps.setInt(2, d.getRestaurant().getId());
		 	            ps.setFloat(3, d.getNote());
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
	 
	 public int insertPlat(Note d){
		 int a=0;
		 	        String requete = "insert into notes (id_client,id_plat,note) values (?,?,?)";
		 	        try {
		 	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
		 	           PositiongeoC c=new PositiongeoC();
		 	            ps.setInt(1, d.getClient().getIdClient());
		 	            ps.setInt(2, d.getRestaurant().getId());
		 	            ps.setFloat(3, d.getNote());
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
	
	
	 public List<Note> DisplayAllnotePlat (int id){


	        List<Note> listenote = new ArrayList<Note>();

	        String requete = "select * from notes where id_plat ="+id;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         PlatDao platDao=new PlatDao();
	            while(resultat.next()){
	                Note stock =new Note();
	                stock.setId(resultat.getInt(1));
	                stock.setNote(resultat.getFloat(5));
	                stock.setPlat(platDao.getPlatById(resultat.getInt(4)));

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
