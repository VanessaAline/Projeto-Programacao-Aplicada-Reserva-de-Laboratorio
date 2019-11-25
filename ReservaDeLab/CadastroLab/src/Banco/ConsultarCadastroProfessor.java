package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarCadastroProfessor {

	public boolean consultaProfessor(String matriculaProf, String senhaProf) {
		Connection c = null;
		Statement stmt = null;
		boolean encontrado = false;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROFESSOR;");

			while (rs.next() ) {
				String matricula  = rs.getString("matricula");
				String senha = rs.getString("senha");
				
				if(matricula.equals(matriculaProf) && senha.equals(senhaProf)) {
					encontrado = true;
					//System.out.println("MATRICULA = " + matricula);
					//System.out.println("SENHA = " + senha);
					break;
				}else {
					//System.out.println("Não foi encontrado");
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
	
	public static void main(String[] args) {
		ConsultarCadastroProfessor con = new ConsultarCadastroProfessor();
		System.out.println(con.consultaProfessor("11033358", "46799703"));
	}
}
