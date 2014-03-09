package com.abstractTeam.IHM;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.abstractTeam.IHM.admin.PanelClient;
import com.abstractTeam.IHM.admin.PanelCommentaire;
import com.abstractTeam.IHM.admin.PanelRestaurateur;

@SuppressWarnings("serial")
public class PanelLeftBottomAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	public static String title="";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	
	public PanelLeftBottomAdmin(String title) {
		final JRadioButton rdbtncomvalide = new JRadioButton("valide");
		buttonGroup.add(rdbtncomvalide);
		rdbtncomvalide.setBounds(10, 22, 109, 23);
		add(rdbtncomvalide);
		
		final JRadioButton rdbtncomNonValide = new JRadioButton("non valide");
		buttonGroup.add(rdbtncomNonValide);
		rdbtncomNonValide.setBounds(133, 22, 109, 23);
		add(rdbtncomNonValide);
		
		final JRadioButton radioButtonClientValide = new JRadioButton("valide");
		buttonGroup_1.add(radioButtonClientValide);
		radioButtonClientValide.setBounds(10, 108, 109, 23);
		add(radioButtonClientValide);
		
		final JRadioButton radioButtonClientNonValide = new JRadioButton("non valide");
		buttonGroup_1.add(radioButtonClientNonValide);
		radioButtonClientNonValide.setBounds(133, 108, 109, 23);
		add(radioButtonClientNonValide);
		
		final JRadioButton radioButtonRestoValide = new JRadioButton("valide");
		buttonGroup_2.add(radioButtonRestoValide);
		radioButtonRestoValide.setBounds(10, 194, 109, 23);
		add(radioButtonRestoValide);
		
		final JRadioButton radioButtonRestoNonValide = new JRadioButton("non valide");
		buttonGroup_2.add(radioButtonRestoNonValide);
		radioButtonRestoNonValide.setBounds(133, 194, 109, 23);
		add(radioButtonRestoNonValide);
		setBackground(Color.WHITE);
		this.title=title;
		JButton btnCommentaires = new JButton("Gestion Commentaires");
		btnCommentaires.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCommentaires.setHorizontalAlignment(SwingConstants.LEFT);
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnCommentaires.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(rdbtncomvalide.isSelected()){
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelCommentaire(2);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}else{
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelCommentaire(1);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}

			
			}
		});
//		setBorder(new TitledBorder(null, "Restaurant 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btnCommentaires.setBounds(10, 53, 317, 36);
		setBounds(0, 376, 337, 316);

		setLayout(null);
		add(btnCommentaires);
		JButton btnClients = new JButton("Gestion Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButtonClientNonValide.isSelected()){
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelClient(1);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}else{
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelClient(2);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}
			}
		});
		btnClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		btnClients.setHorizontalAlignment(SwingConstants.LEFT);
		btnClients.setBounds(10, 138, 317, 36);
		add(btnClients);

		JButton btnRestaurant = new JButton("Gestion Restaurateurs");
		btnRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(radioButtonRestoNonValide.isSelected()){
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelRestaurateur(1);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}else{
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelRestaurateur(2);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}

			}
		});

		btnRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		btnRestaurant.setHorizontalAlignment(SwingConstants.LEFT);
		btnRestaurant.setBounds(10, 224, 317, 36);
		add(btnRestaurant);
		
		

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
