package com.abstractTeam.Controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.InfoPlats;
import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Menus;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Restaurant;

public class PlatDao {
	Connection connection;
	Connection connection2;
	Connection connection3;
	LivraisonsDao livDAO = new LivraisonsDao();
	ReservationsDao resDAO = new ReservationsDao();
	public List<Plat> findPlatsByReservation(int id) {
		List<Plat> list = new ArrayList<Plat>();
		try {
			connection = ConnexionDB.getConnected();
			Statement statPlatinf = connection.createStatement();
			System.out.println(id);
			String req = "SELECT * FROM infoPlats where idReservation=" + id;

			ResultSet resPlatinf = statPlatinf.executeQuery(req);

			while (resPlatinf.next()) {
				InfoPlats info = new InfoPlats();
				info.setId(resPlatinf.getInt(1));

				info.setReservation(resDAO.findReservationById(resPlatinf
						.getInt(2)));
				// info.setLivraison(livraison)
				int platId = resPlatinf.getInt(4);
//				connection2 = MyConnection.getInstance();
				System.out.println(" id plat : "+platId);
				Statement statPlat = connection.createStatement();
				String reqP = "SELECT * FROM PLats where id=" + platId;
				ResultSet resPlat = statPlat.executeQuery(reqP);

				while (resPlat.next()) {

					Plat Plat = new Plat();

					Plat.setId(resPlat.getInt(1));
					Plat.setLabel(resPlat.getString(2));
					Plat.setDescription(resPlat.getString(3));
					Plat.setPrix(resPlat.getDouble(4));
					Plat.setNote(resPlat.getDouble(5));
					System.out.println(Plat.getDescription());
					list.add(Plat);
					
				}
				info.getReservation().setPlats(list);
			}
			connection.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Plat> findPlatsByLivraison(int idLivraison) {
		List<Plat> list = new ArrayList<Plat>();
		try {
			connection = ConnexionDB.getConnected();
			Statement statPlatinf = connection.createStatement();
			System.out.println(idLivraison);
			String req = "SELECT * FROM infoPlats where idLivraison=" + idLivraison;

			ResultSet resPlatinf = statPlatinf.executeQuery(req);

			while (resPlatinf.next()) {
				InfoPlats info = new InfoPlats();
				info.setId(resPlatinf.getInt(1));

				info.setLivraison(livDAO.findLivraisonById(resPlatinf
						.getInt(2)));
				// info.setLivraison(livraison)
				int platId = resPlatinf.getInt(4);
			
				System.out.println(" id plat : "+platId);
				Statement statPlat = connection.createStatement();
				String reqP = "SELECT * FROM PLats where id=" + platId;
				ResultSet resPlat = statPlat.executeQuery(reqP);

				while (resPlat.next()) {

					Plat Plat = new Plat();

					Plat.setId(resPlat.getInt(1));
					Plat.setLabel(resPlat.getString(2));
					Plat.setDescription(resPlat.getString(3));
					Plat.setPrix(resPlat.getDouble(4));
					Plat.setNote(resPlat.getDouble(5));
					System.out.println(Plat.getDescription());
					list.add(Plat);
					
				}
				info.getLivraison().setPlats(list);
			}
			connection.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	 public int insertPlat(Plat plat,int  idMenu){
		 int a=0;
		 	        String requete = "insert into plats (label,description,prix,idMenus) values (?,?,?,?)";
		 	        try {
		 	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
		 	            ps.setString(1, plat.getLabel());
		 	            ps.setString(2, plat.getDescription());
		 	           ps.setDouble(3, plat.getPrix());
		 	          ps.setInt(4,idMenu );
		 	            
		 	            ps.executeUpdate();
		 	            ResultSet rs = ps.getGeneratedKeys();
		 	            if (rs.next()){
		 	                	a=rs.getInt(1);
		 	            }
		 	            rs.close();
		 	            ps.close();
		 	        		 	        } catch (SQLException ex) {
		 	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
		 	            System.out.println("erreur lors de l'insertion "+ex.getMessage());
		 	        }
		 	        PhotoDao photoDao=new PhotoDao();
		 	        for(Photo photo:plat.getPhotos())
		 	        	photoDao.insertPhotoPlat(photo, a);
		 	       IngredientDao ingredientDao=new IngredientDao();
		 	       for(Ingredient ingredient:plat.getIngredients())
		 	       ingredientDao.insertIngredient(ingredient, a);
		 	      System.out.println("Ajout effectuée avec succès");

		 	       return a;
		 	    }
	 public void updatePlat(Plat palt){
	        String requete = "update plats set label=?, description=?, prix=? where id=?";
	        try {
	        	System.out.println("modification");
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	            ps.setString(1, palt.getLabel());
	            ps.setString(2, palt.getDescription());
	            ps.setDouble(3, palt.getPrix());
	            ps.setInt(4, palt.getId());
	            System.out.println(palt.getDescription());
	            ps.executeUpdate();
	            System.out.println("Mise à jour effectuée avec succès");
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
	        }
	 }
	
	public Plat getPlatById(int id){
		Plat plat=new Plat();
		String requete="select * from plats where id="+id;
		   try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	            Plat stock =new Plat();
	            while(resultat.next()){
	              
	                stock.setId(id);
	                stock.setLabel(resultat.getString(2));
	                stock.setDescription(resultat.getString(3));
	                stock.setPrix(resultat.getDouble(4));
	                

	             
	            }
	            return stock;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
		
		
		
	}
	 public List<Plat> DisplayAllStocks (){


	        List<Plat> listedepots = new ArrayList<Plat>();

	        String requete = "select * from plats";
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         
	            while(resultat.next()){
	                Plat stock =new Plat();
	                stock.setLabel(resultat.getString(2));
	                stock.setNote(resultat.getDouble(5));
	                stock.setId(resultat.getInt(1));
	                listedepots.add(stock);
	            }
	            return listedepots;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
	    }
	 public List<Plat> DisplayAllStocksByMenus (int id){


	        List<Plat> listedepots = new ArrayList<Plat>();

	        String requete = "select * from plats where idMenus= "+id;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         
	            while(resultat.next()){
	                Plat stock =new Plat();
	                stock.setLabel(resultat.getString(2));
	                stock.setNote(resultat.getDouble(5));
	                stock.setId(resultat.getInt(1));
	                stock.setDescription(resultat.getString(3));
	                List<Photo> photos=new ArrayList<Photo>();
	                PhotoDao photoDao=new PhotoDao();
	                photos=photoDao.AllPhotoByPlat(resultat.getInt(1));
	                stock.setPhotos(photos);
	                IngredientDao ingredientDao=new IngredientDao();
	                List<Ingredient> ingredients=ingredientDao.getAllIngredientsByIdPlat(resultat.getInt(1));
	                stock.setIngredients(ingredients);
	                
	                listedepots.add(stock);
	            }
	            return listedepots;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
	    }
	 public List<Plat> DisplayAllPlatByRestau (Restaurant restaurant){
		 boolean ok=false;
		 List<Menus> menus=new ArrayList<Menus>();
		 MenueDao menueDao=new MenueDao();
		 menus=menueDao.getAllMenusByRestaurant(restaurant.getId());
		 List<Plat> plats=null;
		 for(Menus menus2 : menus){
			for(Plat plat: DisplayAllStocksByMenus(menus2.getId())){
				if(!ok){
					ok=true;
					plats=new ArrayList<Plat>();
				}
				plats.add(plat);
			}
		 }


	        return plats;
	    }

	public void deletePlatById(int id) {

	          String requete = "delete from plats where id=?";
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("Suppression plat effectuée avec succès");
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	        	OptionMessage.messageWarning("warning", "erreur lors de la suppression ");
	            System.out.println("erreur lors de la suppression "+ex.getMessage());
	        }
	    }
	public List<Plat> reschrcheAllPlat(String nom_String) {
		List<Plat> listePalts = new ArrayList<Plat>();

        String requete = "select * from plats where label LIKE '%"+nom_String+"%'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
            	Plat plat =new Plat();
                plat.setId(resultat.getInt(1));
                plat.setLabel(resultat.getString(2));
                plat.setDescription(resultat.getString(3));
                plat.setPrix(resultat.getDouble(4));
                
                NoteDao notePlatDAO=new NoteDao();
              
                
                
                plat.setNote( notePlatDAO.calculMoy(resultat.getInt(1)));
                PhotoDao photoDao=new PhotoDao();
                List<Photo> photos=photoDao.AllPhotoByPlat(resultat.getInt(1));
                plat.setPhotos(photos);
                
//                restaurant1.set
//                restaurant1.setp
                listePalts.add(plat);
            }
            return listePalts;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
	}

	}
	  


