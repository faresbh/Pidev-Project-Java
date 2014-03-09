package com.abstractTeam.IHM.client;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelLeftTop extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLeftTop() {
		setBackground(Color.WHITE);

		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)), "Accueil",
				TitledBorder.LEFT, TitledBorder.TOP, new Font(" Arial ",
						Font.BOLD, 15), new Color(64, 64, 64)));
		setBounds(0, 75, 337, 301);
		setLayout(null);
		JLabel lblVousPouvezAccder = new JLabel(
				"<html>Bienvenue \u00E0 votre espace personnel <br>     \r\ndans Resto - Tunisie </html>");
		lblVousPouvezAccder.setVerticalAlignment(SwingConstants.BOTTOM);
		lblVousPouvezAccder.setIcon(null);
		lblVousPouvezAccder.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblVousPouvezAccder.setForeground(Color.RED);
		lblVousPouvezAccder.setBackground(Color.PINK);
		lblVousPouvezAccder.setHorizontalAlignment(SwingConstants.CENTER);
		lblVousPouvezAccder.setBounds(32, 26, 305, 32);

		add(lblVousPouvezAccder);

		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(207, 93, 46, 32);
		add(lblNewLabel);

		JLabel label_nomText = new JLabel("");
		label_nomText.setBounds(106, 230, 46, 14);
		add(label_nomText);

		JLabel label_EspaceText = new JLabel("");
		label_EspaceText.setBounds(107, 255, 46, 14);
		add(label_EspaceText);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(PanelLeftTop.class.getResource("/images/mgaref.png")));
		label.setBounds(20, 58, 307, 232);
		add(label);
		setVisible(true);
	}
}
