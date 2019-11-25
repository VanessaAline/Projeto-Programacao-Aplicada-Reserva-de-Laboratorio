package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarNomeProfessor {
	public String consultaNome(String matriculaProf) {
		Connection c = null;
		Statement stmt = null;
		String encontrado = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROFESSOR;");

			while (rs.next() ) {
				String matricula = rs.getString("matricula");
				String nome = rs.getString("nome");
				
				if(matricula.equals(matriculaProf)) {
					encontrado = nome;
					break;
				}else {
					encontrado = null;
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
