package com.abstractTeam.Model;

import java.util.Comparator;

import com.abstractTeam.Controller.NoteDao;

public class ComparateurPlat implements Comparator<Plat> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compare(Plat o1, Plat o2) {
		NoteDao noteDao =new NoteDao();
		double nombre1=noteDao.calculMoy(o1.getId());
		 System.out.println("bjr");
	      double nombre2 = noteDao.calculMoy(o2.getId());
	      if (nombre1 > nombre2)  return -1; 
	      else if(nombre1 == nombre2) return 0; 
	      else return 1; 
		
	}

}
