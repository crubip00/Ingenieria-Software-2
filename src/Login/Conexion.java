package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	static String usuario = "system";
	static String clave = "galleta";
	
	Connection conexion;
	
	
	public Conexion(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConexion(){
		
		return conexion;
		
	}
	
	
}
