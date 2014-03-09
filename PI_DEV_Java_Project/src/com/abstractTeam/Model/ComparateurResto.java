package com.abstractTeam.Model;

import java.util.Comparator;

import com.abstractTeam.Controller.NoteRestoDAO;

public class ComparateurResto implements Comparator<Restaurant> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compare(Restaurant o1, Restaurant o2) {
		NoteRestoDAO noteDao =new NoteRestoDAO();
		double nombre1=noteDao.calculMoy(o1.getId());
		 System.out.println("bjr");
	      double nombre2 = noteDao.calculMoy(o2.getId());
	      if (nombre1 > nombre2)  return -1; 
	      else if(nombre1 == nombre2) return 0; 
	      else return 1; 
		
	}

}
