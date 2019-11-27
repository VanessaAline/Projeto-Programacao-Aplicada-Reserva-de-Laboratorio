package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarCadastroProfessor {

	/*
	 * Classe para verificar cadastro do professor
	 */
	public boolean consultaProfessor(String matriculaProf, String senhaProf) {
		Connection c = null;
		Statement stmt = null;
		boolean encontrado = false;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:ReservaDeLab/CadastroLab/db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROFESSOR;");

			while (rs.next() ) {
				String matricula  = rs.getString("matricula");
				String senha = rs.getString("senha");
				
				if(matricula.equals(matriculaProf) && senha.equals(senhaProf)) {
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
