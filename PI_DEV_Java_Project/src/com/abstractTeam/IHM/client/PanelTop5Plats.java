package com.abstractTeam.IHM.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.Legend;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.DefaultPieDataset;

import com.abstractTeam.Controller.NoteDao;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Model.ComparateurPlat;
import com.abstractTeam.Model.Note;
import com.abstractTeam.Model.Plat;

@SuppressWarnings("serial")
public class PanelTop5Plats extends JPanel {
	private final JPanel contentPanel = new JPanel();

	List<Note> listNotes = new ArrayList<Note>();

	/**
	 * Create the panel.
	 */
	public PanelTop5Plats() {
		{
			setBounds(337, 76, 1013, 611);

			DefaultPieDataset pieDataset = new DefaultPieDataset();
			PlatDao dao = new PlatDao();
			List<Plat> plats = new ArrayList<Plat>();

			NoteDao noteDao = new NoteDao();
			plats = dao.DisplayAllStocks();

			Collections.sort(plats, new ComparateurPlat());

			int i = 0;

			for (Plat plat : plats) {

				if ((i < 5) && (existe(plat.getId())))

				{
					i++;
					System.out.println(plat.getLabel());
					pieDataset.setValue(plat.getLabel(),
							noteDao.calculMoy(plat.getId()));
				}
			}
			JFreeChart pieChart = ChartFactory.createPieChart3D("TOP 5 PLATS",
					pieDataset, true, true, true);
			PiePlot piePlot = (PiePlot) pieChart.getPlot();
			piePlot.setExplodePercent(1, 0.5);
			Legend legend = pieChart.getLegend();
			legend.setAnchor(Legend.EAST_NORTHEAST);
			ChartPanel cPanel = new ChartPanel(pieChart);

			File fichier = new File("image.png");
			try {
				ChartUtilities.saveChartAsPNG(fichier, pieChart, 400, 250);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.add(cPanel);
		}
	}

	public boolean existe(int idRest) {
		NoteDao noteDao = new NoteDao();
		listNotes = noteDao.DisplayAllnotePlat(idRest);
		if (listNotes.isEmpty())
			return false;
		return true;

	}

}