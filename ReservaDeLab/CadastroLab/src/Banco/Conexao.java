package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.tools.javac.Main;

import Modelo.Professor;

public class Conexao {
	private Connection conexao;
	
	/*package Banco;

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
	public boolean conectar() {
		
		try {
			String url = "jdbc:sqlite:db/ReservaLab.db";
			
			conexao = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
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
	
	//cria statement para executar um sql
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
	 * Conecta ou cria um bd
	 */
	public boolean conectar() {
		
		try {
			String url = "jdbc:sqlite:db/ReservaLab.db";
			
			conexao = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("Conectado com sucesso!");
		return true;
	}
	
	public boolean desconectar() {
		
		try {
			if(conexao.isClosed() == false) {
				conexao.close();
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("Desconectado!");
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
	
	//cria statement para executar um sql
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
	
	public static void main(String[] args) throws Exception {
		Conexao conexao = new Conexao();
		conexao.conectar();
		conexao.desconectar();
		
		Professor pf = new Professor("Andrey", "123456");
		pf.setSenha("123");
		
		conexao.conectar();
		
		String sqlInserte = "insert into professor (matricula, nome, senha) values (?, ?, ?);";
		
		PreparedStatement prepared = conexao.criarPreparedStatement(sqlInserte);
		
		try {
			prepared.setString(1, pf.getMatricula());
			prepared.setString(2, pf.getNome());
			prepared.setString(3, pf.getSenha());
			
			int resultado = prepared.executeUpdate();
			
			if(resultado == 1) {
				System.out.println("Professor Cadastrado");
			}else {
				System.out.println("Professor não inserido");
			}
		}catch(SQLException e) {
			System.out.println("Professor não inserido");
		}finally {
			if(prepared != null) {
				try {
					prepared.close();
				}catch(SQLException e) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
				}
			}
			conexao.desconectar();
		}
	}
}
