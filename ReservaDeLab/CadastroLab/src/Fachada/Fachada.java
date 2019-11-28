package Fachada;

import javax.swing.JButton;
import javax.swing.JPanel;

import Banco.Conexao;
import Banco.ConsultarCadastroProfessor;
import Banco.ConsultarNomeProfessor;
import Banco.ConsultarReserva;
import Banco.CriarTabelas;
import Banco.InserirProfessor;
import Banco.InserirReserva;
import Gui.Calendario;
import Modelo.Professor;
import Modelo.Reservado;

public class Fachada {
	
	/*
	 * Classe que serve de fachada
	 */
	private Professor prof;
	private InserirProfessor insert;
	private Reservado reservadoClasse;
	private InserirReserva reserva;
	private ConsultarCadastroProfessor consultaProf;
	private CriarTabelas createTable;
	private Conexao conexao;
	private Calendario calendario;
	private ConsultarNomeProfessor consultaNome;
	private ConsultarReserva consultaReserva;
	
	public Fachada(){
		prof = new Professor();
		insert = new InserirProfessor();
		consultaProf = new ConsultarCadastroProfessor();
		conexao = new Conexao();
		createTable = new CriarTabelas(conexao);
		calendario = new Calendario();
		consultaNome = new ConsultarNomeProfessor();
		consultaReserva = new ConsultarReserva();
		reserva = new InserirReserva();
		reservadoClasse = new Reservado();
	}

	//InserirProfessor
	public void cadastrarProf(String matricula, String nome, String senha){
		insert.cadastrarProfessor(matricula, nome, senha);
	}
	//InserirProfessor
	public void criarProf(String nome, String matricula, String senha){
		prof.setNome(nome);
		prof.setMatricula(matricula);
		prof.setSenha(senha);
	}
	
	//ConsultarProfessor
	public boolean consultaProfessor(String matricula, String senha) {
		return consultaProf.consultaProfessor(matricula, senha);
	}
	
	//ConsultaNome
	public String consultaNome(String matricula) {
		return consultaNome.consultaNome(matricula);
	}
	
	//CriarTabelas
	public void criarTabelas() {
		try {
			createTable.criarTabelas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Calendario
	public void criaCalendario(JPanel panel) {
		calendario.criaCalendario(panel);
	}
	//Calendario
	public boolean enviarData(String codigoLab) {
		return consultaReserva.consultaReserva(new String(), codigoLab);
	}
	//Calendario
	public String dataBanco(){
		return calendario.enviaDataBanco();
	}
	//calendario
	public String diaNome(String dia) {
		return calendario.getDiaNome(new String());
	}
	
	//ConsultarReserva
	public boolean consultaReserva(String dataConsulta, String codigoLab) {
		return consultaReserva.consultaReserva(dataConsulta, codigoLab);
	}
	
	//InserirReserva
	public void criarReserva(String data, String codigo_lab, String matricula_prof, boolean reservado){
		reservadoClasse.setData(data);
		reservadoClasse.setCodigo_lab(codigo_lab);
		reservadoClasse.setMatricula_prof(matricula_prof);
		reservadoClasse.setReservado(reservado);
	}
	//InserirReserva
	public void inserirReserva(){
		reserva.inserirReserva(reservadoClasse);
	}
	//InserirReserva
	public boolean verificaFDS(){
		return calendario.verificaFDS(new JButton());
	}
	
	//Professor
	public String getMatricula(){
		return prof.getMatricula();
	}
}
