package Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

//import com.sun.tools.javac.Main;

import Modelo.Laboratorio;
import sun.tools.jar.Main;

public class InserirLaboratorio {
	/*
	 * Classe para inserir um lab
	 */
	Conexao conexao = new Conexao();
	
	public void cadastrarLaboratorio(Laboratorio lab){
		
		conexao.conectar();
		
		String sqlInserte = "insert into laboratorio (codigo, quantidademaquinas, bloco) values (?, ?, ?);";
		
		PreparedStatement prepared = conexao.criarPreparedStatement(sqlInserte);
		
		try {
			prepared.setString(1, lab.getCodigo());
			prepared.setInt(2, lab.getQuantidadeMaquinas());
			prepared.setLong(3, lab.getBloco());
			
			int resultado = prepared.executeUpdate();
			
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Laboratorio Cadastrado</p></body></html>");
			}else {
				JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Laboratorio nao Cadastrado</p></body></html>");
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Laboratorio nao Cadastradoo</p></body></html>");
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
