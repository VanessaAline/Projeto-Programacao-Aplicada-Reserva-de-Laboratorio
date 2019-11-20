package Modelo;

public class Laboratorio {
	
	private String codigo;
	private int quantidadeMaquinas;
	private char bloco;
	private boolean reservado;
	
	//construtor
	public Laboratorio(String codigo, int quantidadeMaquinas, char bloco, boolean reservado){
		this.codigo = codigo;
		this.quantidadeMaquinas = quantidadeMaquinas;
		this.bloco = bloco;
		this.reservado = reservado;
	}
	
	public Laboratorio(){}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getQuantidadeMaquinas() {
		return quantidadeMaquinas;
	}

	public void setQuantidadeMaquinas(int quantidadeMaquinas) {
		this.quantidadeMaquinas = quantidadeMaquinas;
	}

	public char getBloco() {
		return bloco;
	}

	public void setBloco(char bloco) {
		this.bloco = bloco;
	}

	public boolean getReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
}
