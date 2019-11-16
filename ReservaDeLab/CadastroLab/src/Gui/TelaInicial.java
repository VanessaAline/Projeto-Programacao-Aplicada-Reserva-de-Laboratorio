package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaInicial {
	//variaveis
	JFrame tela = new JFrame("Reserva de Laboratórios");
	JPanel panel, panelCadastro;
	ImageIcon icon = new ImageIcon(getClass().getResource("untitled.png"));
	JLabel Imagemfundo, lbNomeMatricula, lbAcesso, lbCadastro;
	JLabel lbLogo = new JLabel(icon);
	JTextField textMatricula;
	JPasswordField textSenha; //para pegar o texto do password usa getPassword()
	JButton btnEntrar, btnCadastrar, btnVoltar;

	//construtor
	public TelaInicial() {}
	
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
		Imagemfundo = new JLabel();
		panel.add(Imagemfundo);
		//ficara a imagem promocional da faculdade
		Imagemfundo.setVisible(true);
		Imagemfundo.setOpaque(true);
		Imagemfundo.setBackground(Color.BLACK);
		Imagemfundo.setBounds(0,0,650,700);
		
		//logo da faculdade
		panel.add(lbLogo);
		icon.setImage(icon.getImage().getScaledInstance(250,200,100));
		lbLogo.setBounds(680,60,240,100);
		
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
		
		//cadastrar
		lbAcesso = new JLabel("Não tem acesso?");
		panel.add(lbAcesso);
		lbAcesso.setBounds(700,500,120,30);
		lbAcesso.setFont(new Font("Verdana", 0, 14));
		lbCadastro = new JLabel("Cadastre-se");
		panel.add(lbCadastro);
		lbCadastro.setBounds(825,500,100,30);
		lbCadastro.setFont(new Font("Verdana", 1, 14));
		lbCadastro.setForeground(Color.BLUE);
		novoCadastro(lbCadastro); //chama a funcao novoCadastro
	}
	
	//variaveis para cadastro
	JLabel lbNome, lbMatricula, lbSenha, lbTextoCadastro;
	JTextField textNome, textNewMatricula, texNewtSenha;
	
	//funcao para cadastrar um professor
	public void novoCadastro(JLabel label) {
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
				
				lbTextoCadastro = new JLabel("CADASTRO DE PROFESSOR");
				panelCadastro.add(lbTextoCadastro);
				lbTextoCadastro.setBounds(100,100,350,30);
				lbTextoCadastro.setFont(new Font("Verdana",1,22));
				panelCadastro.add(lbLogo);
				
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
	
	//main
	public static void main(String[] args) {
		TelaInicial teste = new TelaInicial();
		teste.inicializa();
	}
}