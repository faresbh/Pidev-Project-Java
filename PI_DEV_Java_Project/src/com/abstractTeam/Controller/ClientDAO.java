package com.abstractTeam.Controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Client;
import com.abstractTeam.Model.Restaurateur;



public class ClientDAO extends Client {
	
	 public Client findClientByMailMdp(String mail,String mdp){

	        String requete = "select * from clients where mail=? && mdp=?";

	        try{
	        PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	        ps.setString(1, mail);
	        ps.setString(2, mdp);
	        ResultSet resultat = ps.executeQuery();
	        
	        Client Client =null;
	        while (resultat.next()){
	        	Client=new Client();
	        	Client.setIdClient(resultat.getInt(1));
	        	Client.setNom(resultat.getString(2));
	        	Client.setPrenom(resultat.getString(3));
	        	Client.setMail(resultat.getString(4));
	            Client.setMdp(resultat.getString(5));
	            Client.setAdresse(resultat.getString(6));
	            Client.setTel(resultat.getString(7));
	        }
	        return Client;
	        }
	        catch(SQLException ex){
	            System.out.println("erreur lors du chargement"+ex.getMessage());
	            return null;
	        }
	    }
 
public List<Client> DisplayAllClientValide() {
		
	      List<Client> listeClient = new ArrayList<Client>();

	        String requete = "select * from clients where statut = 'valide'";
	        try {
	     Statement statement = MyConnection.getInstance().createStatement();
	            ResultSet resClient = statement.executeQuery(requete);
	         
	            while(resClient.next()){
	            	
	            	Client client =new Client();
	            	
	            	client.setIdClient(resClient.getInt(1));
	            	client.setNom(resClient.getString(2));
					client.setPrenom(resClient.getString(3));
					client.setMail(resClient.getString(4));
					client.setMdp(resClient.getString(5));
					client.setAdresse(resClient.getString(6));
					client.setTel(resClient.getString(7));
//					client.setIdPosition(resClient.getInt(8));
					client.setStatut(resClient.getString(9));
					listeClient.add(client);
	            }
	         
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des cs "+ex.getMessage());
	         
	        }
	
	        return listeClient;
	}
public List<Client> DisplayAllClientNonValide() {
	
    List<Client> listeClient = new ArrayList<Client>();

      String requete = "select * from clients where statut = 'non valide'";
      try {
   Statement statement = MyConnection.getInstance().createStatement();
          ResultSet resClient = statement.executeQuery(requete);
       
          while(resClient.next()){
          	
          	Client client =new Client();
          	
          	client.setIdClient(resClient.getInt(1));
          	client.setNom(resClient.getString(2));
				client.setPrenom(resClient.getString(3));
				client.setMail(resClient.getString(4));
				client.setMdp(resClient.getString(5));
				client.setAdresse(resClient.getString(6));
				client.setTel(resClient.getString(7));
//				client.setIdPosition(resClient.getInt(8));
				client.setStatut(resClient.getString(9));
				listeClient.add(client);
          }
       
      } catch (SQLException ex) {
         //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("erreur lors du chargement des cs "+ex.getMessage());
       
      }

      return listeClient;
}

 public Client FindClientByID(int id) {
	 Client client =new Client();
	 String req = " select * from clients where idClient = "+id;
	 ResultSet resClient;
	try {
		Statement statement = MyConnection.getInstance().createStatement();
		 resClient = statement.executeQuery(req);
		 
	
	while(resClient.next()){
    	
    	
    	
    	client.setIdClient(resClient.getInt(1));
    	client.setNom(resClient.getString(2));
		client.setPrenom(resClient.getString(3));
		client.setMail(resClient.getString(4));
		client.setMdp(resClient.getString(5));
		client.setAdresse(resClient.getString(6));
		client.setTel(resClient.getString(7));
//		client.setIdPosition(resClient.getInt(8));
		client.setStatut(resClient.getString(9));
	
    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return (client);
	
}
 
 public void UpdateClient(Client client){
	 
	 String req = "update clients set statut = 'valide' where idClient="+client.getIdClient();
	 Statement statement;
	try {
		statement = MyConnection.getInstance().createStatement();
		statement.executeUpdate(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 public void supprimerClient(int id){
	 
	 String req = "delete from clients where idClient="+id;
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
