package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendario {

	private Calendar c = Calendar.getInstance();
	private JPanel panelCalendario, panelSemana, panelMes;
	
	public Calendario() {}
	
	public String getDataAtual() {
		/* Retorna a data no formato DD/MM/AAAA
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(c.getTime());
		
		return data;
	}
	
	public String getDiaNome() {
		/* Retorna o dia da semana por extenso, ex sábado
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String dia = sdf.format(c.getTime());
		dia = dia.substring(0,1).toUpperCase().concat(dia.substring(1));
		
		return dia;
	}
	
	public String getNomeMes(){
		/* Retorna o nome do mes por extenso, ex agosto
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("M");
		String mes = sdf.format(c.getTime());
		mes = mes.substring(0,1).toUpperCase().concat(mes.substring(1));
		
		return mes;
	}
	
	public String getAno(){
		/* Retorna o ano no formato 2019
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("Y");
		String ano = sdf.format(c.getTime());
		
		return ano;
	}
	
	public void criaCalendario(JPanel panel){
		/* Cria um calendario grafico em um JPanel passado por parametro
		 */
		panelCalendario = new JPanel(); panelSemana = new JPanel();
		panelMes = new JPanel();
		
		JLabel lbMes = new JLabel(getNomeMes()+", "+getAno());
		panelMes.add(lbMes);
		panelCalendario.setSize(340,150); panelSemana.setSize(340,20);
		panelMes.setSize(340,20);
		panelCalendario.setBounds(100,240,340,150); panelSemana.setBounds(100,220,340,20);
		panelMes.setBounds(100,200,340,20);
		panelCalendario.setLayout(new GridLayout(5,2)); panelSemana.setLayout(new GridLayout(1,1));
		panelMes.setLayout(new GridLayout(1,1));
		panel.add(panelCalendario); panel.add(panelSemana); panel.add(panelMes);
		
		JButton[] btnDias = new JButton[35];
		JLabel[] lbSemana = new JLabel[7];
		
		//adicionando os dias
		for(int i=0; i<lbSemana.length; i++) {
			lbSemana[i] = new JLabel();
			lbSemana[i].setFont(new Font("Verdana",1,10));
			panelSemana.add(lbSemana[i]);
		}
		//adicionando nomes dos dias
		lbSemana[0].setText("D"); lbSemana[1].setText("S"); lbSemana[2].setText("T");
		lbSemana[3].setText("Q"); lbSemana[4].setText("Q"); lbSemana[5].setText("S");
		lbSemana[6].setText("S");
		//preenchendo com botoes
		for(int i=0; i<btnDias.length; i++) {
			btnDias[i] = new JButton();
			btnDias[i].setFont(new Font("Verdana",0,10));
			btnDias[i].setBackground(new Color(248,248,255));
			panelCalendario.add(btnDias[i]);
		}
		//mes de novembro
		for(int i=5, j=0; i<btnDias.length; i++,j++){
			btnDias[i].setText(Integer.toString(j+1));
		}
		
		for(int i=0; i<btnDias.length; i++){
			int j =i;
			btnDias[j].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnDias[j].setBackground(new Color(218,112,214));
					for(int k=0; k<btnDias.length; k++){
						if(k != j)
							btnDias[k].setBackground(new Color(248,248,255));
					}
					String data = getAno()+"/"+getNomeMes()+"/"+btnDias[j].getText();
					System.out.println(data);
					
				}
			});
		}
	}

	public static void main(String[] args) {
		Calendario c = new Calendario();
		System.out.println(c.getDataAtual());
		System.out.println(c.getDiaNome());
		System.out.println(c.getNomeMes());
		System.out.println(c.getAno());
	}
}
