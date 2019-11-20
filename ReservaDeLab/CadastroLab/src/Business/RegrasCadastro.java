package Business;

import Modelo.Professor;
import Business.RegrasNegocio;

public class RegrasCadastro {
	
	RegrasNegocio prof = new RegrasNegocio();
	
	public boolean Salvar(Professor p) {
		if(p.getMatricula() != null) {
			this.prof.novoCadastro(p);
			return true;
		}
		return false;
	}
}
