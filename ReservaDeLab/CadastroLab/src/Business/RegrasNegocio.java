package Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Banco.ConexaoBanco;
import Modelo.Professor;


public class RegrasNegocio {
	
	public void novoCadastro(Professor p) {
		
		/*
		 * Isso é um Comando SQL comum de Insert, 
		 * as ? são os paramentros que nós vamos adcionar a base de dados
		 */
		
		String sql = "INSERT INTO PROFESSOR(NOME, MATRICULA, SENHA)" +
		"VALUES (?,?,?)";
		
		//Classe java de conexão com o bd
		Connection conexao = null;
		
		//Classe java de execução de query
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
			
			//Executa a sql para inserção dos dados
			executaQuery.executeUpdate();
			System.out.println("Dados enviado com Sucesso!");

		} catch (Exception erro) {
			erro.printStackTrace();
		} finally {
			
			//Fecha as conexões com o banco
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
