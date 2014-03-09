package com.abstractTeam.Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Client;
import com.abstractTeam.Model.Facture;
import com.abstractTeam.Model.Plat;
import com.abstractTeam.Model.Positiongeo;
import com.abstractTeam.Model.Reservation;
import com.abstractTeam.Model.Restaurant;


public class ReservationsDao {

	Connection connection;
	Connection connection2;
	Connection connection3;
	FactureDao gestion_facture = new FactureDao();
	public void AjouterReservation(Reservation reservation) {

		try {
			connection = MyConnection.getInstance();

			PreparedStatement req = connection
					.prepareStatement("insert into reservations(choix, date, idFacture, idClient , idResto) "
							+ "values(?,?,?,?)");
			req.setString(1, reservation.getChoix());
			req.setDate(2, (Date) reservation.getDate());
			req.setInt(3, reservation.getFacture().getIdFacture());
			req.setInt(4, reservation.getClient().getIdClient());
			req.setInt(5, reservation.getRestaurant().getId());

			int s = req.executeUpdate();

			if (s > 0) {
				System.out.println("reservation ajoutée !");

				// JOptionPane.showMessageDialog(rootPane,
				// "Uploaded successfully !");
			} else {
				System.out.println("ERROR : reservation non ajoutée !");
			}

			connection.close();
		} catch (SQLException e) {

			System.out.println("ERROR SQL!");
			e.printStackTrace();
			return;
		}
	}

	public int ModifierReservation(Reservation reservation) {
		connection = MyConnection.getInstance();
		int x =0;
		try {
			Statement requete = connection.createStatement();
			String req = "UPDATE Reservations SET choix =  '"
					+ reservation.getChoix() + "', date='"
					
					+ reservation.getDate() + "',etat='"+reservation.getEtat()+"',idFacture="
					+ reservation.getFacture().getIdFacture() + ",idClient="
					+ reservation.getClient().getIdClient() + ",idResto="
					+ reservation.getRestaurant().getId()
					+ " WHERE idReservation="+reservation.getIdReservation()+"";

			 x =requete.executeUpdate(req);
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public int SupprimeReservation(Reservation reservation) {
		connection = MyConnection.getInstance();
		int x=0;
		try {
			Statement requete = connection.createStatement();
			String req = "DELETE FROM Reservations WHERE  idReservation ="
					+ reservation.getIdReservation();

			x=requete.executeUpdate(req);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public List<Reservation> findAllReservations() {
		List<Reservation> list = new ArrayList<Reservation>();
		try {
			connection = MyConnection.getInstance();
			Statement statReservation = connection.createStatement();
			String req = "SELECT * FROM reservations ";
			ResultSet resReservation = statReservation.executeQuery(req);

			while (resReservation.next()) {

				Reservation reservation = new Reservation();

				reservation.setIdReservation(resReservation.getInt(1));
				reservation.setChoix(resReservation.getString(2));
				reservation.setDate(resReservation.getDate(3));
				reservation.setEtat(resReservation.getString(4));
				// Facture ***********************
				Facture facture = new Facture();
				facture.setIdFacture(resReservation.getInt(5));

				String reqFacture = "SELECT * FROM Factures WHERE idFacture = "
						+ facture.getIdFacture();

				Statement statFacture = connection.createStatement();
				ResultSet resFacture = statFacture.executeQuery(reqFacture);

				while (resFacture.next()) {
					facture.setSomme(resFacture.getDouble(2));
					facture.setDescription(resFacture.getString(3));
				}
				reservation.setFacture(facture);

				// Client ***********************
				Client client = new Client();
				client.setIdClient(resReservation.getInt(6));
				String reqClient = "SELECT * FROM Clients WHERE idClient = "
						+ client.getIdClient();
				Statement statClient = connection.createStatement();
				ResultSet resClient = statClient.executeQuery(reqClient);
				while (resClient.next()) {
					client.setNom(resClient.getString(2));
					client.setPrenom(resClient.getString(3));
					client.setMail(resClient.getString(4));
					client.setMdp(resClient.getString(5));
					client.setAdresse(resClient.getString(6));
					client.setTel(resClient.getString(7));

					// position geo client ***********************
					Positiongeo positiongeo = new Positiongeo();
					positiongeo.setIdGeo(resClient.getInt(8));

					String reqPos = "SELECT * FROM positiongeo WHERE id_geo = "
							+ positiongeo.getIdGeo();

					Statement statPos = connection.createStatement();
					ResultSet resPos = statPos.executeQuery(reqPos);
					while (resPos.next()) {
						positiongeo.setAbs(resPos.getDouble(2));
						positiongeo.setOrd(resPos.getDouble(3));
						// System.out.println(positiongeo.getAbs());
						client.setPositiongeo(positiongeo);
					}
					reservation.setClient(client);
				}
				// restaurant ***********************
				Restaurant restaurant = new Restaurant();
				restaurant.setId(resReservation.getInt(7));

				String reqResto = "SELECT * FROM restaurants WHERE id= "
						+ restaurant.getId();

				Statement statResto = connection.createStatement();
				ResultSet resResto = statResto.executeQuery(reqResto);
				while (resResto.next()) {
					restaurant.setNom(resResto.getString(2));
					restaurant.setAdresse(resResto.getString(3));
					restaurant.setNbrTable(resResto.getInt(4));
					restaurant.setSpecialite(resResto.getString(5));
					restaurant.setNote(resResto.getDouble(6));
					// System.out.println(restaurant.getAdresse());
					reservation.setRestaurant(restaurant);
				}
				// plats ***********************
			
				PlatDao dao = new PlatDao();
				List<Plat> plats = new ArrayList<Plat>();
					plats=	dao.findPlatsByReservation(reservation.getIdReservation());
				reservation.setPlats(plats);
				
				Double somme = 0.0;
				//System.out.println(plats.get(0).getLabel());
			
				for (int j=0 ; j<plats.size();j++) {

					somme += plats.get(j).getPrix();

				}
				 reservation.getFacture().setSomme(somme);

				int x = gestion_facture.ModifierFacture( reservation.getFacture());

				list.add(reservation);
			}

			connection.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	public Reservation findReservationById(int id) {
		Reservation reservation = new Reservation();
		
		try {
			connection = MyConnection.getInstance();
			Statement statReservation = connection.createStatement();
			String req = "SELECT * FROM reservations where idReservation="+id;
			ResultSet resReservation = statReservation.executeQuery(req);

			while (resReservation.next()) {
			

				

					reservation.setIdReservation(resReservation.getInt(1));
					reservation.setChoix(resReservation.getString(2));
					reservation.setDate(resReservation.getDate(3));
					reservation.setEtat(resReservation.getString(4));
					// Facture ***********************
					Facture facture = new Facture();
					facture.setIdFacture(resReservation.getInt(5));

					String reqFacture = "SELECT * FROM Factures WHERE idFacture = "
							+ facture.getIdFacture();

					Statement statFacture = connection.createStatement();
					ResultSet resFacture = statFacture.executeQuery(reqFacture);

					while (resFacture.next()) {
						facture.setSomme(resFacture.getDouble(2));
						facture.setDescription(resFacture.getString(3));
					}
					reservation.setFacture(facture);

					// Client ***********************
					Client client = new Client();
					client.setIdClient(resReservation.getInt(6));
					String reqClient = "SELECT * FROM Clients WHERE idClient = "
							+ client.getIdClient();
					Statement statClient = connection.createStatement();
					ResultSet resClient = statClient.executeQuery(reqClient);
					while (resClient.next()) {
						client.setNom(resClient.getString(2));
						client.setPrenom(resClient.getString(3));
						client.setMail(resClient.getString(4));
						client.setMdp(resClient.getString(5));
						client.setAdresse(resClient.getString(6));
						client.setTel(resClient.getString(7));

						// position geo client ***********************
						Positiongeo positiongeo = new Positiongeo();
						positiongeo.setIdGeo(resClient.getInt(8));

						String reqPos = "SELECT * FROM positiongeo WHERE id_geo = "
								+ positiongeo.getIdGeo();

						Statement statPos = connection.createStatement();
						ResultSet resPos = statPos.executeQuery(reqPos);
						while (resPos.next()) {
							positiongeo.setAbs(resPos.getDouble(2));
							positiongeo.setOrd(resPos.getDouble(3));
							// System.out.println(positiongeo.getAbs());
							client.setPositiongeo(positiongeo);
						}
						reservation.setClient(client);
					}
					// restaurant ***********************
					Restaurant restaurant = new Restaurant();
					restaurant.setId(resReservation.getInt(7));

					String reqResto = "SELECT * FROM restaurants WHERE id= "
							+ restaurant.getId();

					Statement statResto = connection.createStatement();
					ResultSet resResto = statResto.executeQuery(reqResto);
					while (resResto.next()) {
						restaurant.setNom(resResto.getString(2));
						restaurant.setAdresse(resResto.getString(3));
						restaurant.setNbrTable(resResto.getInt(4));
						restaurant.setSpecialite(resResto.getString(5));
						restaurant.setNote(resResto.getDouble(6));
						// System.out.println(restaurant.getAdresse());
						reservation.setRestaurant(restaurant);
					}
					// plats ***********************
					Plat plat = new Plat();
					PlatDao dao = new PlatDao();
					List<Plat> plats = dao.findPlatsByReservation(resReservation
							.getInt(7));
					reservation.setPlats(plats);
				//	list.add(reservation);
				}

				connection.close();
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			return reservation;
		}

	
}