package Login;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JList;

public class VentanaTienda {

	JFrame frameTienda;
	private JTextField textTotal;
	private JTextField textUsuario;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList listaCompra;// = new JList();
	@SuppressWarnings("rawtypes")
	private DefaultListModel modelListaCompra;

	DecimalFormat df = new DecimalFormat("0.00");

	private float contadorCesta = 0;

	public VentanaTienda() {
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frameTienda = new JFrame();
		frameTienda.setResizable(false);
		frameTienda.setTitle("Tienda 'En Forma'");
		frameTienda.setBounds(100, 100, 694, 658);
		frameTienda.setLocationRelativeTo(null);
		frameTienda.getContentPane().setLayout(null);

		modelListaCompra = new DefaultListModel();
		listaCompra = new JList(modelListaCompra);

		// listaCompra.setBounds(450, 223, 163, 259);
		frameTienda.getContentPane().add(listaCompra);
		scrollPane = new JScrollPane(listaCompra);
		frameTienda.getContentPane().add(scrollPane);
		scrollPane.setBounds(450, 223, 200, 259);

		// Icono y Botones AÃ±adir y borrar Item PROTEINAS a la cesta de compra:

		JLabel labelProtes = new JLabel("");
		labelProtes.setBounds(26, 36, 123, 100);
		frameTienda.getContentPane().add(labelProtes);
		labelProtes.setIcon(new ImageIcon("images\\Proteina.png"));

		JButton anadirProtes = new JButton("Añadir");
		anadirProtes.setBounds(44, 147, 89, 23);
		frameTienda.getContentPane().add(anadirProtes);
		anadirProtes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				modelListaCompra
						.addElement("Proteinas 5kg.                         29,95€");

				contadorCesta = (float) (contadorCesta + 29.95);

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));
				textTotal.setText(contadorCestastr);

			}
		});

		// Icono y Botones AÃ±adir y borrar Item VITAMINAS a la cesta de compra:

		JLabel labelVitaminas = new JLabel("");
		labelVitaminas.setBounds(217, 50, 107, 85);
		frameTienda.getContentPane().add(labelVitaminas);
		labelVitaminas
				.setIcon(new ImageIcon("images\\Multivitaminas.png"));

		JButton anadirVitaminas = new JButton("Añadir");
		anadirVitaminas.setBounds(227, 147, 89, 23);
		frameTienda.getContentPane().add(anadirVitaminas);
		anadirVitaminas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				modelListaCompra
						.addElement("Multivitaminas 100u.                8,95€");

				contadorCesta = (float) (contadorCesta + 8.95);

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));
				textTotal.setText(contadorCestastr);

			}
		});

		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(582, 514, 54, 23);
		frameTienda.getContentPane().add(textTotal);
		textTotal.setColumns(10);

		String contadorCestastr = String.valueOf(contadorCesta);
		textTotal.setText(contadorCestastr);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(487, 515, 54, 18);
		frameTienda.getContentPane().add(lblTotal);

		JLabel lblCestaCompra = new JLabel("Cesta compra: ");
		lblCestaCompra.setBounds(450, 189, 95, 23);
		frameTienda.getContentPane().add(lblCestaCompra);

		JLabel labelBolsa = new JLabel("");
		labelBolsa
				.setIcon(new ImageIcon("images\\Bolsadeporte.png"));
		labelBolsa.setBounds(26, 219, 123, 121);
		frameTienda.getContentPane().add(labelBolsa);

		JLabel labelPesas = new JLabel("");
		labelPesas.setIcon(new ImageIcon("images\\Pesas.png"));
		labelPesas.setBounds(217, 219, 112, 110);
		frameTienda.getContentPane().add(labelPesas);

		JButton anadirBolsa = new JButton("Añadir");
		anadirBolsa.setBounds(44, 349, 89, 23);
		frameTienda.getContentPane().add(anadirBolsa);
		anadirBolsa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelListaCompra
						.addElement("Mochila                                      21.49€");

				contadorCesta = (float) (contadorCesta + 21.49);

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));
				textTotal.setText(contadorCestastr);

			}
		});

		JButton anadirPesas = new JButton("Añadir");
		anadirPesas.setBounds(227, 349, 89, 23);
		frameTienda.getContentPane().add(anadirPesas);
		anadirPesas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelListaCompra
						.addElement("Mancuernas 5kg 2u.              11.30€");

				contadorCesta = (float) (contadorCesta + 11.30);

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));
				textTotal.setText(contadorCestastr);
			}
		});

		JLabel labelBarrita = new JLabel("");
		labelBarrita.setIcon(new ImageIcon("images\\barrita.png"));
		labelBarrita.setBounds(26, 434, 123, 117);
		frameTienda.getContentPane().add(labelBarrita);

		JButton anadirBarrita = new JButton("Añadir");
		anadirBarrita.setBounds(44, 573, 89, 23);
		frameTienda.getContentPane().add(anadirBarrita);
		anadirBarrita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelListaCompra
						.addElement("Barrita Energetica 1u.              3.99€");

				contadorCesta = (float) (contadorCesta + 3.99);

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));
				textTotal.setText(contadorCestastr);

			}
		});

		JLabel labelBotellin = new JLabel("");
		labelBotellin.setIcon(new ImageIcon("images\\botellin.png"));
		labelBotellin.setBounds(217, 434, 123, 117);
		frameTienda.getContentPane().add(labelBotellin);

		JButton anadirBotellin = new JButton("Añadir");
		anadirBotellin.setBounds(227, 573, 89, 23);
		frameTienda.getContentPane().add(anadirBotellin);
		anadirBotellin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelListaCompra
						.addElement("Botellin 1u.                                  1.99€");

				contadorCesta = (float) (contadorCesta + 1.99);

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));
				textTotal.setText(contadorCestastr);

			}
		});

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(408, 72, 68, 33);
		frameTienda.getContentPane().add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setBounds(494, 72, 100, 26);
		frameTienda.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		textUsuario.setText(VentanaSistema.nombreUsuario);

		JButton botonComprar = new JButton("Comprar");
		botonComprar.setBounds(493, 573, 131, 23);
		frameTienda.getContentPane().add(botonComprar);
		botonComprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String contadorCestastr = String.valueOf(df
						.format(contadorCesta));

				String strCompra = "La compra se ha realizado satisfactoriamente\n "
						+ "por un total de:\n\n" + contadorCestastr +" €";
				
				modelListaCompra.clear();
				textTotal.setText("");
				contadorCesta=0;
					

				JOptionPane.showMessageDialog(null, strCompra,
						"Compra Finalizada", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(562, 189, 88, 20);
		frameTienda.getContentPane().add(botonBorrar);
		botonBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String elemento = (String) listaCompra.getSelectedValue();

				int index = listaCompra.getSelectedIndex();

				modelListaCompra.remove(index);

				String elemento1 = elemento.split(" ")[0];

				if (elemento1.equals("Proteinas")) {
					contadorCesta = (float) (contadorCesta - 29.95);
					String contadorCestastr = String.valueOf(df
							.format(contadorCesta));
					textTotal.setText(contadorCestastr);
				}

				if (elemento1.equals("Multivitaminas")) {
					contadorCesta = (float) (contadorCesta - 8.95);
					String contadorCestastr = String.valueOf(df
							.format(contadorCesta));
					textTotal.setText(contadorCestastr);
				}

				if (elemento1.equals("Mochila")) {
					contadorCesta = (float) (contadorCesta - 21.49);
					String contadorCestastr = String.valueOf(df
							.format(contadorCesta));
					textTotal.setText(contadorCestastr);
				}

				if (elemento1.equals("Mancuernas")) {
					contadorCesta = (float) (contadorCesta - 11.30);
					String contadorCestastr = String.valueOf(df
							.format(contadorCesta));
					textTotal.setText(contadorCestastr);
				}

				if (elemento1.equals("Barrita")) {
					contadorCesta = (float) (contadorCesta - 3.99);
					String contadorCestastr = String.valueOf(df
							.format(contadorCesta));
					textTotal.setText(contadorCestastr);
				}

				if (elemento1.equals("Botellin")) {
					contadorCesta = (float) (contadorCesta - 1.99);
					String contadorCestastr = String.valueOf(df
							.format(contadorCesta));
					textTotal.setText(contadorCestastr);
				}

			}
		});

	}
}
