package com.abstractTeam.IHM.client;



import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;

import com.abstractTeam.Model.Client;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {

	static URI url;

	public static JPanel panelLeftTop;
	public static JPanel panelLeftBottom ;
	// public static PanelContenu panelContenu;
	public static JPanel panelContenu;
	
	public static Container content;
	public static JTree tree;
	public static Thread thread;
	private final Action action = new SwingAction();
	public Client client;

	/**
	 * Create the application.
	 */

	public ClientFrame(Client client) {
		
		super();
		
this.client=client;

		// setType(Type.POPUP);
		//this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

		setFont(new Font("Dialog", Font.BOLD, 12));
		initialize();
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame window = new ClientFrame(null);
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

		panelLeftTop = new PanelLeftTop();
		content.add(panelLeftTop);

		panelLeftBottom =  new PanelLeftBottom();
		content.add(panelLeftBottom);

		panelContenu =   
				new PanelContenu();
		panelContenu.setBounds(368, -296, 761, 601);
		panelLeftBottom.add(panelContenu);

		JButton btnNewButton_7 = new JButton("Serveurs");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 24);
		this.content.add(menuBar);

		JMenu mnNewMenu = new JMenu("INSCRIVEZ-VOUS");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Inscription");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelInscription();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
				

			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnConnectezvous = new JMenu("CONNECTEZ-VOUS");
		
		menuBar.add(mnConnectezvous);
		
		JMenuItem mntmConnection = new JMenuItem("connection");
		mntmConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new PanelLoginFinal();
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
				
				
			/*	ClientFrame.content.remove(ClientFrame.panelContenu);
				ClientFrame.panelContenu= new  PanelLogin(true);
				ClientFrame.content.add(ClientFrame.panelContenu);
				ClientFrame.content.validate();
				ClientFrame.content.repaint();
				*/
		/*1		try
			    {
			   //   DialogConnectServer dialog = new DialogConnectServer();
					DialogLogin dialog = new DialogLogin(true);
			      dialog.setDefaultCloseOperation(2);
			      dialog.setVisible(true);
			    }
			    catch (Exception e1)
			    {
			      e1.printStackTrace();
			    };
				

			
			1*/		
			}});


		mnConnectezvous.add(mntmConnection);

		JMenu mnNewMenu_1 = new JMenu("STATISTIQUE");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("meilleurs plats");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {
				/*	ClientFrame.content.remove(ClientFrame.panelContenu);
					ClientFrame.panelContenu= new PanelContenu();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
					//ClientFrame.content.remove(ClientFrame.panelContenu);
					
					ClientFrame.panelContenu= new PanelStatistique();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
			*/
				//	new PanelStatistique();
			
					ClientFrame.content.remove(ClientFrame.panelContenu);
					ClientFrame.panelContenu= new PanelTop5Plats();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
				
				
				}
			});
		
		
		JMenuItem mntmNewMenuItem3 = new JMenuItem("meilleurs Restaurants");
		mntmNewMenuItem3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 
					
				/*	ClientFrame.content.remove(ClientFrame.panelContenu);
					ClientFrame.panelContenu= new PanelContenu();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
					//ClientFrame.content.remove(ClientFrame.panelContenu);
					
					ClientFrame.panelContenu= new PanelStatistique2();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
*/
				//	new PanelStatistique2();
					ClientFrame.content.remove(ClientFrame.panelContenu);
					ClientFrame.panelContenu= new PanelTop5Resto();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
				}
			});
		
		
		mnNewMenu_1.add(mntmNewMenuItem2);
		mnNewMenu_1.add(mntmNewMenuItem3);
		JMenu mnNewMenu_2 = new JMenu("OUTILS");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A propos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
     JOptionPane.showMessageDialog(ClientFrame.content,"Réalisé par ABSTRACT-TEAM","a propos",JOptionPane.INFORMATION_MESSAGE);

	
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnDeconnection = new JMenu("DECONNECTION\r\n");
		mnDeconnection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 JFrame f = new JFrame();
//			        f.getContentPane().add(new AnimatedRectangle());
//			        f.setSize(800,650);
//			        f.setLocationRelativeTo(null);
//			        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			        f.setVisible(true);
     //JOptionPane.showMessageDialog(ClientFrame.content,"BY BY CHER CLIENT","a propos",JOptionPane.INFORMATION_MESSAGE);
			    	ClientFrame.content.remove(ClientFrame.panelContenu);
					ClientFrame.panelContenu= new PanelDeconx();
					ClientFrame.content.add(ClientFrame.panelContenu);
					ClientFrame.content.validate();
					ClientFrame.content.repaint();
			//		System.exit(0);
			
					
			
			}
		});
		mnDeconnection.setAction(action);
		mnDeconnection.setHorizontalAlignment(SwingConstants.CENTER);
		mnDeconnection.setBounds(1135, 50, 99, 22);
		getContentPane().add(mnDeconnection);
		
	panelContenu = new PanelContenu();
		panelContenu.setBounds(368, 75, 956, 617);
		getContentPane().add(panelContenu);

		this.content.validate();
		this.content.repaint();

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Deconnection");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
