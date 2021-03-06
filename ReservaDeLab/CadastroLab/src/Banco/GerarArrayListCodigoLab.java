package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GerarArrayListCodigoLab {
	
	/*
	 * Gera um ArrayList com os codigos dos labs
	 */
	public ArrayList<String> consultaLaboratorio() {
		Connection c = null;
		Statement stmt = null;
		ArrayList<String> listaLabs = new ArrayList<String>();

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:ReservaDeLab/CadastroLab/db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LABORATORIO;");

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				
				if(codigo != null) {
					listaLabs.add(codigo);
				}else {	
					listaLabs = null;
				}
			}
			rs.close();
			stmt.close();
			c.close();
		}catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return listaLabs;
	}
}
