package com.abstractTeam.IHM.GestionRestaurant;

import javax.crypto.spec.IvParameterSpec;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

import com.abstractTeam.Controller.MenueDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.IHM.PanelLeftTop;
import com.abstractTeam.Model.Menus;
import com.abstractTeam.Model.Plat;
import javax.swing.ListSelectionModel;

public class PanelMenu extends JPanel {
	private JTextField textField;
	public static DefaultListModel modelPlats;
	public static JList listPlats;
	public static JPanel content;

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		content = this;
		setLayout(null);
		setBounds(131, 319, 267, 255);
		setOpaque(false);
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(28, 22, 46, 14);
		add(lblNom);

		JButton btnAjouterPlat = new JButton("Ajouter Plat");
		btnAjouterPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("")) {
					MenueRestaurantPanel.lblPlat_1.setVisible(true);
					MenueRestaurantPanel.content
							.remove(MenueRestaurantPanel.panelPlat);
					MenueRestaurantPanel.panelPlat = new PanelPlat();
					MenueRestaurantPanel.content
							.add(MenueRestaurantPanel.panelPlat);
					MenueRestaurantPanel.content.validate();
					MenueRestaurantPanel.content.repaint();
				} else {
					ImageIcon iconOk = new ImageIcon("icon\\ok.png");
					Image imgOk = iconOk.getImage();
					Image newimgOk = imgOk.getScaledInstance(50, 50,
							java.awt.Image.SCALE_SMOOTH);
					iconOk = new ImageIcon(newimgOk);
					ImageIcon iconNo = new ImageIcon("icon\\no.png");
					Image imgNo = iconNo.getImage();
					Image newimgNo = imgNo.getScaledInstance(50, 50,
							java.awt.Image.SCALE_SMOOTH);
					iconNo = new ImageIcon(newimgNo);
					ImageIcon iconInfo = new ImageIcon("icon\\info.png");
					Image imgInfo = iconInfo.getImage();
					Image newimgInfo = imgInfo.getScaledInstance(50, 50,
							java.awt.Image.SCALE_SMOOTH);
					iconInfo = new ImageIcon(newimgInfo);
					JOptionPane.showMessageDialog(null, "remplir les champs",
							"Warning", JOptionPane.OK_OPTION, iconInfo);

				}
			}
		});
		btnAjouterPlat.setBounds(28, 44, 131, 23);
		add(btnAjouterPlat);

		textField = new JTextField();
		textField.setBounds(73, 19, 86, 20);
		textField.setText("");
		add(textField);
		textField.setColumns(10);
		textField.setOpaque(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 71, 171, 114);
		add(scrollPane);
		listPlats = new JList();
		scrollPane.setViewportView(listPlats);

		JButton btnAjouterMenu = new JButton("Ajouter menu");
		btnAjouterMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!textField.equals("")) {
					int result = OptionMessage.messageInfo("Ajouter menue",
							"Voulez vous ajouter ce menu");
					if (result == JOptionPane.OK_OPTION) {
						Menus menu = new Menus();
						menu.setLabel(textField.getText().toString());
						menu.setPlats(PanelPlat.listNewPlat);
						PanelPlat.listNewPlat = new ArrayList<Plat>();
						MenueDao menueDao = new MenueDao();
						int idRestaurant = PanelLeftTop.restaurantIds
								.get(PanelLeftTop.comboBox.getSelectedIndex());
						menueDao.insertMenu(menu, idRestaurant);
						MenueRestaurantPanel.panelPlat.setVisible(false);
						PanelPlat.listNewPlat=new ArrayList<Plat>();
						textField.setText("");
						modelPlats.removeAllElements();
						setVisible(false);
						
						OptionMessage.messageOk("Success", "Le menue est ajouté avec success");
					}
				}else{
					OptionMessage.messageWarning("Controle de saisie", "Remplir les champs");
				}
			}
		});
		btnAjouterMenu.setBounds(28, 196, 131, 23);
		add(btnAjouterMenu);
		modelPlats = new DefaultListModel();
		listPlats.setModel(modelPlats);
		// textField.setContentAreaFilled(false);

	}
}
