package Modelo;

public class Reservado {
	private String data;
	private String matricula_prof;
	private boolean reservado;
	private String codigo_lab;

	//construtor
	public Reservado(String data, String matricula_prof, boolean reservado, String codigo_lab){
		this.data = data;
		this.matricula_prof = matricula_prof;
		this.reservado = reservado;
		this.codigo_lab = codigo_lab;
	}
	
	public Reservado(){}

	//gets e sets
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMatricula_prof() {
		return matricula_prof;
	}

	public void setMatricula_prof(String matricula_prof) {
		this.matricula_prof = matricula_prof;
	}

	public boolean getReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public String getCodigo_lab() {
		return codigo_lab;
	}

	public void setCodigo_lab(String codigo_lab) {
		this.codigo_lab = codigo_lab;
	}
}
