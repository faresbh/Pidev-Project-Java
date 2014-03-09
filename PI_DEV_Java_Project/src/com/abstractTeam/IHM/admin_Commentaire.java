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

public class admin_Commentaire {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_Commentaire window = new admin_Commentaire();
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
	public admin_Commentaire() {
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
		
		JButton btnNewButton = new JButton("Restaurant");
		btnNewButton.setBounds(2, 99, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Client\r\n");
		btnNewButton_1.setBounds(2, 133, 108, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion Commentaire\r\n");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 189, 108, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Commentaire");
		btnNewButton_2.setBounds(2, 214, 116, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setEditable(true);
		comboBox.setToolTipText("test2");
		comboBox.setBounds(148, 141, 96, 23);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_3 = new JButton("Consulter");
		btnNewButton_3.setBounds(304, 141, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("nouveau demande des commentaires");
		lblNewLabel_4.setBounds(148, 99, 209, 14);
		frame.getContentPane().add(lblNewLabel_4);
	}
}