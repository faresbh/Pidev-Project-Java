package com.abstractTeam.IHM.GestionRestaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import com.abstractTeam.Model.Photo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePhotoPlat extends JFrame {

	private JPanel contentPane;
	public JFrame myJFrame;
	 
	public FramePhotoPlat(final int indicePhotoPlat) {
		myJFrame=this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(20, 11, 100, 14);
		contentPane.add(lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 11, 220, 147);
		contentPane.add(scrollPane);
		final Photo photoCuurent=MenueRestaurantPanel.plats.get(MenueRestaurantPanel.selectedPlat).getPhotos().get(indicePhotoPlat);
		final JTextArea textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		JButton btnModifierDescription = new JButton("Modifier Description");
		JButton btnSupprimerImage = new JButton("Supprimer Image");
		btnModifierDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		if(!PanelPlat.modif){
		textAreaDescription.setText(PanelPlat.photosNewPlat.get(indicePhotoPlat).getDescription()+"");
		btnModifierDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Photo photonew=new Photo();
				Photo photoAncien=PanelPlat.photosNewPlat.get(indicePhotoPlat);
				photonew.setUrl(photoAncien.getUrl());
				photonew.setDescription(textAreaDescription.getText());
				
				
				PanelPlat.photosNewPlat.add(indicePhotoPlat, photonew);
				PanelPlat.photosNewPlat.remove(indicePhotoPlat+1);
				PanelPlat.listImageModel.removeAllElements();
				for(Photo photo:PanelPlat.photosNewPlat)
					PanelPlat.listImageModel.addElement(photo.getUrl());
				
				myJFrame.dispose();
			}
		});
		btnSupprimerImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelPlat.listImageModel.remove(indicePhotoPlat);
				PanelPlat.photosNewPlat.remove(indicePhotoPlat);
				myJFrame.dispose();
				 
			}
		});
		}else{
			textAreaDescription.setText(MenueRestaurantPanel.plats.get(MenueRestaurantPanel.selectedPlat).getPhotos().get(indicePhotoPlat).getDescription());
		
			btnModifierDescription.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Photo photonew=new Photo();
					Photo photoAncien=photoCuurent;
					photonew.setUrl(photoAncien.getUrl());
					photonew.setDescription(textAreaDescription.getText());
					MenueRestaurantPanel.plats.get(MenueRestaurantPanel.selectedPlat).getPhotos().add(indicePhotoPlat,photonew);
					MenueRestaurantPanel.plats.get(MenueRestaurantPanel.selectedPlat).getPhotos().remove(indicePhotoPlat+1);
					PanelPlat.listImageModel.removeAllElements();
					for(Photo photo:	MenueRestaurantPanel.plats.get(MenueRestaurantPanel.selectedPlat).getPhotos())
						PanelPlat.listImageModel.addElement(photo.getUrl());
					myJFrame.dispose();
				}
			});
			btnSupprimerImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelPlat.listImageModel.remove(indicePhotoPlat);
					MenueRestaurantPanel.plats.get(MenueRestaurantPanel.selectedPlat).getPhotos().remove(indicePhotoPlat);
					myJFrame.dispose();
					 
				}
			});
		}
		btnModifierDescription.setBounds(73, 203, 170, 23);
		contentPane.add(btnModifierDescription);
		
		
		
		btnSupprimerImage.setBounds(253, 203, 154, 23);
		contentPane.add(btnSupprimerImage);
	}

}
