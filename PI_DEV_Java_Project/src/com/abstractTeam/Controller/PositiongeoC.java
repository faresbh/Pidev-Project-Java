package com.abstractTeam.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abstractTeam.Model.Positiongeo;

public class PositiongeoC {
	 public int insertPositiongeo(Positiongeo d){
		 int a=0;
		 PreparedStatement ps=null;
	        String requete = "insert into positiongeo (abs,ord) values (?,?)";
	        try {
	           ps = MyConnection.getInstance().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
	            ps.setDouble(1, d.getAbs());
	            ps.setDouble(2, d.getOrd());
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
}
