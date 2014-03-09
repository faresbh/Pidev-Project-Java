package com.abstractTeam.IHM;



import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;

import com.abstractTeam.IHM.Inscription.PanelInscriptionRestaurant;
import com.abstractTeam.IHM.client.PanelTop5Plats;
import com.abstractTeam.Model.Administrateur;
import com.abstractTeam.Model.Restaurateur;


@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame {

	static URI url;

	public static JPanel panelLeftTop;
	public static JPanel panelLeftBottom ;
	// public static PanelContenu panelContenu;
	public static JPanel panelContenu;
	
	public static Container content;
	public static JTree tree;
	public static Thread thread;

	public  static boolean typeCompt;

	public static Administrateur admin=new Administrateur();
	public static Restaurateur restaurateur=new Restaurateur();
	private final Action action = new SwingAction();
	public boolean type;
	public Administrateur administrateur;
	public Restaurateur restaurateur2;
	/**
	 * Create the application.
	 */

	public ApplicationFrame(boolean type,Administrateur administrateur,Restaurateur restaurateur) {
		super();
		this.type=type;
		this.administrateur=administrateur;
		this.restaurateur2=restaurateur;
		// setType(Type.POPUP);
		setFont(new Font("Dialog", Font.BOLD, 12));
		initialize();
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFrame window = new ApplicationFrame(false,null,null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */

	@SuppressWarnings("static-access")
	private void initialize() {
		

		content = getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1366, 731);
		this.setLocationRelativeTo(null);
		this.content.setLayout(null);
		
		this.setTitle("Resto Tunisie");
		if(restaurateur2!=null)
		panelLeftTop = new PanelLeftTop(restaurateur2.getId());
		else
			panelLeftTop=new PanelLeftTop(0);
		content.add(panelLeftTop);
		if(!type){
			PanelLeftTop.comboBox.setVisible(true);
			PanelLeftTop.btnNewButton.setVisible(true);
			PanelLeftTop.label_loginText.setText(restaurateur2.getPrenom()+" "+restaurateur2.getNom());
			PanelLeftTop.lblType.setText("Restaurateur");
			PanelLeftTop.lblMesRestaurants.setVisible(true);
			System.out.println("restaurant");
			if(PanelLeftTop.comboBox.getSelectedItem()!=null)
		panelLeftBottom =  new PanelLeftBottom(PanelLeftTop.comboBox.getSelectedItem().toString());
			else
				panelLeftBottom =  new PanelLeftBottom("");
		content.add(panelLeftBottom);
		}else{
			PanelLeftTop.comboBox.setVisible(false);
			PanelLeftTop.btnNewButton.setVisible(false);
			PanelLeftTop.label_loginText.setText(administrateur.getPrenom()+" "+administrateur.getNom());
			PanelLeftTop.lblType.setText("admin");
			PanelLeftTop.lblMesRestaurants.setVisible(false);
			System.out.println("admin");
			panelLeftBottom =  new PanelLeftBottomAdmin("");
			content.add(panelLeftBottom);
		}
		if(restaurateur2!=null)
		panelContenu =   new PanelContenu(restaurateur2,null);
		else
			panelContenu =   new PanelContenu(null,administrateur);
		content.add(panelContenu);

		JButton btnNewButton_7 = new JButton("Serveurs");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 24);
		this.content.add(menuBar);

		JMenu mnNewMenu = new JMenu("Connection");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Inscription");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelInscriptionRestaurant();
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Statistiques");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("meilleurs plats");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelTop5Plats();
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}
			});
		mnNewMenu_1.add(mntmNewMenuItem2);
		
		JMenu mnNewMenu_2 = new JMenu("Outils");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A propos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
     JOptionPane.showMessageDialog(ApplicationFrame.content,"Réalisé par ABSTRACT-TEAM","a propos",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		this.content.validate();
		this.content.repaint();

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
