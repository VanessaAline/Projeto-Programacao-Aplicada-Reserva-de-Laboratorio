package Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

//import com.sun.tools.javac.Main;

import Modelo.Reservado;
import sun.tools.jar.Main;

public class InserirReserva {
	/*
	 * Classe para inserir um lab
	 */
	Conexao conexao = new Conexao();
	
	public void inserirReserva(Reservado reservado){
		
		conexao.conectar();
		
		String sqlInserte = "insert into reservado (data, codigo_lab, reservado, matricula_prof) values (?, ?, ?, ?);";
		
		PreparedStatement prepared = conexao.criarPreparedStatement(sqlInserte);
		
		try {
			prepared.setString(1, reservado.getData());
			prepared.setString(2, reservado.getCodigo_lab());
			prepared.setBoolean(3, reservado.getReservado());
			prepared.setString(4, reservado.getMatricula_prof());
			
			int resultado = prepared.executeUpdate();
			
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Laboratorio Reservado</p></body></html>");
			}else {
				JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Laboratorio nao Reservado</p></body></html>");
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Laboratorio nao Reservado</p></body></html>");
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
