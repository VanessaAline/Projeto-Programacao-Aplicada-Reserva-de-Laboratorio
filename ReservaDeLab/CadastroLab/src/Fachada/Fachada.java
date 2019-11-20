package Fachada;

import Banco.Inserir;
import Modelo.Laboratorio;
import Modelo.Professor;

public class Fachada {
	
	Professor prof;
	Laboratorio lab;
	Inserir insert;
	
	public Fachada(){
		prof = new Professor();
		lab = new Laboratorio();
		insert = new Inserir();
	}

	public void criarProf(String nome, String matricula, String senha){
		prof.setNome(nome);
		prof.setMatricula(matricula);
		prof.setSenha(senha);
	}
	public void cadastrarProf(){
		insert.cadastrarProfessor(prof);
	}
}
