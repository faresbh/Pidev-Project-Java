package com.abstractTeam.IHM;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.abstractTeam.Controller.RestaurantDao;
import com.abstractTeam.IHM.GestionRestaurant.ContentRestaurantPanel;
import com.abstractTeam.Model.Restaurant;

@SuppressWarnings("serial")
public class PanelLeftTop extends JPanel {

	/**
	 * Create the panel.
	 */
	public static JComboBox comboBox;
	public static List<Integer> restaurantIds;
	public static DefaultComboBoxModel dt;
	public static JLabel lblMesRestaurants;
	public static JButton btnNewButton ;
	public static JLabel label_loginText;
	public static JLabel lblType ;
	public static int idRestaurateur;
	public PanelLeftTop(final int idRestaurateur) {
		this.idRestaurateur=idRestaurateur;
		setBackground(Color.WHITE);

		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)), "Accueil",
				TitledBorder.LEFT, TitledBorder.TOP, new Font(" Arial ",
						Font.BOLD, 15), new Color(64, 64, 64)));
		setBounds(0, 75, 337, 301);
		setLayout(null);
		JLabel lblVousPouvezAccder = new JLabel(
				"<html>Bienvenue à votre espace personnel dans Resto - Tunisie </html>");
		lblVousPouvezAccder.setHorizontalAlignment(SwingConstants.LEFT);
		lblVousPouvezAccder.setVerticalAlignment(SwingConstants.TOP);
		lblVousPouvezAccder.setBounds(10, 68, 283, 47);

		add(lblVousPouvezAccder);

		JLabel lblInformationsDu = new JLabel(
				"<html><u>Informations du compte : </u></html>");
		lblInformationsDu.setBounds(10, 93, 180, 14);
		add(lblInformationsDu);

		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(207, 93, 46, 32);
		add(lblNewLabel);

		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(10, 126, 46, 14);
		add(lblLogin);
		
		

		label_loginText= new JLabel("");
		label_loginText.setText("dddddddss");
		label_loginText.setBounds(86, 126, 108, 14);
		add(label_loginText);

		JLabel label_nomText = new JLabel("");
		label_nomText.setBounds(106, 230, 46, 14);
		add(label_nomText);

		JLabel label_EspaceText = new JLabel("");
		label_EspaceText.setBounds(107, 255, 46, 14);
		add(label_EspaceText);

		JLabel lblNom = new JLabel("Type compte :");
		lblNom.setBounds(10, 151, 102, 14);
		add(lblNom);

		lblType= new JLabel("");
		lblType.setText("dddddddd");
		lblType.setBounds(96, 151, 171, 14);
		add(lblType);
		
		JButton btnSeDconnecter = new JButton("se d\u00E9connecter");
		btnSeDconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Panel panel=new Panel();
				
			}
		});
		
		btnSeDconnecter.setBounds(176, 21, 151, 23);
		add(btnSeDconnecter);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(10, 230, 180, 20);
		dt=new DefaultComboBoxModel();
		comboBox.setModel(dt);
		RestaurantDao c=new RestaurantDao();
		List<Restaurant> restaurants=new ArrayList<Restaurant>();
		restaurants=c.getAllRestaurants(idRestaurateur);
		restaurantIds=new ArrayList<Integer>();
		for(Restaurant restaurant:restaurants){
			dt.addElement(restaurant.getNom());
			restaurantIds.add(restaurant.getId());
		}
		add(comboBox);
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	//panel menu
//		    	MenueRestaurantPanel.content.remove(MenueRestaurantPanel.panelMenue);
//		    	MenueRestaurantPanel.this.remove(MenueRestaurantPanel.panelMenue);
//				MenueRestaurantPanel.panelMenue= new PanelMenu();
//				MenueRestaurantPanel.this.add(MenueRestaurantPanel.panelMenue);
//				MenueRestaurantPanel.content.validate();
//				MenueRestaurantPanel.content.repaint();
				
				
		    	ApplicationFrame.content.remove(ApplicationFrame.panelLeftBottom);
				ApplicationFrame.panelLeftBottom= new PanelLeftBottom(comboBox.getSelectedItem().toString());
				ApplicationFrame.content.add(ApplicationFrame.panelLeftBottom);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
		    }
		});
		
		lblMesRestaurants= new JLabel("Mes Restaurants :");
		lblMesRestaurants.setBounds(10, 199, 142, 14);
		add(lblMesRestaurants);
		
		btnNewButton= new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon iconInfo=new ImageIcon("icon\\info.png");
				Image imgInfo = iconInfo.getImage() ;  
				Image newimgInfo = imgInfo.getScaledInstance( 50	, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
				
				iconInfo = new ImageIcon( newimgInfo );

				int result = JOptionPane.showOptionDialog(null, "Voulez Vous ajouter un Restaurant à votre compte",   "Confirmer l'ajout d'un restaurant", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, iconInfo,null,null);
				if(result==JOptionPane.OK_OPTION){
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new ContentRestaurantPanel(idRestaurateur);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
					
				}
			}
		});
		btnNewButton.setBounds(225, 229, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(225, 265, 89, 23);
		add(btnNewButton_1);
		setVisible(true);
	}
	
	public void showMeg(){
		final JComponent[] inputs = new JComponent[] {
				new JLabel("Voulez vous ajouter un restaurant a votre compte")
				
		};
		JOptionPane.showMessageDialog(null, "dd", "My custom dialog", JOptionPane.OK_CANCEL_OPTION);
	}
}
