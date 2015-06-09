package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaEntrenamientos {

	JFrame frameEntrenamientos;
	private JTextField textUsuario;
	

	public VentanaEntrenamientos(final Statement consulta3) {

		frameEntrenamientos = new JFrame();
		frameEntrenamientos.setResizable(false);
		frameEntrenamientos.setTitle("Entrenamientos ' En Forma'");
		frameEntrenamientos.setBounds(100, 100, 814, 570);
		frameEntrenamientos.getContentPane().setLayout(null);
		frameEntrenamientos.setLocationRelativeTo(null);
		

		// Icono, Botones y Action Listener de weider:

		JLabel labelWeider = new JLabel("");
		labelWeider.setIcon(new ImageIcon("images\\Weider.png"));
		labelWeider.setBounds(55, 98, 133, 89);
		frameEntrenamientos.getContentPane().add(labelWeider);

		JLabel lblNewLabel = new JLabel("Weider");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(90, 64, 89, 23);
		frameEntrenamientos.getContentPane().add(lblNewLabel);

		JButton botonPreviaWeider = new JButton("Vista Previa");
		botonPreviaWeider.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonPreviaWeider.setBounds(33, 210, 95, 23);
		frameEntrenamientos.getContentPane().add(botonPreviaWeider);
		botonPreviaWeider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strWeider = " DÃ­a 1: Espalda â€“ TrÃ­ceps:\n"
						+ "Dominadascon las manos hacia atrÃ¡s: 3 X 6\n"
						+ "JalÃ³n frontal: 3 X 12\n"
						+ "Remo Gironda: 3 X 12\n"
						+ "Press francÃ©s: 4 X 10\n"
						+ "Extensiones con polea: 3 X 10\n\n\n"
						+

						"DÃ­a 2: Pectoral â€“ BÃ­ceps:\n"
						+ "Press de banca con barra: 4 X 7\n"
						+ "Aperturas con mancuernas: 3 X 12\n"
						+ "MÃ¡quina contractora de pectoral: 3 X 12\n"
						+ "Curl de bÃ­ceps martillo con mancuernas: 4 X 10\n"
						+ "Curl de bÃ­ceps con barra Z en banco Scott: 4 X 10\n\n\n"
						+

						"DÃ­a 3: Piernas â€“ Hombros:\n" + "Peso muerto: 3 X 8\n"
						+ "Contractora de femoral: 4 X 10\n"
						+ "Contractora de cuÃ¡driceps: 4 X 10\n"
						+ "Press de hombro con mancuernas, sentado: 4 X 6\n"
						+ "Elevaciones laterales: 3 X 10\n"
						+ "Elevaciones frontales: 3 X 10\n ";

				JOptionPane.showMessageDialog(null, strWeider,
						"Vista Previa Weider", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton botonDescargarWeider = new JButton("Descargar");
		botonDescargarWeider.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDescargarWeider.setBounds(144, 210, 95, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarWeider);
		botonDescargarWeider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				Conexion gc = null;

				try {

					gc = new Conexion();
					conn = gc.getConexion();
					
					

					 String path = "C:\\Users\\CÃ©sarJesÃºs\\Downloads";

					RecuperadorBLOB.RecuperarBLOB(conn, "weider", path);

				} catch (SQLException sqle) {
					System.out.println("Error de acceso a BD:"
							+ sqle.getMessage());
					sqle.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Error de acceso a disco:"
							+ ioe.getMessage());
					ioe.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");

			}

		});

		// Icono, Botones y Action Listener de Full Body:

		JLabel lblFullBody = new JLabel("Full body");
		lblFullBody.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFullBody.setBounds(337, 66, 70, 18);
		frameEntrenamientos.getContentPane().add(lblFullBody);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images\\fullBody.png"));
		lblNewLabel_1.setBounds(318, 98, 133, 89);
		frameEntrenamientos.getContentPane().add(lblNewLabel_1);

		JButton botonPreviaFullBody = new JButton("Vista Previa");
		botonPreviaFullBody.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonPreviaFullBody.setBounds(293, 210, 89, 23);
		frameEntrenamientos.getContentPane().add(botonPreviaFullBody);
		botonPreviaFullBody.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strFullBody = " DÃ­a 1:\n" +

				"Sentadilla 2 x 15 reps.\n" + "Gemelos 1 x 15 reps.\n"
						+ "JalÃ³n al Pecho 2 x 10 reps.\n"
						+ "Press Banca 2 x 10 reps.\n"
						+ "Press Militar 1 x 8 reps.\n"
						+ "Extensiones Antebrazos 1 x 20 reps.\n"
						+ "Abdominales 1 x Max.\n\n\n" +

						"DÃ­a 2:\n" +

						"Peso Muerto  2 x 15 reps.\n"
						+ "Curl Femoral 1 x 15 reps.\n"
						+ "Remo Sentado 2 x 10 reps.\n"
						+ "Press Superior 2 x 10 reps.\n"
						+ "PÃ¡jaros 45Âº 1 x 8 reps.\n"
						+ "Curl Antebrazos 1 x 20 reps.\n"
						+ "Abdominales 1 x Max.\n";

				JOptionPane.showMessageDialog(null, strFullBody,
						"Vista Previa FullBody",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton botonDescargarFullBody = new JButton("Descargar");
		botonDescargarFullBody.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDescargarFullBody.setBounds(403, 210, 89, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarFullBody);
		botonDescargarFullBody.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn = null;
				Conexion gc = null;

				try {

					gc = new Conexion();
					conn = gc.getConexion();

					 String path = "C:\\Users\\CÃ©sarJesÃºs\\Downloads";
					 
					RecuperadorBLOB.RecuperarBLOB(conn, "fullbody", path);

				} catch (SQLException sqle) {
					System.out.println("Error de acceso a BD:"
							+ sqle.getMessage());
					sqle.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Error de acceso a disco:"
							+ ioe.getMessage());
					ioe.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");
				
			}
		});
		
		
		
		
		

		// Icono, Botones y Action Listener de CrosFit:

		JLabel lblCrossfit = new JLabel("CrossFit");
		lblCrossfit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCrossfit.setBounds(632, 66, 82, 18);
		frameEntrenamientos.getContentPane().add(lblCrossfit);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\crossfit.png"));
		label.setBounds(605, 98, 116, 89);
		frameEntrenamientos.getContentPane().add(label);

		JButton botonPreviaCrossFit = new JButton("Vista Previa");
		botonPreviaCrossFit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonPreviaCrossFit.setBounds(558, 210, 89, 23);
		frameEntrenamientos.getContentPane().add(botonPreviaCrossFit);
		botonPreviaCrossFit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strCrossFit = "DÃ­a 1:\n" + "5Ã—5 Sentadilla con barra\n"
						+ "15 Sentadillas con peso corporal\n"
						+ "10 Flexiones\n" + "5 Dominadas con kipping\n\n\n" +

						"DÃ­a 2:\n" +

						"5Ã—5 Press militar con barra\n"
						+ "500 metros de remo\n" + "21 Burpees\n"
						+ "400 metros de remo\n" + "19 Burpees\n"
						+ "300 metros de remo\n" + "17 Burpees\n"
						+ "200 metros de remo\n" + "15 Burpees\n"
						+ "100 metros de remo\n" + "13 Burpees\n\n\n" +

						"DÃ­a 3:\n" +

						"8Ã—3 Peso muerto (Al 75% de nuestra 1RM)\n"
						+ "10 Dominadas con kipping\n"
						+ "10 Sentadillas frontales con 30/20 kg\n\n\n" +

						"DÃ­a 4:\n" +

						"5Ã—5 Press de banca con barra\n"
						+ "20 Abdominales de crossfit\n" + "10 Flexiones\n"
						+ "10 Arrancadas con mancuerna 17,5/12,5 kg\n";

				JOptionPane.showMessageDialog(null, strCrossFit,
						"Vista Previa CrossFit",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton botonDescargarCrossFit = new JButton("Descargar");
		botonDescargarCrossFit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDescargarCrossFit.setBounds(665, 210, 89, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarCrossFit);
		botonDescargarCrossFit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				Conexion gc = null;

				try {

					gc = new Conexion();
					conn = gc.getConexion();

					 String path = "C:\\Users\\CÃ©sarJesÃºs\\Downloads";
					RecuperadorBLOB.RecuperarBLOB(conn, "crossfit", path);

				} catch (SQLException sqle) {
					System.out.println("Error de acceso a BD:"
							+ sqle.getMessage());
					sqle.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Error de acceso a disco:"
							+ ioe.getMessage());
					ioe.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");			
			}
		});
		

		// Icono, Botones y Action Listener de GAP:

		JLabel lblVolumen = new JLabel("GAP");
		lblVolumen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVolumen.setBounds(109, 273, 70, 18);
		frameEntrenamientos.getContentPane().add(lblVolumen);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images\\rutina1.png"));
		label_1.setBounds(70, 319, 133, 121);
		frameEntrenamientos.getContentPane().add(label_1);

		JButton botonDescargarGAP = new JButton("Descargar");
		botonDescargarGAP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDescargarGAP.setBounds(150, 469, 89, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarGAP);
		botonDescargarGAP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Conexion gc = null;

				try {

					gc = new Conexion();
					conn = gc.getConexion();

					 String path = "C:\\Users\\CÃ©sarJesÃºs\\Downloads";

					RecuperadorBLOB.RecuperarBLOB(conn, "gap", path);

				} catch (SQLException sqle) {
					System.out.println("Error de acceso a BD:"
							+ sqle.getMessage());
					sqle.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Error de acceso a disco:"
							+ ioe.getMessage());
					ioe.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");
				}
		});

		JButton botonPreviaGAP = new JButton("Vista Previa");
		botonPreviaGAP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonPreviaGAP.setBounds(33, 469, 89, 23);
		frameEntrenamientos.getContentPane().add(botonPreviaGAP);
		botonPreviaGAP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strGAP = "GAP: ejercicio 1. Piernas y glÃºteos\n" +

				"GAP: ejercicio 2. Muslos y glÃºteos 1\n" +

				"GAP: ejercicio 3. Muslos y glÃºteos 2\n" +

				"GAP: ejercicio 4. Gemelos\n" +

				"GAP: ejercicio 5. Muslos\n" +

				"GAP: ejercicio 6. Abdominales 1\n" +

				"GAP: ejercicio 7. Abdominales 2\n" +

				"GAP: ejercicio 8. Abdominales 3\n";

				JOptionPane.showMessageDialog(null, strGAP, "Vista Previa GAP",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		// Icono, Botones y Action Listener de BODY PUMP:

		JLabel lblBodyPump = new JLabel("Body Pump");
		lblBodyPump.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBodyPump.setBounds(357, 274, 82, 17);
		frameEntrenamientos.getContentPane().add(lblBodyPump);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("images\\bodypump.png"));
		label_2.setBounds(318, 300, 133, 121);
		frameEntrenamientos.getContentPane().add(label_2);

		JButton botonPreviaBodyPump = new JButton("Vista Previa");
		botonPreviaBodyPump.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonPreviaBodyPump.setBounds(293, 469, 89, 23);
		frameEntrenamientos.getContentPane().add(botonPreviaBodyPump);
		botonPreviaBodyPump.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strGAP = "Track 1: Calentamiento.\n"
						+ "Track 2: Piernas y glÃºteos.\n"
						+ "Track 3: Trabajo pectoral.\n"
						+ "Track 4: Espalda y gluteos. (Sentadillas).\n"
						+ "Track 5: TrÃ­ceps.\n" + "Track 6: BÃ­ceps.\n"
						+ "Track 7: Piernas (Genuflexiones).\n"
						+ "Track  8: Hombros.\n" + "Track 9: Abdominales.\n"
						+ "Track 10: RelajaciÃ³n y estiramientos.\n";

				JOptionPane.showMessageDialog(null, strGAP,
						"Vista Previa Body Pump",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton botonDescargarBodyPump = new JButton("Descargar");
		botonDescargarBodyPump.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDescargarBodyPump.setBounds(403, 469, 89, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarBodyPump);
		botonDescargarBodyPump.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Conexion gc = null;

				try {

					gc = new Conexion();
					conn = gc.getConexion();

					 String path = "C:\\Users\\CÃ©sarJesÃºs\\Downloads";
					 
					RecuperadorBLOB.RecuperarBLOB(conn, "bodypump", path);

				} catch (SQLException sqle) {
					System.out.println("Error de acceso a BD:"
							+ sqle.getMessage());
					sqle.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Error de acceso a disco:"
							+ ioe.getMessage());
					ioe.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");			
			}
		});
		
		

		// Icono, Botones y Action Listener de VOLUMEN:

		JLabel lblVolumen_1 = new JLabel("Volumen");
		lblVolumen_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVolumen_1.setBounds(632, 274, 70, 17);
		frameEntrenamientos.getContentPane().add(lblVolumen_1);

		
		JLabel label_3 = new JLabel("");		
		label_3.setIcon(new ImageIcon("images\\volumen.png"));
		
		
		 
		label_3.setBounds(605, 300, 133, 121);
		frameEntrenamientos.getContentPane().add(label_3);

		JButton botonVistaPreviaVolumen = new JButton("Vista Previa");
		botonVistaPreviaVolumen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonVistaPreviaVolumen.setBounds(558, 469, 89, 23);
		frameEntrenamientos.getContentPane().add(botonVistaPreviaVolumen);
		botonVistaPreviaVolumen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strGAP = "RUTINA  << Hipertrofia - Volumen >>\n\n"
						+

						"Estructura: ABAxBABx..\n"
						+ "Descanso entre (sÃºper)series: Cada 2x, 60s / +Myo-reps 5s\n\n\n"
						+

						"<< DÃ�A A >>\n"
						+ "1. SS.A1 Sentadillas  4x10\n"
						+ "2. SS.A2 Dominadas  4x10\n"
						+ "3. SS.B1 Elevaciones de talones  4x30\n"
						+ "4. SS.B2 JalÃ³n al pecho  4x12+3+3+3\n"
						+ "5. SS.C1 Extensiones de cuadriceps  4x12+3+3+3\n"
						+ "6. SS.C2 Scap trap semi-inclinado  4x12+3+3+3\n"
						+ "7. SS.D1 Curl femoral  4x12+3+3+3\n"
						+ "8. SS.D2 Curl predicador  4x12+3+3+3\n\n\n"
						+

						"<< DÃ�A B >>\n"
						+ "1. SS.E1 Press banca semi-inclinado  4x10+2+2+2\n"
						+ "2. SS.E2 Elevaciones posteriores  4x12+3+3+3\n"
						+ "3. SS.F1 Press banca inclinado  4x10+2+2+2\n"
						+ "4. SS.F2 Elevaciones laterales  4x12+3+3+3\n"
						+ "5. SS.G1 Press militar  4x10\n"
						+ "6. SS.G2 Aperturas inclinado  4x12+3+3+3\n"
						+ "7. SS.H1 Extensiones de trÃ­ceps con polea  4x12+3+3+3\n"
						+ "8. SS.H2 Ab wheel  4x12+3+3+3\n";

				JOptionPane.showMessageDialog(null, strGAP,
						"Vista Previa Hipertrofia - Volumen",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton botonDescargarVolumen = new JButton("Descargar");
		botonDescargarVolumen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDescargarVolumen.setBounds(665, 469, 89, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarVolumen);
		botonDescargarVolumen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				Conexion gc = null;

				try {

					gc = new Conexion();
					conn = gc.getConexion();

					 String path = "C:\\Users\\CÃ©sarJesÃºs\\Downloads";					
					RecuperadorBLOB.RecuperarBLOB(conn, "volumen", path);

				} catch (SQLException sqle) {
					System.out.println("Error de acceso a BD:"
							+ sqle.getMessage());
					sqle.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Error de acceso a disco:"
							+ ioe.getMessage());
					ioe.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");
			}
		});
		

		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setBounds(415, 24, 86, 20);
		frameEntrenamientos.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.setText(VentanaSistema.nombreUsuario);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(293, 24, 70, 17);
		frameEntrenamientos.getContentPane().add(lblUsuario);
	}
}
