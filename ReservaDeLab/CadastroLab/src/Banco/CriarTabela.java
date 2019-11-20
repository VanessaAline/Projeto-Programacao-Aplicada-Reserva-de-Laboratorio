package Banco;

import java.beans.Statement;
import java.sql.SQLException;


//erro
public class CriarTabela {

	private final Conexao conexaoSqlite;
	
	public CriarTabela(Conexao conexao) {
		conexaoSqlite = conexao;
	}
	
	public void criarTabelaProfessor() throws Exception {
		String sql = "CREATE TABLE IF NOT EXISTS professor(matricula PRIMARY KEY NOT NULL,"
				+ "nome TEXT NOT NULL, senha TEXT NOT NULL);";
		
		//executando o sql acima
		boolean conectou = false;
		
		try {
			conexaoSqlite.conectar();

			Statement state = (Statement) conexaoSqlite.criarStatement();
			
			state.execute();
		}catch(SQLException e){
			//erro
			
		}finally {
			if(conectou)
				conexaoSqlite.desconectar();
		}
	}
}
