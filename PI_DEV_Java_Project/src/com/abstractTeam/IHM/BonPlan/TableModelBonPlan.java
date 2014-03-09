package com.abstractTeam.IHM.BonPlan;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.abstractTeam.Controller.BonPlanDao;
import com.abstractTeam.Model.Bonplan;
public class TableModelBonPlan extends AbstractTableModel {
	
	String tableau[]= new String[6];
    
   Object[][] data;
BonPlanDao dao=new BonPlanDao();
public int  id_resto;
public  TableModelBonPlan (int id_resto)
{
	super();
	this.id_resto=id_resto;
	tableau[0]="Nom";
	tableau[1]="Type";
	tableau[2]="Description";
	tableau[3]="Prix";
	tableau[4]="Date";
	tableau[5]="id";
	
	
	
//modification DAO
BonPlanDao gestion_regle = new BonPlanDao();
List <Bonplan> listebonplan = gestion_regle.selectAllBonPlan(id_resto);
data=new Object[listebonplan.size()][6];
	for (int i=0;i< listebonplan.size();i++)
	{
	data[i][0] = listebonplan.get(i).getNom();
	data[i][1] = listebonplan.get(i).getType();
	data[i][2] = listebonplan.get(i).getDescription();
	data[i][3] = listebonplan.get(i).getPrix();
	data[i][4] = listebonplan.get(i).getDate();
	data[i][5] = listebonplan.get(i).getId();


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
	
	
	
	return data.length;	}

public Object getValueAt(int l, int c) {
	// TODO Auto-generated method stub
	

	
	return data[l][c];
}

public void setValueAt(Object value, int r,int c) {
	// TODO Auto-generated method stub
	

	
	data[r][c]=value;
	fireTableCellUpdated(r, c);
}





}

