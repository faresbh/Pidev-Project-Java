package com.abstractTeam.IHM.Inscription;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Font;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.RestaurateurDAO;
import com.abstractTeam.IHM.ApplicationFrame;
import com.abstractTeam.IHM.ConnectionFrame;
import com.abstractTeam.IHM.PanelContenu;
import com.abstractTeam.Model.Restaurateur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PanelModifCompte extends JPanel {
	Restaurateur restaurateur=ApplicationFrame.restaurateur;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textMail;
	private JTextField textTel;
	private JTextField textAddresse;
	private JPasswordField textMDP;
	public Restaurateur restaurateur2;
	private Image backgroundImage;
	/**
	 * Create the panel.
	 */
	public PanelModifCompte(Restaurateur restaurateur) {
		restaurateur2=restaurateur;
		try {
			backgroundImage = ImageIO.read(new File("img/girona_restaurants-HD.jpg"));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setBackground(Color.WHITE);
		
		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)),
				"Modifier- Compte -", TitledBorder.LEADING,
				TitledBorder.TOP, new Font(" Arial ", Font.BOLD, 15),
				Color.DARK_GRAY));
		setBounds(337, 76, 1013, 611);

		setLayout(null);
		setVisible(true);
		
		JPanel panelConnection = new JPanel();
		panelConnection.setBackground(Color.WHITE);
		panelConnection.setBounds(109, 66, 661, 454);
		add(panelConnection);
		panelConnection.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(20, 23, 80, 14);
		panelConnection.add(lblNewLabel);
		
		
		textNom = new JTextField();
		textNom.setBounds(212, 20, 159, 20);
		panelConnection.add(textNom);
		textNom.setColumns(10);
		textNom.setText(restaurateur.getNom());
	
		
		JLabel lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setBounds(20, 81, 80, 14);
		panelConnection.add(lblNewLabel_2);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(212, 78, 159, 20);
		panelConnection.add(textPrenom);
		textPrenom.setColumns(10);
		textPrenom.setText(restaurateur.getPrenom());
		
		JLabel lblNewLabel_3 = new JLabel("Mail :");
		lblNewLabel_3.setBounds(20, 134, 80, 14);
		panelConnection.add(lblNewLabel_3);
		
		textMail = new JTextField();
		textMail.setBounds(212, 131, 159, 20);
		panelConnection.add(textMail);
		textMail.setColumns(10);
		textMail.setText(restaurateur.getMail());
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe :");
		lblNewLabel_4.setBounds(20, 191, 110, 20);
		panelConnection.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Tel :");
		lblNewLabel_6.setBounds(20, 251, 80, 14);
		panelConnection.add(lblNewLabel_6);
		
		textTel = new JTextField();
		textTel.setBounds(212, 264, 159, 20);
		panelConnection.add(textTel);
		textTel.setColumns(10);
		textTel.setText(restaurateur.getTel());
		
		JLabel lblNewLabel_8 = new JLabel("Adresse :");
		lblNewLabel_8.setBounds(20, 326, 80, 14);
		panelConnection.add(lblNewLabel_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 339, 159, 88);
		panelConnection.add(scrollPane);
		
		textAddresse = new JTextField();
		scrollPane.setViewportView(textAddresse);
		textAddresse.setColumns(10);
		textAddresse.setText(restaurateur.getAdresse());
		
		JButton btnModifCompte = new JButton("OK");
		btnModifCompte.setIcon(new ImageIcon("C:\\Users\\Ahmed Taha\\Desktop\\java\\AbstractTeamJava\\PI_DEV_Java_Project\\img\\ok.jpg"));
		btnModifCompte.setBackground(Color.WHITE);
		btnModifCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textNom.getText().equals("")&&!textMDP.getText().equals("")&&!textPrenom.getText().equals("")&&!textAddresse.getText().equals("")&&!textTel.getText().equals("")&&!textMail.equals("")){
			Restaurateur restaurateur =new Restaurateur();
			restaurateur.setId(ApplicationFrame.restaurateur.getId());
			restaurateur.setNom(textNom.getText());
			restaurateur.setPrenom(textPrenom.getText());
			restaurateur.setAdresse(textAddresse.getText());
			restaurateur.setMail(textMail.getText());
			restaurateur.setTel(textTel.getText());
			restaurateur.setMdp(textMDP.getText());
			RestaurateurDAO restaurateurDAO=new RestaurateurDAO();
			int a=restaurateurDAO.updateRestaurateur(restaurateur);
			if(a<0){
				System.out.println("faux update");
				
			}
			else{
				System.out.println("vari updatee");
				ApplicationFrame.restaurateur=restaurateur;
			
			//JOptionPane.showMessageDialog(null, "Votre compte modifier" );
			
			ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
			ApplicationFrame.panelContenu= new PanelContenu(restaurateur,null);
			ApplicationFrame.content.add(ApplicationFrame.panelContenu);
			ApplicationFrame.content.revalidate();
			ApplicationFrame.content.repaint();
		
			}
				}
				else{
					OptionMessage.messageWarning("Controle de saisie", "Il faut remplir tous les champs");
				}
			}
		});
		btnModifCompte.setBounds(407, 342, 136, 37);
		panelConnection.add(btnModifCompte);
		
		textMDP = new JPasswordField();
		textMDP.setBounds(212, 191, 159, 20);
		panelConnection.add(textMDP);
		textMDP.setText(restaurateur2.getMdp());
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Ahmed Taha\\Desktop\\java\\AbstractTeamJava\\PI_DEV_Java_Project\\img\\annul.png"));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAddresse.setText("");
				textMail.setText("");
				textNom.setText("");
				textPrenom.setText("");
				textTel.setText("");
				textMDP.setText("");
			}
		});
		btnReset.setBounds(407, 390, 136, 37);
		panelConnection.add(btnReset);
		
		
	}
	public void paintComponent(final Graphics g) {

		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0,1000,900, null);
	}
}
