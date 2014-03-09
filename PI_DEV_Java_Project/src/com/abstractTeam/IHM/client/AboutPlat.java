package com.abstractTeam.IHM.client;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

import com.abstractTeam.Model.Plat;

import java.awt.Toolkit;



public class AboutPlat extends JFrame {
public Plat plat;
    
    public AboutPlat(Plat plat) {
    	this.plat=plat;
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AboutPlat.class.getResource("/images/objects.png")));
        initComponents();
        setVisible(true);
        setBounds(100, 100, 410, 444);
    }
//  public static void main(String[] args) {
//        
//        new AboutPlat();
//      
//        
//    }
    

    private void initComponents() {
setVisible(true);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();  
   
        jLabelImage.setIcon(new ImageIcon(plat.getPhotos().get(0).getUrl()));
        jLabelNom = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(true);

        setResizable(true);
        setTitle("About Plat");
        setSize(132,188);
        setMinimumSize(null);
    
        setVisible(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Nom Plat :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 120, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Image");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 204, 70, 30);

        jLabelImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage.setForeground(new java.awt.Color(128, 128, 128));
        getContentPane().add(jLabelImage);
        jLabelImage.setBounds(124, 204, 246, 179);

        jLabelNom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNom.setForeground(new java.awt.Color(128, 128, 128));
        jLabelNom.setText(plat.getLabel());
        getContentPane().add(jLabelNom);
        jLabelNom.setBounds(190, 34, 140, 20);
        
        lblNoteMoyene = new JLabel();
        lblNoteMoyene.setText("Note moyene");
        lblNoteMoyene.setForeground(Color.BLUE);
        lblNoteMoyene.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNoteMoyene.setBounds(30, 121, 120, 30);
        getContentPane().add(lblNoteMoyene);
        
        labelNote = new JLabel();
        labelNote.setText(plat.getNote()+"");
        labelNote.setForeground(Color.GRAY);
        labelNote.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNote.setBounds(190, 121, 180, 30);
        getContentPane().add(labelNote);
        
        lblPrix = new JLabel();
        lblPrix.setText("Prix");
        lblPrix.setForeground(Color.BLUE);
        lblPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrix.setBounds(30, 157, 120, 30);
        getContentPane().add(lblPrix);
        
        lbldtPrix = new JLabel();
        lbldtPrix.setText(plat.getPrix()+"");
        lbldtPrix.setForeground(Color.GRAY);
        lbldtPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbldtPrix.setBounds(190, 162, 180, 30);
        getContentPane().add(lbldtPrix);

    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelNom;
    private JLabel lblNoteMoyene;
    private JLabel labelNote;
    private JLabel lblPrix;
    private JLabel lbldtPrix;
  
}
