package Login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class VentanaTienda {

	JFrame frameTienda;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textUsuario;

	

	
	public VentanaTienda() {
		initialize();
	}

	
	private void initialize() {
		frameTienda = new JFrame();
		frameTienda.setTitle("Tienda 'En Forma'");
		frameTienda.setBounds(100, 100, 662, 659);
		frameTienda.setLocationRelativeTo(null);
		frameTienda.getContentPane().setLayout(null);
		
		
		// Icono y Botones Añadir y borrar Item PROTEINAS a la cesta de compra:
		
		JLabel labelProtes = new JLabel("");
		labelProtes.setBounds(26, 36, 123, 100);
		frameTienda.getContentPane().add(labelProtes);
		labelProtes.setIcon(new ImageIcon("C:\\Users\\CésarJesús\\workspace\\GYM\\images\\Proteina.png"));
		
		JButton anadirProtes = new JButton("Añadir");
		anadirProtes.setBounds(44, 147, 89, 23);
		frameTienda.getContentPane().add(anadirProtes);
		anadirProtes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				

				
				
			}
		});
		
		
		// Icono y Botones Añadir y borrar Item VITAMINAS a la cesta de compra:
		
		
		JLabel labelVitaminas = new JLabel("");
		labelVitaminas.setBounds(217, 50, 107, 85);
		frameTienda.getContentPane().add(labelVitaminas);
		labelVitaminas.setIcon(new ImageIcon(
				"C:\\Users\\C\u00E9sarJes\u00FAs\\workspace\\GYM\\images\\Multivitaminas.png"));
		
		JButton anadirVitaminas = new JButton("Añadir");
		anadirVitaminas.setBounds(227, 147, 89, 23);
		frameTienda.getContentPane().add(anadirVitaminas);
		anadirVitaminas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		
		
		// Icono y Botones Añadir y borrar Item BOLSA DEPORTE a la cesta de compra:
		
		
		
		
		
		textField = new JTextField();
		textField.setBounds(487, 246, 107, 228);
		frameTienda.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(487, 514, 107, 23);
		frameTienda.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(391, 516, 54, 18);
		frameTienda.getContentPane().add(lblTotal);
		
		JLabel lblCestaCompra = new JLabel("Cesta compra: ");
		lblCestaCompra.setBounds(485, 189, 95, 23);
		frameTienda.getContentPane().add(lblCestaCompra);
		
		JLabel labelBolsa = new JLabel("");
		labelBolsa.setIcon(new ImageIcon("C:\\Users\\CésarJesús\\workspace\\GYM\\images\\Bolsadeporte.png"));
		labelBolsa.setBounds(26, 219, 123, 121);
		frameTienda.getContentPane().add(labelBolsa);
		
		JLabel labelPesas = new JLabel("");
		labelPesas.setIcon(new ImageIcon("C:\\Users\\CésarJesús\\workspace\\GYM\\images\\Pesas.png"));
		labelPesas.setBounds(217, 219, 112, 110);
		frameTienda.getContentPane().add(labelPesas);
		
		JButton anadirBolsa = new JButton("Añadir");
		anadirBolsa.setBounds(44, 349, 89, 23);
		frameTienda.getContentPane().add(anadirBolsa);
		
		JButton anadirPesas = new JButton("Añadir");
		anadirPesas.setBounds(227, 349, 89, 23);
		frameTienda.getContentPane().add(anadirPesas);
		
		JLabel labelBarrita = new JLabel("");
		labelBarrita.setIcon(new ImageIcon("C:\\Users\\CésarJesús\\workspace\\GYM\\images\\barrita.png"));
		labelBarrita.setBounds(26, 434, 123, 117);
		frameTienda.getContentPane().add(labelBarrita);
		
		JButton anadirBarrita = new JButton("Añadir");
		anadirBarrita.setBounds(44, 573, 89, 23);
		frameTienda.getContentPane().add(anadirBarrita);
		
		JLabel labelBotellin = new JLabel("");
		labelBotellin.setIcon(new ImageIcon("C:\\Users\\CésarJesús\\workspace\\GYM\\images\\botellin.png"));
		labelBotellin.setBounds(217, 434, 123, 117);
		frameTienda.getContentPane().add(labelBotellin);
		
		JButton AnadirBotellin = new JButton("Añadir");
		AnadirBotellin.setBounds(227, 573, 89, 23);
		frameTienda.getContentPane().add(AnadirBotellin);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(408, 72, 68, 33);
		frameTienda.getContentPane().add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(494, 72, 100, 26);
		frameTienda.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		
	}
}
