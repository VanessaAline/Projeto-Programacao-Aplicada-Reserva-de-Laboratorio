package Modelo;

public class Professor {
	
	private String nome;
	private String matricula;
	private String senha;
	
	//Construtor
	public Professor(String nome, String matricula, String senha){
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
	}
	
	public Professor(){}

	//GetÂ´s & SetÂ´s
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
}
