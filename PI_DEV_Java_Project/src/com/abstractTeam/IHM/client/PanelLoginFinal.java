package com.abstractTeam.IHM.client;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.abstractTeam.Controller.ClientDAO;
import com.abstractTeam.Model.Client;

@SuppressWarnings("serial")
public class PanelLoginFinal extends JPanel {
	 private final JPanel contentPanel = new JPanel();
	  private JTextField txtUsername;
	  private JPasswordField txtPassword;
	  public static boolean login = false;
	  public static String username = "";
	  public static String password = "";
	  
	  public JPanel myframe;
	
	public static Client client=null;
	
	
	/**
	 * Create the panel.
	 */
	public PanelLoginFinal() {
		myframe=this;
		 {setBounds(337, 76, 1013, 611);
			 
				setVisible(true);
				 this.setLayout(new BorderLayout());
				    this.contentPanel.setBackground(new Color(255, 218, 185));
				    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				    this.add(this.contentPanel, "Center");
				    this.contentPanel.setLayout(null);
				   final JLabel lblincorrect = new JLabel("Votre mail ou mot de passe est incorrecte");
					 lblincorrect.setForeground(Color.RED);
					 lblincorrect.setBounds(140, 392, 292, 14);
					 contentPanel.add(lblincorrect);
					 lblincorrect.setVisible(false);
				    JButton okButton = new JButton("OK");
				    okButton.addActionListener(new ActionListener()
				    {
				      public void actionPerformed(ActionEvent arg0)
				      {
				    	  ClientDAO clientDAO=new ClientDAO();
				    	  Client client=clientDAO.findClientByMailMdp(txtUsername.getText(), txtPassword.getText());
				    	  if(client!=null){
				    		  PanelLoginFinal.client=client;
				    		  lblincorrect.setVisible(false);
				    		  System.out.println("client vrai");
				    		 ClientFrame.panelContenu = new PanelContenu();
				    		 ClientFrame.panelContenu.setBounds(368, 75, 956, 617);
				    			ClientFrame.content.add(ClientFrame.panelContenu);

				    			ClientFrame.content.validate();
				    			ClientFrame.content.repaint();
//				    		  ClientFrame clientFrame=new ClientFrame(client);
//				    		  clientFrame.setVisible(true);
				    		  myframe.setVisible(false);
				    	  }else{
				    		  lblincorrect.setVisible(true);
				    	  }
				         }
				      }
				    );
				    okButton.setForeground(new Color(255, 0, 0));
				    okButton.setIcon(new ImageIcon(PanelLoginFinal.class.getResource("/images/button_ok.png")));
				    okButton.setFont(new Font("Tahoma", 1, 14));
				    okButton.setBackground(new Color(218, 165, 32));
				    okButton.setBounds(88, 295, 132, 52);
				    this.contentPanel.add(okButton);
				    okButton.setActionCommand("OK");
				//    getRootPane().setDefaultButton(okButton);
				    
					 
					
				    JButton cancelButton = new JButton("Cancel");
				    cancelButton.setForeground(new Color(255, 0, 0));
				    cancelButton.setIcon(new ImageIcon(PanelLoginFinal.class.getResource("/images/button_cancel.png")));
				    cancelButton.setFont(new Font("Tahoma", 1, 14));
				    cancelButton.setBackground(new Color(238, 130, 238));
				    cancelButton.addActionListener(new ActionListener()
				    {
				      public void actionPerformed(ActionEvent arg0)
				      {
				     //   System.exit(0);
				      
				    		ClientFrame.content.remove(ClientFrame.panelContenu);
							ClientFrame.panelContenu= new PanelContenu();
							ClientFrame.content.add(ClientFrame.panelContenu);
							ClientFrame.content.validate();
							ClientFrame.content.repaint();
						
				      }
				    });
				    cancelButton.setBounds(266, 295, 132, 52);
				    this.contentPanel.add(cancelButton);
				    cancelButton.setActionCommand("Cancel");
				    
				    JLabel lblUsername = new JLabel("Username :");
				    lblUsername.setForeground(Color.BLUE);
				    lblUsername.setFont(new Font("Tahoma", 1, 14));
				    lblUsername.setBounds(37, 101, 101, 16);
				    this.contentPanel.add(lblUsername);
				    
				    JLabel lblPassword = new JLabel("Password :");
				    lblPassword.setForeground(Color.BLUE);
				    lblPassword.setFont(new Font("Tahoma", 1, 14));
				    lblPassword.setBounds(37, 154, 101, 16);
				    this.contentPanel.add(lblPassword);
				    
				    
				    this.txtUsername = new JTextField();
				    this.txtUsername.setFocusable(true);
				    this.txtUsername.setBounds(184, 92, 237, 38);
				    this.contentPanel.add(this.txtUsername);
				    this.txtUsername.setColumns(10);
				    this.txtUsername.setText("azza");
				    
				    this.txtPassword = new JPasswordField();
				    this.txtPassword.setBounds(184, 144, 237, 38);
				    this.txtPassword.setText("pass");
				    this.contentPanel.add(this.txtPassword);
}
		 
		 JLabel label = new JLabel("\r\n");
		 label.setIcon(new ImageIcon(PanelLoginFinal.class.getResource("/images/welcome.jpg")));
		 label.setForeground(Color.BLUE);
		 label.setFont(new Font("Tahoma", Font.BOLD, 14));
		 label.setBounds(621, 101, 249, 220);
		 contentPanel.add(label);

		 
}
}