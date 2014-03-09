package com.abstractTeam.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Facture;
import com.abstractTeam.Model.Facture;

public class FactureDao {
	
	private Connection connection;

	public int ModifierFacture(Facture facture) {
		connection = ConnexionDB.getConnected();
		int x =0;
		try {
			Statement requete = connection.createStatement();
			String req = "UPDATE Factures SET somme =  "
					+ facture.getSomme() + ", description='"
					
					+ facture.getDescription() + "' where idFacture = "+facture.getIdFacture();

			 x =requete.executeUpdate(req);
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}


	 
	 
	 
	 
	 
	 
	

		
	}

	
		
	
	
	
	

