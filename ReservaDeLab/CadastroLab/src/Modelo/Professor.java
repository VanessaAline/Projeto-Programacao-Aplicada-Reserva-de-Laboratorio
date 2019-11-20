package Modelo;

public class Professor {
	
	private String nome;
	private String matricula;
	private String senha;
	
	//Construtor
	public Professor(String nome, int matricula){
		super();
	}

	//Get´s & Set´s
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
