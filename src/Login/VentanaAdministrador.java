package Login;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VentanaAdministrador {

	JFrame frmAdministracion;
	private String[] var = {"usuarios", "actividades", "pistas"};
	private String[] var2 = {"basico", "premium", "administrador"};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String id_usuario;
	private ResultSet resultado;
	DefaultListModel modelo = new DefaultListModel();

	public VentanaAdministrador(final Statement consulta3) {
		frmAdministracion = new JFrame();
		frmAdministracion.setTitle("Administracion");
		frmAdministracion.setBounds(100, 100, 522, 389);
		frmAdministracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministracion.getContentPane().setLayout(null);
		frmAdministracion.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 127, 488, 213);
		frmAdministracion.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 301, 166);
		panel.add(scrollPane);
		
		final JList list = new JList();
		scrollPane.setViewportView(list);
		
		final JComboBox comboBox = new JComboBox(var);
		
		JButton btnNewButton = new JButton("Eliminar selecci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = String.valueOf(list.getSelectedValue());
				String[] sol = s.split("  ");
				
					try {
						consulta3.executeQuery("DELETE FROM usuarios WHERE id_usuario = '"
								+sol[0]+"' AND nombre = '"+sol[1]+"' AND clave = '"+sol[2]+"' AND tipo_cuenta = '"+sol[3]+"'");
						consulta3.executeQuery("DELETE FROM actividades WHERE nombre = '"
								+sol[1]+"' AND fecha = '"+sol[2]+"' AND hora = '"+sol[3]+"' AND id_usuario = '"+sol[0]+"'");
						consulta3.executeQuery("DELETE FROM pistas WHERE nombre = '"
								+sol[1]+"' AND fecha = '"+sol[2]+"' AND hora = '"+sol[3]+"' AND id_usuario = '"+sol[0]+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					modelo.clear();
					if(comboBox.getSelectedIndex() == 0){
						try {
							consulta3.executeQuery("DELETE FROM actividades WHERE id_usuario = '"
									+sol[0]+"'");
							consulta3.executeQuery("DELETE FROM pistas WHERE id_usuario = '"
									+sol[0]+"'");
							resultado = consulta3.executeQuery("SELECT * FROM usuarios");
							while(resultado.next()){
								modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3)+"  "+resultado.getString(4));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(comboBox.getSelectedIndex() == 1){
						try {
							resultado = consulta3.executeQuery("SELECT * FROM actividades");
							while(resultado.next()){
								modelo.addElement(resultado.getString(4)+"  "+resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(comboBox.getSelectedIndex() == 2){
						try {
							resultado = consulta3.executeQuery("SELECT * FROM pistas");
							while(resultado.next()){
								modelo.addElement(resultado.getString(4)+"  "+resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					list.setModel(modelo);
			}
		});
		btnNewButton.setBounds(321, 179, 160, 23);
		panel.add(btnNewButton);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				if(comboBox.getSelectedIndex() == 0){
					try {
						resultado = consulta3.executeQuery("SELECT * FROM usuarios");
						while(resultado.next()){
							modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3)+"  "+resultado.getString(4));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(comboBox.getSelectedIndex() == 1){
					try {
						resultado = consulta3.executeQuery("SELECT * FROM actividades");
						while(resultado.next()){
							modelo.addElement(resultado.getString(4)+"  "+resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(comboBox.getSelectedIndex() == 2){
					try {
						resultado = consulta3.executeQuery("SELECT * FROM pistas");
						while(resultado.next()){
							modelo.addElement(resultado.getString(4)+"  "+resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				list.setModel(modelo);
			}
		});
		comboBox.setBounds(381, 35, 100, 20);
		panel.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(321, 68, 157, 107);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTipoCuenta = new JLabel("Cambiar tipo cuenta:");
		lblTipoCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoCuenta.setBounds(10, 11, 137, 14);
		panel_3.add(lblTipoCuenta);
		
		final JComboBox comboBox_1 = new JComboBox(var2);
		comboBox_1.setBounds(20, 36, 114, 20);
		panel_3.add(comboBox_1);
		
		JButton btnDarPermiso = new JButton("Dar permiso");
		btnDarPermiso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0){
					String s = String.valueOf(list.getSelectedValue());
					String[] sol = s.split("  ");
					try {
						modelo.clear();
						resultado = consulta3.executeQuery("UPDATE usuarios SET tipo_cuenta = '"+comboBox_1.getSelectedIndex()+"' WHERE id_usuario = '"
								+sol[0]+"' AND nombre = '"+sol[1]+"' AND clave = '"+sol[2]+"' AND tipo_cuenta = '"+sol[3]+"'");
						resultado = consulta3.executeQuery("SELECT * FROM usuarios");
						while(resultado.next()){
							modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3)+"  "+resultado.getString(4));
						}
						list.setModel(modelo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDarPermiso.setBounds(10, 73, 137, 23);
		panel_3.add(btnDarPermiso);
		
		JLabel lblMostrar = new JLabel("Mostrar:");
		lblMostrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMostrar.setBounds(321, 38, 61, 14);
		panel.add(lblMostrar);
		
		JLabel lblBaseDeDatos = new JLabel("Base de datos:");
		lblBaseDeDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBaseDeDatos.setBounds(10, 11, 98, 14);
		panel.add(lblBaseDeDatos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(227, 11, 271, 105);
		frmAdministracion.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 55, 14);
		panel_1.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(75, 8, 186, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(20, 40, 49, 14);
		panel_1.add(lblClave);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 37, 125, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont = 1;
				try {
					resultado = consulta3.executeQuery("SELECT id_usuario FROM usuarios WHERE id_usuario = '" + cont + "'");
					while(resultado.next() == true){
						resultado = consulta3.executeQuery("SELECT id_usuario FROM usuarios WHERE id_usuario = '" + cont + "'");
						cont++;
					}
					cont--;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					consulta3.executeQuery("INSERT INTO usuarios (id_usuario, nombre, clave) " + "values ('"
							+cont+"','"
							+textField.getText()+"','"
							+textField_1.getText()+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");
				textField_1.setText("");
				if(comboBox.getSelectedIndex() == 0){
					modelo.clear();
					try {
						resultado = consulta3.executeQuery("SELECT * FROM usuarios");
						while(resultado.next()){
							modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3)+"  "+resultado.getString(4));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.setModel(modelo);
				}
			}
		});
		btnCrearUsuario.setBounds(85, 71, 113, 23);
		panel_1.add(btnCrearUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 11, 207, 105);
		frmAdministracion.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAdministrador = new JLabel("Administrador:");
		lblAdministrador.setBounds(10, 11, 85, 14);
		panel_2.add(lblAdministrador);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(105, 8, 86, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNSocio = new JLabel("N\u00BA socio:");
		lblNSocio.setBounds(40, 39, 55, 14);
		panel_2.add(lblNSocio);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(105, 36, 44, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceder.frmLogin.setVisible(true);
				frmAdministracion.dispose();
			}
		});
		btnNewButton_1.setBounds(60, 71, 89, 23);
		panel_2.add(btnNewButton_1);
		
		try {
			resultado = consulta3.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
			resultado.next();
			textField_2.setText(resultado.getString("nombre"));
			id_usuario = resultado.getString("id_usuario");
			textField_3.setText(id_usuario);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			resultado = consulta3.executeQuery("SELECT * FROM usuarios");
			while(resultado.next()){
				modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3)+"  "+resultado.getString(4));
			}
			list.setModel(modelo);
			
			JButton btnNewButton_2 = new JButton("Crear copia de la BD");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileWriter fichero = null;
					String s = "";
					
					try {
						s = s + "USUARIOS:\n";
						resultado = consulta3.executeQuery("SELECT * FROM usuarios");
						while(resultado.next()){
							s = s + resultado.getString(1) + "  " + resultado.getString(2) + 
									"  " + resultado.getString(3) + "  " + resultado.getString(4) + "\n";
						}
						s = s + "\n\n";
						s = s + "ACTIVIDADES:\n";
						resultado = consulta3.executeQuery("SELECT * FROM actividades");
						while(resultado.next()){
							s = s + resultado.getString(1) + "  " + resultado.getString(2) + 
									"  " + resultado.getString(3) + "  " + resultado.getString(4) + "\n";
						}
						s = s + "\n\n";
						s = s + "PISTAS:\n";
						resultado = consulta3.executeQuery("SELECT * FROM pistas");
						while(resultado.next()){
							s = s + resultado.getString(1) + "  " + resultado.getString(2) + 
									"  " + resultado.getString(3) + "  " + resultado.getString(4) + "\n";
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try{
						JFileChooser fileChooser = new JFileChooser();
						File file_backup = null;
						int seleccion = fileChooser.showSaveDialog(null);
						if (seleccion == JFileChooser.APPROVE_OPTION) {
							file_backup = fileChooser.getSelectedFile();
							fichero = new FileWriter(file_backup);
							fichero.write(s);
							
							
						}
						} catch (Exception ex){
				            ex.printStackTrace();
				    } finally {
				       try {           
				         if (null != fichero)
				              fichero.close();
				       } catch (Exception e2) {
				           e2.printStackTrace();
				       }
				    }   
				 }
					
					
					
			});
			btnNewButton_2.setBounds(107, 7, 204, 23);
			panel.add(btnNewButton_2);
			
			final JButton btnAyuda = new JButton("?");
			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String str = "Para crear nuevo usuario: introducir nombre y clave y pulsar crear usuario.\n"+
							"Para mostrar usuarios, actividades o pistas seleccionar el desplegable.\n"+
							"Para eliminar el registro de la base de datos pulsar eliminar selecci�n.\n"+
							"Para cambiar los permisos de un usuario, seleccionar el usuario, seleccionar el tipo de permiso\n"+
							"y pulsar dar permiso.\n"+
							"Para crear una copia de la base de datos pulsar crear una copia de la BD.";
					JOptionPane.showMessageDialog(btnAyuda,str , "Ayuda", 3);
				}
			});
			btnAyuda.setBounds(435, 7, 46, 23);
			panel.add(btnAyuda);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
