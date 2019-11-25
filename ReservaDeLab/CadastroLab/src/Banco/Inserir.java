package Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Modelo.Professor;
//import sun.applet.Main;

public class Inserir {
	Conexao conexao = new Conexao();
	
	public void cadastrarProfessor(Professor prof){
		
		conexao.conectar();
		
		String sqlInserte = "insert into professor (matricula, nome, senha) values (?, ?, ?);";
		
		PreparedStatement prepared = conexao.criarPreparedStatement(sqlInserte);
		
		try {
			prepared.setString(1, prof.getMatricula());
			prepared.setString(2, prof.getNome());
			prepared.setString(3, prof.getSenha());
			
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
					//Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
				}
			}
			conexao.desconectar();
		}
	}

}
