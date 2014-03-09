package com.abstractTeam.IHM.client;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import Dialog.DialogConnectServer;

@SuppressWarnings("serial")
public class PanelInscription extends JPanel {
	 private final JPanel contentPanel = new JPanel();
	  private JTextField txtNom;
	  private JTextField txtPrenom;
	  private JButton okButton;
	  private JButton cancelButton;
	  private JLabel lblLogin;
	  private JTextField textField;
	  private JTextField textField_1;
	  private JTextField textField_2;
	  //private JTextField txtPass;
	  private JPasswordField txtPassword;
	  
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelInscription() {
		 {setBounds(337, 76, 1013, 611);
			 
	
			// setBounds(368, 75, 956, 617);
				setVisible(true);
			
			    this.setLayout(new BorderLayout());
			    this.contentPanel.setBackground(new Color(224, 255, 255));
			    this.add(this.contentPanel, "Center");
			    contentPanel.setLayout(null);
			    
			    this.okButton = new JButton("Connect");
			    okButton.setBounds(67, 382, 135, 52);
			    this.okButton.setBackground(new Color(173, 255, 47));
			    this.okButton.setIcon(new ImageIcon(PanelInscription.class.getResource("/images/upload_database.png")));
			    this.okButton.setForeground(new Color(255, 0, 0));
			    this.contentPanel.add(this.okButton);
			    this.okButton.addActionListener(new ActionListener()
			    {
			      public void actionPerformed(ActionEvent e)
			      {
			    	  
			    	  JOptionPane.showMessageDialog(null, "Successful connection");
			          
			     }
			    });
			    this.okButton.setActionCommand("OK");
		
			    

			    this.cancelButton = new JButton("Cancel");
			    cancelButton.setBounds(257, 382, 135, 52);
			    this.cancelButton.setBackground(new Color(233, 150, 122));
			    this.cancelButton.setIcon(new ImageIcon(PanelInscription.class.getResource("/images/delete.png")));
			    this.cancelButton.addActionListener(new ActionListener()
			    {
			      public void actionPerformed(ActionEvent e)
			      {
			//        System.exit(0);
			    		ClientFrame.content.remove(ClientFrame.panelContenu);
						ClientFrame.panelContenu= new PanelContenu();
						ClientFrame.content.add(ClientFrame.panelContenu);
						ClientFrame.content.validate();
						ClientFrame.content.repaint();
					
			      
			      }
			    });
			    this.cancelButton.setForeground(new Color(255, 0, 0));
			    this.contentPanel.add(this.cancelButton);
			    this.cancelButton.setActionCommand("Cancel");
			    

			    JLabel lblHost = new JLabel("Nom");
			    lblHost.setBounds(22, 45, 63, 16);
			    lblHost.setForeground(new Color(0, 0, 255));
			    this.contentPanel.add(lblHost);
			    
			    
			    JLabel lblDatabaes = new JLabel("Prenom");
			    lblDatabaes.setBounds(22, 94, 83, 16);
			    lblDatabaes.setForeground(new Color(0, 0, 255));
			    this.contentPanel.add(lblDatabaes);
			    

			    this.txtNom = new JTextField();
			    txtNom.setBounds(146, 34, 246, 40);
			    this.contentPanel.add(this.txtNom);
			    this.txtNom.setColumns(10);
			    

			    this.txtPrenom = new JTextField();
			    txtPrenom.setBounds(146, 83, 246, 40);
			  //  this.txtPort.setText("20000");
			    this.txtPrenom.setColumns(10);
			    this.contentPanel.add(this.txtPrenom);
			    
			    lblLogin = new JLabel("email");
			    lblLogin.setBounds(22, 144, 83, 16);
			    lblLogin.setForeground(Color.BLUE);
			    contentPanel.add(lblLogin);
			    
			    textField = new JTextField();
			    textField.setBounds(146, 134, 246, 40);
			    textField.setColumns(10);
			    contentPanel.add(textField);
			    
			    JLabel lblAddresse = new JLabel("addresse\r\n");
			    lblAddresse.setBounds(22, 203, 83, 16);
			    lblAddresse.setForeground(Color.BLUE);
			    contentPanel.add(lblAddresse);
			    
			    textField_1 = new JTextField();
			    textField_1.setBounds(146, 185, 246, 40);
			    textField_1.setColumns(10);
			    contentPanel.add(textField_1);
			    
			    JLabel lblTel = new JLabel("TEL");
			    lblTel.setBounds(22, 249, 83, 16);
			    lblTel.setForeground(Color.BLUE);
			    contentPanel.add(lblTel);
			    
			    textField_2 = new JTextField();
			    textField_2.setBounds(146, 236, 246, 40);
			    textField_2.setColumns(10);
			    contentPanel.add(textField_2);
			    
			    JLabel lblMotDePasse = new JLabel("mot de passe");
			    lblMotDePasse.setBounds(22, 311, 83, 16);
			    lblMotDePasse.setForeground(Color.BLUE);
			    contentPanel.add(lblMotDePasse);
			    
			    this.txtPassword = new JPasswordField();
			    txtPassword.setBounds(146, 300, 246, 38);
			    this.contentPanel.add(this.txtPassword);
	    
		
	}
		 
		 JLabel label = new JLabel("\r\n");
		 label.setIcon(new ImageIcon(PanelInscription.class.getResource("/images/welcome.jpg")));
		 label.setForeground(Color.BLUE);
		 label.setBounds(540, 144, 246, 221);
		 contentPanel.add(label);
}
}