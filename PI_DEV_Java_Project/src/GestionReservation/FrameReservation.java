package GestionReservation;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import org.jdesktop.swingx.JXDatePicker;

import com.abstractTeam.Controller.GenererPDFLivraison;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Controller.ReservationsDao;
import com.abstractTeam.IHM.ApplicationFrame;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Reservation;

public class FrameReservation extends JFrame {

	/**
	 * 
	 */

	public static JPanel contentPane;
	public static JPanel panel = new JPanel();
	final JXDatePicker datePicker = new JXDatePicker();
	ReservationsDao dao = new ReservationsDao();
	List<Plat> plats = new ArrayList<Plat>();
	PlatDao platsDAO = new PlatDao();

	/**
	 * Create the frame.
	 * 
	 * @param reservation
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameReservation window = new FrameReservation(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameReservation(final Reservation reservation) {

		setTitle("D\u00E9tails R\u00E9servation\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("R\u00E9servation Num\u00E9ro :");
		lblNewLabel.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 24));
		lblNewLabel.setBounds(24, 23, 299, 67);
		contentPane.add(lblNewLabel);

		JLabel numLabel = new JLabel("");
		numLabel.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 24));
		numLabel.setBounds(333, 44, 62, 25);
		numLabel.setText(reservation.getIdReservation() + "");
		contentPane.add(numLabel);

		JButton btnNewButton = new JButton("Accepter");
		btnNewButton.setIcon(new ImageIcon("img/ok.png"));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Date date = null;
				int x = 0;
				java.sql.Date dd = new java.sql.Date(datePicker.getDate()
						.getYear(), datePicker.getDate().getMonth(), datePicker
						.getDate().getDate());

				int reponse = JOptionPane.showConfirmDialog(null,
						"souhaitez vous modifier la date de cette réservation du "
								+ reservation.getDate() + " au " + dd + " ?");

				if (JOptionPane.YES_OPTION == reponse) {

					reservation.setDate(dd);
					reservation.setEtat("valide");
					x = dao.ModifierReservation(reservation);
					if (x == 1) {
						JOptionPane.showMessageDialog(null,
								"modification de la date avec succés");

					}
					if (x != 1 && x != 0) {
						JOptionPane.showMessageDialog(null,
								"Erreur lors de la modification", "Error", 0,
								null);

					}
				}
				panel.removeAll();
				chargerPanel(reservation);
				panel.repaint();
				panel.revalidate();
			}

		});
		btnNewButton.setBounds(136, 410, 114, 44);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("R\u00E9fuser");
		btnNewButton_1.setIcon(new ImageIcon("img/notok.png"));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (reservation.getEtat().equals("refuse")) {
					int x = 0;

					int reponse = JOptionPane
							.showConfirmDialog(
									null,
									"cette réservation est dèja refusée voulez vous la supprimer ?",
									"Suppression", JOptionPane.YES_NO_OPTION);
					if (JOptionPane.YES_OPTION == reponse) {
						x = dao.SupprimeReservation(reservation);
						if (x == 1) {
							JOptionPane.showMessageDialog(null,
									"suppresion de la date avec succés");

							TableReservations.frame.dispose();
							ApplicationFrame.content
									.remove(ApplicationFrame.panelContenu);
							ApplicationFrame.panelContenu = new TableReservations(
									new String("img/fourchette.jpg"));

							ApplicationFrame.content
									.add(ApplicationFrame.panelContenu);
							ApplicationFrame.content.validate();
							ApplicationFrame.content.repaint();

						}
						if (x != 1 && x != 0) {
							JOptionPane.showMessageDialog(null,
									"Erreur lors de la suppression", "Error",
									0, null);
						}

					}
				} else {
					reservation.setEtat("refuse");
					// JOptionPane.showMessageDialog(null,
					// "refus de la réservation avec succés","refus", 1);
					int x = dao.ModifierReservation(reservation);
					if (x == 1) {
						JOptionPane.showMessageDialog(null,
								"refus de la réservation avec succés", "refus",
								1);
					} else {
						JOptionPane.showMessageDialog(null,
								"Erreur lors de la modification", "Error", 0,
								null);

					}
				}
				panel.removeAll();
				chargerPanel(reservation);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton_1.setBounds(260, 410, 114, 44);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Valeurs initiaux");
		btnNewButton_2.setIcon(new ImageIcon("img/def.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				chargerPanel(reservation);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton_2.setBounds(384, 410, 155, 44);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("G\u00E9n\u00E9rer Facture");
		btnNewButton_3.setIcon(new ImageIcon("img/pdf.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GenererPDF frame = new GenererPDF(reservation);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(620, 345, 174, 51);
		contentPane.add(btnNewButton_3);

		chargerPanel(reservation);

		setLocationRelativeTo(null);

		FrameReservation.this.repaint();
		FrameReservation.this.revalidate();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void chargerPanel(final Reservation reservation) {
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBounds(24, 104, 559, 270);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Date : ");
		lblNewLabel_2.setBounds(23, 202, 33, 14);
		panel.add(lblNewLabel_2);

		datePicker.setBounds(185, 198, 231, 22);
		panel.add(datePicker);

		datePicker.setBackground(Color.RED);

		datePicker.setDate(reservation.getDate());
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JXDatePicker.COMMIT_KEY.equals(e.getActionCommand())) {
					datePicker.setDate(datePicker.getDate());
				}
			}
		};
		datePicker.addActionListener(l);

		JLabel choix = new JLabel("Choix :");
		choix.setBounds(23, 109, 46, 14);
		panel.add(choix);

		JLabel choixLabel = new JLabel("");
		choixLabel.setBounds(185, 109, 105, 14);
		panel.add(choixLabel);
		choixLabel.setText(reservation.getChoix());
		JLabel lblClient = new JLabel("Client : ");
		lblClient.setBounds(23, 70, 46, 14);
		panel.add(lblClient);

		JLabel clientLabel = new JLabel("");
		clientLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		clientLabel.setForeground(Color.BLUE);
		clientLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				panel.removeAll();
				JLabel icone = new JLabel("");
				icone.setIcon(new ImageIcon("img/icone_retour.png"));
				icone.setBounds(477, 11, 46, 36);
				icone.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {

						panel.removeAll();
						chargerPanel(reservation);
						panel.repaint();
						panel.revalidate();

					}

				});

				panel.repaint();
				JLabel linf = new JLabel("Informations sur le Client ");
				linf.setBounds(50, 10, 250, 14);
				linf.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 15));

				JLabel lnom = new JLabel("nom :");
				lnom.setBounds(10, 50, 46, 14);

				JLabel nom = new JLabel("");
				nom.setBounds(84, 50, 161, 14);
				nom.setText(reservation.getClient().getNom());

				JLabel lprenom = new JLabel("prenom :");
				lprenom.setBounds(10, 75, 55, 14);

				JLabel prenom = new JLabel("");
				prenom.setBounds(84, 75, 161, 14);
				prenom.setText(reservation.getClient().getPrenom());

				JLabel ladr = new JLabel("adresse :");
				ladr.setBounds(10, 100, 55, 14);

				JLabel adr = new JLabel("");
				adr.setBounds(84, 100, 161, 14);
				adr.setText(reservation.getClient().getAdresse());

				JLabel ltel = new JLabel("téléphone :");
				ltel.setBounds(10, 125, 70, 14);

				JLabel tel = new JLabel("");
				tel.setBounds(84, 125, 161, 14);
				tel.setText(reservation.getClient().getTel());

				// /

				panel.add(linf);
				panel.add(icone);
				panel.add(ladr);
				panel.add(adr);
				panel.add(tel);
				panel.add(ltel);

				panel.add(prenom);
				panel.add(lprenom);
				panel.add(nom);
				panel.add(lnom);
				panel.revalidate();

			}
		});
		clientLabel.setBounds(185, 70, 161, 14);

		clientLabel.setText("<html> <u>" + reservation.getClient().getNom()
				+ "</u></html>");
		panel.add(clientLabel);

		JLabel lblListeDesPlats = new JLabel("Liste des plats :");
		lblListeDesPlats.setBounds(21, 155, 89, 14);
		panel.add(lblListeDesPlats);

		
		plats = platsDAO.findPlatsByReservation(reservation.getIdReservation());

		String[] platsLabel = new String[plats.size()];

		for (int i = 0; i < plats.size(); i++) {
			platsLabel[i] = plats.get(i).getLabel();
		}

		DefaultComboBoxModel model = new DefaultComboBoxModel();
		JComboBox combo = new JComboBox();
			combo.setModel(model);
			for (int i = 0; i < plats.size(); i++) {
				model.addElement(platsLabel[i]);
				
			}
		combo.setBounds(185, 152, 231, 20);
		panel.add(combo);

		JLabel lblRservation = new JLabel("R\u00E9servation ");
		lblRservation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRservation.setForeground(Color.BLACK);
		lblRservation.setBounds(335, 26, 90, 14);
		panel.add(lblRservation);
		JLabel label = new JLabel("en attente");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		if (reservation.getEtat().equals("valide")) {
			label.setText("validée");
			label.setForeground(Color.GREEN);
		}
		if (reservation.getEtat().equals("refuse")) {
			label.setText("refusée");
			label.setForeground(Color.RED);
		}
		label.setBounds(425, 26, 89, 14);
		panel.add(label);

		JLabel lblSomme = new JLabel("Somme : ");
		lblSomme.setBounds(23, 245, 61, 14);
		panel.add(lblSomme);

		JLabel lblD = new JLabel("");
		lblD.setBounds(185, 245, 118, 14);
		lblD.setText(reservation.getFacture().getSomme() + " DT");
		panel.add(lblD);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/couteau.jpg"));
		lblNewLabel_1.setBounds(593, 11, 175, 270);
		contentPane.add(lblNewLabel_1);

		JButton btnNotifierLeClient = new JButton("Notifier Le Client");
		btnNotifierLeClient.setIcon(new ImageIcon("img/mail.png"));
		btnNotifierLeClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				if ( reservation.getEtat().equals("valide"))
				{
				final String username = "espritabstractteam@gmail.com";
				final String password = "abstractteam";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});

				try {

					Message message = new MimeMessage(session);
					
					
					message.setFrom(new InternetAddress(
							"espritabstractteam@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(reservation.getClient().getMail()));
					message.setSubject("Réservation acceptée pour le "+ reservation.getDate());
				

					// message.setFileName()

					MimeMultipart mmp = new MimeMultipart();

					MimeBodyPart mbp = new MimeBodyPart();
					File f = new File("doc/facture/factureRes.pdf");
					FileDataSource fds = new FileDataSource(f);
					mbp.setDataHandler(new DataHandler(fds));
					mbp.setFileName(fds.getName());
					String s = fds.getName();
					mmp.addBodyPart(mbp);
					message.setText("Votre demande de réservation pour le "
							+ reservation.getDate()
							+ " a été acceptée ci-joint votre facture  ");
					message.setContent(mmp);
					
					Transport.send(message);
					System.out.println("Done");
					JOptionPane.showMessageDialog(null, "Un Mail est envoyé à l'adresse mail du client");

				} catch (MessagingException e) {
					e.printStackTrace();
				}// TODO Auto-generated method stub
			}
				else 
				{
					JOptionPane.showMessageDialog(null, "cette réservation n'est pas acceptée ");
				}
			}
			

		});
		btnNotifierLeClient.setBounds(620, 407, 174, 51);
		contentPane.add(btnNotifierLeClient);

		datePicker.setVisible(true);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				panel.removeAll();
				// chargerPanel(reservation);
				panel.repaint();
				panel.revalidate();

			}
		});

	}

	// public void JoinFile(String path) {
	// try {
	// MimeMultipart mmp = new MimeMultipart();
	//
	// MimeBodyPart mbp = new MimeBodyPart();
	// File f = new File(path);
	// FileDataSource fds = new FileDataSource(f);
	// mbp.setDataHandler(new DataHandler(fds));
	// mbp.setFileName(fds.getName());
	// String s = fds.getName();
	// mmp.addBodyPart(mbp);
	//
	// message.setContent(mmp);
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// }
}
