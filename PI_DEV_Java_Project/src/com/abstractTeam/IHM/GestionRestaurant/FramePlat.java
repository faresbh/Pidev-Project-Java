package com.abstractTeam.IHM.GestionRestaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import com.abstractTeam.Controller.IngredientDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Plat;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePlat extends JFrame {

	private PanelPlat contentPane;
public static	List<Ingredient> ingredients =new ArrayList<Ingredient>();
public static boolean choice = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePlat frame = new FramePlat(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePlat(final int i) {
		final JFrame myFrame=this;
		  addWindowListener( new WindowAdapter() {
			  
              @Override
              public void windowClosing(WindowEvent we) {
            	 choice=true;
//                 MenueRestaurantPanel.listPlats.clearSelection();
              }
          } );
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 544);
		contentPane = new PanelPlat();
		contentPane.jlistImages.setLocation(100, 364);
		contentPane.btnAjouterPlat.setBounds(98, 377, 114, 23);
		contentPane.list.setBounds(99, 262, 130, 84);
		contentPane.textFieldPrix.setBounds(98, 45, 132, 20);
		contentPane.textArea.setBounds(99, 85, 130, 155);
		contentPane.textFieldNom.setBounds(98, 8, 132, 20);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Plat plat=new Plat();
		System.out.println(i+"  iiiiiiiiiiii");
		
		contentPane.setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(OptionMessage.messageInfo("Modification Plat", "Voulez vous modifier ce plat")==JOptionPane.OK_OPTION){
				Plat platnouveau=new Plat();
				Plat platAncien=new Plat();
				platAncien=MenueRestaurantPanel.plats.get(i);
				platnouveau.setId(platAncien.getId());
				System.out.println("ttttttttttttttt"+contentPane.textFieldPrix.getText());
				platnouveau.setLabel(contentPane.textFieldNom.getText());
				platnouveau.setDescription(contentPane.textArea.getText());
				platnouveau.setPrix(Double.parseDouble(contentPane.textFieldPrix.getText()));
				platnouveau.setIngredients(ingredients);
				platnouveau.setPhotos(platAncien.getPhotos());
				MenueRestaurantPanel.plats.add(i, platnouveau);
				MenueRestaurantPanel.plats.remove(i+1);
				if(!platnouveau.getLabel().equals(platAncien.getLabel())){
				MenueRestaurantPanel.defaultListModel.removeAllElements();
				for(Plat p:MenueRestaurantPanel.plats)
					MenueRestaurantPanel.defaultListModel.addElement(p.getLabel());}
				if(!choice){
				PlatDao platDao=new PlatDao();
				platDao.updatePlat(platnouveau);
				}
				OptionMessage.messageOk("Succes", "Votre modification se fait avec succes");
				myFrame.dispose();
				}
			}
		});
		btnModifier.setBounds(147, 471, 89, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(OptionMessage.messageInfo("Attention", "Voulez vous supprimer ce plat")==JOptionPane.OK_OPTION){
					if(!choice){
					PlatDao platDao =new PlatDao();
					platDao.deletePlatById(MenueRestaurantPanel.plats.get(i).getId());
					}
					//rarachir Jlist
					MenueRestaurantPanel.plats.remove(i);
					MenueRestaurantPanel.defaultListModel.removeAllElements();
					for(Plat p:MenueRestaurantPanel.plats)
						MenueRestaurantPanel.defaultListModel.addElement(p.getLabel());
					OptionMessage.messageOk("Succes", "Votre suppression se fait avec succes");
					myFrame.dispose();
					
				}
			}
		});
		btnSupprimer.setBounds(246, 471, 106, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!contentPane.textArea.getText().equals("")&&!contentPane.textFieldNom.getText().equals("")&&!contentPane.textFieldPrix.getText().equals("")){
//				if(pan)
				int result=OptionMessage.messageInfo("Ajout Plat", "Voulez vous ajouter ce plat");
				if(result==JOptionPane.OK_OPTION){
				Plat plat=new Plat();
				plat.setLabel(contentPane.textFieldNom.getText());
				plat.setDescription(contentPane.textArea.getText());
				plat.setPrix(Double.parseDouble(contentPane.textFieldPrix.getText()));
				plat.setIngredients(FramePlat.ingredients);
				PlatDao platDao=new PlatDao();
				platDao.insertPlat(plat, MenueRestaurantPanel.menus.get(MenueRestaurantPanel.comboBoxMenue.getSelectedIndex()).getId());
//				plat.setPhotos(PanelPlat.)
				OptionMessage.messageOk("succes", "Votre ajout se fait avec succes");
				MenueRestaurantPanel.defaultListModel.addElement(plat);
				MenueRestaurantPanel.plats.add(plat);
				
				}
				}else{
					OptionMessage.messageWarning("Erreur", "Il faut saisir tous les champs");
				}
			}
		});
		btnOk.setBounds(56, 471, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnAjouterIngredient = new JButton("Ajouter ingredient");
		btnAjouterIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.awt.EventQueue.invokeLater(new Runnable() {

					public void run() {
						new FrameAddIngredientNewPlat().setVisible(true);
					}
				});
			}
		});
		btnAjouterIngredient.setBounds(233, 325, 140, 23);
		contentPane.add(btnAjouterIngredient);
		
		JButton btnAjouterImage = new JButton("Ajouter image");
		btnAjouterImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AjouterImageAncienPlat ajouterImageAncienPlat = new AjouterImageAncienPlat(i);
				ajouterImageAncienPlat.setVisible(true);
			}
		});
		btnAjouterImage.setBounds(271, 359, 127, 23);
		contentPane.add(btnAjouterImage);
		
		JButton btnVoirImage = new JButton("Voir Image");
		btnVoirImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ImageIcon> imageIcons = new ArrayList<ImageIcon>();
				for (Photo photo : MenueRestaurantPanel.plats.get(i).getPhotos()) {
					imageIcons.add(new ImageIcon(photo.getUrl()));
					ImageGallery imageGallery = new ImageGallery(imageIcons);
					imageGallery.setVisible(true);
				}
			}
		});
		btnVoirImage.setBounds(284, 389, 89, 23);
		contentPane.add(btnVoirImage);
				if(i!=-1){
					contentPane.btnAjouter.setVisible(false);
					contentPane.btnVoirImages.setVisible(false);
					contentPane.buttonAjouterImage.setVisible(false);
					IngredientDao ingredientDao=new IngredientDao();
					plat=MenueRestaurantPanel.plats.get(i);

					if(ingredientDao.getAllIngredientsByIdPlat(plat.getId())!=null){
						
						ingredients=ingredientDao.getAllIngredientsByIdPlat(plat.getId());
					for(Ingredient ingredient:ingredients)
					contentPane.model.addElement(ingredient.getLabel());
					for(Photo photo:MenueRestaurantPanel.plats.get(i).getPhotos())
						contentPane.listImageModel.addElement(photo.getUrl());
				}

			contentPane.textFieldNom.setText(plat.getLabel());
			contentPane.textFieldPrix.setText(plat.getPrix()+"");
			contentPane.textArea.setText(plat.getDescription());
			System.out.println(plat.getDescription()+"Decription");
			contentPane.btnAjouterPlat.setVisible(false);
			btnModifier.setVisible(true);
			btnSupprimer.setVisible(true);
			btnOk.setVisible(false);
			contentPane.btnAjouter.setVisible(true);
			btnAjouterIngredient.setVisible(false);
			}else{
				contentPane.btnAjouter.setVisible(false);
				contentPane.btnAjouterPlat.setVisible(false);
			btnModifier.setVisible(false);
			btnSupprimer.setVisible(false);
			btnOk.setVisible(true);
			btnAjouterIngredient.setVisible(true);
			}
	}
}
