package Fachada;

import java.text.ParseException;
import Business.RegrasCadastro;
import Business.RegrasNegocio;
import Gui.InterfaceGUI;
import Modelo.Professor;
import Gui.InterfaceGUI;

public class Principal {
		
	//main
	public static void main(String[] args) throws ParseException {
		InterfaceGUI teste = new InterfaceGUI();
		teste.inicializa();
		
		RegrasCadastro regras = new RegrasCadastro();
		RegrasNegocio regras1 = new RegrasNegocio();
		
		Professor pessoa2 = new Professor();
		Professor pessoa3 = new Professor();
		Professor pessoa4 = new Professor();
		
		InterfaceGUI teste1 = new InterfaceGUI();
		
		
		pessoa2.setMatricula("01144105");
		pessoa2.setSenha("eu"); 
		regras1.novoCadastro(pessoa2);
		
		pessoa3.setNome("Andrey");
		pessoa3.setMatricula("11033358");
		pessoa3.setSenha("tu");
		regras1.novoCadastro(pessoa3);
		
		pessoa4.setNome("Adriele");
		pessoa4.setMatricula("01257200");
		pessoa4.setSenha("nos");
		regras1.novoCadastro(pessoa4);
		
	}

}
