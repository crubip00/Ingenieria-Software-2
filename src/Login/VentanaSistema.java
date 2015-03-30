package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;


public class VentanaSistema {

	JFrame frmCentroDeportivoS;
	
	private String [] pistas = {"padel", "tenis", "squash", "polideportivo"};
	private String [] tipos = {"actividades", "pistas"};
	private String [] horasPistas = {"10:00", "11:00", "12:00", "13:00", "16:00", "17:00", "18:00", "19:00", "20:00"};
	private String [] horasBatuka = {"10:00", "16:00"};
	private String [] horasMantenimiento = {"11:00", "17:00"};
	private String [] horasPilates = {"12:00", "18:00"};
	private String [] horasMeditacion = {"20:00"};
	private JTextField textField;
	private JTextField textField_1;
	private ResultSet resultado;
	private String id_usuario;
	DefaultListModel modelo = new DefaultListModel();
	private int dia;
	private int mes;
	private int ano;

	private int tipo;
	private JTextField textField_2;
	
	public VentanaSistema(final Statement consulta2) {
		
		frmCentroDeportivoS = new JFrame();
		frmCentroDeportivoS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCentroDeportivoS.setTitle("Centro deportivo 'En forma'");
		frmCentroDeportivoS.setBounds(100, 100, 618, 409);
		frmCentroDeportivoS.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 244, 345);
		frmCentroDeportivoS.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JComboBox comboBox_2 = new JComboBox(horasBatuka);
		comboBox_2.setBounds(138, 67, 96, 20);
		panel.add(comboBox_2);
		
		final JComboBox comboBox = new JComboBox(tipos);
		final JComboBox comboBox_1 = new JComboBox();
		
		final JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(comboBox.getSelectedIndex() == 1 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) != 7 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) != 1){
					comboBox_2.removeAllItems();
					for(int i=0; i<horasPistas.length; i++){
						comboBox_2.addItem(horasPistas[i]);
					}
				}
				else if(comboBox_1.getSelectedIndex() == 0 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("10:00");
					comboBox_2.addItem("16:00");
					
				}
				else if(comboBox_1.getSelectedIndex() == 1 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("11:00");
					comboBox_2.addItem("17:00");
				}
				else if(comboBox_1.getSelectedIndex() == 2 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("12:00");
					comboBox_2.addItem("18:00");
				}
				else if(comboBox_1.getSelectedIndex() == 3 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("10:00");
					comboBox_2.addItem("16:00");
				}
				else if(comboBox_1.getSelectedIndex() == 4 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("11:00");
					comboBox_2.addItem("17:00");
				}
				else if(comboBox_1.getSelectedIndex() == 5 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("12:00");
					comboBox_2.addItem("18:00");
				}
				else if(comboBox_1.getSelectedIndex() == 6 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 6){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("12:00");
				}
				else if(comboBox_1.getSelectedIndex() == 7 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 6){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("18:00");
				}
				else comboBox_2.removeAllItems();
			}
		});
		calendar.setBounds(10, 120, 224, 153);
		panel.add(calendar);
		
		
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex() == 1 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) != 7 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) != 1){
					comboBox_2.removeAllItems();
					for(int i=0; i<horasPistas.length; i++){
						comboBox_2.addItem(horasPistas[i]);
					}
				}
				else if(comboBox_1.getSelectedIndex() == 0 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("10:00");
					comboBox_2.addItem("16:00");
					
				}
				else if(comboBox_1.getSelectedIndex() == 1 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("11:00");
					comboBox_2.addItem("17:00");
				}
				else if(comboBox_1.getSelectedIndex() == 2 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 2 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 4)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("12:00");
					comboBox_2.addItem("18:00");
				}
				else if(comboBox_1.getSelectedIndex() == 3 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("10:00");
					comboBox_2.addItem("16:00");
				}
				else if(comboBox_1.getSelectedIndex() == 4 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("11:00");
					comboBox_2.addItem("17:00");
				}
				else if(comboBox_1.getSelectedIndex() == 5 && (calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 3 || calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 5)){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("12:00");
					comboBox_2.addItem("18:00");
				}
				else if(comboBox_1.getSelectedIndex() == 6 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 6){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("12:00");
				}
				else if(comboBox_1.getSelectedIndex() == 7 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == 6){
					comboBox_2.removeAllItems();
					comboBox_2.addItem("18:00");
				}
				else comboBox_2.removeAllItems();
			}
		});
		comboBox_1.addItem("batuka");
		comboBox_1.addItem("mantenimiento");
		comboBox_1.addItem("pilates");
		comboBox_1.addItem("tonificacion");
		comboBox_1.addItem("yoga");
		comboBox_1.addItem("aerobox");
		comboBox_1.addItem("step");
		comboBox_1.addItem("meditacion");
		comboBox_1.setBounds(116, 36, 118, 20);
		panel.add(comboBox_1);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex() == 0){
					comboBox_1.removeAllItems();
					comboBox_1.addItem("batuka");
					comboBox_1.addItem("mantenimiento");
					comboBox_1.addItem("pilates");
					comboBox_1.addItem("tonificacion");
					comboBox_1.addItem("yoga");
					comboBox_1.addItem("aerobox");
					comboBox_1.addItem("step");
					comboBox_1.addItem("meditacion");
				}
				else if(comboBox.getSelectedIndex() == 1){
					comboBox_1.removeAllItems();
					comboBox_1.addItem("padel");
					comboBox_1.addItem("tenis");
					comboBox_1.addItem("squash");
					comboBox_1.addItem("polideportivo");
					
					comboBox_2.removeAllItems();
					
					if(calendar.getCalendar().get(Calendar.DAY_OF_WEEK) != 7 && calendar.getCalendar().get(Calendar.DAY_OF_WEEK) != 1){
						for(int i=0; i<horasPistas.length; i++){
							comboBox_2.addItem(horasPistas[i]);
						}
					}
				}
			}
		});
		comboBox.setBounds(10, 36, 96, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(264, 11, 327, 345);
		frmCentroDeportivoS.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 100, 196, 200);
		panel_1.add(scrollPane);
		
		final JList list = new JList();
		scrollPane.setViewportView(list);
		
		final JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dia = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes = calendar.getCalendar().get(Calendar.MONTH) + 1;
				ano = calendar.getCalendar().get(Calendar.YEAR);
				if(comboBox_2.getSelectedIndex() == -1) JOptionPane.showMessageDialog(btnReservar, "Este día no hay reservas.", "Advertencia", 2);
				else if(comboBox.getSelectedIndex() == 0){
					try {
						resultado = consulta2.executeQuery("SELECT fecha, hora, id_usuario FROM actividades"+
								" WHERE fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND hora = '"+String.valueOf(comboBox_2.getSelectedItem())+"' AND id_usuario = '"+id_usuario+"'");
						if(resultado.next() == true){
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva a esa hora.", "Advertencia", 2);
							return;
						}
						resultado = consulta2.executeQuery("SELECT nombre, fecha, id_usuario FROM actividades"+
								" WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"' AND fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND id_usuario = '"+id_usuario+"'");
						if(resultado.next() == true){
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva ese día.", "Advertencia", 2);
							return;
						}
						resultado = consulta2.executeQuery("SELECT fecha, hora, id_usuario FROM pistas"+
								" WHERE fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND hora = '"+String.valueOf(comboBox_2.getSelectedItem())+"' AND id_usuario = '"+id_usuario+"'");
						if(resultado.next() == true){
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva a esa hora.", "Advertencia", 2);
							return;
						}
						resultado = consulta2.executeQuery("SELECT count(*) FROM actividades"+
								" WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"' AND fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND hora = '"+String.valueOf(comboBox_2.getSelectedItem())+"'");
						int cont = 0;
						while(resultado.next()){
							cont = resultado.getInt(1);
						}
						if(!(cont < 15)){
							JOptionPane.showMessageDialog(btnReservar, "La reserva está completa.", "Advertencia", 2);
							return;
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						consulta2.executeQuery("INSERT INTO actividades (nombre, fecha, hora, id_usuario) " + "values ('"
								+String.valueOf(comboBox_1.getSelectedItem())+"','"
								+dia+"/"+mes+"/"+ano+"','"
								+String.valueOf(comboBox_2.getSelectedItem())+"','"+id_usuario+"')");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(comboBox.getSelectedIndex() == 1){
					if(tipo == 0){
						JOptionPane.showMessageDialog(btnReservar, "No tienes cuenta premium.", "Advertencia", 2);
						return;
					}
					try {
						resultado = consulta2.executeQuery("SELECT fecha, hora, id_usuario FROM actividades"+
								" WHERE fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND hora = '"+String.valueOf(comboBox_2.getSelectedItem())+"' AND id_usuario = '"+id_usuario+"'");
						if(resultado.next() == true){
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva a esa hora.", "Advertencia", 2);
							return;
						}
						resultado = consulta2.executeQuery("SELECT fecha, id_usuario FROM pistas"+
								" WHERE fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND id_usuario = '"+id_usuario+"'");
						if(resultado.next() == true){
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva ese día.", "Advertencia", 2);
							return;
						}
						resultado = consulta2.executeQuery("SELECT fecha, hora FROM pistas"+
								" WHERE fecha = '"+dia+"/"+mes+"/"+ano+
								"' AND hora = '"+String.valueOf(comboBox_2.getSelectedItem())+"'");
						if(resultado.next() == true){
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva a esa hora.", "Advertencia", 2);
							return;
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					try {
						consulta2.executeQuery("INSERT INTO pistas (nombre, fecha, hora, id_usuario) "
								+ "values ('" +String.valueOf(comboBox_1.getSelectedItem())+"','"
								+dia+"/"+mes+"/"+ano+"','"
								+String.valueOf(comboBox_2.getSelectedItem())+"','"+id_usuario+"')");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				try {
					resultado = consulta2.executeQuery("SELECT * FROM pistas WHERE id_usuario = '" + id_usuario + "'");
					modelo.clear();
					while(resultado.next()){
						modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
					}
					resultado = consulta2.executeQuery("SELECT * FROM actividades WHERE id_usuario = '" + id_usuario + "'");
					while(resultado.next()){
						modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
					}
					list.setModel(modelo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReservar.setBounds(77, 297, 89, 23);
		panel.add(btnReservar);
		
		JLabel lblReservarActividadYo = new JLabel("Reservar actividad y/o pista:");
		lblReservarActividadYo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservarActividadYo.setBounds(10, 11, 174, 14);
		panel.add(lblReservarActividadYo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 52, 14);
		panel_1.add(lblNombre);
		
		JLabel lblNSocio = new JLabel("N\u00BA socio:");
		lblNSocio.setBounds(10, 36, 52, 14);
		panel_1.add(lblNSocio);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(64, 8, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(64, 33, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = String.valueOf(list.getSelectedValue());
				String[] sol = s.split("  ");
				try {
					consulta2.executeQuery("DELETE FROM actividades WHERE nombre = '"
							+sol[0]+"' AND fecha = '"+sol[1]+"' AND hora = '"+sol[2]+"' AND id_usuario = '"+id_usuario+"'");
					consulta2.executeQuery("DELETE FROM pistas WHERE nombre = '"
							+sol[0]+"' AND fecha = '"+sol[1]+"' AND hora = '"+sol[2]+"' AND id_usuario = '"+id_usuario+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					resultado = consulta2.executeQuery("SELECT * FROM pistas WHERE id_usuario = '" + id_usuario + "'");
					modelo.clear();
					while(resultado.next()){
						modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
					}
					resultado = consulta2.executeQuery("SELECT * FROM actividades WHERE id_usuario = '" + id_usuario + "'");
					while(resultado.next()){
						modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
					}
					list.setModel(modelo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancelarReserva.setBounds(85, 311, 140, 23);
		panel_1.add(btnCancelarReserva);
		
		JLabel lblTipoCuenta = new JLabel("Tipo cuenta:");
		lblTipoCuenta.setBounds(160, 11, 77, 14);
		panel_1.add(lblTipoCuenta);
		
		textField_2 = new JTextField();
		textField_2.setText("<dynamic>");
		textField_2.setEditable(false);
		textField_2.setBounds(236, 8, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		try {
			resultado = consulta2.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
			resultado.next();
			textField.setText(resultado.getString("nombre"));
			id_usuario = resultado.getString("id_usuario");
			textField_1.setText(id_usuario);
			tipo = resultado.getInt("tipo_cuenta");
			if(tipo == 0) textField_2.setText("básico");
			else if(tipo == 1) textField_2.setText("premium");
			else if(tipo == 2) textField_2.setText("administrador");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			resultado = consulta2.executeQuery("SELECT * FROM pistas WHERE id_usuario = '" + id_usuario + "'");
			while(resultado.next()){
				modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
			}
			resultado = consulta2.executeQuery("SELECT * FROM actividades WHERE id_usuario = '" + id_usuario + "'");
			while(resultado.next()){
				modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
			}
			list.setModel(modelo);
			
			JLabel lblReservasEfectuadas = new JLabel("Reservas efectuadas:");
			lblReservasEfectuadas.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblReservasEfectuadas.setBounds(10, 74, 140, 14);
			panel_1.add(lblReservasEfectuadas);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Acceder.frmLogin.setVisible(true);
					frmCentroDeportivoS.dispose();
				}
			});
			btnSalir.setBounds(160, 32, 89, 23);
			panel_1.add(btnSalir);
			
			final JButton button = new JButton("?");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String str = "Para crear una reserva: elegir la actividad, el día y la hora y pulsar reservar.\n"+
							"Para eliminar la reserva: seleccionarla y pulsar cancelar reserva.";
					JOptionPane.showMessageDialog(button, str , "Ayuda", 3);
				}
			});
			button.setBounds(270, 66, 52, 23);
			panel_1.add(button);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
