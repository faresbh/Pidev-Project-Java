package com.abstractTeam.Controller;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OptionMessage {
	static ImageIcon iconOk = new ImageIcon("icon\\ok.png");

static	ImageIcon iconNo = new ImageIcon("icon\\annul.png");
	static ImageIcon iconInfo = new ImageIcon("icon\\info.png");

	public OptionMessage() {
		super();

		Image imgOk = iconOk.getImage();
		Image newimgOk = imgOk.getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		iconOk = new ImageIcon(newimgOk);

		Image imgNo = iconNo.getImage();
		Image newimgNo = imgNo.getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		iconNo = new ImageIcon(newimgNo);

		Image imgInfo = iconInfo.getImage();
		Image newimgInfo = imgInfo.getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		iconInfo = new ImageIcon(newimgInfo);
	}

	public static int messageInfo(String titre,String contenue) {
		return JOptionPane.showOptionDialog(null,
				
				contenue,  titre,JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, iconInfo, null, null);
	}

	public static void messageWarning(String titre,String contenue) {
		 JOptionPane.showMessageDialog(null,contenue,  titre,JOptionPane.OK_OPTION, iconNo );
	}
	public static void messageOk(String titre,String contenue){
		JOptionPane.showMessageDialog(null, contenue, titre, JOptionPane.OK_OPTION, iconOk);
	}

}
