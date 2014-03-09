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
import com.abstractTeam.Model.Livraison;
import com.abstractTeam.Model.Restaurant;

public class LivraisonsDao {

	Connection connection;
	Connection connection2;
	Connection connection3;
	FactureDao gestion_facture = new FactureDao();
	public void AjouterLivraison(Livraison Livraison) {

		try {
			connection = ConnexionDB.getConnected();

			PreparedStatement req = connection
					.prepareStatement("insert into Livraisons(description, dateLivraison, idFacture, idClient , idResto) "
							+ "values(?,?,?,?)");
			req.setString(1, Livraison.getDescription());
			req.setDate(2, (Date) Livraison.getDateLivraison());
			req.setInt(3, Livraison.getFacture().getIdFacture());
			req.setInt(4, Livraison.getClient().getIdClient());
			req.setInt(5, Livraison.getRestaurant().getId());

			int s = req.executeUpdate();

			if (s > 0) {
				System.out.println("Livraison ajoutée !");

				// JOptionPane.showMessageDialog(rootPane,
				// "Uploaded successfully !");
			} else {
				System.out.println("ERROR : Livraison non ajoutée !");
			}

			connection.close();
		} catch (SQLException e) {

			System.out.println("ERROR SQL!");
			e.printStackTrace();
			return;
		}
	}

	public int ModifierLivraison(Livraison Livraison) {
		connection = ConnexionDB.getConnected();
		int x =0;
		System.out.println("livraison "+Livraison.getIdLivraison());
		try {
			Statement requete = connection.createStatement();
			String req = "UPDATE Livraisons SET description =  '"
					+ Livraison.getDescription() + "', dateLivraison='"
					
					+ Livraison.getDateLivraison() + "',etat='"+Livraison.getEtat()+"',idFacture="
					+ Livraison.getFacture().getIdFacture() + ",idClient="
					+ Livraison.getClient().getIdClient() + ",idResto="
					+ Livraison.getRestaurant().getId()
					+ " WHERE idLivraison="+Livraison.getIdLivraison()+"";

			 x =requete.executeUpdate(req);
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public int SupprimeLivraison(Livraison Livraison) {
		connection = ConnexionDB.getConnected();
		int x=0;
		try {
			Statement requete = connection.createStatement();
			String req = "DELETE FROM Livraisons WHERE  idLivraison ="
					+ Livraison.getIdLivraison();

			x=requete.executeUpdate(req);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public List<Livraison> findAllLivraisons() {
		List<Livraison> list = new ArrayList<Livraison>();
		try {
			connection = ConnexionDB.getConnected();
			Statement statLivraison = connection.createStatement();
			String req = "SELECT * FROM Livraisons ";
			ResultSet resLivraison = statLivraison.executeQuery(req);

			while (resLivraison.next()) {

				Livraison Livraison = new Livraison();

				Livraison.setIdLivraison(resLivraison.getInt(1));
				Livraison.setDescription(resLivraison.getString(2));
				Livraison.setDateLivraison(resLivraison.getDate(3));
				Livraison.setEtat(resLivraison.getString(4));
				// Facture ***********************
				Facture facture = new Facture();
				facture.setIdFacture(resLivraison.getInt(5));

				String reqFacture = "SELECT * FROM Factures WHERE idFacture = "
						+ facture.getIdFacture();

				Statement statFacture = connection.createStatement();
				ResultSet resFacture = statFacture.executeQuery(reqFacture);

				while (resFacture.next()) {
					facture.setSomme(resFacture.getDouble(2));
					facture.setDescription(resFacture.getString(3));
				}
				Livraison.setFacture(facture);

				// Client ***********************
				Client client = new Client();
				client.setIdClient(resLivraison.getInt(6));
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
					Livraison.setClient(client);
				}
				// restaurant ***********************
				Restaurant restaurant = new Restaurant();
				restaurant.setId(resLivraison.getInt(7));

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
					Livraison.setRestaurant(restaurant);
				}
				// plats ***********************
			
				PlatDao dao = new PlatDao();
				List<Plat> plats = new ArrayList<Plat>();
					plats=	dao.findPlatsByLivraison(Livraison.getIdLivraison());
				Livraison.setPlats(plats);
				
				Double somme = 0.0;
				//System.out.println(plats.get(0).getLabel());
			
				for (int j=0 ; j<plats.size();j++) {

					somme += plats.get(j).getPrix();

				}
				 Livraison.getFacture().setSomme(somme);

				int x = gestion_facture.ModifierFacture( Livraison.getFacture());

				list.add(Livraison);
			}

			connection.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	public Livraison findLivraisonById(int id) {
		Livraison Livraison = new Livraison();
		
		try {
			connection = ConnexionDB.getConnected();
			Statement statLivraison = connection.createStatement();
			String req = "SELECT * FROM Livraisons where idLivraison="+id;
			ResultSet resLivraison = statLivraison.executeQuery(req);

			while (resLivraison.next()) {
			

				

					Livraison.setIdLivraison(resLivraison.getInt(1));
					Livraison.setDescription(resLivraison.getString(2));
					Livraison.setDateLivraison(resLivraison.getDate(3));
					Livraison.setEtat(resLivraison.getString(4));
					// Facture ***********************
					Facture facture = new Facture();
					facture.setIdFacture(resLivraison.getInt(5));

					String reqFacture = "SELECT * FROM Factures WHERE idFacture = "
							+ facture.getIdFacture();

					Statement statFacture = connection.createStatement();
					ResultSet resFacture = statFacture.executeQuery(reqFacture);

					while (resFacture.next()) {
						facture.setSomme(resFacture.getDouble(2));
						facture.setDescription(resFacture.getString(3));
					}
					Livraison.setFacture(facture);

					// Client ***********************
					Client client = new Client();
					client.setIdClient(resLivraison.getInt(6));
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
						Livraison.setClient(client);
					}
					// restaurant ***********************
					Restaurant restaurant = new Restaurant();
					restaurant.setId(resLivraison.getInt(7));

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
						Livraison.setRestaurant(restaurant);
					}
					// plats ***********************
					Plat plat = new Plat();
					PlatDao dao = new PlatDao();
					List<Plat> plats = dao.findPlatsByLivraison(resLivraison
							.getInt(7));
					Livraison.setPlats(plats);
				//	list.add(Livraison);
				}

				connection.close();
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			return Livraison;
		}
}