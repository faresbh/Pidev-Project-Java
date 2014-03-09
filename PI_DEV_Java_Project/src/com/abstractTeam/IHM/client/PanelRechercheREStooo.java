package com.abstractTeam.IHM.client;



import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import com.abstractTeam.IHM.GestionRestaurant.FramePlat;
import com.abstractTeam.IHM.GestionRestaurant.PanelPlat;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Restaurant;
import com.lowagie.text.List;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelRechercheREStooo extends JPanel {
    public static DefaultListModel defaultListModel=new DefaultListModel();
    public static java.util.List<Restaurant> restaurants=null;
	private static final JLabel Prix_jTextField = null;
	/**
	 * Create the panel.
	 */
	public PanelRechercheREStooo() {
		setBounds(368, 75, 956, 617);
		setVisible(true);
	        Nom_jLabel = new javax.swing.JLabel();
	        Categorie_jLabel = new javax.swing.JLabel();
	        Nom_jTextField = new javax.swing.JTextField();
	        Ajouter_jButton = new javax.swing.JButton();
	        Ajouter_jButton.setIcon(new ImageIcon(PanelRechercheREStooo.class.getResource("/images/find.png")));
	        Reset_jButton = new javax.swing.JButton();
	        Categorie_jComboBox = new javax.swing.JComboBox();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
	        Image_jPanel = new javax.swing.JPanel();
	        BX = new javax.swing.JLabel();

	        setBackground(new java.awt.Color(191, 205, 219));

	        Nom_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        Nom_jLabel.setText("Nom Restaurant :");

	        Categorie_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        Categorie_jLabel.setText("Categorie Restaurant :");

	        Nom_jTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

	        Ajouter_jButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
//	        Ajouter_jButton.setIcon(new ImageIcon(ConsulterPlat_Form.class.getResource("/images/find.png"))); // NOI18N
	        Ajouter_jButton.setText("Rechercher Restaurant\r\n\r\n");
	        Ajouter_jButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                Ajouter_jButtonActionPerformed(evt);
	            }
	        });

	        Reset_jButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        Reset_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cut.png"))); // NOI18N
	        Reset_jButton.setText("Reset");
	        Reset_jButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                Reset_jButtonActionPerformed(evt);
	            }
	        });

	        Categorie_jComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        Categorie_jComboBox.setModel(new DefaultComboBoxModel(new String[] {"selectionner une", "Fast Food", "Restaurant", "Salon de th\u00E9"}));

	        jLabel1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
	        jLabel1.setText("Rechercher \r\nun Restaurant");

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
	        //JList list = new JList(vegOptions);
		    final JList list=new JList();
		    list.setModel(defaultListModel);
	        list.setBorder(new CompoundBorder());
	        list.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        list.setForeground(new Color(0, 0, 0));
	        list.setVisibleRowCount(100);
	        Image_jPanel.add(list);
	        Image_jPanel.add(BX);
	        list.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent arg0) {
					if (arg0.getValueIsAdjusting() == false)
				      {
						if(list.getSelectedIndex()!=-1){
							System.out.println(list.getSelectedIndex()+"aaaaaaaaaaaaaaaaaaaaaaaaaaa");
//							selectedPlat=listPlats.getSelectedIndex();
						
//						System.out.println(list.getSelectedIndex()+"count");
				      }}
				      else
				      {
				        System.out.println("I think the value is adjusting");
				      }
					
				}
			});
	        JButton btnPlusDinfos = new JButton();
	        btnPlusDinfos.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		Restaurant restaurant=restaurants.get(list.getSelectedIndex());
	        		new AboutRestaurant(restaurant);
	        	}
	        });
	        btnPlusDinfos.setIcon(new ImageIcon(PanelRechercheREStooo.class.getResource("/images/info.png")));
	        btnPlusDinfos.setText("plus d'infos");
	        btnPlusDinfos.setFont(new Font("Tahoma", Font.BOLD, 11));
	        
	        JButton btnPasserCommande = new JButton();
	        btnPasserCommande.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		JOptionPane.showMessageDialog(ClientFrame.content,"Demande de reservation envoyé au restaurateur","Commande",JOptionPane.INFORMATION_MESSAGE);
	        	
	        	}
	        });
	        btnPasserCommande.setIcon(new ImageIcon(PanelRechercheREStooo.class.getResource("/images/plat.png")));
	        btnPasserCommande.setText("Reserver");
	        btnPasserCommande.setFont(new Font("Tahoma", Font.BOLD, 11));
	        
	        lblVille = new JLabel();
	        lblVille.setText("Adresse");
	        lblVille.setFont(new Font("Tahoma", Font.BOLD, 14));
	        
	        textField = new JTextField();
	        textField.setFont(new Font("Tahoma", Font.BOLD, 14));

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(82)
	        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addComponent(Ajouter_jButton)
	        					.addGap(18)
	        					.addComponent(Reset_jButton, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
	        					.addGap(82))
	        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        					.addGroup(layout.createSequentialGroup()
	        						.addPreferredGap(ComponentPlacement.RELATED)
	        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        							.addComponent(Categorie_jLabel, GroupLayout.PREFERRED_SIZE, 220, Short.MAX_VALUE)
	        							.addComponent(Nom_jLabel, GroupLayout.PREFERRED_SIZE, 220, Short.MAX_VALUE)
	        							.addComponent(lblVille, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
	        						.addPreferredGap(ComponentPlacement.RELATED)
	        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        								.addComponent(Categorie_jComboBox, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
	        								.addComponent(Nom_jTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
	        							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
	        						.addGap(86))
	        					.addGroup(layout.createSequentialGroup()
	        						.addGap(92)
	        						.addComponent(jLabel1)
	        						.addGap(165))))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addComponent(btnPlusDinfos, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(btnPasserCommande, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
	        				.addComponent(Image_jPanel, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(34)
	        			.addComponent(jLabel1)
	        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(Categorie_jComboBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(Categorie_jLabel))
	        			.addGap(18)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(Nom_jLabel)
	        				.addComponent(Nom_jTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
	        			.addGap(30)
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lblVille, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
	        			.addGap(327)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(Reset_jButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(Ajouter_jButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
	        			.addGap(50))
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(19)
	        			.addComponent(Image_jPanel, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
	        			.addGap(18)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnPlusDinfos, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnPasserCommande, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(151, Short.MAX_VALUE))
	        );
	        this.setLayout(layout);

	      //  pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void Ajouter_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rechercher_jButtonActionPerformed

	        
	        try {
	        	restaurants=null;
	            String Categorie_String = (String)Categorie_jComboBox.getSelectedItem();
	            String Nom_String = Nom_jTextField.getText();
	            String adresse=textField.getText(); 
	            RestaurantDao restaurantDao=new RestaurantDao();
	            Restaurant restaurant=new Restaurant();
	            restaurant.setAdresse(adresse);
	            restaurant.setSpecialite(Categorie_String);
	            restaurant.setNom(Nom_String);
	           
	            restaurants= restaurantDao.rechercheRestaurant(restaurant);
	            if(restaurants!=null){
	            	
	            	defaultListModel.removeAllElements();
	            	for(Restaurant restaurant2:restaurants)
	            		defaultListModel.addElement(restaurant2.getNom());
	            }
	            else{
	            	OptionMessage.messageWarning("Resultat Recherche", "il n'y a pas des restaurants correspondant à votre recherche ");
	            }
//	            String
//	            double Prix_Double = Double.parseDouble(Prix_jTextField.getText());

//	            byte[] myByte = new byte[(int) file.length()];

	     

	        
	                Categorie_jComboBox.setSelectedIndex(0);
	                Nom_jTextField.setText("");
//	                Prix_jTextField.setText("");
	                textField.setText("");

	               	                BX.setIcon(null);

	                filePath="";
	                file = null;
	                nomImageX="";
	            
	        }catch(Exception ex){
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
	        }

	    }//GEN-LAST:event_Rechercher_jButtonActionPerformed
	    
	    

	    private void Reset_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reset_jButtonActionPerformed
	        Categorie_jComboBox.setSelectedIndex(0);
	                Nom_jTextField.setText("");
	                Prix_jTextField.setText("");
	      //          duree_jTextField.setText("");
	               
	                BX.setIcon(null);
	    }//GEN-LAST:event_Reset_jButtonActionPerformed
	    
		
	

public JFileChooser fileChooser;
public String filePath;
public File file;
public String nomImageX;


private OutputStream os;
private ObjectOutputStream oos;
private InputStream is;
private ObjectInputStream ois;
boolean ArchOS = System.getProperty("os.name").startsWith("Windows");

// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JButton Ajouter_jButton;
private javax.swing.JLabel BX;
private javax.swing.JComboBox Categorie_jComboBox;
private javax.swing.JLabel Categorie_jLabel;
private javax.swing.JPanel Image_jPanel;
private javax.swing.JLabel Nom_jLabel;
private javax.swing.JTextField Nom_jTextField;
private javax.swing.JButton Reset_jButton;
private javax.swing.JLabel jLabel1;
private JLabel lblVille;
private JTextField textField;
}
