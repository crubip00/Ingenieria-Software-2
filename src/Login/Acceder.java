package Login;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Acceder {

	static JFrame frmLogin;
	private JTextField textField;
	
	private Statement consulta;
	private ResultSet resultado;
	private JPasswordField passwordField;
	private static String nombre;
	private static String clave;

	public static String getNombre() {
		return nombre;
	}

	public static String getClave() {
		return clave;
	}

	public Acceder(final Conexion conexion) {
		
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 457, 163);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		
		
		JPanel panel_1 = new JPanel();
		frmLogin.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nombre = String.valueOf(textField.getText());
				clave = String.valueOf(passwordField.getPassword());
				
				try{
					
					consulta = conexion.getConexion().createStatement();
					
					resultado = consulta.executeQuery("SELECT nombre, clave FROM usuarios WHERE nombre = '" + nombre + "' AND clave = '" + clave + "'");
					
					if(resultado.next() == true){
						
							
							frmLogin.dispose();
							VentanaSistema ventana = new VentanaSistema(consulta);
							ventana.frmCentroDeportivoS.setVisible(true);
						
							frmLogin.dispose();
					}
					else{
						JOptionPane.showMessageDialog(btnAceptar, "Usuario y/o clave incorrectos.", "Acceso incorrecto", JOptionPane.ERROR_MESSAGE );
					}
					
					
					
				}catch(SQLException e){
					JOptionPane.showMessageDialog(btnAceptar, "Ha sucedido un error: " + e.getMessage() + ".", "Error", JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		panel_1.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				passwordField.setText("");
				
			}
		});
		panel_1.add(btnCancelar);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nombre = String.valueOf(textField.getText());
					clave = String.valueOf(passwordField.getPassword());
					
					consulta = conexion.getConexion().createStatement();
					
					resultado = consulta.executeQuery("SELECT nombre, clave, tipo_cuenta FROM usuarios WHERE nombre = '"
							+ nombre + "' AND clave = '" + clave + "' AND tipo_cuenta = '"+String.valueOf(2)+"'");
					if(resultado.next() == true){
						VentanaAdministrador ventana2 = new VentanaAdministrador(consulta);
						ventana2.frmAdministracion.setVisible(true);
						frmLogin.dispose();
					}
					else JOptionPane.showMessageDialog(btnAceptar, "No tienes permisos de administrador.", "Acceso incorrecto", 2);
				} catch (SQLException e1) {
					// 
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnAdministrar);
		
		JButton botonImportarBD2 = new JButton("Importar BD");
		panel_1.add(botonImportarBD2);
		botonImportarBD2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				

				String script_location = "";
				final String file_extension = ".sql";
				ProcessBuilder processBuilder = null;

				try {
					File file = new File("sql");
					File[] list_files = file.listFiles(new FileFilter() {

						public boolean accept(File f) {
							if (f.getName().toLowerCase()
									.endsWith(file_extension))
								return true;
							return false;
						}
					});
					for (int i = 0; i < list_files.length; i++) {
						script_location = "@"
								+ list_files[i].getAbsolutePath();
						processBuilder = new ProcessBuilder("sqlplus",
								"SYSTEM/galleta@localhost", script_location);

						processBuilder.redirectErrorStream(true);
						Process process = processBuilder.start();
						BufferedReader in = new BufferedReader(
								new InputStreamReader(process
										.getInputStream()));
						String currentLine = null;
						while ((currentLine = in.readLine()) != null) {
							System.out.println(" " + currentLine);
						}

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
		});
		
		
		JPanel panel_2 = new JPanel();
		frmLogin.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(91, 8, 76, 14);
		panel_2.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(177, 5, 118, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(91, 39, 76, 14);
		panel_2.add(lblClave);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 36, 118, 20);
		panel_2.add(passwordField);
	}
}
