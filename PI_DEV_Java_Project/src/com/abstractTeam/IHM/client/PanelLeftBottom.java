package com.abstractTeam.IHM.client;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class PanelLeftBottom extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLeftBottom() {
		setBackground(Color.WHITE);

		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAccueil.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnAccueil.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelContenu();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
			
			}
		});

		setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.LIGHT_GRAY));

		btnAccueil.setBounds(10, 22, 317, 36);
		setBounds(0, 376, 337, 316);

		setLayout(null);
		add(btnAccueil);

		JButton btnListes = new JButton("Consulter les Restaurants");
		btnListes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelConsulterRestoPlats();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
				
			}
		});
		btnListes.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		btnListes.setHorizontalAlignment(SwingConstants.LEFT);
		btnListes.setBounds(10, 69, 317, 36);
		add(btnListes);
		
		JButton btnTopRestaurants = new JButton("Top 5 Restaurants");
		btnTopRestaurants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//new PanelStatistique2();

				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelTop5Resto();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
			
			}
		});
		btnTopRestaurants.setHorizontalAlignment(SwingConstants.LEFT);
		btnTopRestaurants.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTopRestaurants.setBounds(10, 116, 317, 36);
		add(btnTopRestaurants);
		
		JButton btnTopPlats = new JButton("Top 5 Plats");
		btnTopPlats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//	new PanelStatistique();

				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelTop5Plats();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
			
			
			
			}
		});
		btnTopPlats.setHorizontalAlignment(SwingConstants.LEFT);
		btnTopPlats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTopPlats.setBounds(10, 163, 317, 36);
		add(btnTopPlats);
		
		JButton btnRechercher = new JButton("Rechercher plats");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelRecherchePlat();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
//				RechercherPlat_Form myFrame = new RechercherPlat_Form();
//		        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		        myFrame.setVisible(true);
//		 
		
			
				//new AjoutPlat_Form();
	
			}
		});
		btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRechercher.setBounds(10, 210, 317, 36);
		add(btnRechercher);
		
		JButton btnRechercherRestaurant = new JButton("Rechercher restaurant");
		btnRechercherRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelRechercheREStooo();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
			
			}
		});
		
		
		
		btnRechercherRestaurant.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercherRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRechercherRestaurant.setBounds(10, 257, 317, 36);
		add(btnRechercherRestaurant);

		JButton btnAdministration = new JButton("Administration");
	
		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAdministration.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		btnAdministration.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdministration.setBounds(10, 250, 317, 36);
		
		setVisible(true);

	}
}
