package com.abstractTeam.IHM.client;



import java.awt.Color;
import java.awt.Font;


import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelContenu extends JPanel {


	JLabel lblNewLabel_1 = new JLabel("");

	/**
	 * Create the panel.
	 */
	public PanelContenu() {
		setBackground(Color.WHITE);
		
		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)),
				"Acceuil  - Resto-Tunisie -", TitledBorder.LEADING,
				TitledBorder.TOP, new Font(" Arial ", Font.BOLD, 15),
				Color.DARK_GRAY));
		setBounds(337, 76, 1013, 611);

		setLayout(null);
		setVisible(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(PanelContenu.class.getResource("/images/restaurant-sentido-rosa-beach_118145_pgbighd.jpg")));
		lblNewLabel_1.setBounds(159, 83, 627, 298);
		
	
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(PanelContenu.class.getResource("/images/299735_343907955726029_996262332_n.jpg")));
		lblNewLabel.setBounds(107, 418, 832, 182);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Retrouvez votre plat tunisien \r\npr\u00EAt de chez vous \r\n en un simple clic!");
		label.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(182, -101, 627, 298);
		add(label);
		
		
	}
}
