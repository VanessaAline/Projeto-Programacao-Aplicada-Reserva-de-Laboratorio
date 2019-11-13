package Modelo;

public class Professor {
	
	private String nome;
	private int matricula;
	
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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}	
}
