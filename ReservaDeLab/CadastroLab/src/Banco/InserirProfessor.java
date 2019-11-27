package Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.sun.tools.javac.Main;

public class InserirProfessor {
	/*
	 * Classe para inserir um professor
	 */
	Conexao conexao = new Conexao();
	
	public void cadastrarProfessor(String matricula, String nome, String senha){
		
		conexao.conectar();
		
		String sqlInserte = "insert into professor (matricula, nome, senha) values (?, ?, ?);";
		
		PreparedStatement prepared = conexao.criarPreparedStatement(sqlInserte);
		
		try {
			prepared.setString(1, matricula);
			prepared.setString(2, nome);
			prepared.setString(3, senha);
			
			int resultado = prepared.executeUpdate();
			
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Professor Cadastrado</p></body></html>");
			}else {
				JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Professor não Cadastrado</p></body></html>");
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Professor não Cadastrado</p></body></html>");
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
