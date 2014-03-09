package com.abstractTeam.IHM.client;



import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Controller.RestaurantDao;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Restaurant;

import com.mysql.jdbc.Blob;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelRecherchePlat extends JPanel {
	   public static DefaultListModel defaultListModel=new DefaultListModel();
	   public static java.util.List<Plat> plats=null;
	public PanelRecherchePlat() {
		setBounds(368, 75, 956, 617);
		setVisible(true);
	        Nom_jLabel = new javax.swing.JLabel();
	        NomPlat = new javax.swing.JTextField();
	        Ajouter_jButton = new javax.swing.JButton();
	        Reset_jButton = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
	        Image_jPanel = new javax.swing.JPanel();
	        RestaurantDao restaurantDao=new RestaurantDao();
	        restaurants=restaurantDao.getAllRestaurants2();
//	        comboBoxRestaurants.addItem("All");
	        setBackground(new java.awt.Color(191, 205, 219));

	        Nom_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); 
	        Nom_jLabel.setText("Nom Plat :");

	        NomPlat.setFont(new java.awt.Font("Tahoma", 1, 14));

	        Ajouter_jButton.setFont(new java.awt.Font("Tahoma", 1, 14)); 
	        Ajouter_jButton.setIcon(new ImageIcon(PanelRecherchePlat.class.getResource("/images/find.png")));  
	        Ajouter_jButton.setText("Rechercher plat\r\n");
	        Ajouter_jButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                Ajouter_jButtonActionPerformed(evt);
	            }
	        });

	        Reset_jButton.setFont(new java.awt.Font("Tahoma", 1, 14)); 
	        Reset_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cut.png"))); 
	        Reset_jButton.setText("Reset");
	        Reset_jButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                Reset_jButtonActionPerformed(evt);
	            }
	        });

	        jLabel1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24)); 
	        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
	        jLabel1.setText("Rechercher \r\nun Plat");

	        Image_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(" Resultat de recherche.."));
		      String[] vegOptions=new String[100];
		      PlatDao plats=new PlatDao();
		      
		   java.util.List<Plat> lstP = plats.DisplayAllStocks();
		    
		    int j=0;
		    for (Plat plat : lstP)
				{
			
			{
			
				System.out.println(plat.getLabel());
			
			vegOptions[j]=plat.getLabel();
			j++;
				
			}	}
	       final JList list = new JList();
	       list.setModel(defaultListModel);
	        list.setBorder(new CompoundBorder());
	        list.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        list.setForeground(new Color(0, 0, 0));
	        list.setVisibleRowCount(100);
	        Image_jPanel.add(list);
	        
	        JButton btnPlusDinfos = new JButton();
	        btnPlusDinfos.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        	
	        		Plat plat=PanelRecherchePlat.plats.get(list.getSelectedIndex());
	        		new AboutPlat(plat);
	        	}
	        });
	        btnPlusDinfos.setIcon(new ImageIcon(PanelRecherchePlat.class.getResource("/images/info.png")));
	        btnPlusDinfos.setText("plus d'infos");
	        btnPlusDinfos.setFont(new Font("Tahoma", Font.BOLD, 12));
	        
	        JButton btnPasserCommande = new JButton();
	        btnPasserCommande.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		JOptionPane.showMessageDialog(ClientFrame.content,"Commande envoyé au restaurateur","Commande",JOptionPane.INFORMATION_MESSAGE);
	        	
	        	}
	        });
	        btnPasserCommande.setIcon(new ImageIcon(PanelRecherchePlat.class.getResource("/images/plat.png")));
	        btnPasserCommande.setText("passer commande");
	        btnPasserCommande.setFont(new Font("Tahoma", Font.BOLD, 12));

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addContainerGap()
	        					.addComponent(Ajouter_jButton)
	        					.addGap(18)
	        					.addComponent(Reset_jButton, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
	        					.addGap(114))
	        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        					.addGroup(layout.createSequentialGroup()
	        						.addContainerGap()
	        						.addComponent(Nom_jLabel, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
	        						.addPreferredGap(ComponentPlacement.UNRELATED)
	        						.addComponent(NomPlat, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
	        						.addGap(166))
	        					.addGroup(layout.createSequentialGroup()
	        						.addGap(92)
	        						.addComponent(jLabel1)
	        						.addGap(249))))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
	        				.addGroup(layout.createSequentialGroup()
	        					.addComponent(btnPlusDinfos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(btnPasserCommande, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
	        				.addComponent(Image_jPanel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
	        			.addGap(19))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(34)
	        			.addComponent(jLabel1)
	        			.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(Nom_jLabel)
	        				.addComponent(NomPlat, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
	        			.addGap(332)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(Ajouter_jButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(Reset_jButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
	        			.addGap(50))
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(Image_jPanel, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnPlusDinfos, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnPasserCommande, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(118, Short.MAX_VALUE))
	        );
	        this.setLayout(layout);

	}

	    private void Ajouter_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ajouter_jButtonActionPerformed

	        
	        try {

	            String Nom_String = NomPlat.getText();
	            Restaurant restaurant=null;
	     plats=null;
	            PlatDao platDao=new PlatDao();
//	            if(comboBoxRestaurants.getSelectedIndex()!=0){
//	            restaurant=restaurants.get(comboBoxRestaurants.getSelectedIndex()-1);
	           
//	            plats=platDao.reschrchePlatByresto(Nom_String);
//	            }else{
	            	plats=platDao.reschrcheAllPlat(Nom_String);
//	            }
	            if(plats!=null){
	            	
	            	defaultListModel.removeAllElements();
	            	for(Plat plat:plats)
	            		defaultListModel.addElement(plat.getLabel());
	            }
	            else{
	            	OptionMessage.messageWarning("Resultat Recherche", "il n'y a pas des plats correspondant à votre recherche ");
	            }

	            Blob blob= null;
	      
	                NomPlat.setText("");

	              // 	                BX.setIcon(null);

	            
	        }catch(Exception ex){
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
	        }

	    }

	    private void Reset_jButtonActionPerformed(java.awt.event.ActionEvent evt) {
	                NomPlat.setText("");
	              }
	   
	               
	       
		
	


//public String nomImageX;





private javax.swing.JButton Ajouter_jButton;
private javax.swing.JPanel Image_jPanel;
private javax.swing.JLabel Nom_jLabel;
private javax.swing.JTextField NomPlat;
private javax.swing.JButton Reset_jButton;
private javax.swing.JLabel jLabel1;
public List<Restaurant> restaurants;
}

