package com.abstractTeam.IHM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.abstractTeam.Controller.AdministrateurDao;
import com.abstractTeam.Controller.RestaurateurDAO;
import com.abstractTeam.IHM.Inscription.PanelInscriptionRestaurant;
import com.abstractTeam.IHM.Inscription.PanelMail;
import com.abstractTeam.Model.Administrateur;
import com.abstractTeam.Model.Restaurateur;

public class ConnectionFrame {

	public JFrame frmRestoTunisie;
	private JTextField textMail;
	private JPasswordField textMdp;
	public static JFrame f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionFrame window = new ConnectionFrame();
					window.frmRestoTunisie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectionFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRestoTunisie = new JFrame();
		frmRestoTunisie.setTitle("Resto Tunisie");
		frmRestoTunisie.setBounds(100, 100, 529, 367);
		frmRestoTunisie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRestoTunisie.getContentPane().setLayout(null);
		frmRestoTunisie.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(255, 0, 0), 6, true));
		panel.setBounds(49, 98, 417, 175);
		frmRestoTunisie.getContentPane().add(panel);
		panel.setLayout(null);
		final JLabel lblMailOuMot = new JLabel("Mail ou mot de passe invalide");
		lblMailOuMot.setForeground(Color.RED);
		lblMailOuMot.setBounds(158, 303, 171, 14);
		lblMailOuMot.setVisible(false);
		final JLabel lblNewLabel = new JLabel("Mail : ");
		lblNewLabel.setBounds(37, 29, 106, 14);
		panel.add(lblNewLabel);
		final JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(35, 54, 118, 14);
		panel.add(lblNewLabel_1);
		textMail = new JTextField();
		textMail.setBounds(175, 26, 193, 20);
		panel.add(textMail);
		textMail.setColumns(10);
		
		JButton btnConnecte = new JButton("Connecte");
		btnConnecte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			Restaurateur restaurateur =new Restaurateur();
			restaurateur.setMail(textMail.getText());
			restaurateur.setMdp(textMdp.getText());
			
			RestaurateurDAO restaurateurDAO =new RestaurateurDAO();
			Restaurateur restaurateur2=null;
		
		 restaurateur2=	restaurateurDAO.findRestaurateurByMailMdp(textMail.getText(), textMdp.getText());
//		System.out.println(restaurateur2.getNom()+"sqsdqsdqs");
		if(restaurateur2==null){
				System.out.println("faux");
				AdministrateurDao administrateurDao=new AdministrateurDao();
				Administrateur administrateur= administrateurDao.findAdminByMailMdp(textMail.getText(), textMdp.getText());
				if(administrateur==null){
					
					lblMailOuMot.setVisible(true);
				}
				else{
					ApplicationFrame applicationFrame=new ApplicationFrame(true,administrateur,null);
					applicationFrame.setVisible(true);
					ApplicationFrame.typeCompt=true;
					ApplicationFrame.admin=administrateur;
					frmRestoTunisie.dispose();
				}
			
			}
			else{
				ApplicationFrame applicationFrame=new ApplicationFrame(false,null,restaurateur2);
				applicationFrame.setVisible(true);
				ApplicationFrame.typeCompt=false;
				ApplicationFrame.restaurateur=restaurateur2;
				frmRestoTunisie.dispose();
			}
			}}
		);
			
		
	
		btnConnecte.setBounds(274, 108, 89, 23);
		panel.add(btnConnecte);
		
		JButton btnAnnule = new JButton("Annuler");
		btnAnnule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMail.setText("");
				textMdp.setText("");
			}
		});
		btnAnnule.setBounds(175, 108, 89, 23);
		panel.add(btnAnnule);
		
		textMdp = new JPasswordField();
		textMdp.setBounds(175, 51, 193, 20);
		panel.add(textMdp);
		
		JLabel lblMotDePasse = new JLabel("mot de passe oubli\u00E9 ");
		lblMotDePasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame f=new JFrame();
				f.setBounds(337,76,1013,611);
              PanelMail mail=new PanelMail();
              mail.setVisible(true);
              f.setLocationRelativeTo(null);
              f.setVisible(true);
              f.getContentPane().add(mail);
              frmRestoTunisie.dispose();
		
			}
		});
		lblMotDePasse.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		lblMotDePasse.setBounds(22, 284, 127, 14);
		frmRestoTunisie.getContentPane().add(lblMotDePasse);
//		lblNewLabel_2.
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(339, 0, 110, 152);
		frmRestoTunisie.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("resto_icone.jpg"));
		
		JLabel lblRestoTunisie = new JLabel("Resto Tunisie");
		lblRestoTunisie.setBounds(22, 11, 222, 55);
		frmRestoTunisie.getContentPane().add(lblRestoTunisie);
		lblRestoTunisie.setForeground(Color.DARK_GRAY);
		lblRestoTunisie.setFont(new Font("Comic Sans MS", Font.PLAIN, 31));
		
		JButton btnCreeCompte = new JButton("Cree Compte");
		btnCreeCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PanelInscriptionRestaurant p = new PanelInscriptionRestaurant();
				 p.main(null);
			}
		});
		btnCreeCompte.setBounds(339, 281, 127, 23);
		frmRestoTunisie.getContentPane().add(btnCreeCompte);
		
		
		frmRestoTunisie.getContentPane().add(lblMailOuMot);
	}
}
