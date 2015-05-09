package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaFisio {

	JFrame frameFisio;

	
	public VentanaFisio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameFisio = new JFrame();
		frameFisio.setBounds(100, 100, 450, 300);		
		frameFisio.setLocationRelativeTo(null);
		frameFisio.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblPruebaVentanaFisio = new JLabel("Prueba ventana Fisio");
		lblPruebaVentanaFisio.setBounds(69, 67, 153, 37);
		frameFisio.getContentPane().add(lblPruebaVentanaFisio);
	}

}
