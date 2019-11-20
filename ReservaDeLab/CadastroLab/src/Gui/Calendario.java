package Gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/* 
 * Classe para manipular datas e criar calendario visual
 */
public class Calendario {
	//atributos
	private Calendar c = Calendar.getInstance();
	private JPanel panelCalendario, panelSemana, panelMes;
	
	//construtor
	public Calendario() {}
	//metodos
	public String getDataAtual() {
		/* Retorna a data no formato DD/MM/AAAA
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(c.getTime());
		
		return data;
	}
	
	public String getDiaNome() {
		/* Retorna o dia da semana por extenso, ex sábado
		 * Converte a primeira letra para MAIUSC
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String dia = sdf.format(c.getTime());
		dia = dia.substring(0,1).toUpperCase().concat(dia.substring(1));
		
		return dia;
	}
	
	public String getNomeMes(){
		/* Retorna o nome do mes por extenso, ex agosto
		 * Converte a primeira letra para MAIUSC
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMM");
		String mes = sdf.format(c.getTime());
		mes = mes.substring(0,1).toUpperCase().concat(mes.substring(1));
		
		return mes;
	}

	public String getAno(){
		/* Retorna o ano no formato '2019'
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("Y");
		String ano = sdf.format(c.getTime());
		
		return ano;
	}
	
	public void criaCalendario(JPanel panel){
		/* Cria um calendario grafico em um JPanel passado por parametro
		 * a principio, somente o mes de novembro
		 */
		panelCalendario = new JPanel(); panelSemana = new JPanel();
		panelMes = new JPanel();
		JLabel lbDia = new JLabel();

		JLabel lbMes = new JLabel(getNomeMes()+" de "+getAno());
		lbMes.setFont(new Font("Verdana",0,14));
		panelMes.add(lbMes);
		panelCalendario.setSize(340,150); panelSemana.setSize(340,20);
		panelMes.setSize(340,20);
		panelCalendario.setBounds(100,240,340,150); panelSemana.setBounds(100,220,340,20);
		panelMes.setBounds(100,200,340,20);
		panelCalendario.setLayout(new GridLayout(5,2)); panelSemana.setLayout(new GridLayout(1,1));
		panelMes.setLayout(new FlowLayout());
		panel.add(panelCalendario); panel.add(panelSemana); panel.add(panelMes);
		
		panel.add(lbDia);
		lbDia.setFont(new Font("Verdana",0,14));
		lbDia.setBounds(60,440,200,30);
		String dia = "Data: "+getDataAtual();
		lbDia.setText(dia);
		
		//botoes e labels
		JButton[] btnDias = new JButton[35];
		JLabel[] lbSemana = new JLabel[7];
		
		//adicionando os dias
		for(int i=0; i<lbSemana.length; i++) {
			lbSemana[i] = new JLabel();
			lbSemana[i].setFont(new Font("Verdana",0,10));
			lbSemana[i].setHorizontalAlignment(SwingConstants.CENTER);
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
			btnDias[i].setText(null);
			panelCalendario.add(btnDias[i]);
		}
		//mes de novembro
		for(int i=5, j=0; i<btnDias.length; i++,j++){
			btnDias[i].setText(Integer.toString(j+1));
		}
		
		//for para mudar a cor no calendario e fazer a manipulacao da data
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
					if(btnDias[j].getText() != null) {
						String newData = "Data: "+btnDias[j].getText()+"/"+(c.get(Calendar.MONTH)+1)+"/"+getAno();
						lbDia.setText(newData);
					}else {
						lbDia.setText("Data: ");
					}
				}
			});
		}
	}
}
