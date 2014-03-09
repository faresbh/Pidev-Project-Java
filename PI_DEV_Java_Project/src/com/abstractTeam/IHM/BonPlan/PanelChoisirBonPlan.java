package com.abstractTeam.IHM.BonPlan;

import java.awt.Color;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import com.abstractTeam.Controller.BonPlanDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.IHM.ApplicationFrame;
import com.abstractTeam.Model.Bonplan;
import com.toedter.calendar.JDateChooser;

public class PanelChoisirBonPlan extends JPanel {
	private JTable table;
	private JTextField textFieldnom;
	/**
	 * Create the panel.
	 */
	public PanelChoisirBonPlan(final int idResto) {
		

		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "Bon plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(337, 76, 1013, 611);
		setVisible(true);
		setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(534, 45, 469, 231);
		add(scrollPane);
		
		
		final TableModelBonPlan tableModel = new TableModelBonPlan(idResto);
		System.out.println(idResto+"id restooooooooooooo");
		table = new JTable(new TableModelBonPlan(idResto));
		
		scrollPane.setViewportView(table);
		table.setForeground(Color.BLACK);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);


		table.setBackground(Color.WHITE);

		
		
		JLabel label1 = new JLabel("Nom : ");
		label1.setBounds(62, 46, 46, 14);
		add(label1);
		
		JLabel label2 = new JLabel("Type :");
		label2.setBounds(62, 92, 46, 14);
		add(label2);
		
		JLabel label3 = new JLabel("Description : ");
		label3.setBounds(63, 138, 68, 25);
		add(label3);
		
		JLabel label4 = new JLabel("Prix :");
		label4.setBounds(62, 279, 46, 14);
		add(label4);
		
		JLabel label5 = new JLabel("Date :");
		label5.setBounds(62, 326, 46, 14);
		add(label5);
		
		textFieldnom = new JTextField();
		textFieldnom.setBounds(148, 43, 86, 20);
		add(textFieldnom);
		textFieldnom.setColumns(10);
		
		final JComboBox comboBoxtype = new JComboBox();
		comboBoxtype.setModel(new DefaultComboBoxModel(new String[] {"Soir\u00E9e", "DJ", "Hadhra"}));
		comboBoxtype.setBounds(148, 89, 86, 20);
		add(comboBoxtype);
		
		final TextArea textAreaDescription = new TextArea();
		textAreaDescription.setBounds(148, 134, 380, 99);
		add(textAreaDescription);
		
		final JSpinner spinnerprix = new JSpinner();
		spinnerprix.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinnerprix.setBounds(148, 276, 112, 20);
		add(spinnerprix);
		
		
		SimpleDateFormat formate = new SimpleDateFormat();
		
		
		final JLabel lmessage = new JLabel("");
		lmessage.setForeground(Color.RED);
		lmessage.setBounds(62, 446, 436, 22);
		add(lmessage);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(148, 320, 112, 20);
		add(dateChooser);
		final JTextField textfielddate =((JTextField) dateChooser.getDateEditor().getUiComponent());
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon(PanelChoisirBonPlan.class.getResource("/com/alee/examples/groups/desktoppane/icons/tetris/new.png")));
		btnAjouter.setSelectedIcon(new ImageIcon(PanelChoisirBonPlan.class.getResource("/com/alee/laf/filechooser/icons/approve.png")));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lmessage.setText("");


				TableModelBonPlan model = (TableModelBonPlan) table.getModel();
			if (!textFieldnom.getText().trim().equals("")){
				int option=OptionMessage.messageInfo ( "Ajout BonPlan","Voulez-vous ajouter ce BonPlan ?");
			
				if(option == JOptionPane.OK_OPTION){
				  		
				
				Bonplan bonplan = new Bonplan();
				bonplan.setNom(textFieldnom.getText());
                bonplan.setType((String) comboBoxtype.getSelectedItem());
				bonplan.setDescription(textAreaDescription.getText());
				bonplan.setPrix((Double) (spinnerprix.getValue()));				
				bonplan.setDate(textfielddate.getText());
			    BonPlanDao bonPlanDao=new BonPlanDao();

				bonPlanDao.insertBonPlan(bonplan,idResto);

				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelChoisirBonPlan(idResto);
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
				OptionMessage.messageOk("Ajout BonPlan", "Ajout effectué avec Succès");
				}
				}
				else {
					lmessage.setText("Le nom du Bon plan ne devrait pas etre vide");
					lmessage.setForeground(Color.RED);
				}
			
			}
		});
		btnAjouter.setBounds(62, 380, 119, 23);
		add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon(PanelChoisirBonPlan.class.getResource("/com/alee/laf/filechooser/icons/refresh.png")));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lmessage.setText("");
				TableModelBonPlan model = (TableModelBonPlan) table.getModel();
				if(table.getSelectedRow()== -1){
					
					if(table.getRowCount()==0){
						lmessage.setText("Aucun Bon plan Existant");
						lmessage.setForeground(Color.RED);

					}
					else{
						lmessage.setText("Vous devez selectionner un Bon plan");
						lmessage.setForeground(Color.RED);
					}
				}else{
					
					int option = OptionMessage.messageInfo ( "Modification BonPlan","Voulez-vous modifier ce BonPlan ?");					

					
					if(option == JOptionPane.OK_OPTION){

				

		        
                BonPlanDao bonplanDao=new BonPlanDao();
                int row = table.getSelectedRow();
                
                int id = (Integer) table.getValueAt(row, 5);
            	Bonplan bonplan = new Bonplan();
            	System.out.println(row +" "+id+"" );
				bonplan = bonplanDao.findbonplanbyId(id);

			
				bonplan.setNom(textFieldnom.getText());
                bonplan.setType((String) comboBoxtype.getSelectedItem());
				bonplan.setDescription(textAreaDescription.getText());
				bonplan.setPrix((Double) (spinnerprix.getValue()));				
				bonplan.setDate(textfielddate.getText());
				
				int x=bonplanDao.updateBonplan(bonplan);
				System.out.println("x :"+x);
			
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelChoisirBonPlan(idResto);
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
				OptionMessage.messageOk("Modification BonPlan", "Modification effectué avec Succès");

					}
				
				
				}
				
				
			}
		});
		btnModifier.setBounds(239, 380, 119, 23);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon(PanelChoisirBonPlan.class.getResource("/com/alee/examples/groups/desktoppane/icons/tetris/exit.png")));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableModelBonPlan model = (TableModelBonPlan) table.getModel();
                if(table.getSelectedRow()== -1){
					
					if(table.getRowCount()==0){
						lmessage.setText("Aucun Bon plan Existant");
						lmessage.setForeground(Color.RED);

					}
					else{
						lmessage.setText("Vous devez selectionner un Bon plan");
						lmessage.setForeground(Color.RED);

					}
				}else{

					int option = OptionMessage.messageInfo ( "Suppression BonPlan","Voulez-vous Supprimer ce BonPlan ?");					

					if(option == JOptionPane.OK_OPTION){
					 BonPlanDao bonplanDao=new BonPlanDao();
		                int row = table.getSelectedRow();
		                
		                int id = (Integer) table.getValueAt(row, 5);
		            	Bonplan bonplan = new Bonplan();
		            	System.out.println(row +" "+id+"" );
						bonplan = bonplanDao.findbonplanbyId(id);
					bonplanDao.delete(bonplan);


					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelChoisirBonPlan(idResto);
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
					OptionMessage.messageOk("Suppression BonPlan", "Suppression effectué avec Succès");

					
				}
				}


				
				
				
			}
		});
		btnSupprimer.setBounds(409, 380, 119, 23);
		add(btnSupprimer);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				TableModelBonPlan model = (TableModelBonPlan) table.getModel();

                textFieldnom.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
                comboBoxtype.setSelectedItem((model.getValueAt(table.getSelectedRow(), 1).toString()));
                textAreaDescription.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
                spinnerprix.setValue(model.getValueAt(table.getSelectedRow(), 3));
                textfielddate.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
               
                
			}
		});
		
	}
}
