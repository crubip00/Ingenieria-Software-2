package Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
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
	private ResultSet resultadoUsuarios;
	private ResultSet resultadoActividades;
	private ResultSet resultadoPistas;
	private ResultSet resultadoPistas2;
	private ResultSet resultadoActividades2;
	DefaultListModel modeloUsuarios = new DefaultListModel();
	DefaultListModel modeloActividades = new DefaultListModel();
	DefaultListModel modeloPistas = new DefaultListModel();
	DefaultListModel modeloPistas2 = new DefaultListModel();
	DefaultListModel modeloActividades2 = new DefaultListModel();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	final JList listUsuarios = new JList();
	final JList listActividades = new JList();
	final JList listActividades2 = new JList();
	final JList listPistas = new JList();
	final JList listPistas2 = new JList();
	private JTextField textField_8;
	private JTextField textField_11;

	public VentanaAdministrador(final Statement consulta3) {
		frmAdministracion = new JFrame();
		frmAdministracion.setTitle("Administracion");
		frmAdministracion.setBounds(100, 100, 545, 421);
		frmAdministracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministracion.getContentPane().setLayout(null);
		
		try {
			resultadoUsuarios = consulta3.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
			resultadoUsuarios.next();
			id_usuario = resultadoUsuarios.getString("id_usuario");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			resultadoUsuarios = consulta3.executeQuery("SELECT * FROM usuarios");
			while(resultadoUsuarios.next()){
				modeloUsuarios.addElement(resultadoUsuarios.getString(1)+"  "+resultadoUsuarios.getString(2)+"  "+resultadoUsuarios.getString(3)+"  "+resultadoUsuarios.getString(4));
			}
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 529, 383);
			frmAdministracion.getContentPane().add(tabbedPane);
			
			JPanel usuariosPanel = new JPanel();
			tabbedPane.addTab("Usuarios", null, usuariosPanel, null);
			usuariosPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			usuariosPanel.setLayout(null);
			
			JPanel tipoCuentaPanel = new JPanel();
			tipoCuentaPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			tipoCuentaPanel.setBounds(287, 109, 227, 140);
			usuariosPanel.add(tipoCuentaPanel);
			tipoCuentaPanel.setLayout(null);
			
			JLabel lblTipoCuenta = new JLabel("Cambiar tipo cuenta:");
			lblTipoCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTipoCuenta.setBounds(10, 11, 137, 14);
			tipoCuentaPanel.add(lblTipoCuenta);
			
			final JComboBox comboBoxPermisos = new JComboBox(var2);
			comboBoxPermisos.setBounds(10, 47, 137, 20);
			tipoCuentaPanel.add(comboBoxPermisos);
			
			JButton btnDarPermiso = new JButton("Dar permiso");
			btnDarPermiso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						String s = String.valueOf(listUsuarios.getSelectedValue());
						String[] sol = s.split("  ");
						try {
							modeloUsuarios.clear();
							consulta3.executeQuery("UPDATE usuarios SET tipo_cuenta = '"+comboBoxPermisos.getSelectedIndex()+"' WHERE id_usuario = '"
									+sol[0]+"' AND nombre = '"+sol[1]+"' AND clave = '"+sol[2]+"' AND tipo_cuenta = '"+sol[3]+"'");
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							resultadoUsuarios = consulta3.executeQuery("SELECT * FROM usuarios ORDER BY id_usuario ASC");
							while(resultadoUsuarios.next()){
								modeloUsuarios.addElement(resultadoUsuarios.getString(1)+"  "+resultadoUsuarios.getString(2)+"  "+resultadoUsuarios.getString(3)+"  "+resultadoUsuarios.getString(4));
							}
							listUsuarios.setModel(modeloUsuarios);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			btnDarPermiso.setBounds(10, 93, 207, 23);
			tipoCuentaPanel.add(btnDarPermiso);
			
			JPanel infoUsuarioPanel_2 = new JPanel();
			infoUsuarioPanel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			infoUsuarioPanel_2.setBounds(287, 11, 227, 87);
			usuariosPanel.add(infoUsuarioPanel_2);
			infoUsuarioPanel_2.setLayout(null);
			
			JLabel label = new JLabel("Administrador:");
			label.setBounds(10, 8, 95, 14);
			infoUsuarioPanel_2.add(label);
			
			textField_4 = new JTextField();
			textField_4.setBounds(115, 5, 102, 20);
			textField_4.setText((String) null);
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			infoUsuarioPanel_2.add(textField_4);
			
			JLabel label_1 = new JLabel("N\u00BA socio:");
			label_1.setBounds(37, 33, 57, 14);
			infoUsuarioPanel_2.add(label_1);
			
			textField_5 = new JTextField();
			textField_5.setBounds(115, 30, 102, 20);
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
			button.setBounds(131, 59, 86, 23);
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
			
			JPanel BBDDPanelUsuarios = new JPanel();
			BBDDPanelUsuarios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			BBDDPanelUsuarios.setBounds(10, 11, 269, 238);
			usuariosPanel.add(BBDDPanelUsuarios);
			BBDDPanelUsuarios.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 25, 258, 169);
			BBDDPanelUsuarios.add(scrollPane);
			
			
			scrollPane.setViewportView(listUsuarios);
			listUsuarios.setModel(modeloUsuarios);
			
			JLabel lblBaseDeDatos = new JLabel("Base de datos:");
			lblBaseDeDatos.setBounds(5, 11, 82, 14);
			BBDDPanelUsuarios.add(lblBaseDeDatos);
			lblBaseDeDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JButton btnEliminarUsuario = new JButton("Eliminar selecci\u00F3n");
			btnEliminarUsuario.setBounds(5, 205, 139, 23);
			BBDDPanelUsuarios.add(btnEliminarUsuario);
			btnEliminarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s = String.valueOf(listUsuarios.getSelectedValue());
					String[] sol = s.split("  ");
					
						try {
							consulta3.executeQuery("DELETE FROM usuarios WHERE id_usuario = '"
									+sol[0]+"' AND nombre = '"+sol[1]+"' AND clave = '"+sol[2]+"' AND tipo_cuenta = '"+sol[3]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloUsuarios.clear();
						modeloActividades.clear();
						modeloPistas.clear();
						
							try {
								consulta3.executeQuery("DELETE FROM actividades WHERE id_usuario = '"
										+sol[0]+"'");
								consulta3.executeQuery("DELETE FROM pistas WHERE id_usuario = '"
										+sol[0]+"'");
								resultadoUsuarios = consulta3.executeQuery("SELECT * FROM usuarios ORDER BY id_usuario ASC");
								while(resultadoUsuarios.next()){
									modeloUsuarios.addElement(resultadoUsuarios.getString(1)+"  "+resultadoUsuarios.getString(2)+"  "+resultadoUsuarios.getString(3)+"  "+resultadoUsuarios.getString(4));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								resultadoActividades = consulta3.executeQuery("SELECT * FROM actividades ORDER BY id_usuario ASC");
								while(resultadoActividades.next()){
									modeloActividades.addElement(resultadoActividades.getString(4)+"  "+resultadoActividades.getString(1)+"  "+resultadoActividades.getString(2)+"  "+resultadoActividades.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								resultadoPistas = consulta3.executeQuery("SELECT * FROM pistas ORDER BY id_usuario ASC");
								while(resultadoPistas.next()){
									modeloPistas.addElement(resultadoPistas.getString(4)+"  "+resultadoPistas.getString(1)+"  "+resultadoPistas.getString(2)+"  "+resultadoPistas.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listUsuarios.setModel(modeloUsuarios);
						listActividades.setModel(modeloActividades);
						listPistas.setModel(modeloPistas);
				}
			});
			
			JButton btnNewButton_2 = new JButton("Copia de la BD");
			btnNewButton_2.setBounds(146, 205, 118, 23);
			BBDDPanelUsuarios.add(btnNewButton_2);
			
			JPanel crearUsuarioPanel = new JPanel();
			crearUsuarioPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			crearUsuarioPanel.setBounds(10, 272, 504, 72);
			usuariosPanel.add(crearUsuarioPanel);
			crearUsuarioPanel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 36, 55, 14);
			crearUsuarioPanel.add(lblNombre);
			
			textField = new JTextField();
			textField.setBounds(64, 33, 86, 20);
			crearUsuarioPanel.add(textField);
			textField.setColumns(10);
			
			JLabel lblClave = new JLabel("Clave:");
			lblClave.setBounds(171, 36, 42, 14);
			crearUsuarioPanel.add(lblClave);
			
			textField_1 = new JTextField();
			textField_1.setBounds(215, 33, 86, 20);
			crearUsuarioPanel.add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnCrearUsuario = new JButton("Crear usuario");
			btnCrearUsuario.setBounds(323, 32, 171, 23);
			crearUsuarioPanel.add(btnCrearUsuario);
			
			JLabel lblCrearNuevoUsuario = new JLabel("Crear nuevo usuario:");
			lblCrearNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCrearNuevoUsuario.setBounds(10, 11, 160, 14);
			crearUsuarioPanel.add(lblCrearNuevoUsuario);
			btnCrearUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cont = 1;
					try {
						resultadoUsuarios = consulta3.executeQuery("SELECT id_usuario FROM usuarios WHERE id_usuario = '" + cont + "'");
						do{
							resultadoUsuarios = consulta3.executeQuery("SELECT id_usuario FROM usuarios WHERE id_usuario = '" + cont + "'");
							cont++;
						}while(resultadoUsuarios.next() == true);
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
						modeloUsuarios.clear();
						try {
							resultadoUsuarios = consulta3.executeQuery("SELECT * FROM usuarios ORDER BY id_usuario ASC");
							while(resultadoUsuarios.next()){
								modeloUsuarios.addElement(resultadoUsuarios.getString(1)+"  "+resultadoUsuarios.getString(2)+"  "+resultadoUsuarios.getString(3)+"  "+resultadoUsuarios.getString(4));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						listUsuarios.setModel(modeloUsuarios);
				}
			});
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileWriter fichero = null;
					String s = "";
					
					try {
						s = s + "USUARIOS:\n";
						resultadoUsuarios = consulta3.executeQuery("SELECT * FROM usuarios");
						while(resultadoUsuarios.next()){
							s = s + resultadoUsuarios.getString(1) + "  " + resultadoUsuarios.getString(2) + 
									"  " + resultadoUsuarios.getString(3) + "  " + resultadoUsuarios.getString(4) + "\n";
						}
						s = s + "\n\n";
						s = s + "ACTIVIDADES:\n";
						resultadoUsuarios = consulta3.executeQuery("SELECT * FROM actividades");
						while(resultadoUsuarios.next()){
							s = s + resultadoUsuarios.getString(1) + "  " + resultadoUsuarios.getString(2) + 
									"  " + resultadoUsuarios.getString(3) + "  " + resultadoUsuarios.getString(4) + "\n";
						}
						s = s + "\n\n";
						s = s + "PISTAS:\n";
						resultadoUsuarios = consulta3.executeQuery("SELECT * FROM pistas");
						while(resultadoUsuarios.next()){
							s = s + resultadoUsuarios.getString(1) + "  " + resultadoUsuarios.getString(2) + 
									"  " + resultadoUsuarios.getString(3) + "  " + resultadoUsuarios.getString(4) + "\n";
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
			infoUsuarioPanel.setBounds(287, 11, 227, 87);
			actividadesPanel.add(infoUsuarioPanel);
			
			JLabel label_2 = new JLabel("Administrador:");
			label_2.setBounds(10, 8, 91, 14);
			infoUsuarioPanel.add(label_2);
			
			textField_2 = new JTextField();
			textField_2.setText((String) null);
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(115, 5, 102, 20);
			infoUsuarioPanel.add(textField_2);
			
			JLabel label_3 = new JLabel("N\u00BA socio:");
			label_3.setBounds(37, 33, 54, 14);
			infoUsuarioPanel.add(label_3);
			
			textField_3 = new JTextField();
			textField_3.setText("<dynamic>");
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(115, 30, 102, 20);
			infoUsuarioPanel.add(textField_3);
			
			JButton button_1 = new JButton("Salir");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Acceder.frmLogin.setVisible(true);
					frmAdministracion.dispose();
				}
			});
			button_1.setBounds(131, 59, 86, 23);
			infoUsuarioPanel.add(button_1);
			
			JButton button_2 = new JButton("?");
			button_2.setBounds(7, 59, 46, 23);
			infoUsuarioPanel.add(button_2);
			
			JPanel BBDDPanelActividades = new JPanel();
			BBDDPanelActividades.setLayout(null);
			BBDDPanelActividades.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			BBDDPanelActividades.setBounds(10, 11, 269, 238);
			actividadesPanel.add(BBDDPanelActividades);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(5, 25, 258, 169);
			BBDDPanelActividades.add(scrollPane_1);
			
			scrollPane_1.setViewportView(listActividades);
			
			JLabel lblBaseDeDatos_4 = new JLabel("Base de datos (reservas):");
			lblBaseDeDatos_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBaseDeDatos_4.setBounds(5, 11, 184, 14);
			BBDDPanelActividades.add(lblBaseDeDatos_4);
			
			JButton btnEliminarActividad = new JButton("Eliminar selecci\u00F3n");
			btnEliminarActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = String.valueOf(listActividades.getSelectedValue());
					String[] sol = s.split("  ");
					
						try {
							consulta3.executeQuery("DELETE FROM actividades WHERE nombre = '"
									+sol[1]+"' AND fecha = '"+sol[2]+"' AND hora = '"+sol[3]+"' AND id_usuario = '"+sol[0]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloActividades.clear();
						
							try {
								resultadoActividades = consulta3.executeQuery("SELECT * FROM actividades ORDER BY id_usuario ASC");
								while(resultadoActividades.next()){
									modeloActividades.addElement(resultadoActividades.getString(4)+"  "+resultadoActividades.getString(1)+"  "+resultadoActividades.getString(2)+"  "+resultadoActividades.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listActividades.setModel(modeloActividades);
				}
			});
			btnEliminarActividad.setBounds(5, 205, 139, 23);
			BBDDPanelActividades.add(btnEliminarActividad);
			
			JButton button_6 = new JButton("Copia de la BD");
			button_6.setBounds(146, 205, 118, 23);
			BBDDPanelActividades.add(button_6);
			
			JPanel pistasPanel = new JPanel();
			tabbedPane.addTab("Pistas", null, pistasPanel, null);
			pistasPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			pistasPanel.setLayout(null);
			
			JPanel infoUsuarioPanel_1 = new JPanel();
			infoUsuarioPanel_1.setLayout(null);
			infoUsuarioPanel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			infoUsuarioPanel_1.setBounds(287, 11, 227, 87);
			pistasPanel.add(infoUsuarioPanel_1);
			
			JLabel label_4 = new JLabel("Administrador:");
			label_4.setBounds(10, 8, 95, 14);
			infoUsuarioPanel_1.add(label_4);
			
			textField_6 = new JTextField();
			textField_6.setText((String) null);
			textField_6.setEditable(false);
			textField_6.setColumns(10);
			textField_6.setBounds(115, 5, 102, 20);
			infoUsuarioPanel_1.add(textField_6);
			
			JLabel label_5 = new JLabel("N\u00BA socio:");
			label_5.setBounds(37, 33, 54, 14);
			infoUsuarioPanel_1.add(label_5);
			
			textField_7 = new JTextField();
			textField_7.setText("<dynamic>");
			textField_7.setEditable(false);
			textField_7.setColumns(10);
			textField_7.setBounds(115, 30, 102, 20);
			infoUsuarioPanel_1.add(textField_7);
			
			JButton button_3 = new JButton("Salir");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Acceder.frmLogin.setVisible(true);
					frmAdministracion.dispose();
				}
			});
			button_3.setBounds(131, 59, 86, 23);
			infoUsuarioPanel_1.add(button_3);
			
			JButton button_4 = new JButton("?");
			button_4.setBounds(7, 59, 46, 23);
			infoUsuarioPanel_1.add(button_4);
			
			JPanel BBDDPanelPistas = new JPanel();
			BBDDPanelPistas.setLayout(null);
			BBDDPanelPistas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			BBDDPanelPistas.setBounds(10, 11, 269, 238);
			pistasPanel.add(BBDDPanelPistas);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(5, 25, 258, 169);
			BBDDPanelPistas.add(scrollPane_2);
			
			scrollPane_2.setViewportView(listPistas);
			
			JLabel lblBaseDeDatos_1 = new JLabel("Base de datos (reservas):");
			lblBaseDeDatos_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBaseDeDatos_1.setBounds(5, 11, 177, 14);
			BBDDPanelPistas.add(lblBaseDeDatos_1);
			
			JButton btnEliminarPistas = new JButton("Eliminar selecci\u00F3n");
			btnEliminarPistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s = String.valueOf(listPistas.getSelectedValue());
					String[] sol = s.split("  ");
					
						try {
							consulta3.executeQuery("DELETE FROM pistas WHERE nombre = '"
									+sol[1]+"' AND fecha = '"+sol[2]+"' AND hora = '"+sol[3]+"' AND id_usuario = '"+sol[0]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloPistas.clear();
						
							try {
								resultadoPistas = consulta3.executeQuery("SELECT * FROM pistas ORDER BY id_usuario ASC");
								while(resultadoPistas.next()){
									modeloPistas.addElement(resultadoPistas.getString(4)+"  "+resultadoPistas.getString(1)+"  "+resultadoPistas.getString(2)+"  "+resultadoPistas.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listPistas.setModel(modeloPistas);
				}
			});
			btnEliminarPistas.setBounds(5, 205, 139, 23);
			BBDDPanelPistas.add(btnEliminarPistas);
			
			JButton button_8 = new JButton("Copia de la BD");
			button_8.setBounds(146, 205, 118, 23);
			BBDDPanelPistas.add(button_8);
			
			JPanel panel = new JPanel();
			panel.setBounds(287, 109, 227, 235);
			pistasPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(10, 26, 207, 164);
			panel.add(scrollPane_3);
			
			
			scrollPane_3.setViewportView(listPistas2);
			
			try {
				resultadoUsuarios = consulta3.executeQuery("SELECT nombre, id_usuario, tipo_cuenta FROM usuarios WHERE nombre = '" + Acceder.getNombre() + "' AND clave = '" + Acceder.getClave() + "'");
				resultadoUsuarios.next();
				nombre = resultadoUsuarios.getString("nombre");
				textField_2.setText(nombre);
				textField_4.setText(nombre);
				textField_6.setText(nombre);
				id_usuario = resultadoUsuarios.getString("id_usuario");
				textField_3.setText(id_usuario);
				textField_5.setText(id_usuario);
				textField_7.setText(id_usuario);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			modeloUsuarios.clear();
			
			try {
				resultadoUsuarios = consulta3.executeQuery("SELECT * FROM usuarios ORDER BY id_usuario ASC");
				while(resultadoUsuarios.next()){
					modeloUsuarios.addElement(resultadoUsuarios.getString(1)+"  "+resultadoUsuarios.getString(2)+"  "+resultadoUsuarios.getString(3)+"  "+resultadoUsuarios.getString(4));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listUsuarios.setModel(modeloUsuarios);
			
			modeloActividades.clear();
			
			try {
				resultadoActividades = consulta3.executeQuery("SELECT * FROM actividades ORDER BY id_usuario ASC");
				while(resultadoActividades.next()){
					modeloActividades.addElement(resultadoActividades.getString(4)+"  "+resultadoActividades.getString(1)+"  "+resultadoActividades.getString(2)+"  "+resultadoActividades.getString(3));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listActividades.setModel(modeloActividades);
			
			modeloActividades2.clear();
			
			try {
				resultadoActividades2 = consulta3.executeQuery("SELECT * FROM actividades_sesiones ORDER BY nombre ASC");
				while(resultadoActividades2.next()){
					modeloActividades2.addElement(resultadoActividades2.getString(4)+"  "+resultadoActividades2.getString(1)+"  "+resultadoActividades2.getString(2)+"  "+resultadoActividades2.getString(3));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listActividades2.setModel(modeloActividades2);
			
			JPanel sesionesPanel = new JPanel();
			sesionesPanel.setBounds(287, 109, 227, 235);
			actividadesPanel.add(sesionesPanel);
			sesionesPanel.setLayout(null);
			
			JLabel lblBaseDeDatos_3 = new JLabel("Base de datos (sesiones):");
			lblBaseDeDatos_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBaseDeDatos_3.setBounds(10, 11, 160, 14);
			sesionesPanel.add(lblBaseDeDatos_3);
			
			JScrollPane scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(10, 26, 207, 164);
			sesionesPanel.add(scrollPane_4);
			
			
			scrollPane_4.setViewportView(listActividades2);
			
			JButton btnEliminarActividad2 = new JButton("Eliminar selecci\u00F3n");
			btnEliminarActividad2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = String.valueOf(listActividades2.getSelectedValue());
					String[] sol = s.split("  ");
					
						try {
							consulta3.executeQuery("DELETE FROM actividades WHERE id_sesion = '"+sol[0]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloActividades.clear();
						
							try {
								resultadoActividades = consulta3.executeQuery("SELECT * FROM actividades ORDER BY id_usuario ASC");
								while(resultadoActividades.next()){
									modeloActividades.addElement(resultadoActividades.getString(4)+"  "+resultadoActividades.getString(1)+"  "+resultadoActividades.getString(2)+"  "+resultadoActividades.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listActividades.setModel(modeloActividades);
					
						try {
							consulta3.executeQuery("DELETE FROM actividades_sesiones WHERE id_sesion = '"
									+sol[0]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloActividades2.clear();
						
							try {
								resultadoActividades2 = consulta3.executeQuery("SELECT * FROM actividades_sesiones ORDER BY id_sesion ASC");
								while(resultadoActividades2.next()){
									modeloActividades2.addElement(resultadoActividades2.getString(4)+"  "+resultadoActividades2.getString(1)+"  "+resultadoActividades2.getString(2)+"  "+resultadoActividades2.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listActividades2.setModel(modeloActividades2);
				}
			});
			btnEliminarActividad2.setBounds(10, 201, 207, 23);
			sesionesPanel.add(btnEliminarActividad2);
			
			JLabel lblDa = new JLabel("D\u00EDa:");
			lblDa.setBounds(10, 290, 35, 14);
			actividadesPanel.add(lblDa);
			
			JLabel lblHora = new JLabel("Hora:");
			lblHora.setBounds(160, 290, 35, 14);
			actividadesPanel.add(lblHora);
			
			JLabel lblNombre_1 = new JLabel("Nombre nueva sesi\u00F3n:");
			lblNombre_1.setBounds(10, 260, 130, 14);
			actividadesPanel.add(lblNombre_1);
			
			textField_11 = new JTextField();
			textField_11.setBounds(141, 257, 139, 20);
			actividadesPanel.add(textField_11);
			textField_11.setColumns(10);
			
			final JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"}));
			comboBox.setBounds(41, 287, 107, 20);
			actividadesPanel.add(comboBox);
			
			final JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"10:00", "11:00", "12:00", "16:00", "17:00", "18:00"}));
			comboBox_1.setBounds(199, 287, 80, 20);
			actividadesPanel.add(comboBox_1);
			
			JButton btnAadir_1 = new JButton("A\u00F1adir");
			btnAadir_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int cont = 1;
					try {
						resultadoActividades2 = consulta3.executeQuery("SELECT id_sesion FROM actividades_sesiones WHERE id_sesion = '" + cont + "'");
						do{
							resultadoActividades2 = consulta3.executeQuery("SELECT id_sesion FROM actividades_sesiones WHERE id_sesion = '" + cont + "'");
							cont++;
						}while(resultadoActividades2.next() == true);
						cont--;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						consulta3.executeQuery("INSERT INTO actividades_sesiones (nombre, dia, hora, id_sesion) " + "values ('"
								+textField_11.getText()+"','"
								+comboBox.getSelectedItem().toString()+"','"
								+comboBox_1.getSelectedItem().toString()+"','"
								+cont+"')");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textField_11.setText("");
						modeloActividades2.clear();
						try {
							resultadoActividades2 = consulta3.executeQuery("SELECT * FROM actividades_sesiones ORDER BY nombre ASC");
							while(resultadoActividades2.next()){
								modeloActividades2.addElement(resultadoActividades2.getString(4)+"  "+resultadoActividades2.getString(1)+"  "+resultadoActividades2.getString(2)+"  "+resultadoActividades2.getString(3));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						listActividades2.setModel(modeloActividades2);
				}
			});
			btnAadir_1.setBounds(141, 316, 138, 23);
			actividadesPanel.add(btnAadir_1);
			
			
			modeloPistas.clear();
			
			try {
				resultadoPistas = consulta3.executeQuery("SELECT * FROM pistas ORDER BY id_usuario ASC");
				while(resultadoPistas.next()){
					modeloPistas.addElement(resultadoPistas.getString(4)+"  "+resultadoPistas.getString(1)+"  "+resultadoPistas.getString(2)+"  "+resultadoPistas.getString(3));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listPistas.setModel(modeloPistas);
			modeloPistas2.clear();
			
			try {
				resultadoPistas2 = consulta3.executeQuery("SELECT * FROM pistas_tipos ORDER BY id_pista ASC");
				while(resultadoPistas2.next()){
					modeloPistas2.addElement(resultadoPistas2.getString(2)+"  "+resultadoPistas2.getString(1));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listPistas2.setModel(modeloPistas2);
			
			
			
			
			JLabel lblBaseDeDatos_2 = new JLabel("Base de datos (pistas) :");
			lblBaseDeDatos_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBaseDeDatos_2.setBounds(10, 11, 160, 14);
			panel.add(lblBaseDeDatos_2);
			
			JButton btnEliminarPistas2 = new JButton("Eliminar selecci\u00F3n");
			btnEliminarPistas2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = String.valueOf(listPistas2.getSelectedValue());
					String[] sol = s.split("  ");
					
						try {
							consulta3.executeQuery("DELETE FROM pistas WHERE nombre = '"+sol[1]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloPistas.clear();
						
							try {
								resultadoPistas = consulta3.executeQuery("SELECT * FROM pistas ORDER BY id_usuario ASC");
								while(resultadoPistas.next()){
									modeloPistas.addElement(resultadoPistas.getString(4)+"  "+resultadoPistas.getString(1)+"  "+resultadoPistas.getString(2)+"  "+resultadoPistas.getString(3));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listPistas.setModel(modeloPistas);
					
						try {
							consulta3.executeQuery("DELETE FROM pistas_tipos WHERE nombre = '"
									+sol[1]+"' AND id_pista = '"+sol[0]+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						modeloPistas2.clear();
						
							try {
								resultadoPistas2 = consulta3.executeQuery("SELECT * FROM pistas_tipos ORDER BY id_pista ASC");
								while(resultadoPistas2.next()){
									modeloPistas2.addElement(resultadoPistas2.getString(2)+"  "+resultadoPistas2.getString(1));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						listPistas2.setModel(modeloPistas2);
				}
			});
			btnEliminarPistas2.setBounds(10, 201, 207, 23);
			panel.add(btnEliminarPistas2);
			
			textField_8 = new JTextField();
			textField_8.setBounds(10, 280, 189, 20);
			pistasPanel.add(textField_8);
			textField_8.setColumns(10);
			
			JLabel lblNombre_2 = new JLabel("Nombre nueva pista:");
			lblNombre_2.setBounds(10, 260, 159, 14);
			pistasPanel.add(lblNombre_2);
			
			JButton btnAadir = new JButton("A\u00F1adir");
			btnAadir.setBounds(10, 306, 159, 23);
			pistasPanel.add(btnAadir);
			btnAadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int cont = 1;
					try {
						resultadoPistas2 = consulta3.executeQuery("SELECT id_pista FROM pistas_tipos WHERE id_pista = '" + cont + "'");
						do{
							resultadoPistas2 = consulta3.executeQuery("SELECT id_pista FROM pistas_tipos WHERE id_pista = '" + cont + "'");
							cont++;
						}while(resultadoPistas2.next() == true);
						cont--;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						consulta3.executeQuery("INSERT INTO pistas_tipos (nombre, id_pista) " + "values ('"
								+textField_8.getText()+"','"
								+cont+"')");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textField_8.setText("");
						modeloPistas2.clear();
						try {
							resultadoPistas2 = consulta3.executeQuery("SELECT * FROM pistas_tipos ORDER BY id_pista ASC");
							while(resultadoPistas2.next()){
								modeloPistas2.addElement(resultadoPistas2.getString(2)+"  "+resultadoPistas2.getString(1));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						listPistas2.setModel(modeloPistas2);
				}
			});
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
