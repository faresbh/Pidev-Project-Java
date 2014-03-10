package com.abstractTeam.Controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abstractTeam.Model.Administrateur;

public class AdministrateurDao {
	
	 public Administrateur findAdminByMailMdp(String mail,String mdp){

	        String requete = "select * from administrateurs where mail=? && mdp=? ";

	        try{
	        PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	        ps.setString(1, mail);
	        ps.setString(2, mdp);
	        ResultSet resultat = ps.executeQuery();
	        
	        Administrateur admin = null;
	        while (resultat.next()){
	        	admin=new Administrateur();
	        	admin.setId(resultat.getInt(1));
	        	admin.setNom(resultat.getString(5));
	        	admin.setPrenom(resultat.getString(6));
	        	admin.setMail(resultat.getString(3));
	            admin.setMdp(resultat.getString(4));
	            admin.setAdresse(resultat.getString(2));
	            admin.setTel(resultat.getString(7));
	        }
	        return admin;
	        }
	        catch(SQLException ex){
	            System.out.println("erreur lors du chargement"+ex.getMessage());
	            return null;
	        }
	    }


}
