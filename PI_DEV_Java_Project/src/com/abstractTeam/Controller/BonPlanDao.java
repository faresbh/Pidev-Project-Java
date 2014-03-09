package com.abstractTeam.Controller;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Bonplan;

public class BonPlanDao {
	
	@SuppressWarnings("deprecation")
	public int insertBonPlan(Bonplan  bonplan ,int id_resto){
		int a=0;
		
			        String requete = "insert into bonplans (nom,type,prix,description,date,idresto) values (?,?,?,?,?,?)";
			        try {
			        	
			            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, bonplan.getNom());
			            ps.setString(2, bonplan.getType());
			            ps.setDouble(3, bonplan.getPrix());
			            ps.setString(4, bonplan.getDescription());
			            	
			            ps.setString(5, bonplan.getDate());
			            ps.setInt(6, id_resto);
			            ps.executeUpdate();
			            
			          
			            System.out.println("Ajout effectuée avec succès");
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors de l'insertion "+ex.getMessage());
			        }
			        return a;
			    }
	public List<Bonplan> selectAllBonPlan(int idResto){
		List<Bonplan>  a=new ArrayList<Bonplan>();
			        String requete = "Select * from bonplans where idresto="+idResto;
			        try {

			           Statement ps = MyConnection.getInstance().createStatement();
			           ResultSet resultSet=ps.executeQuery(requete);
			           Bonplan bonplan=null;
			           while(resultSet.next()){
			        	    bonplan=new Bonplan();
			        	  bonplan.setNom(resultSet.getString(2));

			        	  bonplan.setDescription(resultSet.getString(4));
			        	  bonplan.setPrix(resultSet.getDouble(5));
			        	  bonplan.setType(resultSet.getString(3));
			        	  bonplan.setDate(resultSet.getString(6));
			        	  bonplan.setId(resultSet.getInt(1));
			        	  a.add(bonplan);

			           }
			           	
			          
			            System.out.println("Affichage effectuée avec succès");
			        } catch (SQLException ex) {
			           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			            System.out.println("erreur lors de l'insertion "+ex.getMessage());
		            return  null;
			        }
			        return a;
			    }
	public int updateBonplan(Bonplan bn){
		int x=0;
		String requete = "update bonplans set nom=?,type=?,description=?,prix=?,date=? where id="+bn.getId() ;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, bn.getNom());

            ps.setString(2, bn.getType());
            ps.setString(3, bn.getDescription());

            ps.setDouble(4, bn.getPrix());
       
            ps.setString(5,bn.getDate());

           x= ps.executeUpdate();
            
            
            System.out.println("Mise a jour de la table avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("erreur lors de la mise Ã  jour "+ex.getMessage());

        }
       return x;
    }
	public Bonplan findbonplanbyId(int id){
	    Bonplan bn = new Bonplan();
	     String requete = "select * from bonplans where id= "+id;
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	            ResultSet resultat = ps.executeQuery();
	            while (resultat.next())
	            {
	            	bn.setId(resultat.getInt(1));
	                bn.setNom(resultat.getString(2));
	                bn.setType(resultat.getString(3));
	                bn.setDescription(resultat.getString(4));
	                bn.setPrix(resultat.getDouble(5));
	                bn.setDate(resultat.getString(6));
	            }
	            return bn;

	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	           System.out.println("erreur lors de la recherche du bn "+ex.getMessage());
	            return null;
	        }
	    }

public int delete(Bonplan bn){
     int resultat = 0;
	String requete = "delete  from bonplans where id= "+bn.getId();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             resultat = ps.executeUpdate();
           
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("erreur lors de la recherche du bn "+ex.getMessage());
        }
		return resultat;
    }
}
