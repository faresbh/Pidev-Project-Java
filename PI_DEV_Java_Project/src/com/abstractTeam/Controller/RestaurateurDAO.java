package com.abstractTeam.Controller;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.abstractTeam.Model.Restaurateur;


public class RestaurateurDAO {

	 public int updateMotDePasseRestaurateur(String mdp, String mail){
	     int a=0;  
		 String requete = "update restaurateurs set  mdp=? where mail=?";
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	            
	            ps.setString(1, mdp);
	            ps.setString(2, mail);
	          a=  ps.executeUpdate();
	            System.out.println("Mise à jour effectuée avec succès");
	           
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
	        }
	        return a;

	    }
 
	public Restaurateur findRestaurateurByMail(String mail){

	        String requete = "select * from restaurateurs where mail=?";

	        try{
	        PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	        ps.setString(1, mail);
	        
	        ResultSet resultat = ps.executeQuery();
	        
	        Restaurateur Restaurateur = null;
	        while (resultat.next()){
	        	Restaurateur=new Restaurateur();
	        	Restaurateur.setId(resultat.getInt(1));
	        	Restaurateur.setNom(resultat.getString(2));
	        	Restaurateur.setPrenom(resultat.getString(3));
	        	Restaurateur.setMail(resultat.getString(4));
	            Restaurateur.setMdp(resultat.getString(5));
	            Restaurateur.setAdresse(resultat.getString(6));
	            Restaurateur.setTel(resultat.getString(7));
	        }
	        return Restaurateur;
	        }
	        catch(SQLException ex){
	            System.out.println("erreur lors du chargement"+ex.getMessage());
	            return null;
	        }
	    }
	
	 public int updateRestaurateur(Restaurateur restaurateur){
	     int a=0;  
		 String requete = "update restaurateurs set nom=?, prenom=?, mail=?, mdp=?, adresse=?, tel=? where id=?";
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	            ps.setString(1, restaurateur.getNom());
	            ps.setString(2, restaurateur.getPrenom());
	            ps.setString(3, restaurateur.getMail());
	            ps.setString(4, restaurateur.getMdp());
	            ps.setString(5, restaurateur.getAdresse());
	            ps.setString(6, restaurateur.getTel());
	            ps.setInt(7, restaurateur.getId());
	          a=  ps.executeUpdate();
	            System.out.println("Mise à jour effectuée avec succès");
	           
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
	        }
	        return a;

	    }
	 public int insertrestaurateur(Restaurateur resaturateur){
		 int a=0;
		 PreparedStatement ps=null;
	        String requete = "insert into restaurateurs (nom,prenom,mail,mdp,adresse,tel) values (?,?,?,?,?,?)";
	        try {
	           ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, resaturateur.getNom());
	            ps.setString(2, resaturateur.getPrenom());
	            ps.setString(3, resaturateur.getMail());
	            ps.setString(4, resaturateur.getMdp());
	            ps.setString(5, resaturateur.getAdresse());
	            ps.setString(6, resaturateur.getTel());
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()){
	                	a=rs.getInt(1);
	            }
	            rs.close();

	            ps.close();
	            System.out.println("Ajout effectuée avec succès");
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors de l'insertion "+ex.getMessage());
	        }
	        return  a;
	    }
	 public Restaurateur findRestaurateurByMailMdp(String mail,String mdp){

	        String requete = "select * from restaurateurs where mail=? && mdp=?";

	        try{
	        PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	        ps.setString(1, mail);
	        ps.setString(2, mdp);
	        ResultSet resultat = ps.executeQuery();
	        
	        Restaurateur Restaurateur =null;
	        while (resultat.next()){
	        	Restaurateur=new Restaurateur();
	        	Restaurateur.setId(resultat.getInt(1));
	        	Restaurateur.setNom(resultat.getString(2));
	        	Restaurateur.setPrenom(resultat.getString(3));
	        	Restaurateur.setMail(resultat.getString(4));
	            Restaurateur.setMdp(resultat.getString(5));
	            Restaurateur.setAdresse(resultat.getString(6));
	            Restaurateur.setTel(resultat.getString(7));
	        }
	        return Restaurateur;
	        }
	        catch(SQLException ex){
	            System.out.println("erreur lors du chargement"+ex.getMessage());
	            return null;
	        }
	    }
	 
	 public List<Restaurateur> DisplayAllrestaurateurValide() {
			
	      List<Restaurateur> listerestaurateur = new ArrayList<Restaurateur>();

	        String requete = "select * from restaurateurs where statut = 'valide'";
	        try {
	     Statement statement = MyConnection.getInstance().createStatement();
	            ResultSet resRestau = statement.executeQuery(requete);
	         
	            while(resRestau.next()){
	            	
	            	Restaurateur restaurateur =new Restaurateur();
	            	
	            	restaurateur.setId(resRestau.getInt(1));
	            	restaurateur.setNom(resRestau.getString(2));
					restaurateur.setPrenom(resRestau.getString(3));
					restaurateur.setMail(resRestau.getString(4));
					restaurateur.setMdp(resRestau.getString(5));
					restaurateur.setAdresse(resRestau.getString(6));
					restaurateur.setTel(resRestau.getString(7));
					restaurateur.setStatut(resRestau.getString(8));
					listerestaurateur.add(restaurateur);
	            }
	         
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des cs "+ex.getMessage());
	         
	        }
	
	        return listerestaurateur;
	}
public List<Restaurateur> DisplayAllrestaurateurNonValide() {
	
   List<Restaurateur> listerestaurateur = new ArrayList<Restaurateur>();

     String requete = "select * from restaurateurs where statut = 'non valide'";
     try {
  Statement statement = MyConnection.getInstance().createStatement();
         ResultSet resRestau = statement.executeQuery(requete);
      
         while(resRestau.next()){
         	
         	Restaurateur restaurateur =new Restaurateur();
         	
         	restaurateur.setId(resRestau.getInt(1));
         	restaurateur.setNom(resRestau.getString(2));
				restaurateur.setPrenom(resRestau.getString(3));
				restaurateur.setMail(resRestau.getString(4));
				restaurateur.setMdp(resRestau.getString(5));
				restaurateur.setAdresse(resRestau.getString(6));
				restaurateur.setTel(resRestau.getString(7));
				restaurateur.setStatut(resRestau.getString(8));
				listerestaurateur.add(restaurateur);
         }
      
     } catch (SQLException ex) {
        //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("erreur lors du chargement des cs "+ex.getMessage());
      
     }

     return listerestaurateur;
}

public Restaurateur FindRestaurateurByID(int id) {
	Restaurateur restaurateur =new Restaurateur();
	 String req = " select * from restaurateurs where id = "+id;
	 ResultSet resRestau;
	try {
		Statement statement = MyConnection.getInstance().createStatement();
		 resRestau = statement.executeQuery(req);
		 
	
	while(resRestau.next()){
   	
   	
   	
   	restaurateur.setId(resRestau.getInt(1));
   	restaurateur.setNom(resRestau.getString(2));
		restaurateur.setPrenom(resRestau.getString(3));
		restaurateur.setMail(resRestau.getString(4));
		restaurateur.setMdp(resRestau.getString(5));
		restaurateur.setAdresse(resRestau.getString(6));
		restaurateur.setTel(resRestau.getString(7));
		restaurateur.setStatut(resRestau.getString(8));
	
   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return (restaurateur);
	
}

public void Updaterestaurateur(Restaurateur restaurateur){
	 
	 String req = "update restaurateurs set statut = 'valide' where id="+restaurateur.getId();
	 Statement statement;
	try {
		statement = MyConnection.getInstance().createStatement();
		statement.executeUpdate(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}

public void supprimerRestaurateur(int id){
	 
	 String req = "delete from restaurateurs where id="+id;
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
