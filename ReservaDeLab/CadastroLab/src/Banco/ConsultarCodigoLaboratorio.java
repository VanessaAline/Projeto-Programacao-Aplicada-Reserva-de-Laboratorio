package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarCodigoLaboratorio {
	
	public boolean consultaCodigo(String codigoConsulta) {
		Connection c = null;
		Statement stmt = null;
		boolean encontrado = false;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LABORATORIO;");

			while (rs.next()) {
				String codigoLab = rs.getString("codigo");
				
				if(codigoLab.equals(codigoConsulta)) {					
					encontrado = true;
					break;
				}else {
					encontrado = false;
				}
			}
			rs.close();
			stmt.close();
			c.close();
		}catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return encontrado;
	}
}