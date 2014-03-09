package com.abstractTeam.IHM.GestionRestaurant;

import java.awt.BorderLayout;

import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.title.TextTitle;

import com.abstractTeam.Controller.PhotoDao;
import com.abstractTeam.Controller.RestaurantDao;
import com.abstractTeam.IHM.ApplicationFrame;
import com.abstractTeam.IHM.PanelLeftTop;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Positiongeo;
import com.abstractTeam.Model.Restaurant;
import com.abstractTeam.Model.Restaurateur;



public class ContentRestaurantPanel extends JPanel {
	private JTextField textFieldNomRestaurant;
	private JTextField textFieldMail;
	private JTextField textFieldMpw;
	private JTextField textFieldMpw2;
	public static Positiongeo positiongeo;
	public static Photo photo;
	public static JComboBox comboBoxImages ;
	public static JButton btnNewButtonEffacer;
	public static JButton btnNewButtonModifier;
	public JPanel thisJPanel=this;
	public static BufferedImage backgroundImage;
	public static int idRestaurant;
	/**
	 * Create the panel.
	 */
	public ContentRestaurantPanel(final int idRestaurant) {
		System.out.println(idRestaurant+"3adi");
		this.idRestaurant=idRestaurant;
		System.out.println(this.idRestaurant+"qsdqsdqsd");
		final JPanel panel = new JPanel();
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		comboBoxImages = new JComboBox();
		comboBoxImages.setEnabled(false);
		comboBoxImages.setBounds(69, 467, 302, 20);
		add(comboBoxImages);
		final DefaultComboBoxModel dt=new DefaultComboBoxModel();
		comboBoxImages.setModel(dt);
		JLabel label = new JLabel("Nom Restaurant :");
		label.setBounds(10, 14, 135, 14);
		add(label);
		
		textFieldNomRestaurant = new JTextField();
		textFieldNomRestaurant.setColumns(10);
		textFieldNomRestaurant.setBounds(155, 11, 216, 20);
		add(textFieldNomRestaurant);
		
		JLabel label_1 = new JLabel("Mail :");
		label_1.setBounds(10, 61, 46, 14);
		add(label_1);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(155, 58, 216, 20);
		add(textFieldMail);
		
		JLabel label_2 = new JLabel("Mot de passe :");
		label_2.setBounds(10, 109, 124, 14);
		add(label_2);
		
		textFieldMpw = new JTextField();
		textFieldMpw.setColumns(10);
		textFieldMpw.setBounds(155, 106, 216, 20);
		add(textFieldMpw);
		
		JLabel label_3 = new JLabel("Confirmer mot de passe :");
		label_3.setBounds(10, 155, 146, 14);
		add(label_3);
		
		textFieldMpw2 = new JTextField();
		textFieldMpw2.setColumns(10);
		textFieldMpw2.setBounds(155, 152, 216, 20);
		add(textFieldMpw2);
		
		JLabel label_4 = new JLabel("Nombre Table :");
		label_4.setBounds(10, 205, 134, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Adresse :");
		label_5.setBounds(10, 298, 124, 14);
		add(label_5);
		
		final JTextArea textAreaAdresse1 = new JTextArea();
		textAreaAdresse1.setBounds(155, 293, 216, 116);
		add(textAreaAdresse1);
	
		
		JLabel lblAdresseGeolocalisation = new JLabel("Adresse Geolocalisation :");
		lblAdresseGeolocalisation.setBounds(6, 429, 150, 14);
		add(lblAdresseGeolocalisation);
		
		JButton btnParcourirMap = new JButton(" Parcourir Map");
		btnParcourirMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  
			                new Map().setVisible(true);
			            
			}
		});
		btnParcourirMap.setBounds(155, 420, 144, 23);
		add(btnParcourirMap);
		
		JLabel lblSpcialit = new JLabel("Sp\u00E9cialit\u00E9 :");
		lblSpcialit.setBounds(10, 254, 134, 14);
		add(lblSpcialit);
		
		final JComboBox comboBoxSpecialite = new JComboBox();
		comboBoxSpecialite.setBounds(155, 251, 216, 20);
		comboBoxSpecialite.addItem("Fast Food");
		comboBoxSpecialite.addItem("Resaturant");
		comboBoxSpecialite.addItem("Salon de thé");
		add(comboBoxSpecialite);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(155, 202, 216, 20);
		add(spinner);
		JButton button_1 = new JButton("Ok");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon iconOk=new ImageIcon("icon\\ok.png");
				Image imgOk = iconOk.getImage() ;  
				Image newimgOk = imgOk.getScaledInstance( 50	, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
				iconOk = new ImageIcon( newimgOk );
				ImageIcon iconNo=new ImageIcon("icon\\no.png");
				Image imgNo = iconNo.getImage() ;  
				Image newimgNo = imgNo.getScaledInstance( 50	, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
				iconNo = new ImageIcon( newimgNo );
				ImageIcon iconInfo=new ImageIcon("icon\\info.png");
				Image imgInfo = iconInfo.getImage() ;  
				Image newimgInfo = imgInfo.getScaledInstance( 50	, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
				iconInfo = new ImageIcon( newimgInfo );
				int result = JOptionPane.showOptionDialog(null, "Voulez Vous ajouter ce Restaurant",   "Confirmer l'ajout d'un restaurant", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, iconInfo,null,null);
				if(result==JOptionPane.OK_OPTION){
				
				
				Restaurateur restaurateur=new Restaurateur();
				restaurateur.setId(idRestaurant);
				Restaurant restaurant=new Restaurant();
				restaurant.setNom(textFieldNomRestaurant.getText());
				restaurant.setAdresse(textAreaAdresse1.getText());
				restaurant.setSpecialite(comboBoxSpecialite.getSelectedItem().toString());
				restaurant.setNbrTable((Integer)(spinner.getValue()));
				restaurant.setRestaurateur(restaurateur);
				restaurant.setPositiongeo(positiongeo);
				RestaurantDao restaurantC=new RestaurantDao();
				int id=restaurantC.insertRestaurant(restaurant);
				System.out.println(id);
				PhotoDao photoDao=new PhotoDao();
//				PanelLeftTop.dt.removeAllElements();
				PanelLeftTop.restaurantIds.add(restaurant.getId());
				PanelLeftTop.dt.addElement(restaurant.getNom());
//				for(Restaurant restaurant2 : restaurantC.getAllRestaurants(idRestaurant)){
//					PanelLeftTop.dt.addElement(restaurant2.getNom());
////					PanelLeftTop.restaurantIds.
//				}
				for(Photo photo:ImageUpload1.photos)
				if(photoDao.insertPhotoResto(photo, id)>0){
					
					JOptionPane.showMessageDialog(null, "Votre ajout se fait avec succes", "Succes", JOptionPane.OK_OPTION, iconOk);
//					 JOptionPane.showDialog( null, "Votre ajout se fait avec succes",
//					        "Success", JOptionPane.OK_OPTION);
					textFieldNomRestaurant.setText("");
					textFieldMail.setText("");
					textFieldMpw.setText("");
					textFieldMpw2.setText("");
					textAreaAdresse1.setText("");
					ImageUpload1.photos=new ArrayList<Photo>();
					positiongeo=new Positiongeo();
					comboBoxImages.removeAll();
					ImageUpload1.sommeImages=0;
					spinner.setValue(0);
					btnNewButtonEffacer.setEnabled(false);
					btnNewButtonModifier.setEnabled(false);
					comboBoxImages.setEnabled(false);
					dt.removeAllElements();
//					
					
					 // TODO : redirection vers menu
				
				}else{
				JOptionPane.showConfirmDialog( null, "Voulez Vous supprimer cette image",
					        "Echec", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		button_1.setBounds(20, 563, 89, 23);
		add(button_1);
		setBounds(337, 76, 1013, 611);
		
		
		JButton btnNewButtonAjouter = new JButton("+");
		btnNewButtonAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				java.awt.EventQueue.invokeLater(new Runnable() {
					 
		            public void run() {
		                new ImageUpload1().setVisible(true);
		            }
		        });
			}
		});
		btnNewButtonAjouter.setBounds(378, 466, 41, 23);
		add(btnNewButtonAjouter);
		
 btnNewButtonEffacer = new JButton("-");
 btnNewButtonEffacer.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		panel.setVisible(false);
 		int result = JOptionPane.showConfirmDialog( null, "Voulez Vous supprimer cette image",
		        "Confirmer la suppression d'image", JOptionPane.OK_CANCEL_OPTION);
		if(result==JOptionPane.OK_OPTION){
			dt.removeElement(comboBoxImages.getSelectedItem());
			ImageUpload1.sommeImages--;
			
			if(ImageUpload1.sommeImages==0){
				btnNewButtonEffacer.setEnabled(false);
				btnNewButtonModifier.setEnabled(false);
				comboBoxImages.setEnabled(false);
				
				
			}
			
		}
 		
 	}
 });
		btnNewButtonEffacer.setEnabled(false);
		btnNewButtonEffacer.setBounds(425, 466, 46, 23);
		add(btnNewButtonEffacer);
		panel.setBounds(466, 14, 441, 395);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		JButton btnClickerIciPour = new JButton("Clicker ici pour voir l'image");
		btnClickerIciPour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			
				System.out.println(comboBoxImages.getSelectedItem().toString());
				ImageIcon icon = new ImageIcon(comboBoxImages.getSelectedItem().toString());
				   AlphaPanel alphaPanel=new AlphaPanel(icon, 1);
				   display(alphaPanel);
			}
		});
		btnClickerIciPour.setBounds(134, 26, 269, 23);
		panel.add(btnClickerIciPour);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 72, 269, 245);
		panel.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setBounds(10, 30, 95, 14);
		panel.add(lblImage);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 77, 95, 14);
		panel.add(lblDescription);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog( null, "Voulez Vous modifier le contenue",
				        "Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(result==JOptionPane.OK_OPTION){
				panel.setVisible(false);
				
			
				ImageUpload1.photos.get(comboBoxImages.getSelectedIndex()).setDescription(textArea.getText());
				
				}
			}
			
		});
		btnOk.setBounds(134, 344, 89, 23);
		panel.add(btnOk);
		btnNewButtonModifier = new JButton("modifier");
		btnNewButtonModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel.setVisible(true);
				List<Photo> photos=new ArrayList<Photo>();
				photos=ImageUpload1.photos;
				textArea.setText(photos.get(comboBoxImages.getSelectedIndex()).getDescription());
				
			}
		});
		btnNewButtonModifier.setEnabled(false);
		btnNewButtonModifier.setBounds(480, 466, 89, 23);
		add(btnNewButtonModifier);
		
		JLabel lblImages = new JLabel("Images :");
		lblImages.setBounds(6, 470, 63, 14);
		add(lblImages);
		
		
		
		
		
	
		
//		URL url=null;
//		try {
//			url = new URL("d:\\vvv.png");
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		}
//		ImageIcon icon=new ImageIcon(url);
		   
	}
	
	public static void display(final AlphaPanel ip) {
        JFrame f = new JFrame("AlphaTest");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon icon = new ImageIcon("D://vvv.png");
//        final JSlider slider = new JSlider();
//        slider.addChangeListener(new ChangeListener() {
//
//            public void stateChanged(ChangeEvent e) {
//                int v = slider.getValue();
//                ip.setAlpha((float) v / slider.getMaximum());
//                ip.repaint();
//            }
//        });
        f.getContentPane().add(ip, BorderLayout.CENTER);
//        f.add(slider, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        try {
			 backgroundImage = ImageIO.read(new File("img\\retaurant.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
	public void paintComponent(final Graphics g) {

		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
}
