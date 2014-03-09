package com.abstractTeam.IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTree;

public class admin_gestion_compte {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_gestion_compte window = new admin_gestion_compte();
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
	public admin_gestion_compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 59, 414, 8);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(128, 59, 2, 226);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Bienevenue Dans Restaurant Abstract");
		lblNewLabel.setBounds(100, 11, 199, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue Monsieur Admin");
		lblNewLabel_1.setBounds(279, 34, 128, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion Compte");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 70, 81, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnRestaurant = new JButton("Restaurant");
		btnRestaurant.setBounds(2, 99, 108, 23);
		frame.getContentPane().add(btnRestaurant);
		
		JButton btnClient = new JButton("Client\r\n");
		btnClient.setBounds(2, 133, 108, 23);
		frame.getContentPane().add(btnClient);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion Commentaire\r\n");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 189, 108, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnCommentaire = new JButton("Commentaire");
		btnCommentaire.setBounds(2, 214, 116, 23);
		frame.getContentPane().add(btnCommentaire);
		
		JComboBox comboBoxNouveauClient = new JComboBox();
		comboBoxNouveauClient.setToolTipText("test2");
		comboBoxNouveauClient.setBounds(148, 141, 96, 23);
		frame.getContentPane().add(comboBoxNouveauClient);
		
		JButton btnNouveauConsulter = new JButton("Consulter");
		btnNouveauConsulter.setBounds(304, 141, 89, 23);
		frame.getContentPane().add(btnNouveauConsulter);
		
		JLabel lblNewLabel_4 = new JLabel("nouveau demande des clients");
		lblNewLabel_4.setBounds(148, 99, 209, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBoxAcienClient = new JComboBox();
		comboBoxAcienClient.setBounds(148, 196, 96, 20);
		frame.getContentPane().add(comboBoxAcienClient);
		
		JButton btnAncienConsulter = new JButton("Consulter");
		btnAncienConsulter.setBounds(304, 195, 89, 23);
		frame.getContentPane().add(btnAncienConsulter);
	}
}
