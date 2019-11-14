package ReservaLab;

public class Laboratorio {
	
	private String codigo;
	private int quantidadeMaquinas;
	private char bloco;
	
	public Laboratorio(String codigo, int quantidadeMaquinas, char bloco){
		this.codigo = codigo;
		this.quantidadeMaquinas = quantidadeMaquinas;
		this.bloco = bloco;
	}

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
}
