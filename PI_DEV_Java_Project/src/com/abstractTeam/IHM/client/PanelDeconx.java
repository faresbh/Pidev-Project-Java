package com.abstractTeam.IHM.client;



import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelDeconx extends JPanel {
	 public static JPanel panelLeftTop;
		public static JPanel panelLeftBottom ;
	
		public static JPanel panelContenu;
		
		public static Container content;
		public static JTree tree;
		public static Thread thread;

	    private Rectangle2D rect;
	    private Timer timer;
	 
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelDeconx() {
		 {
			setBounds(337, 76, 1013, 611);
	
	   
		setBackground(Color.LIGHT_GRAY);
    	setForeground(Color.LIGHT_GRAY);
    	FlowLayout flowLayout = (FlowLayout) getLayout();
    	flowLayout.setAlignment(FlowLayout.CENTER);
    //	this.setBounds(50, 50, 600, 464);
    	
    	JLabel label = new JLabel("\r\n");
    	label.setIcon(new ImageIcon(PanelDeconx.class.getResource("/images/Boisson.png")));
    	label.setVerticalAlignment(SwingConstants.TOP);
    	label.setHorizontalAlignment(SwingConstants.CENTER);
    	label.setForeground(Color.LIGHT_GRAY);
    	label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
    	label.setBackground(SystemColor.textHighlight);
    	add(label);
    	
    	JLabel lblNewLabel = new JLabel("          \r\n Cher(e) client(e)  merci pour votre visite !  au revoir !!!\r");
    	lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
    	lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
    	lblNewLabel.setBackground(SystemColor.textHighlight);
    	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel.setForeground(Color.LIGHT_GRAY);
    	add(lblNewLabel);
    	
    
    	
    
		
		
        rect = new Rectangle2D.Float(200,200,250,250);
        super.setBackground(Color.WHITE);
        timer = new Timer(20,new ActionListener() {
 
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("hello width: "+rect.getWidth());
                if(rect.getWidth()> 0) {
 
                    rect.setRect(rect.getBounds2D().getX()+1, rect.getBounds2D().getY()+1, rect.getBounds2D().getWidth()-2, rect.getBounds2D().getHeight()-2) ;
                } else {
                    timer.stop();
                }                
                repaint();
            }
        });
        timer.start();
	  } 

	
	}
	
	   protected void paintComponent(Graphics arg0) {    
	        super.paintComponent(arg0);
	        System.out.println(rect);
	        Graphics2D g2d = (Graphics2D) arg0;
	        g2d.setPaint(Color.LIGHT_GRAY);
	        
	        g2d.fill(rect);
	 
	    }
	    
	 
	    
	
	
}