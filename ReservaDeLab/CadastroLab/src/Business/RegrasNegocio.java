package Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Banco.ConexaoBanco;
import Modelo.Professor;


public class RegrasNegocio {
	
	public void novoCadastro(Professor p) {
		
		/*
		 * Isso � um Comando SQL comum de Insert, 
		 * as ? s�o os paramentros que n�s vamos adcionar a base de dados
		 */
		
		String sql = "INSERT INTO PROFESSOR(NOME, MATRICULA, SENHA)" +
		"VALUES (?,?,?)";
		
		//Classe java de conex�o com o bd
		Connection conexao = null;
		
		//Classe java de execu��o de query
		PreparedStatement executaQuery = null;
		
		try {
			//Cria conexao com o banco de dados
			conexao = ConexaoBanco.createConnectionToPostgres();
			
			//Cria um preparedStatement, Classe que executa Query
			executaQuery = conexao.prepareStatement(sql);
			
			//Adiciona o valor do primeiro paramentro sql
			executaQuery.setString(1, p.getNome());
			
			//Adiciona o valor do segundo paramentro sql
			executaQuery.setString(2, p.getMatricula());
			
			//Adiciona o valor do terceiro paramentro sql
			executaQuery.setString(3, p.getSenha());
			
			//Executa a sql para inser��o dos dados
			executaQuery.executeUpdate();
			System.out.println("Dados enviado com Sucesso!");

		} catch (Exception erro) {
			erro.printStackTrace();
		} finally {
			
			//Fecha as conex�es com o banco
			try {
				if(executaQuery != null) {
					executaQuery.close();
				}
				if(conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
