package com.abstractTeam.IHM.Inscription;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.RestaurateurDAO;
import com.abstractTeam.Model.Restaurateur;

@SuppressWarnings("serial")
public class PanelInscriptionRestaurant extends JPanel {


	JLabel lblNewLabel_1 = new JLabel("");
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textMail;
	private JTextField textTel;
	private JTextField textAddresse;
	private JPasswordField textMDP;
	private JPasswordField textConfirmMDP;
	private Image backgroundImage;
	/**
	 * Create the panel.
	 */
	public PanelInscriptionRestaurant() {
		
		try {
			backgroundImage = ImageIO.read(new File("img/casino.jpg"));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	



		
		
	setBackground(Color.white);
		
		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)),
				"Inscription  - Resto-Tunisie -", TitledBorder.LEADING,
				TitledBorder.TOP, new Font(" Arial ", Font.BOLD, 15),
				Color.DARK_GRAY));
		setBounds(337, 76, 1013, 611);

		setLayout(null);
		setVisible(true);
		lblNewLabel_1.setBounds(330, 221, 419, 120);
	
		add(lblNewLabel_1);
		
		JPanel panelConnection = new JPanel();
		panelConnection.setBounds(172, 82, 607, 479);
		add(panelConnection);
		panelConnection.setLayout(null);
		panelConnection.setBackground(Color.WHITE);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(20, 23, 80, 14);
		panelConnection.add(lblNewLabel);
		
		textNom = new JTextField();
		textNom.setBounds(212, 20, 172, 20);
		panelConnection.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setBounds(20, 81, 80, 14);
		panelConnection.add(lblNewLabel_2);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(212, 78, 172, 20);
		panelConnection.add(textPrenom);
		textPrenom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mail :");
		lblNewLabel_3.setBounds(20, 134, 80, 14);
		panelConnection.add(lblNewLabel_3);
		
		textMail = new JTextField();
		textMail.setBounds(212, 131, 172, 20);
		panelConnection.add(textMail);
		textMail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe :");
		lblNewLabel_4.setBounds(20, 191, 110, 20);
		panelConnection.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirme mot de passe :");
		lblNewLabel_5.setBounds(20, 248, 147, 14);
		panelConnection.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tel :");
		lblNewLabel_6.setBounds(20, 306, 80, 14);
		panelConnection.add(lblNewLabel_6);
		
		textTel = new JTextField();
		textTel.setBounds(212, 300, 172, 20);
		panelConnection.add(textTel);
		textTel.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Adresse :");
		lblNewLabel_8.setBounds(20, 367, 80, 14);
		panelConnection.add(lblNewLabel_8);
		
		textAddresse = new JTextField();
		textAddresse.setBounds(212, 367, 172, 88);
		panelConnection.add(textAddresse);
		textAddresse.setColumns(10);
		
		JButton btnCreeCompte = new JButton("OK");
		btnCreeCompte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreeCompte.setBackground(Color.WHITE);
		btnCreeCompte.setSelectedIcon(new ImageIcon("C:\\Users\\Badreddine\\Desktop\\AbstractTeamJava-49e9582c29fe60ae25471a67addd73891d689d89\\AbstractTeamJava-49e9582c29fe60ae25471a67addd73891d689d89\\PI_DEV_Java_Project\\img\\ok.jpg"));
		btnCreeCompte.setIcon(new ImageIcon("C:\\Users\\Badreddine\\Desktop\\AbstractTeamJava-49e9582c29fe60ae25471a67addd73891d689d89\\AbstractTeamJava-49e9582c29fe60ae25471a67addd73891d689d89\\PI_DEV_Java_Project\\img\\ok.jpg"));
		btnCreeCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
				if(!textNom.getText().equals("")||!textPrenom.getText().equals("")||!textAddresse.getText().equals("")||!textMail.getText().equals("")||!textMDP.getText().equals("")||!textConfirmMDP.getText().equals("")||!textTel.getText().equals("")){
					OptionMessage.messageWarning("Champs vides", "remplir tous les champs SVP");
				}
				else if (!(textMDP.getText().equals(textConfirmMDP.getText()))) {
				
					OptionMessage.messageWarning("Controle de saisie", "Confirmation de mot de passe invalide")	;			
					
				}
				
//				else if (textMail.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" ) ) 				{
//					
//				
//OptionMessage.messageWarning("Mail non valide", "verifier votre mail")	;			
//				}
					
					
				
				else
				{
					
					
				
				Restaurateur restaurateur =new Restaurateur();
			restaurateur.setNom(textNom.getText());
			restaurateur.setPrenom(textPrenom.getText());
			restaurateur.setAdresse(textAddresse.getText());
			restaurateur.setMail(textMail.getText());
			
			restaurateur.setTel(textTel.getText());
			restaurateur.setMdp(textMDP.getText());
		
			
			RestaurateurDAO restaurateurDAO=new RestaurateurDAO();
			restaurateurDAO.insertrestaurateur(restaurateur);
			JOptionPane.showMessageDialog(null, "Votr Compte est Creé");
			}}
		});
		btnCreeCompte.setBounds(464, 359, 117, 50);
		panelConnection.add(btnCreeCompte);
		
		textMDP = new JPasswordField();
		textMDP.setBounds(212, 191, 172, 20);
		panelConnection.add(textMDP);
		
		textConfirmMDP = new JPasswordField();
		textConfirmMDP.setBounds(212, 245, 172, 20);
		panelConnection.add(textConfirmMDP);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Badreddine\\Desktop\\AbstractTeamJava-49e9582c29fe60ae25471a67addd73891d689d89\\AbstractTeamJava-49e9582c29fe60ae25471a67addd73891d689d89\\PI_DEV_Java_Project\\img\\annul.png"));
		btnNewButton.setBounds(464, 420, 117, 48);
		panelConnection.add(btnNewButton);
		
		
	
		
// PanelInscriptionRestaurant.setBackground(Color.blue);		
		
	}
	public void paintComponent(final Graphics g) {

		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0,1000,900, null);
	}


	
	
public static void main(String[] args){
	
	
	JFrame f = new JFrame();
	PanelInscriptionRestaurant p = new PanelInscriptionRestaurant();
	f.getContentPane().add(p);
	f.setBounds(337, 76, 1013, 611);
	f.setLocationRelativeTo(null);
	//f.pack();
	f.setVisible(true);
	
}
}
