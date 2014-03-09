package com.abstractTeam.IHM.GestionLivraison;





import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.event.DateSelectionEvent;
import org.jdesktop.swingx.event.DateSelectionListener;

import com.abstractTeam.Controller.LivraisonsDao;
import com.abstractTeam.IHM.ApplicationFrame;
import com.abstractTeam.Model.Livraison;
import com.abstractTeam.Model.Reservation;

@SuppressWarnings("serial")
public class PanelLivraison extends JPanel {

	JLabel lblNewLabel_1 = new JLabel("");
	public static Reservation LivraisonSelected = null;
	public static JPanel panel;
	Date date ;


	/**
	 * Create the panel.
	 */
	
	 private Image backgroundImage;

	
	@SuppressWarnings("deprecation")
     public PanelLivraison(String fileName) {
		 
		
		    try {
				backgroundImage = ImageIO.read(new File(fileName));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  

		
		  
		
		setBackground(Color.WHITE);

		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(192, 192, 192)), "Gestion Reservations  - Resto-Tunisie -", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		setBounds(337, 76, 1013, 611);
		setLayout(null);

		Date d = new Date();

		LivraisonsDao livDAO = new LivraisonsDao();
		List<Livraison> liste = new ArrayList<Livraison>();
		liste = livDAO.findAllLivraisons();
		int i = 0;
		int j = 0;
		int k = 0;
		for (Livraison liv : liste) {
			if (liv.getDateLivraison().compareTo(d) == 1) {
				if (liv.getEtat().equals("en attente"))
					i++;
				if (liv.getEtat().equals("valide"))
					j++;
				if (liv.getEtat().equals("refuse"))
					k++;
			}
		}

		JLabel lblNewLabel_4 = new JLabel("Vous avez : ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(674, 39, 61, 14);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("" + i);
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setBounds(741, 76, 22, 14);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("livraisons en attente");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(765, 76, 178, 14);
		add(lblNewLabel_6);

		final JXMonthView mv = new JXMonthView();
		mv.setBackground(Color.LIGHT_GRAY);
		mv.setBounds(10, 194, 991, 389);
		add(mv);
		
		JLabel lblRservationsValides = new JLabel("livraisons valid\u00E9es");
		lblRservationsValides.setForeground(Color.WHITE);
		lblRservationsValides.setBounds(765, 98, 178, 14);
		add(lblRservationsValides);
		
		JLabel lblRservationsRefuses = new JLabel("livraisons refus\u00E9es");
		lblRservationsRefuses.setForeground(Color.WHITE);
		lblRservationsRefuses.setBounds(765, 123, 178, 14);
		add(lblRservationsRefuses);
		
		JLabel label_2 = new JLabel(""+j);
		label_2.setForeground(Color.GREEN);
		label_2.setBounds(741, 98, 22, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel(""+k);
		label_3.setForeground(Color.RED);
		label_3.setBounds(741, 123, 22, 14);
		add(label_3);
		
		JButton btnNewButton = new JButton("Consulter les Livraisons en d\u00E9tails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new TableLivraisons(new String("img/liv.jpg"));

				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
			}
		});
		btnNewButton.setBounds(311, 160, 239, 23);
		add(btnNewButton);
		liste = livDAO.findAllLivraisons();
		
		for (final Livraison reservation : liste) {
		 date = new Date(reservation.getDateLivraison().getYear(), reservation
					.getDateLivraison().getMonth(), reservation.getDateLivraison().getDate(),5,5);
		
			mv.addFlaggedDates(date);
			// mv.setFlaggedDayForeground(Color.GRAY);

			
			if (reservation.getEtat().equals("en attente")) {

				// mv.setFlaggedDayForeground(Color.ORANGE);
				mv.setSelectionBackground(Color.ORANGE);
				mv.repaint();
				mv.revalidate();

			}
			if (reservation.getEtat().equals("valide")) {

				mv.setFlaggedDayForeground(Color.GREEN);
				mv.setSelectionBackground(Color.GREEN);
				mv.repaint();
				mv.revalidate();
			}
			if (reservation.getEtat().equals("refuse")) {

				mv.setFlaggedDayForeground(Color.RED);
				mv.setSelectionBackground(Color.RED);
				mv.repaint();
				mv.revalidate();

			}
		
			
			
		
		
		}
		
		mv.getSelectionModel().addDateSelectionListener(
				new DateSelectionListener() {

					
					
				
					public void valueChanged(DateSelectionEvent e) {

							
							
						SortedSet<Date> Fdates = mv.getFlaggedDates();
						
						for ( Date date : Fdates) {
							
						if ( date.equals(e.getSelection().first()))
						{
							//	reservationSelected = reservation;
							
//								reservationSelected=
//							System.out.println("Frame Réservation opened");
//							FrameReservation frame = new FrameReservation();
//							frame.setVisible(true);
//							frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							JOptionPane.showMessageDialog(null, "Réservation pour le "+date.getDate()+" "+date.getMonth()+" ,"+date.getYear());
						}
							}

						}
					});
		// mv.setZoomable(true);
		mv.updateUI();

		setVisible(true);
	}
	  public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    // Draw the background image.
		    g.drawImage(backgroundImage, 0, 0, this);
		  }
}
