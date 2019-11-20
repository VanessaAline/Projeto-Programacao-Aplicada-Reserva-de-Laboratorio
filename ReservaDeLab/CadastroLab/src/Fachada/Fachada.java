package Fachada;

import Banco.Inserir;
import Business.RegrasCadastro;
import Modelo.Laboratorio;
import Modelo.Professor;

public class Fachada {
	
	Professor prof;
	Laboratorio lab;
	Inserir insert;
	RegrasCadastro regra;
	
	public Fachada(){
		prof = new Professor();
		lab = new Laboratorio();
		insert = new Inserir();
		regra = new RegrasCadastro();
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
	//implementar melhor
	public boolean reservado(){
		return lab.getReservado();
	}
}
