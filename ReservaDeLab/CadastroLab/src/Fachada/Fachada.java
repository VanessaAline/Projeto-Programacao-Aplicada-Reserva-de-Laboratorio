package Fachada;

import Banco.Inserir;
import Banco.Pesquisar;
import Business.RegrasCadastro;
import Modelo.Laboratorio;
import Modelo.Professor;

public class Fachada {
	
	Professor prof;
	Laboratorio lab;
	Inserir insert;
	RegrasCadastro regra;
	Pesquisar consulta;
	
	public Fachada(){
		prof = new Professor();
		lab = new Laboratorio();
		insert = new Inserir();
		regra = new RegrasCadastro();
		consulta = new Pesquisar();
	}

	public void criarProf(String nome, String matricula, String senha){
		prof.setNome(nome);
		prof.setMatricula(matricula);
		prof.setSenha(senha);
	}
	public void cadastrarProf(){
		insert.cadastrarProfessor(prof);
	}
	public boolean validarCadastro(){
		return regra.validarCadastro(prof);
	}
	//consulta de reserva laboratorio
	public boolean reservado(){
		if(consulta.pesquisar2("")){
			return true;
		}
		return false;
	}
	
	public String consultaProf(){
		String str = prof.getMatricula() + prof.getSenha();
		
		return str;
	}
	
	public String retornaNomeProf(){
		return prof.getNome();
	}
	
	public boolean validarAcesso(String matricula, String senha){
		return regra.validarAcesso(matricula, senha);
	}
}
