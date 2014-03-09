package com.abstractTeam.IHM.admin;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.abstractTeam.Controller.CommentaireDAO;
import com.abstractTeam.Model.Commentaire;

public class TableModelCommentaire extends AbstractTableModel {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String tableau[]= new String[7];
    
   Object[][] data;

   CommentaireDAO dao=new CommentaireDAO();
public  TableModelCommentaire (int type)
{
	super();
	
	tableau[0]="idCommentaire";
	tableau[1]="message";
	tableau[2]="Plat";
	tableau[3]="Client";
	tableau[4]="Restaurant";
	tableau[5]="BonPlan";
	tableau[6]="statut";
	 
	

	
//modification DAO
	CommentaireDAO gestion_regle = new CommentaireDAO();
switch (type) {
case 2:
	List <Commentaire> listeCommentaire = gestion_regle.DisplayAllcommentaireValide();
	data=new Object[listeCommentaire.size()][7];

		for (int i=0;i< listeCommentaire.size();i++)
		{
		data[i][0] = listeCommentaire.get(i).getIdCommentaire();
		data[i][1] = listeCommentaire.get(i).getMessage();
		data[i][2] = listeCommentaire.get(i).getPlat().getLabel();
		data[i][3] = listeCommentaire.get(i).getClient().getNom();
		data[i][4] = listeCommentaire.get(i).getRestaurant().getNom();
		data[i][5] = listeCommentaire.get(i).getBonplan().getNom();
		data[i][6] = listeCommentaire.get(i).getStatut();
		}

	break;

case 1:
	List <Commentaire> listeCommentaire2 = gestion_regle.DisplayAllcommentaireNonValide();
	data=new Object[listeCommentaire2.size()][7];

		for (int i=0;i< listeCommentaire2.size();i++)
		{
			data[i][0] = listeCommentaire2.get(i).getIdCommentaire();
			data[i][1] = listeCommentaire2.get(i).getMessage();
			data[i][2] = listeCommentaire2.get(i).getPlat().getLabel();
			data[i][3] = listeCommentaire2.get(i).getClient().getNom();
			data[i][4] = listeCommentaire2.get(i).getRestaurant().getNom();
			data[i][5] = listeCommentaire2.get(i).getBonplan().getNom();
			data[i][6] = listeCommentaire2.get(i).getStatut();
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
