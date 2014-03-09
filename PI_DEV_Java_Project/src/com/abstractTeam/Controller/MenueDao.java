package com.abstractTeam.Controller;


import java.awt.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Menus;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Restaurant;

public class MenueDao {
	
	public void deleteMenuById(int id) {
System.out.println(id+"menue a supprimer");
        String requete = "delete from menus where id=?";
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
	
	public int insertMenu(Menus d,int idRestaurant){
		int a=0;
		
			        String requete = "insert into menus (label,idRestaurant) values (?,?)";
			        try {
			        	
			            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, d.getLabel());
			            ps.setInt(2, idRestaurant);
			            
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
			        PlatDao platDao=new PlatDao();
			        for(Plat plat:d.getPlats())
			        platDao.insertPlat(plat, a);
			        return a;
			    }
	 public List<Menus> getAllMenus (){


	        List<Menus> listeMenue = new ArrayList<Menus>();

	        String requete = "select * from menus";
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);

	            while(resultat.next()){
	            	Menus menu=new Menus();
	               menu.setId(resultat.getInt(1));
	               menu.setLabel(resultat.getString(2));
	               List<Plat> plats=new ArrayList<Plat>();
	               PlatDao platDao=new PlatDao();
	               plats=platDao.DisplayAllStocksByMenus(resultat.getInt(1));
	               menu.setPlats(plats);

	                
	            }
	            return listeMenue;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
	            return null;
	        }
	    }
	 public List<Menus> getAllMenusByRestaurant (int id){

boolean ok=false;
	        List<Menus> listeMenue = null;

	        String requete = "select * from menus where idRestaurant ="+id;
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);

	            while(resultat.next()){
	            	if(!ok){
	            		ok=true;
	            		listeMenue=new ArrayList<Menus>();
	            	}
	            	System.out.println("d5al");
	            	Menus menu=new Menus();
	               menu.setId(resultat.getInt(1));
	               menu.setLabel(resultat.getString(2));
	               List<Plat> plats=new ArrayList<Plat>();
	               PlatDao platDao=new PlatDao();
	               plats=platDao.DisplayAllStocksByMenus(resultat.getInt(1));
	               menu.setPlats(plats);

	                listeMenue.add(menu);
	            }
	            return listeMenue;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
	            return null;
	        }
	    }
}
