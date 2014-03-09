package com.abstractTeam.IHM.admin;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.abstractTeam.Controller.RestaurateurDAO;
import com.abstractTeam.Model.Restaurateur;

public class TableModelRestaurateur extends AbstractTableModel {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String tableau[]= new String[8];
    
   Object[][] data;

   RestaurateurDAO dao=new RestaurateurDAO();
public  TableModelRestaurateur (int type)
{
	super();
	
	tableau[0]="id";
	tableau[1]="nom";
	tableau[2]="prenom";
	tableau[3]="mail";
	tableau[4]="mdp";
	tableau[5]="adresse";
	tableau[6]="tel";
	tableau[7]="statut";
	 
	

	
//modification DAO
	RestaurateurDAO gestion_regle = new RestaurateurDAO();
switch (type) {
case 2:
	List <Restaurateur> listeRestaurateur = gestion_regle.DisplayAllrestaurateurValide();
	data=new Object[listeRestaurateur.size()][9];

		for (int i=0;i< listeRestaurateur.size();i++)
		{
		data[i][0] = listeRestaurateur.get(i).getId();
		data[i][1] = listeRestaurateur.get(i).getNom();
		data[i][2] = listeRestaurateur.get(i).getPrenom();
		data[i][3] = listeRestaurateur.get(i).getMail();
		data[i][4] = listeRestaurateur.get(i).getMdp();
		data[i][5] = listeRestaurateur.get(i).getAdresse();
		data[i][6] = listeRestaurateur.get(i).getTel();
		data[i][7] = listeRestaurateur.get(i).getStatut();
		}

	break;

case 1:
	List <Restaurateur> listeRestaurateur2 = gestion_regle.DisplayAllrestaurateurNonValide();
	data=new Object[listeRestaurateur2.size()][9];

		for (int i=0;i< listeRestaurateur2.size();i++)
		{
		data[i][0] = listeRestaurateur2.get(i).getId();
		data[i][1] = listeRestaurateur2.get(i).getNom();
		data[i][2] = listeRestaurateur2.get(i).getPrenom();
		data[i][3] = listeRestaurateur2.get(i).getMail();
		data[i][4] = listeRestaurateur2.get(i).getMdp();
		data[i][5] = listeRestaurateur2.get(i).getAdresse();
		data[i][6] = listeRestaurateur2.get(i).getTel();
		data[i][7] = listeRestaurateur2.get(i).getStatut();
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
