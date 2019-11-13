package Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cadastro {
	
	//Frame\\
	JFrame tela = new JFrame("Reserva de Laboratórios");
	
	//TextField\\
	JTextField texto1 = new JTextField();
	JTextField texto2 = new JTextField();
	
	//Label\\
	JLabel lblnome = new JLabel();
	JLabel lblmatricula = new JLabel();
	
	
	public Cadastro(){
	//Configurações da Tela\\
	tela.setSize(700,500);
	tela.setVisible(true);
	tela.setLayout(null);
	tela.setResizable(false);
	
	tela.getContentPane().add(texto1);
	texto1.setBounds(300, 200, 80, 20);
	
	tela.getContentPane().add(texto2);
	texto2.setBounds(300, 300, 80, 20);
	
	}
	
	public static void main(String[] args) {
		Cadastro teste = new Cadastro();

	}

}
