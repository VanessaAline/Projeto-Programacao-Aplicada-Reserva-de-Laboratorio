package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarReserva {
	
	/*
	 * Classe para verificar se tem uma data reservada
	 */
	private GerarArrayListCodigoLab consultaLab = new GerarArrayListCodigoLab();

	public boolean consultaReserva(String dataConsulta, String codigoLab) {
		Connection c = null;
		Statement stmt = null;
		boolean encontrado = false;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:ReservaDeLab/CadastroLab/db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVADO;");

			while (rs.next()) {
				String dataBanco = rs.getString("data");
				String codigo_lab = rs.getString("codigo_lab");

				if(dataBanco.equals(dataConsulta) && codigo_lab.equals(codigoLab)) {
					for(int i=0; i<consultaLab.consultaLaboratorio().size(); i++) {
						if(consultaLab.consultaLaboratorio().get(i).equals(codigoLab)) {
							encontrado = true;
							break;
						}else {
							encontrado = false;
						}
					}
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
