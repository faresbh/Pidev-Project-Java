package com.abstractTeam.Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import com.abstractTeam.Model.Livraison;
import com.abstractTeam.Model.Reservation;

/**
 * 
 * @salma
 */
public class GenererPDFLivraison extends JFrame {
	@SuppressWarnings("unchecked")
	public GenererPDFLivraison(Livraison res) {
		Connection connection;
		try {
			// - Connexion à la base
			connection =ConnexionDB.getConnected();
			// - Chargement et compilation du rapport
			System.out.println("oci");
			JasperDesign jasperDesign = JRXmlLoader
					.load("doc/report5.jrxml");
			JasperReport jasperReport = JasperCompileManager
					.compileReport(jasperDesign);
			// - Paramètres à envoyer au rapport
			Map parameters = new HashMap();

			parameters.put("idRes", new Integer(res.getIdLivraison()));
			parameters.put("nomClient", res.getClient().getNom());
			parameters.put("prenomClient", res.getClient().getPrenom());
			parameters.put("adrClient", res.getClient().getAdresse());
			parameters.put("telClient", res.getClient().getTel());
			parameters.put("Resto", res.getRestaurant().getNom());
			parameters.put("somme", res.getFacture().getSomme());

			// - Execution du rapport
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, connection);
			// - Création du rapport au format PDF
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"doc/facture/factureLiv.pdf");
			JasperViewer.viewReport(jasperPrint, false); // L'affichage du
															// rapport en
															// utilisant
															// JRViewer
			System.out.println("success");

		}

		catch (JRException e) {
			System.out.println("erreur de compilation" + e.getMessage());
		}

	}

}
/**/