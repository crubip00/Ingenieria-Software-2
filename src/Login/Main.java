package Login;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Conexion conexion = new Conexion();
		
		Acceder ventana = new Acceder(conexion);
		ventana.frmLogin.setVisible(true);

	}

}
