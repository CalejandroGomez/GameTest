package GameTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class ConectionBD {
	
	static String url = "jdbc:mysql://localhost:3306/participants?useSSL=false";
	static String user = "root";
	static String password = "alejandro18";	
		
	public void agregar() {

		try (Connection conexion = DriverManager.getConnection(url, user, password);) {

			String fecha = null;

			PreparedStatement ps = conexion.prepareStatement(
					"insert into usuarios (usuario, clave) values (?,?)");

			ps.setString(1, "Pedro");
			ps.setString(2, "1234");
			

			try {
				int resultado = ps.executeUpdate();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "La cédula ya esta registrada");
				return;
			}

	} catch (SQLException sqlEx) {
		sqlEx.printStackTrace();

		}

	}

}
