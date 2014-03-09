package com.abstractTeam.IHM.GestionRestaurant;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.abstractTeam.Controller.MenueDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.IHM.PanelLeftTop;
import com.abstractTeam.Model.Menus;
import com.abstractTeam.Model.Plat;

public class MenueRestaurantPanel extends JPanel {

	private Image image;
	public static JPanel panelMenue = new JPanel();
	public static Container content;
	public static JPanel panelPlat;
	public static JList listPlats ;
	public static DefaultListModel defaultListModel;
	public static List<Menus> menus;
	public static List<Plat> plats;
	BufferedImage backgroundImage;
	public static int selectedPlat;
	public static JComboBox comboBoxMenue;
	public static JLabel lblPlat_1;
	public DefaultComboBoxModel dt;
	/**
	 * Create the panel.
	 */


	
	
	public MenueRestaurantPanel() {
		try {
			 backgroundImage = ImageIO.read(new File("img\\Menubackground.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			content=this;
		setLayout(null);
		setBounds(337, 76, 1013, 611);
		 ImageIcon iconOk=new ImageIcon("img\\Menubackground.jpg");
			Image imgOk = iconOk.getImage() ; 
			image = imgOk.getScaledInstance( 1013	, 611,  java.awt.Image.SCALE_SMOOTH ) ;  
			panelPlat = new JPanel();
			panelPlat.setBounds(589, 133, 327, 366);
			panelPlat.setOpaque(false);
			add(panelPlat);
			
		JLabel lblVousAvezPas = new JLabel("Vous avez pas encore des menues dans ce restaurant");
		lblVousAvezPas.setForeground(new Color(255, 0, 0));
		lblVousAvezPas.setBounds(131, 133, 336, 14);
		add(lblVousAvezPas);
		panelMenue.setBounds(131, 319, 267, 255);
		panelMenue.setOpaque(false);
		add(panelMenue);
		JButton btnClickerSurMoi = new JButton("clicker sur moi pour ajouter un menu");
		btnClickerSurMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenueRestaurantPanel.this.remove(MenueRestaurantPanel.panelMenue);
				MenueRestaurantPanel.panelMenue= new PanelMenu();
				MenueRestaurantPanel.this.add(MenueRestaurantPanel.panelMenue);
				MenueRestaurantPanel.this.validate();
				MenueRestaurantPanel.this.repaint();
			}
		});
		btnClickerSurMoi.setForeground(new Color(0, 128, 0));
		btnClickerSurMoi.setBounds(131, 296, 278, 23);
		add(btnClickerSurMoi);
		setVisible(true);
		btnClickerSurMoi.setOpaque(false);
		btnClickerSurMoi.setContentAreaFilled(false);
		btnClickerSurMoi.setBorderPainted(false);
		
		 comboBoxMenue = new JComboBox();
		comboBoxMenue.setBounds(190, 124, 208, 23);
		 dt=new DefaultComboBoxModel();
		comboBoxMenue.setModel(dt);
		add(comboBoxMenue);
		
		JLabel lblMenu = new JLabel("Menue");
		lblMenu.setBounds(119, 133, 46, 14);
		add(lblMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 185, 234, 116);
		add(scrollPane);
		
		final JList listPlats = new JList();
		scrollPane.setViewportView(listPlats);
		defaultListModel=new DefaultListModel();
		listPlats.setModel(defaultListModel);
		
		JLabel lblPlat = new JLabel("Plat :");
		lblPlat.setBounds(101, 187, 46, 14);
		add(lblPlat);
		
		JButton buttonajouterPlat = new JButton("+");
		buttonajouterPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FramePlat.ingredients=null;
				FramePlat framePlat=new FramePlat(-1);
				framePlat.setVisible(true);
				
			}
		});
		buttonajouterPlat.setBounds(101, 212, 53, 23);
		add(buttonajouterPlat);
		
		lblPlat_1 = new JLabel("Plat ");
		lblPlat_1.setBounds(709, 97, 46, 14);
		add(lblPlat_1);
		
		JButton btnSupprimerMenu = new JButton("Supprimer menu");
		btnSupprimerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		int result=		OptionMessage.messageInfo("supprission", "Voulez vous supprimer ce menu");
		if(JOptionPane.OK_OPTION==result){
				MenueDao menueDao=new MenueDao();
				int selectedMenu=comboBoxMenue.getSelectedIndex();
				menueDao.deleteMenuById(menus.get(comboBoxMenue.getSelectedIndex()).getId());
				menus.remove(selectedMenu);
				dt.removeElementAt(selectedMenu);
				OptionMessage.messageOk("Success", "Votre menu est supprimé avec success");
//				PanelLeftTop.
		}
			}
		});
		btnSupprimerMenu.setBounds(224, 158, 115, 23);
		add(btnSupprimerMenu);
		lblPlat_1.setVisible(false);
		MenueDao menueDao=new MenueDao();
		menus=menueDao.getAllMenusByRestaurant(PanelLeftTop.restaurantIds.get(PanelLeftTop.comboBox.getSelectedIndex()));
		if(menus!=null){
			System.out.println("!nulll");
		for(Menus menuss :menus)
		{
			
			dt.addElement(menuss.getLabel());
			
		}
		lblVousAvezPas.setVisible(false);
		lblMenu.setVisible(true);
		listPlats.setVisible(true);
		lblPlat.setVisible(true);
		buttonajouterPlat.setVisible(true);
//		co
		comboBoxMenue.setVisible(true);
		plats=menus.get(comboBoxMenue.getSelectedIndex()).getPlats();
		defaultListModel.removeAllElements();
		for(Plat plat:plats){
			
			defaultListModel.addElement(plat.getLabel());
		}
		}
		else{
			System.out.println("null");
			lblVousAvezPas.setVisible(true);
			comboBoxMenue.setVisible(false);
			listPlats.setVisible(false);
			lblMenu.setVisible(false);
			lblPlat.setVisible(false);
			buttonajouterPlat.setVisible(false);
		}
//		ListSelectionModel listSelectionModel=listPlats.getSelectionModel();
//		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
//			
//			public void valueChanged(ListSelectionEvent e) {
//				if (e.getValueIsAdjusting() == false)
//			      {
//					FramePlat frame = new FramePlat(e.getFirstIndex());
//					frame.setVisible(true);
////					System.out.println(list.getSelectedIndex()+"count");
//			      }
//			      else
//			      {
//			        System.out.println("I think the value is adjusting");
//			      }
//				
//			}
//		});
		listPlats.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent arg0) {
				if (arg0.getValueIsAdjusting() == false)
			      {
					if(listPlats.getSelectedIndex()!=-1){
						System.out.println(listPlats.getSelectedIndex()+"aaaaaaaaaaaaaaaaaaaaaaaaaaa");
						selectedPlat=listPlats.getSelectedIndex();
					PanelPlat.modif=true;
					FramePlat frame = new FramePlat(listPlats.getSelectedIndex());
					frame.setVisible(true);
					FramePlat.choice=false;
//					System.out.println(list.getSelectedIndex()+"count");
			      }}
			      else
			      {
			        System.out.println("I think the value is adjusting");
			      }
				
			}
		});
		
		comboBoxMenue.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				listPlats.clearSelection();
				plats=menus.get(comboBoxMenue.getSelectedIndex()).getPlats();
				defaultListModel.removeAllElements();
				for(Plat plat:plats){
					
					defaultListModel.addElement(plat.getLabel());
				}
				
			}
		});
		
//		comboBoxMenue.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		
		
//		ImageIcon icon = new ImageIcon("img\\Menubackground.jpg"); 
//		JLabel thumb = new JLabel();

		
	}
	@Override
	public void paintComponent(final Graphics g) {
		
		
		
	    super.paintComponent(g);

	    // Draw the background image.
//	    backgroundImage.
	    g.drawImage(backgroundImage, 0, 0, this);
	    
//	    g.drawi
//	    if (image != null)
//	        g.drawImage(image, 0, 0, null);
	}
}
