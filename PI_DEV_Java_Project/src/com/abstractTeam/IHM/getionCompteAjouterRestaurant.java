package com.abstractTeam.IHM;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class getionCompteAjouterRestaurant {

	private JFrame frame;
	private JTextField textFieldNomRestaurant;
	private JTextField textFieldMail;
	private JTextField textFieldMpw2;
	private JTextField textFieldNbrTable;
	private JTextField textFieldMpw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getionCompteAjouterRestaurant window = new getionCompteAjouterRestaurant();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public getionCompteAjouterRestaurant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(254, 65, 61, 375);
		frame.getContentPane().add(separator);
		JLabel lblGestionCompte = new JLabel("Gestion Compte");
		lblGestionCompte.setForeground(Color.RED);
		lblGestionCompte.setBounds(10, 117, 109, 14);
		frame.getContentPane().add(lblGestionCompte);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 65, 758, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblBienvenue = new JLabel("Bienvenue Monsieur");
		lblBienvenue.setBounds(618, 40, 109, 14);
		frame.getContentPane().add(lblBienvenue);
		
		JLabel lblBienvenueDans = new JLabel("Bienvenue Dans Restaurant Abstract ");
		lblBienvenueDans.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenueDans.setForeground(Color.RED);
		lblBienvenueDans.setBounds(177, 11, 299, 22);
		frame.getContentPane().add(lblBienvenueDans);
		
		JLabel lblVosRestaurants = new JLabel("Vos Restaurants");
		lblVosRestaurants.setForeground(Color.BLACK);
		lblVosRestaurants.setBounds(10, 146, 109, 14);
		frame.getContentPane().add(lblVosRestaurants);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 178, 210, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnAjouterRestaurant = new JButton("Ajouter Restaurant");
		btnAjouterRestaurant.setBounds(20, 223, 134, 23);
		frame.getContentPane().add(btnAjouterRestaurant);
		
		JLabel lblRestaurantX = new JLabel("Restaurant x");
		lblRestaurantX.setBounds(20, 274, 85, 14);
		frame.getContentPane().add(lblRestaurantX);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 256, 261, 14);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 299, 251, 14);
		frame.getContentPane().add(separator_3);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(0, 325, 255, 23);
		frame.getContentPane().add(btnMenu);
		
		JButton btnReservation = new JButton("Reservation");
		btnReservation.setBounds(0, 372, 255, 23);
		frame.getContentPane().add(btnReservation);
		
		JButton btnLivraison = new JButton("Livraison");
		btnLivraison.setBounds(0, 417, 251, 23);
		frame.getContentPane().add(btnLivraison);
		
		JLabel lblNewLabel = new JLabel("Nom Restaurant :");
		lblNewLabel.setBounds(325, 86, 85, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldNomRestaurant = new JTextField();
		textFieldNomRestaurant.setBounds(470, 83, 216, 20);
		frame.getContentPane().add(textFieldNomRestaurant);
		textFieldNomRestaurant.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setBounds(325, 133, 46, 14);
		frame.getContentPane().add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(470, 130, 216, 20);
		frame.getContentPane().add(textFieldMail);
		
		JLabel lblConfirmerMotDe = new JLabel("Confirmer mot de passe :");
		lblConfirmerMotDe.setBounds(325, 227, 124, 14);
		frame.getContentPane().add(lblConfirmerMotDe);
		
		textFieldMpw2 = new JTextField();
		textFieldMpw2.setColumns(10);
		textFieldMpw2.setBounds(470, 224, 216, 20);
		frame.getContentPane().add(textFieldMpw2);
		
		JLabel lblNombreTable = new JLabel("Nombre Table :");
		lblNombreTable.setBounds(325, 277, 134, 14);
		frame.getContentPane().add(lblNombreTable);
		
		textFieldNbrTable = new JTextField();
		textFieldNbrTable.setColumns(10);
		textFieldNbrTable.setBounds(470, 274, 216, 20);
		frame.getContentPane().add(textFieldNbrTable);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(325, 181, 124, 14);
		frame.getContentPane().add(lblMotDePasse);
		
		textFieldMpw = new JTextField();
		textFieldMpw.setColumns(10);
		textFieldMpw.setBounds(470, 178, 216, 20);
		frame.getContentPane().add(textFieldMpw);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(325, 329, 46, 14);
		frame.getContentPane().add(lblAdresse);
		
		JTextArea textAreaAdresse = new JTextArea();
		textAreaAdresse.setBounds(470, 324, 216, 116);
		frame.getContentPane().add(textAreaAdresse);
		
		JButton btnImage = new JButton("Images");
		btnImage.setBounds(339, 456, 89, 23);
		frame.getContentPane().add(btnImage);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(454, 456, 89, 23);
		frame.getContentPane().add(btnOk);
	}
}
