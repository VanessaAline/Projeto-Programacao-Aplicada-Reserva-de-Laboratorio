package Gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Fachada.Fachada;

/*
 * Classe principal onde ficara a GUI
 */

public class InterfaceGUI {
	//atributos
	private JFrame tela = new JFrame("Reserva de Laboratorios");
	private JPanel panel, panelCadastro, panelAcesso;
	private ImageIcon icon = new ImageIcon(getClass().getResource("untitled.png"));
	private ImageIcon icon2 = new ImageIcon(getClass().getResource("Untitled.png"));
	private ImageIcon icon3 = new ImageIcon(getClass().getResource("nabuco.jpg"));
	private JLabel Imagemfundo, lbNomeMatricula, lbAcesso, lbCadastro, lbInsta, lbRodape, lbCabecalho;
	private JLabel lbLogo = new JLabel(icon);
	private JTextField textMatricula;
	private JPasswordField textSenha; //para pegar o texto do password usa getPassword()
	private JButton btnEntrar, btnCadastrar, btnVoltar;
	
	/*
	 * Fachada para acessar outras classes e metodos
	 */
	private Fachada fachada = new Fachada();

	//construtor
	public InterfaceGUI() {}
	
	//metodo inicializa
	public void inicializa() {
		/* Metodo principal da classe InterfaceGUI
		 */
		
		//criando as tabelas
		fachada.criarTabelas();
		
		//Configuracoes da Tela
		tela.setSize(1000,700);
		tela.setVisible(true);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//configuracoes Panel
		panel = new JPanel();
		tela.add(panel);
		panel.setSize(1000,700);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		icon3.setImage(icon3.getImage().getScaledInstance(650,700,100));
		Imagemfundo = new JLabel(icon3);
		panel.add(Imagemfundo);
		Imagemfundo.setVisible(true);
		Imagemfundo.setOpaque(true);
		Imagemfundo.setBackground(Color.BLACK);
		Imagemfundo.setBounds(0,0,650,700);
		
		//logos
		panel.add(lbLogo);
		icon.setImage(icon.getImage().getScaledInstance(250,170,100));
		lbLogo.setBounds(680,60,240,170);
		ImageIcon iconInsta = new ImageIcon(getClass().getResource("insta.png"));
		iconInsta.setImage(iconInsta.getImage().getScaledInstance(25,25,100));
		lbInsta = new JLabel(iconInsta);
		panel.add(lbInsta);
		lbInsta.setBounds(700,580,25,25);
		//rodape e cabecalho
		lbRodape = new JLabel(); lbCabecalho = new JLabel();
		lbRodape.setBounds(0,632,1000,40);
		lbRodape.setBackground(new Color(255,20,147));
		lbRodape.setOpaque(true);
		lbCabecalho.setBounds(0,0,1000,30);
		lbCabecalho.setBackground(new Color(255,20,147));
		lbCabecalho.setOpaque(true);
		
		//clicar no icone do insta ira abrir a pagina do insta
		lbInsta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.instagram.com/uninabuco/"));
				}catch(Exception erro) {}
			}
		});
		mudarMouse(lbInsta); //metodo para alterar o cursor
		Imagemfundo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://vestibular.uninabuco.edu.br/"));
				}catch(Exception erro) {}
			}
		});
		mudarMouse(Imagemfundo); //metodo para alterar o cursor
		
		lbNomeMatricula = new JLabel("Informe sua Matricula");
		panel.add(lbNomeMatricula);
		lbNomeMatricula.setBounds(700,250,160,30);
		lbNomeMatricula.setFont(new Font("Verdana", 0, 14));
		
		//textfields
		textMatricula = new JTextField(); textSenha = new JPasswordField();
		panel.add(textMatricula); panel.add(textSenha);
		textMatricula.setBounds(700,300,200,30);
		textMatricula.setText("Matricula");
		textMatricula.setFont(new Font("Verdana",0, 14));
		textSenha.setBounds(700,340,200,30);
		textSenha.setText("Senha");
		textSenha.setFont(new Font("Verdana",0, 14));

		//acao de clicar dentro ou fora da caixa de texto
		textMatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textMatricula.getText().equals("Matricula")){
					textMatricula.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textMatricula.getText().equals("")) {
					textMatricula.setText("Matricula");
				}
			}
		});
		
		textSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(textSenha.getPassword()).equals("Senha")){
					textSenha.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(new String(textSenha.getPassword()).equals("")) {
					textSenha.setText("Senha");
				}
			}
		});	
		
		//botao entrar
		btnEntrar = new JButton();
		panel.add(btnEntrar);
		btnEntrar.setText("Entrar");
		btnEntrar.setBackground(Color.BLUE);
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Verdana",0,14));
		btnEntrar.setBounds(700,400,100,30);
		
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//code do botao entrar
				boolean acesso = fachada.consultaProfessor(textMatricula.getText(), new String(textSenha.getPassword()));
				if(acesso){
					acessoProfessor();
				}else{
					JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>LOGIN INVALIDO</p></body></html>");
				}
			}
		});
		
		//cadastrar
		lbAcesso = new JLabel("Nao tem acesso?");
		panel.add(lbAcesso);
		lbAcesso.setBounds(700,500,120,30);
		lbAcesso.setFont(new Font("Verdana", 0, 14));
		lbCadastro = new JLabel("Cadastre-se");
		panel.add(lbCadastro);
		lbCadastro.setBounds(825,505,95,20);
		lbCadastro.setFont(new Font("Verdana", 1, 14));
		lbCadastro.setForeground(Color.BLUE);
		novoCadastro(lbCadastro); //chama a funcao novoCadastro
	}
	
	//variaveis para cadastro do professor
	JLabel lbNome, lbMatricula, lbSenha, lbTextoCadastro, lbBorda;
	JTextField textNewNome, textNewMatricula, textNewSenha;
	
	//funcao para cadastrar um professor
	private void novoCadastro(JLabel label) {
		/* Funcao para cadastrar um novo professor
		 * clicando na label
		 */
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//codigo da tela de cadastro
				panelCadastro = new JPanel();
				panel.setVisible(false);
				tela.remove(panel);
				tela.add(panelCadastro);
				panelCadastro.setSize(1000,700);
				panelCadastro.setLayout(null);
				panelCadastro.setBackground(Color.WHITE);
				
				lbTextoCadastro = new JLabel(" CADASTRO DE PROFESSOR");
				panelCadastro.add(lbTextoCadastro);
				lbTextoCadastro.setBackground(Color.WHITE);
				lbTextoCadastro.setOpaque(true);
				lbTextoCadastro.setBounds(100,100,350,30);
				lbTextoCadastro.setFont(new Font("Verdana",1,22));
				panelCadastro.add(lbLogo); panelCadastro.add(lbRodape); panelCadastro.add(lbCabecalho);
				
				lbBorda = new JLabel();
				panelCadastro.add(lbBorda);
				lbBorda.setBorder(new MatteBorder(1, 1, 1, 1, new Color(169,169,169)));
				lbBorda.setBounds(75,115,550,470);
				
				btnCadastrar = new JButton(); btnVoltar = new JButton();
				panelCadastro.add(btnCadastrar);
				btnCadastrar.setText("Cadastrar");
				btnCadastrar.setBackground(Color.BLUE);
				btnCadastrar.setForeground(Color.WHITE);
				btnCadastrar.setFont(new Font("Verdana",0,14));
				btnCadastrar.setBounds(100,500,120,30);
				panelCadastro.add(btnVoltar);
				btnVoltar.setText("Voltar");
				btnVoltar.setBackground(Color.BLUE);
				btnVoltar.setForeground(Color.WHITE);
				btnVoltar.setFont(new Font("Verdana",0,14));
				btnVoltar.setBounds(250,500,120,30);
				
				lbNome = new JLabel("Informe o seu Nome");
				panelCadastro.add(lbNome);
				lbNome.setFont(new Font("Verdana",0,14));
				lbNome.setBounds(100,200,160,30);
				
				textNewNome = new JTextField();
				panelCadastro.add(textNewNome);
				textNewNome.setFont(new Font("Verdana",0,14));
				textNewNome.setBackground(new Color(248,248,255));
				textNewNome.setBounds(100,230,500,30);
				
				lbMatricula = new JLabel("Informe a sua Matricula");
				panelCadastro.add(lbMatricula);
				lbMatricula.setFont(new Font("Verdana",0,14));
				lbMatricula.setBounds(100,270,170,30);
				
				textNewMatricula = new JTextField();
				textMatricula.setText(null);
				panelCadastro.add(textNewMatricula);
				textNewMatricula.setFont(new Font("Verdana",0,14));
				textNewMatricula.setBackground(new Color(248,248,255));
				textNewMatricula.setBounds(100,300,500,30);
				
				lbSenha = new JLabel("Informe sua Senha");
				panelCadastro.add(lbSenha);
				lbSenha.setFont(new Font("Verdana",0,14));
				lbSenha.setBounds(100,340,160,30);
				
				textNewSenha = new JTextField();
				panelCadastro.add(textNewSenha);
				textNewSenha.setFont(new Font("Verdana",0,14));
				textNewSenha.setBackground(new Color(248,248,255));
				textNewSenha.setBounds(100,370,500,30);
				
				//acao do bota cadastrar
				btnCadastrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//onde Ã© realizado o cadastro de um professor
						//verifica se os campos nao sao nulos
						if(textNewMatricula.getText()!=null && textNewNome.getText()!=null && textNewSenha.getText()!=null) {
							fachada.cadastrarProf(textNewMatricula.getText(), textNewNome.getText(), textNewSenha.getText());
						}
					}
				});
				//acao do botao voltar
				btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panelCadastro.setVisible(false);
						tela.remove(panelCadastro);
						tela.add(panel);
						panel.add(lbLogo);
						panel.setVisible(true);
						textMatricula.setText("Matricula");
						textSenha.setText("Senha");
					}
				});
			}
		});
		mudarMouse(label);
	}
	
	//atributos do Painel de Acesso
	private JButton btnReservar = new JButton();
	private JLabel lbNomeProfessor, lbCampo1, lbCampo2, lbMatriculaProfessor, lbLogOut, 
	lbLogo2, lbReserva, lbLab1, lbLab2;
	private JRadioButton rbLaboratorio1, rbLaboratorio2;
	private ButtonGroup btGrupo = new ButtonGroup();

	private void acessoProfessor() {
		/* Funcao para manipulacao da area de acesso do professor
		 */
		//configuracoes do panel
		panelAcesso = new JPanel();
		panel.setVisible(false);
		tela.remove(panel);
		tela.add(panelAcesso);
		panelAcesso.setSize(1000,700);
		panelAcesso.setLayout(null);
		panelAcesso.setBackground(Color.WHITE);

		//adicionando elementos graficos
		panelAcesso.add(lbRodape); panelAcesso.add(lbCabecalho);
		lbLogOut = new JLabel("LogOut");
		lbLogOut.setFont(new Font("Verdana",0,12));
		lbLogOut.setBounds(900,30,50,30);
		panelAcesso.add(lbLogOut);
		
		lbLogo2 = new JLabel(icon2);
		icon2.setImage(icon2.getImage().getScaledInstance(100,70,100));
		panelAcesso.add(lbLogo2);
		lbLogo2.setBounds(790,30,100,70);
		
		lbReserva = new JLabel("RESERVA DE LABORATORIO");
		panelAcesso.add(lbReserva);
		lbReserva.setFont(new Font("Verdana",1,16));
		lbReserva.setBounds(50,50,260,30);
		
		btnReservar.setText("Reservar");
		btnReservar.setBackground(Color.BLUE);
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setFont(new Font("Verdana",0,14));
		btnReservar.setBounds(500,240,120,30);
		panelAcesso.add(btnReservar);

		//passar o mouse no nome logout
		lbLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { //em cima do nome
				lbLogOut.setFont(new Font("Verdana",1,12));
			}
			@Override
			public void mouseExited(MouseEvent e) { //fora do nome
				lbLogOut.setFont(new Font("Verdana",0,12));
			}
			@Override
			//deslogar
			public void mouseClicked(MouseEvent e) {
				panelAcesso.setVisible(false);
				tela.remove(panelAcesso);
				tela.add(panel);
				panel.add(lbLogo);
				panel.setVisible(true);
				textMatricula.setText("Matricula");
				textSenha.setText("Senha");
			}
		});

		//informacoes do professor
		lbNomeProfessor = new JLabel(fachada.consultaNome(textMatricula.getText()));
		lbMatriculaProfessor = new JLabel(textMatricula.getText());
		panelAcesso.add(lbNomeProfessor); panelAcesso.add(lbMatriculaProfessor);
		lbNomeProfessor.setBounds(50,100,300,30);
		lbNomeProfessor.setFont(new Font("Verdana",0,14));
		lbMatriculaProfessor.setBounds(50,130,300,30);
		lbMatriculaProfessor.setFont(new Font("Verdana",0,12));	
		
		//esboco da area onde vai ficar o calendario
		lbCampo1 = new JLabel(); lbCampo2 = new JLabel();
		panelAcesso.add(lbCampo1); panelAcesso.add(lbCampo2);
		lbCampo1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(169,169,169)));
		lbCampo1.setBounds(50,170,880,240);
		lbCampo2.setBorder(new MatteBorder(1, 1, 1, 1, new Color(169,169,169)));
		lbCampo2.setBounds(50,440,880,110);
		
		//info dos labs
		lbLab1 = new JLabel("Laboratorio 1"); lbLab2 = new JLabel("Laboratorio 2");
		panelAcesso.add(lbLab1); panelAcesso.add(lbLab2);
		lbLab1.setFont(new Font("Verdana",0,14)); lbLab2.setFont(new Font("Verdana",0,14));
		lbLab1.setBounds(60,480,100,30); lbLab2.setBounds(60,510,100,30);
		
		//cria o calendario grafico passando um panel por parametro
		fachada.criaCalendario(panelAcesso);
		
		rbLaboratorio1 = new JRadioButton("Laboratorio 1", false);
		rbLaboratorio2 = new JRadioButton("Laboratorio 2", false);
		btGrupo.add(rbLaboratorio1);
		btGrupo.add(rbLaboratorio2);
		panelAcesso.add(rbLaboratorio1); panelAcesso.add(rbLaboratorio2);
		rbLaboratorio1.setBackground(Color.WHITE);
		rbLaboratorio2.setBackground(Color.WHITE);
		rbLaboratorio1.setBounds(500, 300, 150, 30);
		rbLaboratorio2.setBounds(500, 340, 150, 30);
		rbLaboratorio1.setFont(new Font("Verdana",0,14));
		rbLaboratorio2.setFont(new Font("Verdana",0,14));
		
		btnReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if(!fachada.verificaFDS()){
					if(rbLaboratorio1.isSelected()) {
						fachada.criarReserva(fachada.dataBanco(), "11236", textMatricula.getText(), true);
						fachada.inserirReserva();
					}else if(rbLaboratorio2.isSelected()) {
						fachada.criarReserva(fachada.dataBanco(), "26841", textMatricula.getText(), true);
						fachada.inserirReserva();
					}else {
						JOptionPane.showMessageDialog(null, "Selecione um Laboratorio");
					}
				//}
			}
		});
	}
	
	private void mudarMouse(final JLabel label) {
		/* Funcao para mudar o cursor do mouse ao passar por um hiperlink
		 */
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { //em cima no label
				label.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) { //fora da label
				label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}

	//main
	public static void main(String[] args) throws ParseException {
		InterfaceGUI teste = new InterfaceGUI();
		teste.inicializa();
	}
}
