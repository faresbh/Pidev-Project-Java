package com.abstractTeam.IHM.GestionRestaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import com.abstractTeam.Controller.IngredientDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Model.Ingredient;
import com.abstractTeam.Model.Plat;

public class FrameInredient extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameInredient frame = new FrameInredient();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrameInredient(final int count) {
		final JFrame frame =this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setBounds(10, 11, 58, 14);
		contentPane.add(lblImage);
		
		JButton btnImage = new JButton("Voir Image");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImage.setBounds(121, 7, 303, 23);
		contentPane.add(btnImage);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 62, 58, 14);
		contentPane.add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(121, 59, 303, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		textFieldNom.setText(FramePlat.ingredients.get(count).getLabel());
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 112, 97, 14);
		contentPane.add(lblDescription);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 107, 303, 101);
		contentPane.add(scrollPane);
		
		final JTextArea textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		textAreaDescription.setText(FramePlat.ingredients.get(count).getDescription());
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(OptionMessage.messageInfo("Modification Plat", "Voulez vous modifier ce plat")==JOptionPane.OK_OPTION){
				Ingredient ingredientnouveau=new Ingredient();
				Ingredient ingredientancien=new Ingredient();
				ingredientancien=FramePlat.ingredients.get(count);
				ingredientnouveau.setId(ingredientancien.getId());
				
				ingredientnouveau.setLabel(textFieldNom.getText());
				ingredientnouveau.setDescription(textAreaDescription.getText());
				FramePlat.ingredients.add(count, ingredientnouveau);
				FramePlat.ingredients.remove(count+1);
				PanelPlat.model.removeAllElements();
				for(Ingredient ingredient:FramePlat.ingredients)
					PanelPlat.model.addElement(ingredient.getLabel());
				IngredientDao ingredientDao=new IngredientDao();
				ingredientDao.updateIngredientById(ingredientnouveau);
				OptionMessage.messageOk("Succes", "Votre modification se fait avec succes");
				frame.dispose();
//				PanelPlat.model.getEle
//				ch=textFieldNom.getText();
//				System.out.println(ch+"nommmmm");
//				CopyOfImageUploadIIngredient.ingredients.get(count).setDescription(textAreaDescription.getText());
			}}
		});
		btnModifier.setBounds(121, 227, 89, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=OptionMessage.messageInfo("Suppression", "Voulez vous supprimer cet ingredient");
				if(result==JOptionPane.OK_OPTION){
					IngredientDao ingredientDao=new IngredientDao();
					ingredientDao.deleteIngredientById(FramePlat.ingredients.get(count).getId());
				PanelPlat.model.removeAllElements();
				FramePlat.ingredients.remove(count);
				for(Ingredient ingredient:FramePlat.ingredients)
					PanelPlat.model.addElement(ingredient.getLabel());

				frame.dispose();
				
				OptionMessage.messageOk("Success", "Suuppresion avec succes");
				
				}
			}
		});
		btnSupprimer.setBounds(233, 227, 89, 23);
		contentPane.add(btnSupprimer);
	}
}
