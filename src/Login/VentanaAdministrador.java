package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class VentanaAdministrador {

	JFrame frmAdministracion;
	private String[] var = {"usuarios", "actividades", "pistas"};
	private String[] var2 = {"basico", "premium", "administrador"};
	private JTextField textField;
	private JTextField textField_1;
	private String id_usuario;
	private String nombre;
	private ResultSet resultado;
	DefaultListModel modelo = new DefaultListModel();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	final JList list = new JList();

	public VentanaAdministrador(final Statement consulta3) {
		frmAdministracion = new JFrame();
		frmAdministracion.setTitle("Administracion");
		frmAdministracion.setBounds(100, 100, 522, 389);
		frmAdministracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministracion.getContentPane().setLayout(null);
		
		try {
			resultado = consulta3.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
			resultado.next();
			id_usuario = resultado.getString("id_usuario");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			resultado = consulta3.executeQuery("SELECT * FROM usuarios");
			while(resultado.next()){
				modelo.addElement(resultado.getString(1)+"  "+resultado.getString(2)+"  "+resultado.getString(3)+"  "+resultado.getString(4));
			}
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 506, 351);
			frmAdministracion.getContentPane().add(tabbedPane);
			
			JPanel usuariosPanel = new JPanel();
			tabbedPane.addTab("Usuarios", null, usuariosPanel, null);
			usuariosPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			usuariosPanel.setLayout(null);
			
			final JComboBox comboBox = new JComboBox(var);
			
			
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
			comboBox.setBounds(333, 219, 100, 20);
			usuariosPanel.add(comboBox);
			
			JPanel tipoCuentaPanel = new JPanel();
			tipoCuentaPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			tipoCuentaPanel.setBounds(307, 109, 157, 107);
			usuariosPanel.add(tipoCuentaPanel);
			tipoCuentaPanel.setLayout(null);
			
			JLabel lblTipoCuenta = new JLabel("Cambiar tipo cuenta:");
			lblTipoCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTipoCuenta.setBounds(10, 11, 137, 14);
			tipoCuentaPanel.add(lblTipoCuenta);
			
			final JComboBox comboBox_1 = new JComboBox(var2);
			comboBox_1.setBounds(20, 36, 114, 20);
			tipoCuentaPanel.add(comboBox_1);
			
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
			tipoCuentaPanel.add(btnDarPermiso);
			
			JPanel infoUsuarioPanel_2 = new JPanel();
			infoUsuarioPanel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			infoUsuarioPanel_2.setBounds(287, 11, 204, 87);
			usuariosPanel.add(infoUsuarioPanel_2);
			infoUsuarioPanel_2.setLayout(null);
			
			JLabel label = new JLabel("Administrador:");
			label.setBounds(10, 8, 81, 14);
			infoUsuarioPanel_2.add(label);
			
			textField_4 = new JTextField();
			textField_4.setBounds(101, 5, 86, 20);
			textField_4.setText((String) null);
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			infoUsuarioPanel_2.add(textField_4);
			
			JLabel label_1 = new JLabel("N\u00BA socio:");
			label_1.setBounds(37, 33, 54, 14);
			infoUsuarioPanel_2.add(label_1);
			
			textField_5 = new JTextField();
			textField_5.setBounds(101, 31, 86, 20);
			textField_5.setText("<dynamic>");
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			infoUsuarioPanel_2.add(textField_5);
			
			JButton button = new JButton("Salir");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Acceder.frmLogin.setVisible(true);
					frmAdministracion.dispose();
				}
			});
			button.setBounds(101, 59, 86, 23);
			infoUsuarioPanel_2.add(button);
			
			final JButton btnAyuda = new JButton("?");
			btnAyuda.setBounds(7, 59, 46, 23);
			infoUsuarioPanel_2.add(btnAyuda);
			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String str = "Para crear nuevo usuario: introducir nombre y clave y pulsar crear usuario.\n"+
							"Para mostrar usuarios, actividades o pistas seleccionar el desplegable.\n"+
							"Para eliminar el registro de la base de datos pulsar eliminar selección.\n"+
							"Para cambiar los permisos de un usuario, seleccionar el usuario, seleccionar el tipo de permiso\n"+
							"y pulsar dar permiso.\n"+
							"Para crear una copia de la base de datos pulsar crear una copia de la BD.";
					JOptionPane.showMessageDialog(btnAyuda,str , "Ayuda", 3);
				}
			});
			
			JPanel BBDDPanel = new JPanel();
			BBDDPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			BBDDPanel.setBounds(10, 11, 269, 238);
			usuariosPanel.add(BBDDPanel);
			BBDDPanel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 25, 258, 169);
			BBDDPanel.add(scrollPane);
			
			
			scrollPane.setViewportView(list);
			list.setModel(modelo);
			
			JLabel lblBaseDeDatos = new JLabel("Base de datos:");
			lblBaseDeDatos.setBounds(5, 11, 82, 14);
			BBDDPanel.add(lblBaseDeDatos);
			lblBaseDeDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JButton btnNewButton = new JButton("Eliminar selecci\u00F3n");
			btnNewButton.setBounds(5, 205, 139, 23);
			BBDDPanel.add(btnNewButton);
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
			
			JButton btnNewButton_2 = new JButton("Copia de la BD");
			btnNewButton_2.setBounds(146, 205, 118, 23);
			BBDDPanel.add(btnNewButton_2);
			
			JPanel crearUsuarioPanel = new JPanel();
			crearUsuarioPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			crearUsuarioPanel.setBounds(10, 261, 481, 51);
			usuariosPanel.add(crearUsuarioPanel);
			crearUsuarioPanel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 14, 55, 14);
			crearUsuarioPanel.add(lblNombre);
			
			textField = new JTextField();
			textField.setBounds(75, 11, 86, 20);
			crearUsuarioPanel.add(textField);
			textField.setColumns(10);
			
			JLabel lblClave = new JLabel("Clave:");
			lblClave.setBounds(181, 14, 42, 14);
			crearUsuarioPanel.add(lblClave);
			
			textField_1 = new JTextField();
			textField_1.setBounds(233, 11, 86, 20);
			crearUsuarioPanel.add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnCrearUsuario = new JButton("Crear usuario");
			btnCrearUsuario.setBounds(344, 10, 112, 23);
			crearUsuarioPanel.add(btnCrearUsuario);
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
			
			JPanel actividadesPanel = new JPanel();
			tabbedPane.addTab("Actividades", null, actividadesPanel, null);
			actividadesPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			actividadesPanel.setLayout(null);
			
			JPanel infoUsuarioPanel = new JPanel();
			infoUsuarioPanel.setLayout(null);
			infoUsuarioPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			infoUsuarioPanel.setBounds(287, 11, 204, 87);
			actividadesPanel.add(infoUsuarioPanel);
			
			JLabel label_2 = new JLabel("Administrador:");
			label_2.setBounds(10, 8, 81, 14);
			infoUsuarioPanel.add(label_2);
			
			textField_2 = new JTextField();
			textField_2.setText((String) null);
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(101, 5, 86, 20);
			infoUsuarioPanel.add(textField_2);
			
			JLabel label_3 = new JLabel("N\u00BA socio:");
			label_3.setBounds(37, 33, 54, 14);
			infoUsuarioPanel.add(label_3);
			
			textField_3 = new JTextField();
			textField_3.setText("<dynamic>");
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(101, 31, 86, 20);
			infoUsuarioPanel.add(textField_3);
			
			JButton button_1 = new JButton("Salir");
			button_1.setBounds(101, 59, 86, 23);
			infoUsuarioPanel.add(button_1);
			
			JButton button_2 = new JButton("?");
			button_2.setBounds(7, 59, 46, 23);
			infoUsuarioPanel.add(button_2);
			
			JPanel BBDDPanel_1 = new JPanel();
			BBDDPanel_1.setLayout(null);
			BBDDPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			BBDDPanel_1.setBounds(10, 11, 269, 238);
			actividadesPanel.add(BBDDPanel_1);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(5, 25, 258, 169);
			BBDDPanel_1.add(scrollPane_1);
			
			JLabel label_6 = new JLabel("Base de datos:");
			label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			label_6.setBounds(5, 11, 82, 14);
			BBDDPanel_1.add(label_6);
			
			JButton button_5 = new JButton("Eliminar selecci\u00F3n");
			button_5.setBounds(5, 205, 139, 23);
			BBDDPanel_1.add(button_5);
			
			JButton button_6 = new JButton("Copia de la BD");
			button_6.setBounds(146, 205, 118, 23);
			BBDDPanel_1.add(button_6);
			
			JPanel pistasPanel = new JPanel();
			tabbedPane.addTab("Pistas", null, pistasPanel, null);
			pistasPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			pistasPanel.setLayout(null);
			
			JPanel infoUsuarioPanel_1 = new JPanel();
			infoUsuarioPanel_1.setLayout(null);
			infoUsuarioPanel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			infoUsuarioPanel_1.setBounds(287, 11, 204, 87);
			pistasPanel.add(infoUsuarioPanel_1);
			
			JLabel label_4 = new JLabel("Administrador:");
			label_4.setBounds(10, 8, 81, 14);
			infoUsuarioPanel_1.add(label_4);
			
			textField_6 = new JTextField();
			textField_6.setText((String) null);
			textField_6.setEditable(false);
			textField_6.setColumns(10);
			textField_6.setBounds(101, 5, 86, 20);
			infoUsuarioPanel_1.add(textField_6);
			
			JLabel label_5 = new JLabel("N\u00BA socio:");
			label_5.setBounds(37, 33, 54, 14);
			infoUsuarioPanel_1.add(label_5);
			
			textField_7 = new JTextField();
			textField_7.setText("<dynamic>");
			textField_7.setEditable(false);
			textField_7.setColumns(10);
			textField_7.setBounds(101, 31, 86, 20);
			infoUsuarioPanel_1.add(textField_7);
			
			JButton button_3 = new JButton("Salir");
			button_3.setBounds(101, 59, 86, 23);
			infoUsuarioPanel_1.add(button_3);
			
			JButton button_4 = new JButton("?");
			button_4.setBounds(7, 59, 46, 23);
			infoUsuarioPanel_1.add(button_4);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(10, 11, 269, 238);
			pistasPanel.add(panel);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(5, 25, 258, 169);
			panel.add(scrollPane_2);
			
			JLabel label_7 = new JLabel("Base de datos:");
			label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			label_7.setBounds(5, 11, 82, 14);
			panel.add(label_7);
			
			JButton button_7 = new JButton("Eliminar selecci\u00F3n");
			button_7.setBounds(5, 205, 139, 23);
			panel.add(button_7);
			
			JButton button_8 = new JButton("Copia de la BD");
			button_8.setBounds(146, 205, 118, 23);
			panel.add(button_8);
			
			try {
				resultado = consulta3.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
				resultado.next();
				nombre = resultado.getString("nombre");
				textField_2.setText(nombre);
				textField_4.setText(nombre);
				textField_6.setText(nombre);
				id_usuario = resultado.getString("id_usuario");
				textField_3.setText(id_usuario);
				textField_5.setText(id_usuario);
				textField_7.setText(id_usuario);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
