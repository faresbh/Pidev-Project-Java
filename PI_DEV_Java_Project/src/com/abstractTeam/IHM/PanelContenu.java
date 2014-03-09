package com.abstractTeam.IHM;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.abstractTeam.IHM.Inscription.PanelModifCompte;
import com.abstractTeam.Model.Administrateur;
import com.abstractTeam.Model.Restaurateur;

@SuppressWarnings("serial")
public class PanelContenu extends JPanel {
	private Image backgroundImage;
	public Restaurateur restaurateur;
	public Administrateur administrateur;
	/**
	 * Create the panel.
	 */
	
	//img 
	
	
	
	
	
	public PanelContenu(final Restaurateur restaurateur,final Administrateur administrateur) {
		
		
		try {
			backgroundImage = ImageIO.read(new File("img/kimchi-copy.jpg"));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
//		Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
//	    PanelContenu.drawImage(background, 0, 0, null);

		
		this.restaurateur=restaurateur;
		this.administrateur=administrateur;
		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)),
				"Acceuil  - Resto-Tunisie -", TitledBorder.LEADING,
				TitledBorder.TOP, new Font(" Arial ", Font.BOLD, 15),
				Color.DARK_GRAY));
		setBounds(337, 76, 1013, 611);

		setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(157, 119, 572, 407);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		
		
		JLabel lblNom = new JLabel("Bienvenue Mr :");
		lblNom.setBounds(57, 106, 104, 14);
		panel.add(lblNom);
		
		JLabel lblEmail = new JLabel("Votre Email est :");
		lblEmail.setBounds(57, 167, 104, 14);
		panel.add(lblEmail);
		
		JLabel lblAdresse = new JLabel("Votre Adresse est :");
		lblAdresse.setBounds(57, 222, 125, 14);
		panel.add(lblAdresse);
		
		JLabel lblTel = new JLabel("Votre Tel est :");
		lblTel.setBounds(57, 278, 104, 14);
		panel.add(lblTel);
		
		JLabel lblVotreNom = new JLabel("");
		lblVotreNom.setBounds(219, 106, 297, 14);
		panel.add(lblVotreNom);
		JButton btnModifierVotreCompte = new JButton("Modifier votre compte");
		if (restaurateur != null )
		{
		lblVotreNom.setText(restaurateur.getNom());//recuperer nom du connexion
		
		JLabel lblVotrePrenom = new JLabel("votre prenom");
		lblVotrePrenom.setBounds(276, 106, 318, 14);
		panel.add(lblVotrePrenom);
		lblVotrePrenom.setText(restaurateur.getPrenom());
		
		JLabel lblVotreEmail = new JLabel("votre email");
		lblVotreEmail.setBounds(219, 167, 321, 14);
		panel.add(lblVotreEmail);
		lblVotreEmail.setText(restaurateur.getMail());
		
		JLabel lblVotreAdresse = new JLabel("votre adresse");
		lblVotreAdresse.setBounds(219, 222, 321, 14);
		panel.add(lblVotreAdresse);
		lblVotreAdresse.setText(restaurateur.getAdresse());
		
		JLabel lblVotreTel = new JLabel("votre tel");
		lblVotreTel.setBounds(219, 278, 297, 14);
		panel.add(lblVotreTel);
		lblVotreTel.setText(restaurateur.getTel());
		}else{
			lblVotreNom.setText(administrateur.getNom());//recuperer nom du connexion
			
			JLabel lblVotrePrenom = new JLabel("votre prenom");
			lblVotrePrenom.setBounds(276, 106, 318, 14);
			panel.add(lblVotrePrenom);
			lblVotrePrenom.setText(administrateur.getPrenom());
			
			JLabel lblVotreEmail = new JLabel("votre email");
			lblVotreEmail.setBounds(219, 167, 321, 14);
			panel.add(lblVotreEmail);
			lblVotreEmail.setText(administrateur.getMail());
			
			JLabel lblVotreAdresse = new JLabel("votre adresse");
			lblVotreAdresse.setBounds(219, 222, 321, 14);
			panel.add(lblVotreAdresse);
			lblVotreAdresse.setText(administrateur.getAdresse());
			
			JLabel lblVotreTel = new JLabel("votre tel");
			lblVotreTel.setBounds(219, 278, 297, 14);
			panel.add(lblVotreTel);
			lblVotreTel.setText(administrateur.getTel());
			btnModifierVotreCompte.setVisible(false);
		}
//		if (admin != null )
//		{
//		lblVotreNom.setText(admin.getNom());//recuperer nom du connexion
//		
//		JLabel lblVotrePrenom = new JLabel("votre prenom");
//		lblVotrePrenom.setBounds(276, 106, 318, 14);
//		panel.add(lblVotrePrenom);
//		lblVotrePrenom.setText(admin	.getPrenom());
//		
//		JLabel lblVotreEmail = new JLabel("votre email");
//		lblVotreEmail.setBounds(219, 167, 321, 14);
//		panel.add(lblVotreEmail);
//		lblVotreEmail.setText(admin	.getMail());
//		
//		JLabel lblVotreAdresse = new JLabel("votre adresse");
//		lblVotreAdresse.setBounds(219, 222, 321, 14);
//		panel.add(lblVotreAdresse);
//		lblVotreAdresse.setText(admin	.getAdresse());
//		
//		JLabel lblVotreTel = new JLabel("votre tel");
//		lblVotreTel.setBounds(219, 278, 297, 14);
//		panel.add(lblVotreTel);
//		lblVotreTel.setText(admin	.getTel());
//		}
	
		btnModifierVotreCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//					PanelModifCompte p = new PanelModifCompte();
//					p.main(null);
				

					
					
				
		
				
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelModifCompte(restaurateur);
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
			
			
			
			
			
			}
				
				
			
		});
		btnModifierVotreCompte.setBounds(278, 355, 189, 23);
		panel.add(btnModifierVotreCompte);
		
		
	

		
//		JFrame f = new JFrame();
//		PanelModifCompte p = new PanelModifCompte();
//		f.getContentPane().add(p);
//		f.setBounds(337, 76, 1013, 611);
//		f.setLocationRelativeTo(null);
//		//f.pack();
//		f.setVisible(true);
		
	}

public void paintComponent(final Graphics g) {

	super.paintComponent(g);
	g.drawImage(backgroundImage, 0, 0,1000,900, null);
}

}