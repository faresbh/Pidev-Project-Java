package com.abstractTeam.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Menus;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.PlatIngredient;
import com.abstractTeam.Model.Restaurant;

public class IngredientDao {
	public void deleteIngredientById(int id) {

        String requete = "delete from ingredients where id=?";
      try {
          PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
          ps.setInt(1, id);
          ps.executeUpdate();
          System.out.println("Suppression Ingredient effectuée avec succès");
      } catch (SQLException ex) {
         //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
      	OptionMessage.messageWarning("warning", "erreur lors de la suppression ");
          System.out.println("erreur lors de la suppression "+ex.getMessage());
      }
  }

	
	 public int insertIngredient(Ingredient d,int idPlat){
		 int a=0;
		 	        String requete = "insert into ingredients (label,description) values (?,?)";
		 	        try {
		 	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
		 	            ps.setString(1, d.getLabel());
		 	            ps.setString(2, d.getDescription());
		 	            
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
		 	        for(Photo photo:d.getPhotos()){
		 	        	PhotoDao photoDao=new PhotoDao();
		 	        	photoDao.insertPhotoIngredient(photo, a);
		 	        }
		 	        PlatIngredientDao platIngredientDao=new PlatIngredientDao();
		 	        platIngredientDao.insertIngredientPlat(a, idPlat);
		 	        return a;
		 	    }

	public Ingredient getIngredientsById(int id) {

		Ingredient ingredient = null;

		String requete = "select * from ingredients where id =" + id;
		try {
			Statement statement = MyConnection.getInstance().createStatement();
			ResultSet resultat = statement.executeQuery(requete);

			while (resultat.next()) {
				System.out.println("d5al");
				ingredient = new Ingredient();
				ingredient.setLabel(resultat.getString(2));
				ingredient.setId(resultat.getInt(1));
				ingredient.setDescription(resultat.getString(3));
				List<Photo> photos = new ArrayList<Photo>();
				PhotoDao photoDao = new PhotoDao();
				photos = photoDao.AllPhotoByIngredients(resultat.getInt(1));
				ingredient.setPhotos(photos);
			}

		}

		catch (SQLException ex) {
			// Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE,
			// null, ex);
			System.out.println("erreur lors du chargement des depots "
					+ ex.getMessage());
			return null;
		}
		return ingredient;
	}

	public List<Ingredient> getAllIngredientsByIdPlat(int id) {
		boolean ok=false;
		List<PlatIngredient> platingredients = new ArrayList<PlatIngredient>();
		PlatIngredientDao platIngredientDao=new PlatIngredientDao();
		platingredients=platIngredientDao.getAllIngredientsByPlat(id);
		List<Ingredient> ingredients=null;
		if(platingredients!=null){
		for(PlatIngredient platIngredient: platingredients){
			if(!ok){
				ok=true;
				ingredients=new ArrayList<Ingredient>();
			}
			ingredients.add(getIngredientsById(platIngredient.getIngredient()));
		}
		}
		return ingredients;
	}

	public void updateIngredientById(Ingredient ingredient) {
	
		        String requete = "update ingredients set label=?, description=? where id=?";
		        try {
		            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
		            ps.setString(1, ingredient.getLabel());
		            ps.setString(2, ingredient.getDescription());
		            ps.setInt(3, ingredient.getId());
		            ps.executeUpdate();
		            System.out.println("Mise à jour effectuée avec succès");
		        } catch (SQLException ex) {
		        	OptionMessage.messageWarning("Error", "erreur lors de la mise à jour "+ex.getMessage());
		           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
		            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
		        }
		 }
		
	}


