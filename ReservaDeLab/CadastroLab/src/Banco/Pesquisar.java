package Banco;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Laboratorio;

public class Pesquisar {
	Conexao conexao = new Conexao();
	
	public void pesquisar(Laboratorio lab){
		
		ResultSet result = null;
		Statement state = null;
		
		conexao.conectar();
		
		String query = "select reservado from laboratorio where codigo = ?;";
		
		state = conexao.criarStatement();
		
		try{
			result = state.executeQuery(query);
			
			while(result.next()){
				System.out.println("DADOS");
				System.out.println(result.getBoolean("RESERVADO"));
			}
		}catch(SQLException e){
			System.out.println("erro!");
		}finally{
			try{
				result.close();
				state.close();
				conexao.desconectar();
			}catch(SQLException e){
				System.out.println("Erro ao fechar!");
			}
		}
	}

	public static void main(String[] args) {
		Pesquisar pes = new Pesquisar();
		Laboratorio lab = new Laboratorio();
		pes.pesquisar(lab);
	}
}
