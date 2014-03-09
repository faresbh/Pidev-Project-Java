package com.abstractTeam.IHM.client;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

import com.abstractTeam.Model.Restaurant;

import java.awt.Toolkit;


public class AboutRestaurant extends JFrame {
Restaurant restaurant;
    
    public AboutRestaurant(Restaurant restaurant) {
    	this.restaurant=restaurant;
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AboutRestaurant.class.getResource("/images/objects.png")));
        initComponents();
        setVisible(true);
        setBounds(100, 100, 410, 444);
    }

    


  
    private void initComponents() {
setVisible(true);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelPhoto.setIcon(new ImageIcon(restaurant.getPhotos().get(0).getUrl()));
        jLabelAdresse = new javax.swing.JLabel();
        jLabelNomResto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(true);
        setTitle("About Restaurant");
        setSize(140,224);
 
        setMinimumSize(null);
 
        setVisible(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Nom Resto ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 120, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("lieu");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 120, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Image");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 204, 70, 30);

        jLabelPhoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhoto.setForeground(new java.awt.Color(128, 128, 128));
        getContentPane().add(jLabelPhoto);
        jLabelPhoto.setBounds(124, 204, 246, 179);

        jLabelAdresse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAdresse.setForeground(new java.awt.Color(128, 128, 128));
        jLabelAdresse.setText(restaurant.getAdresse());
        getContentPane().add(jLabelAdresse);
        jLabelAdresse.setBounds(190, 70, 180, 30);

        jLabelNomResto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNomResto.setForeground(new java.awt.Color(128, 128, 128));
        jLabelNomResto.setText(restaurant.getNom());
        getContentPane().add(jLabelNomResto);
        jLabelNomResto.setBounds(190, 34, 140, 20);
        
        lblNoteMoyene = new JLabel();
        lblNoteMoyene.setText("Note moyene");
        lblNoteMoyene.setForeground(Color.BLUE);
        lblNoteMoyene.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNoteMoyene.setBounds(30, 121, 120, 30);
        getContentPane().add(lblNoteMoyene);
        
        labelNote = new JLabel();
        labelNote.setText(restaurant.getNote()+"");
        labelNote.setForeground(Color.GRAY);
        labelNote.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNote.setBounds(190, 121, 180, 30);
        getContentPane().add(labelNote);
        
        lblPrix = new JLabel();
        lblPrix.setText("specialité");
        lblPrix.setForeground(Color.BLUE);
        lblPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrix.setBounds(30, 157, 120, 30);
        getContentPane().add(lblPrix);
        
        lblspecialite = new JLabel();
        lblspecialite.setText(restaurant.getSpecialite());
        lblspecialite.setForeground(Color.GRAY);
        lblspecialite.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblspecialite.setBounds(190, 162, 180, 30);
        getContentPane().add(lblspecialite);
pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelNomResto;
    private JLabel lblNoteMoyene;
    private JLabel labelNote;
    private JLabel lblPrix;
    private JLabel lblspecialite;

}
