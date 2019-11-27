package Banco;

import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

	/*
	 * Classee para realizar os inserts iniciais
	 */
	private final Conexao conexaoSqlite;
	
	public CriarTabelas(Conexao conexao) {
		conexaoSqlite = conexao;
	}
	
	public void criarTabelas() throws Exception {
		String sql = "CREATE TABLE IF NOT EXISTS PROFESSOR(MATRICULA TEXT PRIMARY KEY NOT NULL,"
				+ "NOME TEXT NOT NULL, SENHA TEXT NOT NULL);";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS LABORATORIO(CODIGO TEXT PRIMARY KEY NOT NULL,"
				+ "QUANTIDADEMAQUINAS INT NOT NULL, BLOCO VARCHAR(2) NOT NULL);";
		
		String sql3 = "CREATE TABLE IF NOT EXISTS RESERVADO(DATA TEXT NOT NULL,"
				+ "MATRICULA_PROF TEXT REFERENCES PROFESSOR (MATRICULA) NOT NULL,"
				+ "RESERVADO BOOLEAN NOT NULL, CODIGO_LAB TEXT REFERENCES LABORATORIO (CODIGO) NOT NULL,"
				+ " PRIMARY KEY (DATA, CODIGO_LAB))";
		
		String sql4 = "INSERT INTO LABORATORIO (CODIGO, QUANTIDADEMAQUINAS, BLOCO)"
				+ "VALUES ('11236', 30, 'A'), ('26841', 30, 'A');";

		
		//executando o sql acima
		boolean conectou = false;
		
		try {
			conexaoSqlite.conectar();

			Statement state = conexaoSqlite.criarStatement();
			
			state.execute(sql);
			
			state.execute(sql2);
			
			state.execute(sql3);
			
			state.execute(sql4);

		}catch(SQLException e){
			//erro
		}finally {
			if(conectou)
				conexaoSqlite.desconectar();
		}
	}
}
