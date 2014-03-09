package com.abstractTeam.IHM.admin;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.abstractTeam.Controller.ClientDAO;
import com.abstractTeam.Model.Client;

public class TableModelClient extends AbstractTableModel {
	


	String tableau[]= new String[8];
    
   Object[][] data;

ClientDAO dao=new ClientDAO();
public  TableModelClient (int type)
{
	super();
	
	tableau[0]="idClient";
	tableau[1]="nom";
	tableau[2]="prenom";
	tableau[3]="mail";
	tableau[4]="mdp";
	tableau[5]="adresse";
	tableau[6]="tel";
	tableau[7]="statut";
	 
	

	
//modification DAO
ClientDAO gestion_regle = new ClientDAO();
switch (type) {
case 2:
	List <Client> listeClient = gestion_regle.DisplayAllClientValide();
	data=new Object[listeClient.size()][9];

		for (int i=0;i< listeClient.size();i++)
		{
		data[i][0] = listeClient.get(i).getIdClient();
		data[i][1] = listeClient.get(i).getNom();
		data[i][2] = listeClient.get(i).getPrenom();
		data[i][3] = listeClient.get(i).getMail();
		data[i][4] = listeClient.get(i).getMdp();
		data[i][5] = listeClient.get(i).getAdresse();
		data[i][6] = listeClient.get(i).getTel();
//		data[i][7] = listeClient.get(i).getIdPosition();
		data[i][7] = listeClient.get(i).getStatut();
		}

	break;

case 1:
	List <Client> listeClient2 = gestion_regle.DisplayAllClientNonValide();
	data=new Object[listeClient2.size()][9];

		for (int i=0;i< listeClient2.size();i++)
		{
		data[i][0] = listeClient2.get(i).getIdClient();
		data[i][1] = listeClient2.get(i).getNom();
		data[i][2] = listeClient2.get(i).getPrenom();
		data[i][3] = listeClient2.get(i).getMail();
		data[i][4] = listeClient2.get(i).getMdp();
		data[i][5] = listeClient2.get(i).getAdresse();
		data[i][6] = listeClient2.get(i).getTel();
//		data[i][7] = listeClient2.get(i).getIdPosition();
		data[i][7] = listeClient2.get(i).getStatut();
		}

	break;
}







}


public int getColumnCount() {
		// TODO Auto-generated method stub
		return tableau.length;
		
	}
	
	@Override
	 public String getColumnName(int i) {
	    return tableau[i];
	  }

	public int getRowCount() {
		// TODO Auto-generated method stub
		
		
		return data.length;	}

	public Object getValueAt(int l, int c) {
		// TODO Auto-generated method stub
		
	
		
		return data[l][c];
	}
	
	public void setValueAt(Object value, int row, int col) {
		  
		  data[row][col] = value;
	      fireTableCellUpdated(row,col);
	    }
	


	
}
