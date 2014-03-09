package com.abstractTeam.IHM.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.abstractTeam.Controller.CommentaireDAO;
import com.abstractTeam.Controller.NoteDao;
import com.abstractTeam.Controller.OptionMessage;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Controller.RestaurantDao;
import com.abstractTeam.Model.Commentaire;
import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Restaurant;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PanelConsulterRestoPlats extends JPanel {

	/**
	 * Create the panel.
	 */
	public List<Plat>  plats=null;
	public JSpinner spinnerNotePlat ;
	public PanelConsulterRestoPlats() {
		setBackground(Color.WHITE);
		
		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)),
				"Rechercher Restaurant  - Resto-Tunisie -", TitledBorder.LEADING,
				TitledBorder.TOP, new Font(" Arial ", Font.BOLD, 15),
				Color.DARK_GRAY));
		setBounds(337, 76, 1013, 611);

		setLayout(null);
		setVisible(true);
		
		
		
		
		
		
		
	        
	        //make sure the program exits when the frame closes
	    
	        
	        String[] lstResto=new String[100];
	        RestaurantDao res=new RestaurantDao();
	     
	      final List<Restaurant> lst= res.getAllRestaurants2();
	      
	      
	      int i=0;
	      for (Restaurant resto : lst)
			{
		
		{System.out.println(resto.getNom());
		lstResto[i]=resto.getNom();
		i++;
			
		}	}
	     final JComboBox lstComobox = new JComboBox(lstResto);
          lstComobox.setMaximumRowCount(12);
          lstComobox.setToolTipText("");
          lstComobox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
	      
	      String[] lstPlats=new String[100];
	      PlatDao plats=new PlatDao();
	      
	   List<Plat> lstP= plats.DisplayAllStocks();
	    
	    int j=0;
	    for (Plat plat : lstP)
			{
		
		{
		
			System.out.println(plat.getLabel());
		
		lstPlats[j]=plat.getLabel();
		j++;
			
		}	}
	   
	   JPanel panel = new JPanel();
	   panel.setForeground(Color.WHITE);
	   panel.setBounds(43, 31, 942, 555);
	   add(panel);
	   final JSpinner spinnerNote = new JSpinner();
       spinnerNote.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
	        panel.setLayout(null);
	        
	        //Create the second JPanel. Add a JLabel and JList and
	        //make use the JPanel is not visible.
	        final JPanel listPanel = new JPanel();
	        listPanel.setBounds(137, 54, 795, 366);
	        panel.add(listPanel);
	        listPanel.addMouseMotionListener(new MouseMotionAdapter() {
	        	@Override
	        	public void mouseDragged(MouseEvent arg0) {
	        	
	        	}
	        });
	        listPanel.setVisible(false);
	        listPanel.setLayout(null);
	        
	        JLabel lblListeDesPlats = new JLabel("Liste des plats ");
	        lblListeDesPlats.setBounds(317, 5, 155, 24);
	        lblListeDesPlats.setForeground(Color.BLUE);
	        lblListeDesPlats.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 23));
	        listPanel.add(lblListeDesPlats);
	        final DefaultListModel defaultListModel=new DefaultListModel();
	        final JList JlistPlat = new JList();
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(28, 11, 107, 74);
	        listPanel.add(scrollPane);
	        scrollPane.setViewportView(JlistPlat);
	        JlistPlat.setModel(defaultListModel);
	        JLabel lblNote = new JLabel("Note : /100 \r\n");
	        lblNote.setBounds(10, 105, 64, 14);
	        lblNote.setForeground(Color.DARK_GRAY);
	        lblNote.setFont(new Font("Aharoni", Font.PLAIN, 13));
	        listPanel.add(lblNote);
	        
	        JLabel lblCommentaire = new JLabel("commentaire ");
	        lblCommentaire.setBounds(0, 162, 121, 32);
	        lblCommentaire.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/comment.png")));
	        lblCommentaire.setForeground(Color.DARK_GRAY);
	        lblCommentaire.setFont(new Font("Aharoni", Font.PLAIN, 13));
	        listPanel.add(lblCommentaire);
	        
	        JScrollPane scrollPane_1 = new JScrollPane();
	        scrollPane_1.setBounds(126, 153, 164, 94);
	        listPanel.add(scrollPane_1);
	        
	        final JTextArea textFieldCommentaire = new JTextArea();
	        scrollPane_1.setViewportView(textFieldCommentaire);
	        textFieldCommentaire.setLineWrap(true);
	        textFieldCommentaire.setRows(5);
	        textFieldCommentaire.setToolTipText("");
	        textFieldCommentaire.setFont(new Font("Monospaced", Font.PLAIN, 13));
	        textFieldCommentaire.setTabSize(30);
	        textFieldCommentaire.setColumns(20);
	        
	        JLabel label_1 = new JLabel("");
	        label_1.setBounds(183, 96, 32, 32);
	        label_1.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/arrow_right_double.png")));
	        label_1.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	         		if (PanelLoginFinal.client!=null){
	        			Plat plat=PanelConsulterRestoPlats.this.plats.get(JlistPlat.getSelectedIndex());
	        			Note note=new Note();
	        			note.setNote((Float) spinnerNotePlat.getValue());
	        			note.setClient(PanelLoginFinal.client);
	        			note.setPlat(plat);
	        			NoteDao noteDao=new NoteDao();
	        			noteDao.insertPlat(note);
	        			OptionMessage.messageInfo("Success", "Monsieur "+PanelLoginFinal.client.getNom()+" votre note est inseré avec success");
	        			
	        		}
	        		else{
	        			OptionMessage.messageWarning("Non connecté","Connecté vous s'il vous plait");
	        		}
	        		
	        	}
	        });
	        label_1.setForeground(Color.DARK_GRAY);
	        label_1.setFont(new Font("Aharoni", Font.PLAIN, 13));
	        listPanel.add(label_1);
	        
	        JButton btnPlusDinformation = new JButton("plus d'information");
	        btnPlusDinformation.setBounds(486, 89, 215, 41);
	        btnPlusDinformation.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/info.png")));
	        btnPlusDinformation.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Plat plat=PanelConsulterRestoPlats.this.plats.get(JlistPlat.getSelectedIndex());
	        		new AboutPlat(plat);
	        	}
	        });
	        btnPlusDinformation.setForeground(Color.BLACK);
	        btnPlusDinformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
	        btnPlusDinformation.setBackground(Color.WHITE);
	        listPanel.add(btnPlusDinformation);
	        
	        JButton button = new JButton("Passer une commande\r\n");
	        button.setBounds(225, 89, 251, 41);
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	//	 this.showMessageDialog("jj");
	        		JOptionPane.showMessageDialog(ClientFrame.content,"Commande envoyé au restaurateur","Commande",JOptionPane.INFORMATION_MESSAGE);
		        	
	        	}
	        });
	        button.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/plat.png")));
	        button.setForeground(Color.BLACK);
	        button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
	        button.setBackground(Color.WHITE);
	        listPanel.add(button);
	        
	        spinnerNotePlat = new JSpinner();
	        spinnerNotePlat.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
	        spinnerNotePlat.setBounds(92, 101, 43, 18);
	        listPanel.add(spinnerNotePlat);
	        
	        JLabel labelCommenter = new JLabel("");
	        labelCommenter.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/arrow_right_double.png")));
	        labelCommenter.setForeground(Color.DARK_GRAY);
	        labelCommenter.setFont(new Font("Aharoni", Font.PLAIN, 13));
	        labelCommenter.setBounds(304, 153, 32, 32);
	        listPanel.add(labelCommenter);
	        
	       
	        labelCommenter.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	         		if (PanelLoginFinal.client!=null){
	         			Commentaire commentaire=new Commentaire();
	         			commentaire.setMessage(textFieldCommentaire.getText());
	         			
	         			commentaire.setClient(PanelLoginFinal.client);
	         			Plat plat=PanelConsulterRestoPlats.this.plats.get(JlistPlat.getSelectedIndex());
	         			commentaire.setPlat(plat);
	         			CommentaireDAO commentaireDAO=new CommentaireDAO();
	         			commentaireDAO.insertCommentairePlat(commentaire);
//	         			commentaire.setMessage(text)
	        		}
	        		else{
	        			OptionMessage.messageWarning("Non connecté","Connecté vous s'il vous plait");
	        		}
	        		
	        	}
	        });
	      
	          
	              
	        final JPanel comboPanel = new JPanel();
	        comboPanel.setBounds(75, 28, 795, 42);
	          panel.add(comboPanel);
		
	               JButton vegFruitBut = new JButton( "Consulter les plats ");
	               vegFruitBut.setBounds(122, 473, 686, 59);
	               panel.add(vegFruitBut);
	           //    vegFruitBut.setBackground(Color.LIGHT_GRAY);
	               vegFruitBut.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/cokk.png")));
	               vegFruitBut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
	               vegFruitBut.setForeground(new Color(0, 0, 0));
	               
	               //The ActionListener class is used to handle the
	               //event that happens when the user clicks the button.
	               //As there is not a lot that needs to happen we can 
	               //define an anonymous inner class to make the code simpler.
	               vegFruitBut.addActionListener(new ActionListener()
	               {
	                   public void actionPerformed(ActionEvent event)
	                   {
	                      //When the fruit of veg button is pressed
	                      //the setVisible value of the listPanel and
	                      //comboPanel is switched from true to 
	                      //value or vice versa.
	                	   PlatDao platDao=new PlatDao();
	                	   PanelConsulterRestoPlats.this.plats=platDao.DisplayAllPlatByRestau(lst.get(lstComobox.getSelectedIndex()));
	                	   defaultListModel.removeAllElements();
	                	   for(Plat plat:PanelConsulterRestoPlats.this.plats)
	                		   defaultListModel.addElement(plat.getLabel());
	                	   listPanel.setVisible(!listPanel.isVisible());
	                      comboPanel.setVisible(!comboPanel.isVisible());

	                   }
	               });
	        
	          
	          
	         
	  
	          //The first JPanel contains a JLabel and JCombobox
	        
	          JLabel comboLbl = new JLabel("Liste des restaurants  ");
	          comboLbl.setForeground(Color.BLUE);
	          comboLbl.setFont(new Font("Aharoni", Font.BOLD | Font.ITALIC, 23));
	         
	          comboPanel.add(spinnerNote);
	          comboPanel.add(comboLbl);
	          comboPanel.add(lstComobox);
	          JLabel lblNewLabel_2 = new JLabel("Note : /100");
	          lblNewLabel_2.setIcon(null);
	          lblNewLabel_2.setFont(new Font("Aharoni", Font.PLAIN, 13));
	          lblNewLabel_2.setForeground(Color.DARK_GRAY);
	          lblNewLabel_2.setBounds(20, 81, 46, 14);
	          comboPanel.add(lblNewLabel_2);
	          
	          JLabel lblSss = new JLabel("");
	          lblSss.setIcon(new ImageIcon(PanelConsulterRestoPlats.class.getResource("/images/arrow_right_double.png")));
	          lblSss.addMouseListener(new MouseAdapter() {
	          	@Override
	          	public void mouseClicked(MouseEvent arg0) {
	          		if (PanelLoginFinal.client!=null){
	        			Restaurant restaurant=lst.get(lstComobox.getSelectedIndex());
	        			Note note=new Note();
	        			note.setNote((Float) spinnerNote.getValue());
	        			note.setClient(PanelLoginFinal.client);
	        			note.setRestaurant(restaurant);
	        			NoteDao noteDao=new NoteDao();
	        			noteDao.insertRestaurant(note);
	        			OptionMessage.messageInfo("Success", "Monsieur "+PanelLoginFinal.client.getNom()+" votre note est inseré avec success");
	        			
	        		}
	        		else{
	        			OptionMessage.messageWarning("Non connecté","Connecté vous s'il vous plait");
	        		}
	          	}
	          });
	          
	         
	          lblSss.setForeground(Color.DARK_GRAY);
	          lblSss.setFont(new Font("Aharoni", Font.PLAIN, 13));
	          comboPanel.add(lblSss);
	        
	        //make sure the JFrame is visible
	       setVisible(true);
	    
	    
		
	}
}
