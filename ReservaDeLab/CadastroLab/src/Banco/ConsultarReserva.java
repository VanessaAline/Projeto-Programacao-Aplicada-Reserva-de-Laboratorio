package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarReserva {
	
	private GerarArrayListCodigoLab consultaLab = new GerarArrayListCodigoLab();

	public boolean consultaReserva(String dataConsulta, String codigoLab) {
		Connection c = null;
		Statement stmt = null;
		boolean encontrado = false;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db/ReservaLab.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVADO;");

			while (rs.next()) {
				String dataBanco = rs.getString("data");
				//String codigoBanco = rs.getString("codigo_lab");

				if(dataBanco.equals(dataConsulta)) {
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
	
	public static void main(String[] args) {
		ConsultarReserva con = new ConsultarReserva();
		System.out.println(con.consultaReserva("2019/11/24", "11236"));
	}
}