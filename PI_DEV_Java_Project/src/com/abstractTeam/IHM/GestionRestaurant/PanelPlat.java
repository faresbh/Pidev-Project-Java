package com.abstractTeam.IHM.GestionRestaurant;

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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.abstractTeam.Controller.IngredientDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Photo;
import com.abstractTeam.Model.Plat;

public class PanelPlat extends JPanel {
	public Image image;
	public JTextField textFieldNom;
	public JTextField textFieldPrix;
	public static JList<String> list;
	public static DefaultListModel model;
	public static List<Ingredient> ingredients;
	public static List<Photo> photosNewPlat;
	public final JTextArea textArea = new JTextArea();
	public JButton btnAjouterPlat = new JButton("Ajouter Plat");
	public JButton btnAjouter;
	BufferedImage backgroundImage;
	public static JList jlistImages;
	public static DefaultListModel listImageModel;
	public static List<Plat> listNewPlat;
	public static boolean modif=false;
	// public static Vector<String> vectors;
	/**
	 * Create the panel.
	 */
	public PanelPlat() {
		listNewPlat=new ArrayList<Plat>();
		photosNewPlat = new ArrayList<Photo>();
		setBounds(589, 133, 327, 467);
		setOpaque(false);
		setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(Color.BLUE);
		lblNom.setBounds(10, 11, 46, 14);
		add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setForeground(Color.BLUE);
		textFieldNom.setBounds(98, 8, 132, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		textFieldNom.setOpaque(false);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setBounds(10, 84, 80, 14);
		add(lblDescription);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 84, 132, 157);
		add(scrollPane);

		// final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setForeground(Color.BLUE);
		lblPrix.setBounds(10, 48, 46, 14);
		add(lblPrix);

		textFieldPrix = new JTextField();
		textFieldPrix.setOpaque(false);
		textFieldPrix.setForeground(Color.BLUE);
		textFieldPrix.setColumns(10);
		textFieldPrix.setBounds(98, 45, 132, 20);
		add(textFieldPrix);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(98, 261, 132, 86);
		add(scrollPane_1);

		model = new DefaultListModel();

		list = new JList<String>();
		list.setModel(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// IngredientDao ingredientDao =new IngredientDao();
		//
		// ingredients=ingredientDao.getAllIngredientsByIdPlat(i);
		scrollPane_1.setViewportView(list);
		// list.add
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				// if (choice) {
				if (arg0.getValueIsAdjusting() == false) {
					if (list.getSelectedIndex() != -1) {
						System.out.println("ingredient jlist");
						FrameInredient frame = new FrameInredient(list
								.getSelectedIndex());
						frame.setVisible(true);
						System.out.println(list.getSelectedIndex() + "count");
					}
				} else {
					System.out.println("I think the value is adjusting");
				}
			}

			// }
		});
		// list.add(CopyOfImageUploadIIngredient.textPaneNom);
		JLabel lblIngredients = new JLabel("Ingredients :");
		lblIngredients.setForeground(Color.BLUE);
		lblIngredients.setBounds(10, 262, 80, 14);
		add(lblIngredients);
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(new Color(0, 128, 0));
		btnAjouter.setOpaque(false);
		btnAjouter.setContentAreaFilled(false);
		btnAjouter.setBorderPainted(false);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				java.awt.EventQueue.invokeLater(new Runnable() {

					public void run() {
						new FrameAddIngredient().setVisible(true);
					}
				});

			}
		});
		btnAjouter.setBounds(240, 258, 89, 23);
		add(btnAjouter);

		btnAjouterPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldNom.getText().equals("")
						&& !textFieldPrix.getText().equals("")
						&& !textArea.getText().equals("")) {
					int result=OptionMessage.messageInfo("Ajout Plat", "Voulez vous ajouter ce plat");
					if(result==JOptionPane.OK_OPTION){
					Plat plat = new Plat();
					plat.setLabel(textFieldNom.getText());
					plat.setDescription(textArea.getText());
					plat.setPrix(Double.parseDouble(textFieldPrix.getText()));
					
					plat.setIngredients(FramePlat.ingredients);
					plat.setPhotos(photosNewPlat);
					textFieldNom.setText("");
					textFieldPrix.setText("");
					textArea.setText("");
					model.removeAllElements();
					PanelMenu.modelPlats.addElement(plat.getLabel());
					listImageModel.removeAllElements();
					photosNewPlat=new ArrayList<Photo>();
					FramePlat.ingredients=new ArrayList<Ingredient>();
					System.out.println("plat new ingredient :"+plat.getIngredients().get(0).getLabel());
					listNewPlat.add(plat);
					
					}
				}else{
					
					OptionMessage.messageWarning("Control de saisie", "Il faut remplir tou les champs");
				}
			}
		});
		btnAjouterPlat.setBounds(10, 444, 114, 23);
		add(btnAjouterPlat);

		JLabel lblImages = new JLabel("Images :");
		lblImages.setForeground(Color.BLUE);
		lblImages.setBounds(10, 361, 80, 14);
		add(lblImages);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(98, 358, 132, 75);
		add(scrollPane_2);

		jlistImages = new JList();
		scrollPane_2.setViewportView(jlistImages);
		listImageModel = new DefaultListModel();
		jlistImages.setModel(listImageModel);

		jlistImages.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (arg0.getValueIsAdjusting() == false) {
					if (jlistImages.getSelectedIndex() != -1) {
						FramePhotoPlat frame = new FramePhotoPlat(jlistImages
								.getSelectedIndex());
						frame.setVisible(true);
					}
				} else {
					System.out.println("I think the value is adjusting");
				}
			}
		});

		JButton buttonAjouterImage = new JButton("Ajouter image");
		buttonAjouterImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjouterImageNewPlat ajouterImageNewPlat = new AjouterImageNewPlat();
				ajouterImageNewPlat.setVisible(true);
			}
		});
		buttonAjouterImage.setOpaque(false);
		buttonAjouterImage.setForeground(new Color(0, 128, 0));
		buttonAjouterImage.setContentAreaFilled(false);
		buttonAjouterImage.setBorderPainted(false);
		buttonAjouterImage.setBounds(228, 358, 121, 23);
		add(buttonAjouterImage);

		JButton btnVoirImages = new JButton("Voir images");
		btnVoirImages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<ImageIcon> imageIcons = new ArrayList<ImageIcon>();
				for (Photo photo : photosNewPlat) {
					imageIcons.add(new ImageIcon(photo.getUrl()));
					ImageGallery imageGallery = new ImageGallery(imageIcons);
					imageGallery.setVisible(true);
				}
			}
		});
		btnVoirImages.setOpaque(false);
		btnVoirImages.setForeground(new Color(0, 128, 0));
		btnVoirImages.setContentAreaFilled(false);
		btnVoirImages.setBorderPainted(false);
		btnVoirImages.setBounds(240, 391, 109, 23);
		add(btnVoirImages);
		ImageIcon iconOk = new ImageIcon("img\\plat.gif");
		Image imgOk = iconOk.getImage();
		image = imgOk.getScaledInstance(327, 324, java.awt.Image.SCALE_SMOOTH);
		try {
			backgroundImage = ImageIO.read(new File("img\\plat2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void paintComponent(final Graphics g) {

		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
}
