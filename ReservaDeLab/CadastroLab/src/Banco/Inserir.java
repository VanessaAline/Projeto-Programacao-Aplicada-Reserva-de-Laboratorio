package Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelo.Professor;
import sun.applet.Main;

public class Inserir {
	
	public void cadastrarProfessor(Professor prof){
		Conexao conexao = new Conexao();
		
		conexao.conectar();
		
		String sqlInserte = "insert into professor (matricula, nome, senha) values (?, ?, ?);";
		
		PreparedStatement prepared = conexao.criarPreparedStatement(sqlInserte);
		
		try {
			prepared.setString(1, prof.getMatricula());
			prepared.setString(2, prof.getNome());
			prepared.setString(3, prof.getSenha());
			
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
