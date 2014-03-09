package com.abstractTeam.Controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Bonplan;
import com.abstractTeam.Model.Client;
import com.abstractTeam.Model.Commentaire;
import com.abstractTeam.Model.Menus;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Restaurant;



public class CommentaireDAO extends Commentaire {
	
 
 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int insertCommentairePlat(Commentaire commentaire){
		int a=0;
		
			        String requete = "insert into commentaires (message,idPlat,idClient) values (?,?,?)";
			        try {
			        	
			            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, commentaire.getMessage());
			            ps.setInt(2, commentaire.getPlat().getId());
			            ps.setInt(3, commentaire.getClient().getIdClient());
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
public List<Commentaire> DisplayAllcommentaireValide() {
		
	      List<Commentaire> listecommentaire = new ArrayList<Commentaire>();

	        String requete = "select * from commentaires where statut = 'valide'";
	        try {
	     Statement statement = MyConnection.getInstance().createStatement();
	            ResultSet rescommentaire = statement.executeQuery(requete);
	         
	            while(rescommentaire.next()){
	            	
	            	Commentaire commentaire =new Commentaire();
	            	
	            	commentaire.setIdCommentaire(rescommentaire.getInt(1));
	            	commentaire.setMessage(rescommentaire.getString(2));
	            	PlatDao platDao=new PlatDao();
	            	Plat plat=platDao.getPlatById(rescommentaire.getInt(3));
					commentaire.setPlat(plat);
	            	ClientDAO clientDAO=new ClientDAO();
	            	Client client=clientDAO.FindClientByID(rescommentaire.getInt(4));
					commentaire.setClient(client);
					RestaurantDao restaurantDao=new  RestaurantDao();
					Restaurant restaurant=restaurantDao.getRestoById(rescommentaire.getInt(5));
					commentaire.setRestaurant(restaurant);
					BonPlanDao bonPlanDao=new BonPlanDao();
					Bonplan bonplan=bonPlanDao.findbonplanbyId(rescommentaire.getInt(6));
					commentaire.setBonplan(bonplan);
					commentaire.setStatut(rescommentaire.getString(7));
					listecommentaire.add(commentaire);
	            }
	         
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des cs "+ex.getMessage());
	         
	        }
	
	        return listecommentaire;
	}
public List<Commentaire> DisplayAllcommentaireNonValide() {
	
    List<Commentaire> listecommentaire = new ArrayList<Commentaire>();

      String requete = "select * from commentaires where statut = 'non valide'";
      try {
   Statement statement = MyConnection.getInstance().createStatement();
          ResultSet rescommentaire = statement.executeQuery(requete);
       
          while(rescommentaire.next()){
          	
        	  Commentaire commentaire =new Commentaire();
          	
          	commentaire.setIdCommentaire(rescommentaire.getInt(1));
          	commentaire.setMessage(rescommentaire.getString(2));
          	PlatDao platDao=new PlatDao();
          	Plat plat=platDao.getPlatById(rescommentaire.getInt(3));
				commentaire.setPlat(plat);
          	ClientDAO clientDAO=new ClientDAO();
          	Client client=clientDAO.FindClientByID(rescommentaire.getInt(4));
				commentaire.setClient(client);
				RestaurantDao restaurantDao=new  RestaurantDao();
				Restaurant restaurant=restaurantDao.getRestoById(rescommentaire.getInt(5));
				commentaire.setRestaurant(restaurant);
				BonPlanDao bonPlanDao=new BonPlanDao();
				Bonplan bonplan=bonPlanDao.findbonplanbyId(rescommentaire.getInt(6));
				commentaire.setBonplan(bonplan);
				commentaire.setStatut(rescommentaire.getString(7));
				listecommentaire.add(commentaire);
          }
       
      } catch (SQLException ex) {
         //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("erreur lors du chargement des cs "+ex.getMessage());
       
      }

      return listecommentaire;
}

 public Commentaire FindCommentaireByID(int id) {
	 Commentaire commentaire =new Commentaire();
	 String req = " select * from commentaires where idcommentaire = "+id;
	 ResultSet rescommentaire;
	try {
		Statement statement = MyConnection.getInstance().createStatement();
		 rescommentaire = statement.executeQuery(req);
		 
	
	while(rescommentaire.next()){
    	
    	
    	
    	
    	commentaire.setIdCommentaire(rescommentaire.getInt(1));
    	commentaire.setMessage(rescommentaire.getString(2));
    	PlatDao platDao=new PlatDao();
    	Plat plat=platDao.getPlatById(rescommentaire.getInt(3));
		commentaire.setPlat(plat);
    	ClientDAO clientDAO=new ClientDAO();
    	Client client=clientDAO.FindClientByID(rescommentaire.getInt(4));
		commentaire.setClient(client);
		RestaurantDao restaurantDao=new  RestaurantDao();
		Restaurant restaurant=restaurantDao.getRestoById(rescommentaire.getInt(5));
		commentaire.setRestaurant(restaurant);
		BonPlanDao bonPlanDao=new BonPlanDao();
		Bonplan bonplan=bonPlanDao.findbonplanbyId(rescommentaire.getInt(6));
		commentaire.setBonplan(bonplan);
		commentaire.setStatut(rescommentaire.getString(7));
		
	
    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return (commentaire);
	
}
 
 public void UpdateCommentaire(Commentaire commentaire){
	 
	 String req = "update commentaires set statut = 'valide' where idCommentaire="+commentaire.getIdCommentaire();
	 Statement statement;
	try {
		statement = MyConnection.getInstance().createStatement();
		statement.executeUpdate(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 public void supprimerCommentaire(int id){
	 
	 String req = "delete from commentaires where idCommentaire="+id;
	 Statement statement;
		try {
			statement = MyConnection.getInstance().createStatement();
			statement.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }


}
