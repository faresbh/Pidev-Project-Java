package com.abstractTeam.IHM.Inscription;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.abstractTeam.Controller.RestaurateurDAO;
import com.abstractTeam.IHM.ConnectionFrame;
import com.abstractTeam.Model.Restaurateur;


public class PanelMail extends JPanel {
	private JTextField textFieldMail;
	String mdp="";
	String mail="";
	
	public PanelMail() {
		setLayout(null);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(353, 189, 273, 20);
		add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JLabel lblEntrerVotreMail = new JLabel("Entrer votre Mail :");
		lblEntrerVotreMail.setBounds(122, 195, 169, 14);
		add(lblEntrerVotreMail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe oublier :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblMotDePasse.setBounds(340, 50, 188, 14);
		add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(353, 248, 106, 23);
		add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectionFrame connectionFrame=new ConnectionFrame();
				connectionFrame.frmRestoTunisie.setVisible(true);
				
				
			}
		});
		btnRetour.setBounds(503, 248, 89, 23);
		add(btnRetour);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			mail=textFieldMail.getText();
				Restaurateur rest=new Restaurateur();
				RestaurateurDAO restaurateurDAO=new RestaurateurDAO();
			rest=	restaurateurDAO.findRestaurateurByMail(mail);
				if (!(textFieldMail.getText().equals(rest.getMail()))) {
					
					
					JOptionPane.showMessageDialog(null, "vous n'êtes pas inscrit");
				}
				else {
					
				
				
				
				
				
				//generateur mdp
				String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_-@#&'(!?)$%?:;/.?,";
		        Random rand = new Random();
		        for (int i=0; i<6; i++)
		        {
		        	mdp+=alphabet.charAt(rand.nextInt(alphabet.length()));
//		                System.out.print(alphabet.charAt(rand.nextInt(alphabet.length())));
		        }
		        System.out.print(mdp);
		        
				String Mail =textFieldMail.getText();
				final String username = "espritabstractteam@gmail.com";
				final String password = "abstractteam";
		 
				
				RestaurateurDAO restaurateurdao = new RestaurateurDAO();
				restaurateurdao.updateMotDePasseRestaurateur(mdp,textFieldMail.getText());
		 
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
		 
				Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		 
				try {
		 
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("espritabstractteam@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(Mail));
					message.setSubject("Nouveau mot de passe");
					message.setText("voila votre nouveau mot de passe:   "+mdp);
					
					Transport.send(message);
		 
					System.out.println("Done");
					JOptionPane.showMessageDialog(null, "Message Envoyé!!");
		 
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}// TODO Auto-generated method stub

			}
			
		}
			}
	);
		
	}

	public void main(Object object) {
		
		JFrame f = new JFrame();
		PanelMail p = new PanelMail();
		f.getContentPane().add(p);
		f.setBounds(337, 76, 1013, 611);
		f.setLocationRelativeTo(null);
		//f.pack();
		f.setVisible(true);
		
	}


}
