package com.abstractTeam.IHM.client;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.Legend;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.DefaultPieDataset;

import com.abstractTeam.Controller.NoteRestoDAO;
import com.abstractTeam.Controller.RestaurantDao;
import com.abstractTeam.Model.ComparateurResto;
import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Restaurant;

@SuppressWarnings("serial")
public class PanelTop5Resto extends JPanel  {
	 private final JPanel contentPanel = new JPanel();
	 
	   List<Note> listNotes=new ArrayList<Note>();
	   
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelTop5Resto() {
		 {setBounds(337, 76, 1013, 611);
		  
		
	   

	    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
	    RestaurantDao dao=new   RestaurantDao();
	    List<Restaurant> restaurants=new ArrayList<Restaurant>();
	  //  Collections.sort(restaurants,Collections.reverseOrder());
	    NoteRestoDAO noteDao=new NoteRestoDAO();
	    restaurants=dao.getAllRestaurants2();
	    Collections.sort(restaurants, new ComparateurResto())	;
	    
	    
	 
	    
	    
	    
	    int i=0;
	    for(Restaurant restaurant:restaurants)
	    {
	    	System.out.println("trier ;"+restaurant.getNom());
		if((i<5)&&(existe(restaurant.getId()))) 
		{
			i++;
	    pieDataset.setValue(restaurant.getNom(), noteDao.calculMoy(restaurant.getId())); 
	    
		}}

	    JFreeChart pieChart = ChartFactory.createPieChart3D("TOP 5 Restaurants", 
	    pieDataset, true, true, true); 
	    PiePlot piePlot = (PiePlot) pieChart.getPlot(); 
	    piePlot.setExplodePercent(1, 0.5); 
	    Legend legend = pieChart.getLegend();
	    legend.setAnchor(Legend.EAST_NORTHEAST);
	    ChartPanel cPanel = new ChartPanel(pieChart); 
	    
	    File fichier = new File("image.png"); 
	    try { 
	      ChartUtilities.saveChartAsPNG(fichier, pieChart, 400, 250); 
	    } catch (IOException e) { 
	      e.printStackTrace(); 
	    } 
	    this.add(cPanel); 
	  } 
	}
	public boolean existe (int idRest)
	{
		NoteRestoDAO noteDao=new NoteRestoDAO();
		listNotes	= noteDao.DisplayAllResto(idRest);
		if(listNotes.isEmpty())
			return false;
		return true;
		
	}
	
}