package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JScrollBar;
import javax.swing.JButton;

public class VentanaFisio {

	JFrame frameFisio;
	private JTextField textUsuario;
	private JTextField textDescripcion;
	private JButton botonReservar;
	private JList listaReservas;
	private JComboBox comboHoras;
	private JCalendar calendar;
	private DefaultListModel modelListaFisio;
	private JScrollPane scrollPane;
	private int dia;
	private int mes;
	private int ano;
	private ResultSet rs;
	private JButton btnBorrarReserva;
	private String descripcion;
	private JButton botonDetalles;

	public VentanaFisio(final Statement st) {

		frameFisio = new JFrame();
		frameFisio.setBounds(100, 100, 686, 462);
		frameFisio.setLocationRelativeTo(null);
		frameFisio.getContentPane().setLayout(null);

		calendar = new JCalendar();
		calendar.setBounds(47, 100, 184, 153);
		frameFisio.getContentPane().add(calendar);

		comboHoras = new JComboBox();
		comboHoras.setBounds(153, 56, 78, 20);
		frameFisio.getContentPane().add(comboHoras);
		/*
		 * if (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 1 ||
		 * calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 ||
		 * calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 ||
		 * calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4){
		 */
		comboHoras.addItem("9:00");
		comboHoras.addItem("10:00");
		comboHoras.addItem("11:00");
		comboHoras.addItem("12:00");
		comboHoras.addItem("13:00");
		comboHoras.addItem("16:00");
		comboHoras.addItem("17:00");
		comboHoras.addItem("18:00");
		comboHoras.addItem("19:00");

		/*
		 * } else if (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5 ||
		 * calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 6){
		 * comboHoras.addItem("9:00"); comboHoras.addItem("10:00");
		 * comboHoras.addItem("11:00"); comboHoras.addItem("12:00");
		 * comboHoras.addItem("13:00");
		 * 
		 * }
		 */

		modelListaFisio = new DefaultListModel();
		listaReservas = new JList(modelListaFisio);

		frameFisio.getContentPane().add(listaReservas);
		scrollPane = new JScrollPane(listaReservas);
		frameFisio.getContentPane().add(scrollPane);
		scrollPane.setBounds(395, 89, 223, 197);

		try {
			/*rs = st.executeQuery("SELECT * FROM fisio WHERE nombre = '"
					+ VentanaSistema.nombreUsuario + "'");*/
			rs = st.executeQuery("SELECT * FROM fisio ");
			
			while (rs.next()) {
				modelListaFisio.addElement(rs.getString(1) + "    "
						+ rs.getString(2) + "    " + rs.getString(4) + "    "
						+ rs.getString(5));

			}

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		textUsuario = new JTextField();
		textUsuario.setBounds(532, 42, 86, 20);
		frameFisio.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.setText(VentanaSistema.nombreUsuario);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(395, 42, 71, 17);
		frameFisio.getContentPane().add(lblUsuario);

		JLabel lblReservaCita = new JLabel("Reserva cita:");
		lblReservaCita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReservaCita.setBounds(47, 22, 136, 20);
		frameFisio.getContentPane().add(lblReservaCita);

		textDescripcion = new JTextField();
		textDescripcion.setBounds(126, 335, 443, 61);
		frameFisio.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);

		botonReservar = new JButton("Confirmar Reserva");
		botonReservar.setBounds(72, 264, 147, 23);
		frameFisio.getContentPane().add(botonReservar);
		botonReservar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dia = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes = calendar.getCalendar().get(Calendar.MONTH) + 1;
				ano = calendar.getCalendar().get(Calendar.YEAR);

				descripcion = textDescripcion.getText();

				try {
					st.executeQuery("INSERT INTO fisio (nombre, descripcion, fecha, hora) "
							+ "values ('"
							+ VentanaSistema.nombreUsuario
							+ "','"
							+ descripcion
							+ "','"
							+ dia
							+ "/"
							+ mes
							+ "/"
							+ ano
							+ "','"
							+ String.valueOf(comboHoras.getSelectedItem())
							+ "')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel lblDescripcion = new JLabel("Descripción: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(126, 310, 78, 14);
		frameFisio.getContentPane().add(lblDescripcion);

		btnBorrarReserva = new JButton("Borrar Reserva");
		btnBorrarReserva.setBounds(500, 297, 118, 23);
		frameFisio.getContentPane().add(btnBorrarReserva);

		botonDetalles = new JButton("Mostrar Detalles");
		botonDetalles.setBounds(379, 297, 111, 23);
		frameFisio.getContentPane().add(botonDetalles);
		botonDetalles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String elemento = (String) listaReservas.getSelectedValue();

				int index = listaReservas.getSelectedIndex();

				String idreserva = elemento.split(" ")[0];

				try {
					rs = st.executeQuery("SELECT * FROM fisio WHERE id = '"
							+ idreserva + "'");

					rs.next();
					textDescripcion.setText(rs.getString(3));

				} catch (SQLException e2) {
					e2.printStackTrace();
				}

			}
		});
	}
}
