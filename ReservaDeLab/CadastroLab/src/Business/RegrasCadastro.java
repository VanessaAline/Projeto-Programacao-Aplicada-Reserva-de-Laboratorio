package Business;

import Modelo.Professor;

public class RegrasCadastro {
	
	public boolean validarCadastro(Professor prof) {
		if(prof.getMatricula() != null && prof.getNome() != null && prof.getSenha() != null) {
			return true;
		}
		return false;
	}
	
	public boolean reservado(){
		return false;
	}
}
