package com.abstractTeam.IHM;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import GestionReservation.PanelReservations;

import com.abstractTeam.IHM.BonPlan.PanelChoisirBonPlan;
import com.abstractTeam.IHM.GestionLivraison.PanelLivraison;
import com.abstractTeam.IHM.GestionRestaurant.MenueRestaurantPanel;
import com.abstractTeam.IHM.client.PanelTop5Plats;

@SuppressWarnings("serial")
public class PanelLeftBottom extends JPanel {

	/**
	 * Create the panel.
	 */
	public static String title="";
	
	public PanelLeftBottom(String title) {
		setBackground(Color.WHITE);
		this.title=title;
		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAccueil.setHorizontalAlignment(SwingConstants.LEFT);
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAccueil.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

			
			}
		});
//		setBorder(new TitledBorder(null, "Restaurant 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btnAccueil.setBounds(10, 22, 317, 36);
		setBounds(0, 376, 337, 316);

		setLayout(null);
		add(btnAccueil);
		JButton btnRegles = new JButton("Gestion réservations");
		btnRegles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelReservations(new String("img/fourchette.jpg"));
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
			
			}
		});
		btnRegles.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		btnRegles.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegles.setBounds(10, 69, 317, 36);
		add(btnRegles);

		JButton btnMesDocuments = new JButton("Gestion Livraisons");
		btnMesDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelLivraison(new String("img/liv.jpg"));
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();

			}
		});

		btnMesDocuments.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		btnMesDocuments.setHorizontalAlignment(SwingConstants.LEFT);
		btnMesDocuments.setBounds(10, 116, 317, 36);
		add(btnMesDocuments);
		
		JButton btnStatistique = new JButton("Statistique\r\ns");
		btnStatistique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelTop5Plats();
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
				
			}
		});
		btnStatistique.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistique.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStatistique.setBounds(10, 163, 317, 36);
		add(btnStatistique);
		
		JButton btnGestionBonPlans = new JButton("Gestion Bon Plans");
		btnGestionBonPlans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelChoisirBonPlan(PanelLeftTop.idRestaurateur);
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
			}
		});
		btnGestionBonPlans.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionBonPlans.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGestionBonPlans.setBounds(10, 210, 317, 36);
		add(btnGestionBonPlans);
		
		JButton btnGestionMenus = new JButton("Gestion Menus");
		btnGestionMenus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);

				ApplicationFrame.panelContenu= new MenueRestaurantPanel();
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
//				PanelMenu.content.setVisible(false);
			}
		});
		btnGestionMenus.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionMenus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGestionMenus.setBounds(10, 257, 317, 36);
		add(btnGestionMenus);

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
