package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	private Connection conexao;
	
	/*
	 * Conecta ou cria um bd
	 */
	public Connection conectar() {
		
		try {
			String url = "jdbc:sqlite:ReservaDeLab/CadastroLab/db/ReservaLab.db";
			
			conexao = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		return conexao;
	}
	
	//retorna propria conexao
	public Connection conectar2() {
		
		try {
			String url = "jdbc:sqlite:ReservaDeLab/CadastroLab/db/ReservaLab.db";
			
			conexao = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			
		}
		return conexao;
	}
	
	/*
	 * metodo para fechar a conexao
	 */
	public boolean desconectar() {
		
		try {
			if(conexao.isClosed() == false) {
				conexao.close();
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	//cria statement para executar um sql
	public Statement criarStatement() {
		try {
			return conexao.createStatement();
		}catch(SQLException e) {
			return null;
		}
	}
	
	//cria Prepared statement para executar um sql
	public PreparedStatement criarPreparedStatement(String sql) {
		try {
			return conexao.prepareStatement(sql);
		}catch(SQLException e) {
			return null;
		}
	}

	public Connection getConexao() {
		return conexao;
	}
}
