package GestionReservation;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.abstractTeam.Controller.ReservationsDao;
import com.abstractTeam.Model.Reservation;

@SuppressWarnings("serial")
public class modelReservation extends AbstractTableModel {

	private String[] columnNames;
	private Object[][] data;

	public modelReservation() {
		super();
		columnNames = new String[6];
		columnNames[0] = "id";
		columnNames[1] = "Choix";
		columnNames[2] = "Date";
		columnNames[3] = "Somme";
		columnNames[4] = "Etat";
		columnNames[5] = "";

		ReservationsDao gestion_reservation = new ReservationsDao();
		
		List<Reservation> liste = gestion_reservation.findAllReservations();
		data = new Object[liste.size()][6];

		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = liste.get(i).getIdReservation();
			data[i][1] = liste.get(i).getChoix();
			data[i][2] = liste.get(i).getDate();
			data[i][3] = liste.get(i).getFacture().getSomme();
			data[i][4] = liste.get(i).getEtat();
			data[i][5] = "valider";
		}

	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];

	}

	boolean[] columnEditables = new boolean[] { false, false, false, false,
			false, true };

	public String getColumnName(int i) {
		return columnNames[i];
	}

	public int getColumnCount() {

		return columnNames.length;
	}

	public int getRowCount() {

		return data.length;
	}

	public Object getValueAt(int row, int col) {

		return data[row][col];
	}

	public void setValueAt(Object value, int row, int col) {

		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}
