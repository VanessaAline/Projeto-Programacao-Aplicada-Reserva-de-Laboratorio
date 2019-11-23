package Business;

import Banco.Pesquisar;
import Modelo.Professor;

public class RegrasCadastro {
	
	private Pesquisar consulta = new Pesquisar();
	
	public boolean validarCadastro(Professor prof) {
		if(prof.getMatricula() != null && prof.getNome() != null && prof.getSenha() != null) {
			return true;
		}
		return false;
	}
	
	public boolean validarAcesso(String matricula, String senha){
		if(consulta.pesquisarAcesso(matricula, senha)){
			return true;
		}
		return false;
	}
}
