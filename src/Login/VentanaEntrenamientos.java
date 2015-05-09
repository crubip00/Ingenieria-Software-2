package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaEntrenamientos {

	 JFrame frameEntrenamientos;

	
	public VentanaEntrenamientos() {
		initialize();
	}

	
	
	private void initialize() {
		frameEntrenamientos = new JFrame();
		frameEntrenamientos.setTitle("Entrenamientos ' En Forma'");
		frameEntrenamientos.setBounds(100, 100, 573, 468);
		frameEntrenamientos.getContentPane().setLayout(null);
		frameEntrenamientos.setLocationRelativeTo(null);
		
		JLabel labelWeider = new JLabel("");
		labelWeider.setIcon(new ImageIcon("C:\\Users\\CésarJesús\\workspace\\GYM\\images\\Weider.png"));
		labelWeider.setBounds(57, 64, 133, 89);
		frameEntrenamientos.getContentPane().add(labelWeider);
		
		JLabel lblNewLabel = new JLabel("Weider");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(90, 30, 89, 23);
		frameEntrenamientos.getContentPane().add(lblNewLabel);
		
		JButton botonPreviaWeider = new JButton("Vista Previa");
		botonPreviaWeider.setBounds(39, 164, 89, 23);
		frameEntrenamientos.getContentPane().add(botonPreviaWeider);
		botonPreviaWeider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String strWeider = " Día 1: Espalda – Tríceps:\n"+
									"Dominadascon las manos hacia atrás: 3 X 6\n"+
									"Jalón frontal: 3 X 12\n"+
									"Remo Gironda: 3 X 12\n"+
									"Press francés: 4 X 10\n"+
									"Extensiones con polea: 3 X 10\n\n\n"+
 
									"Día 2: Pectoral – Bíceps:\n"+
									"Press de banca con barra: 4 X 7\n"+
									"Aperturas con mancuernas: 3 X 12\n"+
									"Máquina contractora de pectoral: 3 X 12\n"+
									"Curl de bíceps martillo con mancuernas: 4 X 10\n"+
									"Curl de bíceps con barra Z en banco Scott: 4 X 10\n\n\n"+
 
									"Día 3: Piernas – Hombros:\n"+
									"Peso muerto: 3 X 8\n"+
									"Contractora de femoral: 4 X 10\n"+
									"Contractora de cuádriceps: 4 X 10\n"+
									"Press de hombro con mancuernas, sentado: 4 X 6\n"+
									"Elevaciones laterales: 3 X 10\n"+
									"Elevaciones frontales: 3 X 10\n ";
				
				JOptionPane.showMessageDialog(null, strWeider, "Vista Previa Weider", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		
		JButton botonDescargarWeider = new JButton("Descargar");
		botonDescargarWeider.setBounds(137, 164, 89, 23);
		frameEntrenamientos.getContentPane().add(botonDescargarWeider);
	}

}
