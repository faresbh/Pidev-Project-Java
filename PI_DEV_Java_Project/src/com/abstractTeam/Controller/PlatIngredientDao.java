package com.abstractTeam.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.PlatIngredient;

public class PlatIngredientDao {
	public List<PlatIngredient> getAllIngredientsByPlat (int id){

		boolean ok=false;
			        List<PlatIngredient> listePlatsIngredient = null;

			        String requete = "select * from platingredient where idPlat ="+id;
			        try {
			           Statement statement = MyConnection.getInstance()
			                   .createStatement();
			            ResultSet resultat = statement.executeQuery(requete);

			            while(resultat.next()){
			            	if(!ok){
			            		ok=true;
			            		listePlatsIngredient=new ArrayList<PlatIngredient>();
			            	}
			            	PlatIngredient platIngredient=new PlatIngredient();
			               platIngredient.setPlat(resultat.getInt(1));
			               platIngredient.setIngredient(resultat.getInt(2));
			               
			               listePlatsIngredient.add(platIngredient);
			              
			            }
			            return listePlatsIngredient;
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
			            return null;
			        }
			    }
	
	public int insertIngredientPlat(int ingredient,int plat){
		 int a=0;
		 System.out.println("nsert platIngredient");
		 	        String requete = "insert into platingredient (idPlat,idIngredient) values (?,?)";
		 	        try {
		 	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
		 	            ps.setInt(1, plat);
		 	            ps.setInt(2, ingredient);
		 	            
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

}
