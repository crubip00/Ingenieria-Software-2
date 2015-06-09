package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JButton;
@SuppressWarnings("rawtypes")
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
	//private int cont = 1;
	

	@SuppressWarnings("unchecked")
	public VentanaFisio(final Statement st) {

		frameFisio = new JFrame("Consulta Fisioterapia");
		frameFisio.setResizable(false);
		frameFisio.setBounds(100, 100, 720, 474);
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

			rs = st.executeQuery("SELECT * FROM fisio ORDER BY id");

			while (rs.next()) {
				modelListaFisio.addElement(rs.getString(1) + " \t\t   "
						+ rs.getString(2) + "  \t\t  " + rs.getString(4)
						+ " \t\t   " + rs.getString(5));

			}

		} catch (SQLException e2) {
			// 
			e2.printStackTrace();
		}

		textUsuario = new JTextField();
		textUsuario.setEditable(false);
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
				
				int cont =1;
				
				try {
					rs = st.executeQuery("SELECT id FROM fisio WHERE id = '" + cont + "'");
					do{
						
						rs = st.executeQuery("SELECT id FROM fisio WHERE id = '" + cont + "'");
						cont++;
					}while(rs.next() == true);
					cont--;
				} catch (SQLException e1) {
					// 
					e1.printStackTrace();
				}
				
				
				try {
					rs = st.executeQuery("SELECT fecha, hora  FROM fisio  WHERE fecha = '"+ dia+ "/"+ mes+ "/"+ ano+ "' AND hora = '"+String.valueOf(comboHoras.getSelectedItem())+"'");
				} catch (SQLException e3) {
					// 
					e3.printStackTrace();
				}
				
				try {
					if(rs.next() == true){
						JOptionPane.showMessageDialog(botonReservar, "Ya hay otra reserva a esa hora.", "Advertencia", 2);
						return;
					}
				} catch (HeadlessException e3) {
					
					
				} catch (SQLException e3) {
					
				}
				
				
			
				descripcion = textDescripcion.getText();

				try {
					rs = st.executeQuery("INSERT INTO fisio (id, nombre, descripcion, fecha, hora) "
							+ "values ('"+cont
							+"','"+ VentanaSistema.nombreUsuario+ "','"
							+ descripcion+ "','"+ dia+ "/"+ mes+ "/"+ ano+ "','"+ String.valueOf(comboHoras.getSelectedItem())+ "')");
					

				} catch (SQLException e1) {
					// 
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,
						"La reserva se ha realizado correctamente!");
				textDescripcion.setText("");
				
				// Actualizar la lista de reservas dinamicamente!

				try {

					rs = st.executeQuery("SELECT * FROM fisio ORDER BY id");

					modelListaFisio.clear();

					while (rs.next()) {
						modelListaFisio.addElement(rs.getString(1) + " \t\t   "
								+ rs.getString(2) + "  \t\t  "
								+ rs.getString(4) + " \t\t   "
								+ rs.getString(5));

					}

				} catch (SQLException e2) {
					// 
					e2.printStackTrace();
				}
				
				//cont = cont +1;
				
			}
		});

		JLabel lblDescripcion = new JLabel("DescripciÃ³n: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(126, 310, 78, 14);
		frameFisio.getContentPane().add(lblDescripcion);

		btnBorrarReserva = new JButton("Borrar Reserva");
		btnBorrarReserva.setBounds(522, 297, 133, 23);
		frameFisio.getContentPane().add(btnBorrarReserva);
		btnBorrarReserva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String elemento = (String) listaReservas.getSelectedValue();

				@SuppressWarnings("unused")
				int index = listaReservas.getSelectedIndex();

				String idEliminar = elemento.split(" ")[0];

				try {
					rs = st.executeQuery("DELETE FROM fisio WHERE id = '"
							+ idEliminar + "'");

				} catch (SQLException e2) {
					e2.printStackTrace();

				}

				JOptionPane.showMessageDialog(null,
						"La reserva se ha eliminado correctamente!");

				// Actualizar la lista de reservas dinamicamente!

				try {

					rs = st.executeQuery("SELECT * FROM fisio ORDER BY id");

					modelListaFisio.clear();

					while (rs.next()) {
						modelListaFisio.addElement(rs.getString(1) + " \t\t   "
								+ rs.getString(2) + "  \t\t  "
								+ rs.getString(4) + " \t\t   "
								+ rs.getString(5));

					}

				} catch (SQLException e2) {
					// 
					e2.printStackTrace();
				}
				
				
				
				
				

			}
		});
		
		

		botonDetalles = new JButton("Mostrar Detalles");
		botonDetalles.setBounds(379, 297, 133, 23);
		frameFisio.getContentPane().add(botonDetalles);
		botonDetalles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String elemento = (String) listaReservas.getSelectedValue();

				@SuppressWarnings("unused")
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
