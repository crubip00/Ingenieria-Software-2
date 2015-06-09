package Login;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class VentanaSistema {

	JFrame frmCentroDeportivoS;
	
	//private String [] pistas = {"padel", "tenis", "squash", "polideportivo"};
	private String [] tipos = {"Actividades", "Pistas"};
	private String [] horasPistas = {"10:00", "11:00", "12:00", "13:00", "16:00", "17:00", "18:00", "19:00", "20:00"};
	//private String [] horasBatuka = {"10:00", "16:00"};
	//private String [] horasMantenimiento = {"11:00", "17:00"};
	//private String [] horasPilates = {"12:00", "18:00"};
	//private String [] horasMeditacion = {"20:00"};
	private JTextField textField;
	private JTextField textField_1;
	private ResultSet resultado;
	private String id_usuario;
	@SuppressWarnings("rawtypes")
	DefaultListModel modelo = new DefaultListModel();
	private int dia;
	private int mes;
	private int ano;

	public static String nombreUsuario;
	private int tipo;
	private JTextField textField_2;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VentanaSistema(final Statement consulta2) {
		
		frmCentroDeportivoS = new JFrame();
		frmCentroDeportivoS.setResizable(false);
		frmCentroDeportivoS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCentroDeportivoS.setTitle("Centro deportivo 'En forma'");
		frmCentroDeportivoS.setBounds(100, 100, 618, 425);
		frmCentroDeportivoS.getContentPane().setLayout(null);
		frmCentroDeportivoS.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 244, 345);
		frmCentroDeportivoS.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(138, 67, 96, 20);
		panel.add(comboBox_2);
		
		final JComboBox comboBox = new JComboBox(tipos);
		final JComboBox comboBox_1 = new JComboBox();
		
		final JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		calendar.setBounds(10, 120, 224, 153);
		panel.add(calendar);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_2.removeAllItems();
				try {
					resultado = consulta2.executeQuery("SELECT hora FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'"+
					"AND dia = '"+String.valueOf(comboBox_3.getSelectedItem())+"'");
					while(resultado.next()){
						String item = resultado.getString(1);
						boolean exists = false;
						 for (int index = 0; index < comboBox_2.getItemCount() && !exists; index++) {
						   if (item.equals(comboBox_2.getItemAt(index))) {
						     exists = true;
						   }
						 }
						 if (!exists) {
						   comboBox_2.addItem(item);
						 }
					}
					resultado = consulta2.executeQuery("SELECT dia FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'");
					while(resultado.next()){
						String item = resultado.getString(1);
						boolean exists = false;
						 for (int index = 0; index < comboBox_3.getItemCount() && !exists; index++) {
						   if (item.equals(comboBox_3.getItemAt(index))) {
						     exists = true;
						   }
						 }
						 if (!exists) {
						   comboBox_3.addItem(item);
						 }
					}
				} catch (SQLException e) {
				// 
				e.printStackTrace();
				}
			}
		});
		comboBox_3.setBounds(32, 67, 96, 20);
		panel.add(comboBox_3);
		
		comboBox_1.setBounds(116, 36, 118, 20);
		panel.add(comboBox_1);
		
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.removeAllItems();
				if(comboBox.getSelectedIndex() == 0){
					comboBox_3.setEnabled(true);
					try {
						resultado = consulta2.executeQuery("SELECT nombre FROM actividades_sesiones ORDER BY nombre ASC");
						while(resultado.next()){
							String item = resultado.getString(1);
							boolean exists = false;
							 for (int index = 0; index < comboBox_1.getItemCount() && !exists; index++) {
							   if (item.equals(comboBox_1.getItemAt(index))) {
							     exists = true;
							   }
							 }
							 if (!exists) {
							   comboBox_1.addItem(item);
							 }
						}
						resultado = consulta2.executeQuery("SELECT dia FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'");
						while(resultado.next()){
							String item = resultado.getString(1);
							boolean exists = false;
							 for (int index = 0; index < comboBox_3.getItemCount() && !exists; index++) {
							   if (item.equals(comboBox_3.getItemAt(index))) {
							     exists = true;
							   }
							 }
							 if (!exists) {
							   comboBox_3.addItem(item);
							 }
						}
						resultado = consulta2.executeQuery("SELECT hora FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'"+
								"AND dia = '"+String.valueOf(comboBox_3.getSelectedItem())+"'");
								while(resultado.next()){
									String item = resultado.getString(1);
									boolean exists = false;
									 for (int index = 0; index < comboBox_2.getItemCount() && !exists; index++) {
									   if (item.equals(comboBox_2.getItemAt(index))) {
									     exists = true;
									   }
									 }
									 if (!exists) {
									   comboBox_2.addItem(item);
									 }
								}
					} catch (SQLException e) {
						// 
						e.printStackTrace();
					}
				}
				else if(comboBox.getSelectedIndex() == 1){
					
					try {
						resultado = consulta2.executeQuery("SELECT nombre FROM pistas_tipos ORDER BY nombre ASC");
						while(resultado.next()){
							comboBox_1.addItem(resultado.getString(1));
						}
					} catch (SQLException e) {
						// 
						e.printStackTrace();
					}
					
					comboBox_2.removeAllItems();
					comboBox_3.setEnabled(false);
					
					for(int i=0; i<horasPistas.length; i++){
						comboBox_2.addItem(horasPistas[i]);
					}
					
				}
			}
		});
		comboBox.setBounds(10, 36, 96, 20);
		panel.add(comboBox);
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_3.removeAllItems();
				comboBox_2.removeAllItems();
				
				if(comboBox.getSelectedIndex() == 0){
					try {
						resultado = consulta2.executeQuery("SELECT dia FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'");
						while(resultado.next()){
							String item = resultado.getString(1);
							boolean exists = false;
							 for (int index = 0; index < comboBox_3.getItemCount() && !exists; index++) {
							   if (item.equals(comboBox_3.getItemAt(index))) {
							     exists = true;
							   }
							 }
							 if (!exists) {
							   comboBox_3.addItem(item);
							 }
						}
						resultado = consulta2.executeQuery("SELECT nombre FROM actividades_sesiones ORDER BY nombre ASC");
						while(resultado.next()){
							String item = resultado.getString(1);
							boolean exists = false;
							 for (int index = 0; index < comboBox_1.getItemCount() && !exists; index++) {
							   if (item.equals(comboBox_1.getItemAt(index))) {
							     exists = true;
							   }
							 }
							 if (!exists) {
							   comboBox_1.addItem(item);
							 }
						}
						resultado = consulta2.executeQuery("SELECT hora FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'"+
								"AND dia = '"+String.valueOf(comboBox_3.getSelectedItem())+"'");
								while(resultado.next()){
									String item = resultado.getString(1);
									boolean exists = false;
									 for (int index = 0; index < comboBox_2.getItemCount() && !exists; index++) {
									   if (item.equals(comboBox_2.getItemAt(index))) {
									     exists = true;
									   }
									 }
									 if (!exists) {
									   comboBox_2.addItem(item);
									 }
								}
					} catch (SQLException e) {
						// 
						e.printStackTrace();
					}
				}
				else if(comboBox.getSelectedIndex() == 1){
					comboBox_2.removeAllItems();
					for(int i=0; i<horasPistas.length; i++){
						comboBox_2.addItem(horasPistas[i]);
					}
				}
			}
		});
		
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
				int dia_semana = calendar.getCalendar().get(Calendar.DAY_OF_WEEK);
				
				if(comboBox.getSelectedIndex()==1 && (dia_semana == 1 || dia_semana == 7)){
					JOptionPane.showMessageDialog(btnReservar, "Este dÃ­a no hay reservas.", "Advertencia", 2);
					return;
				}
				if(comboBox.getSelectedIndex()==0){
					if((String.valueOf(comboBox_3.getSelectedItem()).equals("Lunes")) && dia_semana != 2){
						JOptionPane.showMessageDialog(btnReservar, "Este dÃ­a no hay reservas.", "Advertencia", 2);
						return;
					}
					else if((String.valueOf(comboBox_3.getSelectedItem()).equals("Martes")) && dia_semana != 3){
						JOptionPane.showMessageDialog(btnReservar, "Este dÃ­a no hay reservas.", "Advertencia", 2);
						return;
					}
					else if((String.valueOf(comboBox_3.getSelectedItem()).equals("MiÃ©rcoles")) && dia_semana != 4){
						JOptionPane.showMessageDialog(btnReservar, "Este dÃ­a no hay reservas.", "Advertencia", 2);
						return;
					}
					else if((String.valueOf(comboBox_3.getSelectedItem()).equals("Jueves")) && dia_semana != 5){
						JOptionPane.showMessageDialog(btnReservar, "Este dÃ­a no hay reservas.", "Advertencia", 2);
						return;
					}
					else if((String.valueOf(comboBox_3.getSelectedItem()).equals("Viernes")) && dia_semana != 6){
						JOptionPane.showMessageDialog(btnReservar, "Este dÃ­a no hay reservas.", "Advertencia", 2);
						return;
					}
				}
				
				
				if(comboBox_2.getSelectedIndex() == -1) JOptionPane.showMessageDialog(btnReservar, "Este dÃ¯Â¿Â½a no hay reservas.", "Advertencia", 2);
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
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva ese dÃ¯Â¿Â½a.", "Advertencia", 2);
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
							JOptionPane.showMessageDialog(btnReservar, "La reserva estÃ¯Â¿Â½ completa.", "Advertencia", 2);
							return;
						}
					} catch (SQLException e2) {
						// 
						e2.printStackTrace();
					}
					try {
						resultado = consulta2.executeQuery("SELECT id_sesion FROM actividades_sesiones"+
								" WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+
								"' AND dia = '"+String.valueOf(comboBox_3.getSelectedItem())+"' AND hora = '"+String.valueOf(comboBox_2.getSelectedItem())+"'");
						resultado.next();
						consulta2.executeQuery("INSERT INTO actividades (nombre, fecha, hora, id_usuario, id_sesion) " + "values ('"
								+String.valueOf(comboBox_1.getSelectedItem())+"','"
								+dia+"/"+mes+"/"+ano+"','"
								+String.valueOf(comboBox_2.getSelectedItem())+"','"+id_usuario+"','"+resultado.getString(1)+"')");
					} catch (SQLException e1) {
						// 
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
							JOptionPane.showMessageDialog(btnReservar, "Ya hay otra reserva ese dÃ¯Â¿Â½a.", "Advertencia", 2);
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
						// 
						e2.printStackTrace();
					}
					
					try {
						consulta2.executeQuery("INSERT INTO pistas (nombre, fecha, hora, id_usuario) "
								+ "values ('" +String.valueOf(comboBox_1.getSelectedItem())+"','"
								+dia+"/"+mes+"/"+ano+"','"
								+String.valueOf(comboBox_2.getSelectedItem())+"','"+id_usuario+"')");
					} catch (SQLException e1) {
						// 
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
					// 
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
					// 
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
					// 
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
			resultado = consulta2.executeQuery("SELECT nombre FROM actividades_sesiones ORDER BY nombre ASC");
			while(resultado.next()){
				String item = resultado.getString(1);
				boolean exists = false;
				 for (int index = 0; index < comboBox_1.getItemCount() && !exists; index++) {
				   if (item.equals(comboBox_1.getItemAt(index))) {
				     exists = true;
				   }
				 }
				 if (!exists) {
				   comboBox_1.addItem(item);
				 }
			}
			resultado = consulta2.executeQuery("SELECT dia FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'");
			while(resultado.next()){
				String item = resultado.getString(1);
				boolean exists = false;
				 for (int index = 0; index < comboBox_3.getItemCount() && !exists; index++) {
				   if (item.equals(comboBox_3.getItemAt(index))) {
				     exists = true;
				   }
				 }
				 if (!exists) {
				   comboBox_3.addItem(item);
				 }
			}
			resultado = consulta2.executeQuery("SELECT hora FROM actividades_sesiones WHERE nombre = '"+String.valueOf(comboBox_1.getSelectedItem())+"'"+
					"AND dia = '"+String.valueOf(comboBox_3.getSelectedItem())+"'");
					while(resultado.next()){
						String item = resultado.getString(1);
						boolean exists = false;
						 for (int index = 0; index < comboBox_2.getItemCount() && !exists; index++) {
						   if (item.equals(comboBox_2.getItemAt(index))) {
						     exists = true;
						   }
						 }
						 if (!exists) {
						   comboBox_2.addItem(item);
						 }
					}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		
		try {
			resultado = consulta2.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
			resultado.next();
			textField.setText(resultado.getString("nombre"));
			nombreUsuario = resultado.getString("nombre");
			id_usuario = resultado.getString("id_usuario");
			textField_1.setText(id_usuario);
			tipo = resultado.getInt("tipo_cuenta");
			if(tipo == 0) textField_2.setText("bÃ¯Â¿Â½sico");
			else if(tipo == 1) textField_2.setText("premium");
			else if(tipo == 2) textField_2.setText("administrador");
			
			
		} catch (SQLException e) {
			// 
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
			
			JMenuBar menuBar = new JMenuBar();
			frmCentroDeportivoS.setJMenuBar(menuBar);
			
			// Botones y Action listener para ir a la tienda:
			
			JMenu mnTienda = new JMenu("Tienda 'En forma'");
			menuBar.add(mnTienda);
			
			JMenuItem menuItemTienda = new JMenuItem("Ver Tienda");
			mnTienda.add(menuItemTienda);
			menuItemTienda.addActionListener(new ActionListener() {
				private VentanaTienda oVentanaTienda;

				public void actionPerformed(ActionEvent e){
					 this.oVentanaTienda = new VentanaTienda();
					
					 oVentanaTienda.frameTienda.setVisible(true);
					
					
				}
			});
			
			
			// Botones y Action listener para ir a los entrenamientos/rutinas:
			
			
			
			JMenu mnEntrenamientos = new JMenu("Entrenamientos Recomendados");
			menuBar.add(mnEntrenamientos);
			
			JMenuItem menuItemEntrenamientos = new JMenuItem("Lista Entrenamientos Disponibles");
			mnEntrenamientos.add(menuItemEntrenamientos);
			
			menuItemEntrenamientos.addActionListener(new ActionListener() {
				
				private VentanaEntrenamientos oVentanaEntrenamientos;
				@Override
				public void actionPerformed(ActionEvent e) {
					
					this.oVentanaEntrenamientos = new VentanaEntrenamientos(consulta2);
					
					oVentanaEntrenamientos.frameEntrenamientos.setVisible(true);
					
					
				}
			});
			
			
			// Botones y Action listener de la consulta de fisioterapia:
			
			JMenu mnConsultaFisioterapeuta = new JMenu("Consulta fisioterapeuta");
			menuBar.add(mnConsultaFisioterapeuta);
			
			JMenuItem menuItemConsulta = new JMenuItem("Reservar Consulta");
			mnConsultaFisioterapeuta.add(menuItemConsulta);
			menuItemConsulta.addActionListener(new ActionListener() {
				
				private VentanaFisio oVentanaFisio;
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					this.oVentanaFisio = new VentanaFisio(consulta2);
					
					oVentanaFisio.frameFisio.setVisible(true);
					
					
					
				}
			});
			
			
			// Botones y Action Listener de Ayuda y About.
			
			JMenu mnAyuda = new JMenu("Ayuda");
			menuBar.add(mnAyuda);
			
			JMenuItem menuItemAyuda = new JMenuItem("Ver Ayuda");
			mnAyuda.add(menuItemAyuda);
			menuItemAyuda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String str1= "Para efectuar la reserva seleccione el tipo de actividad o pista, la fecha y la hora, y pulse Reservar.\n"+
							"Para eliminar una reserva seleccione la reserva y pulse Cancelar reserva.\n"+
							"Para ir a la tienda: Tienda En Forma/Ver Tienda.\n"+
							"Para ver o descargar rutinas de entrenamiento: Entrenamientos recomendados/Lista entrenamientos disponibles.\n"+
							"Para reservar consulta de fisioterapia: Consulta fisioterapeuta/Reservar consulta.";
					
					JOptionPane.showMessageDialog(null, str1, "Ayuda de la AplicaciÃƒÂ³n", 3);
					
					
				}
			});
			
			
			JMenuItem menuItemAbout = new JMenuItem("Acerca de EnForma");
			mnAyuda.add(menuItemAbout);
			menuItemAbout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String str2= "·César Jesús Rubio Pisabarro.\n"
							+ "·Raquel Fernández González\n"
							+ "·Ismael López Nicolás\n"
							+ "-2015-";
					
					JOptionPane.showMessageDialog(null, str2, "Acerca de EnForma", JOptionPane.INFORMATION_MESSAGE);
					
					
				}
			});
			
			
		} catch (SQLException e1) {
			// 
			e1.printStackTrace();
		}
	}
}
