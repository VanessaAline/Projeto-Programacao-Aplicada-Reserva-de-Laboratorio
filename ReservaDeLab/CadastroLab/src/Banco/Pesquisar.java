package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pesquisar {
	Conexao conexao = new Conexao();

	/*public void pesquisar(Laboratorio lab){

		ResultSet result = null;
		Statement state = null;

		conexao.conectar();

		String query = "select reservado from laboratorio where codigo = ?;";

		state = conexao.criarStatement();

		PreparedStatement pState = conexao.criarPreparedStatement(query);

		try{
			pState.setString(1, "11236");
			result = pState.executeQuery(query);

			while(result.next()){
				System.out.println("DADOS");
				System.out.println(result.getBoolean("RESERVADO"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Erro ao consultar</p></body></html>");
		}
	}*/

	//metodo para retornar boolan se achar o valor passado
	public boolean pesquisar2(String str) {

		String sql = "select reservado from reservado where data = ?;";

		boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			// Cria uma conexão com o banco
			conn = conexao.conectar2();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, str);

			// Recupera os dados do banco de dados fornecidos pela query
			rset = pstm.executeQuery();

			// Se a variável "rset" for diferente de null por conta da query
			// Há realmente um player com aquele nick e senha
			if (rset.next()) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	public boolean pesquisarAcesso(String str, String str2) {

		String sql = "select MATRICULA, SENHA from PROFESSOR where MATRICULA = ? and SENHA = ?;";

		boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			// Cria uma conexão com o banco
			conn = conexao.conectar2();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, str);
			
			pstm.setString(2, str2);

			// Recupera os dados do banco de dados fornecidos pela query
			rset = pstm.executeQuery();

			// Se a variável "rset" for diferente de null por conta da query
			// Há realmente um player com aquele nick e senha
			if (rset.next()) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
}
