package Gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class InterfaceGUI {
	//variaveis
	JFrame tela = new JFrame("Reserva de Laboratórios");
	JPanel panel, panelCadastro, panelAcesso;
	ImageIcon icon = new ImageIcon(getClass().getResource("untitled.png"));
	ImageIcon icon2 = new ImageIcon(getClass().getResource("Untitled.png"));
	ImageIcon icon3 = new ImageIcon(getClass().getResource("nabuco.jpg"));
	JLabel Imagemfundo, lbNomeMatricula, lbAcesso, lbCadastro, lbInsta, lbRodape, lbCabecalho;
	JLabel lbLogo = new JLabel(icon);
	JTextField textMatricula;
	JPasswordField textSenha; //para pegar o texto do password usa getPassword()
	JButton btnEntrar, btnCadastrar, btnVoltar;

	//construtor
	public InterfaceGUI() {}
	
	//metodo inicializa
	public void inicializa() {
		//Configurações da Tela
		tela.setSize(1000,700);
		tela.setVisible(true);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tela.setExtendedState(JFrame.MAXIMIZED_BOTH); teste
		
		panel = new JPanel();
		tela.add(panel);
		panel.setSize(1000,700);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		icon3.setImage(icon3.getImage().getScaledInstance(650,700,100));
		Imagemfundo = new JLabel(icon3);
		panel.add(Imagemfundo);
		//ficara a imagem promocional da faculdade
		Imagemfundo.setVisible(true);
		Imagemfundo.setOpaque(true);
		Imagemfundo.setBackground(Color.BLACK);
		Imagemfundo.setBounds(0,0,650,700);
		
		//logos
		panel.add(lbLogo);
		icon.setImage(icon.getImage().getScaledInstance(250,120,100));
		lbLogo.setBounds(680,60,240,120);
		ImageIcon iconInsta = new ImageIcon(getClass().getResource("insta.png"));
		iconInsta.setImage(iconInsta.getImage().getScaledInstance(25,25,100));
		lbInsta = new JLabel(iconInsta);
		panel.add(lbInsta);
		lbInsta.setBounds(700,580,25,25);
		//rodape
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
		Imagemfundo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://vestibular.uninabuco.edu.br/"));
				}catch(Exception erro) {}
			}
		});
		
		lbNomeMatricula = new JLabel("Informe sua Matrícula");
		panel.add(lbNomeMatricula);
		lbNomeMatricula.setBounds(700,250,160,30);
		lbNomeMatricula.setFont(new Font("Verdana", 0, 14));
		
		//textfields
		textMatricula = new JTextField(); textSenha = new JPasswordField();
		panel.add(textMatricula); panel.add(textSenha);
		textMatricula.setBounds(700,300,200,30);
		textMatricula.setText("Matrícula");
		textMatricula.setFont(new Font("Verdana",0, 14));
		textSenha.setBounds(700,340,200,30);
		textSenha.setText("Senha");
		textSenha.setFont(new Font("Verdana",0, 14));

		//acao de clicar dentro ou fora da caixa de texto
		textMatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textMatricula.getText().equals("Matrícula")){
					textMatricula.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(textMatricula.getText().equals("")) {
					textMatricula.setText("Matrícula");
				}
			}
		});
		
		textSenha.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(textSenha.getText().equals("Senha")){
					textSenha.setText("");
				}
			}

			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(textSenha.getText().equals("")) {
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
				acessoProfessor();
			}
		});
		
		//cadastrar
		lbAcesso = new JLabel("Não tem acesso?");
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
	
	//variaveis para cadastro
	JLabel lbNome, lbMatricula, lbSenha, lbTextoCadastro, lbBorda;
	JTextField textNome, textNewMatricula, textNewSenha;
	
	//funcao para cadastrar um professor
	private void novoCadastro(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//codigo da tela de cadastro
				panelCadastro = new JPanel();
				panel.setVisible(false);
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
				
				textNome = new JTextField();
				panelCadastro.add(textNome);
				textNome.setFont(new Font("Verdana",0,14));
				textNome.setBackground(new Color(248,248,255));
				textNome.setBounds(100,230,500,30);
				
				lbMatricula = new JLabel("Informe a sua Matrícula");
				panelCadastro.add(lbMatricula);
				lbMatricula.setFont(new Font("Verdana",0,14));
				lbMatricula.setBounds(100,270,170,30);
				
				textNewMatricula = new JTextField();
				panelCadastro.add(textNewMatricula);
				textNewMatricula.setFont(new Font("Verdana",0,14));
				textNewMatricula.setBackground(new Color(248,248,255));
				textNewMatricula.setBounds(100,300,500,30);
				
				//falta definir como vai ser a senha, aleatoria ou escolhida
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
						System.exit(0);
						//acao de cadastrar
					}
				});
				//acao do botao voltar
				btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panelCadastro.setVisible(false);
						tela.add(panel);
						panel.add(lbLogo);
						panel.setVisible(true);
					}
				});
			}
		});
	}
	
	JLabel lbNomeProfessor, lbCampo1, lbCampo2, lbMatriculaProfessor, lbLogOut, 
	lbLogo2, lbReserva, lbLab1, lbLab2, lbDia;

	private void acessoProfessor() {
		//configurações do panel
		panelAcesso = new JPanel();
		panel.setVisible(false);
		tela.add(panelAcesso);
		panelAcesso.setSize(1000,700);
		panelAcesso.setLayout(null);
		panelAcesso.setBackground(Color.WHITE);

		//adicionando elementos graficos
		panelAcesso.add(lbRodape); panelAcesso.add(lbCabecalho);
		lbLogOut = new JLabel("LogOut");
		lbLogOut.setFont(new Font("Verdana",0,12));
		lbLogOut.setBounds(900,40,50,30);
		panelAcesso.add(lbLogOut);
		
		lbLogo2 = new JLabel(icon2);
		icon2.setImage(icon2.getImage().getScaledInstance(100,50,100));
		panelAcesso.add(lbLogo2);
		lbLogo2.setBounds(790,30,100,50);
		
		lbReserva = new JLabel("RESERVA DE LABORATÓRIO");
		panelAcesso.add(lbReserva);
		lbReserva.setFont(new Font("Verdana",1,16));
		lbReserva.setBounds(50,50,260,30);
		
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
			public void mouseClicked(MouseEvent e) {
				panelAcesso.setVisible(false);
				tela.add(panel);
				panel.add(lbLogo);
				panel.setVisible(true);
			}
		});
		
		//informacoes do professor
		lbNomeProfessor = new JLabel("Andrey Roberto Serafim Ferreira");
		lbMatriculaProfessor = new JLabel("11033358");
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
		//lbCampo1.setOpaque(true); lbCampo1.setBackground(new Color(248,248,255)); //remover
		lbCampo2.setBorder(new MatteBorder(1, 1, 1, 1, new Color(169,169,169)));
		lbCampo2.setBounds(50,440,880,110);
		//lbCampo2.setOpaque(true); lbCampo2.setBackground(new Color(248,248,255)); //remover
		
		//info dos labs
		lbLab1 = new JLabel("Laboratório 1"); lbLab2 = new JLabel("Laboratório 2");
		panelAcesso.add(lbLab1); panelAcesso.add(lbLab2);
		lbLab1.setFont(new Font("Verdana",0,14)); lbLab2.setFont(new Font("Verdana",0,14));
		lbLab1.setBounds(60,480,100,30); lbLab2.setBounds(60,510,100,30);
		//lbLab1.setForeground(new Color(255,20,147)); lbLab2.setForeground(new Color(255,20,147));
		
		lbDia = new JLabel(); //exemplo de data
		panelAcesso.add(lbDia);
		lbDia.setFont(new Font("Verdana",0,14));
		lbDia.setBounds(60,440,200,30);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfn = new SimpleDateFormat("EEEE");
		String dia = sdfn.format(c.getTime())+", "+sdf.format(c.getTime());
		dia = dia.substring(0,1).toUpperCase().concat(dia.substring(1));
		lbDia.setText(dia);
		//Calendario c = new Calendario();
		//lbDia.setText(c.getDataAtual());
		
		//tentativa de calendario, criar classe
		JPanel panelCalendario, panelSemana, panelMes;
		panelCalendario = new JPanel(); panelSemana = new JPanel();
		panelMes = new JPanel();
		SimpleDateFormat sdfm = new SimpleDateFormat("MMMMM"); //nome do mes
		JLabel lbMes = new JLabel(sdfm.format(c.getTime())+", "+c.get(Calendar.YEAR)); //nome do mes
		panelMes.add(lbMes);
		//panelCalendario.setBackground(Color.DARK_GRAY);
		panelCalendario.setSize(340,150); panelSemana.setSize(340,20);
		panelMes.setSize(340,20);
		panelCalendario.setBounds(100,240,340,150); panelSemana.setBounds(100,220,340,20);
		panelMes.setBounds(100,200,340,20);
		panelCalendario.setLayout(new GridLayout(5,2)); panelSemana.setLayout(new GridLayout(1,1));
		panelMes.setLayout(new GridLayout(1,1));
		panelAcesso.add(panelCalendario); panelAcesso.add(panelSemana); panelAcesso.add(panelMes);
		
		JButton[] btnDias = new JButton[35];
		JLabel[] lbSemana = new JLabel[7];
		
		for(int i=0; i<lbSemana.length; i++) {
			lbSemana[i] = new JLabel();
			lbSemana[i].setFont(new Font("Verdana",1,10));
			lbSemana[i].setHorizontalTextPosition(SwingConstants.CENTER);
			panelSemana.add(lbSemana[i]);
		}
		
		lbSemana[0].setText("D"); lbSemana[1].setText("S"); lbSemana[2].setText("T");
		lbSemana[3].setText("Q"); lbSemana[4].setText("Q"); lbSemana[5].setText("S");
		lbSemana[6].setText("S");
		
		for(int i=0; i<btnDias.length; i++) {
			btnDias[i] = new JButton();
			btnDias[i].setFont(new Font("Verdana",0,10));
			btnDias[i].setBackground(new Color(248,248,255));
			//btnDias[i].setText(Integer.toString(i+1));
			panelCalendario.add(btnDias[i]);
		}
		for(int i=5, j=0; i<btnDias.length; i++,j++){
			btnDias[i].setText(Integer.toString(j+1));
		}
	}

	//main
	public static void main(String[] args) throws ParseException {
		InterfaceGUI teste = new InterfaceGUI();
		teste.inicializa();
	}
}
