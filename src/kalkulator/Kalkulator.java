package kalkulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Kalkulator implements ActionListener{

	public static void main(String[] args) {
		new Kalkulator();
	}
	
	String sEkran = "0";
	String[] sKey = {"1","2","3","C","4","5","6","+","7","8","9","-","0","*","/","="};
	Color[] cKey = {Color.BLACK, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE,
			Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE, Color.BLACK, Color.BLUE, Color.BLUE, Color.GREEN};
	long numer1, numer2;
	boolean plus, minus, razy, dziel;
	
	JFrame okno = new JFrame("Kalkulator");
	JTextField text = new JTextField(sEkran);
	JButton[] bKey = new JButton [16];
	Font font = new Font ("System",Font.BOLD,15);
	
	
	Kalkulator(){
		
		for(byte i=0;i<16;i++) {
			bKey[i]=new JButton(sKey[i]);
			okno.add(bKey[i]);
			bKey[i].addActionListener(this);
		}
		
		byte index = 0;
		for(byte y=0; y<4;y++) {
			for(byte x=0;x<4;x++) {
				bKey[index].setBounds(10+(x*50),55+(y*50),45,45);
				bKey[index].setFont(font);
				
				bKey[index].setForeground(cKey[index]);
				index++;
			}
		}
		
		text.setBounds(10, 10, 195, 35);
		text.setFont(new Font("System",Font.BOLD,20));
		text.setEditable(false);
		text.setHorizontalAlignment(JTextField.RIGHT);
		
		okno.add(text);
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setSize(220, 285);
		okno.setLocationRelativeTo(null); // at center
		okno.setResizable(false);
		okno.setLayout(null);
		okno.setVisible(true); //have to be at the end
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object cel = e.getSource()	;
		for(byte i=0;i<16;i++) {
			if(cel==bKey[i]) {
				oblicz(i);
			}
		}
	}
	private void reset() {
		plus = false;
		minus = false;
		razy = false;
		dziel = false;
		
	}
	
	private void oblicz(int i) {
		
		if(cKey[i]==Color.BLACK&& sEkran.length()<16) {
			
			if(sEkran=="0") sEkran=bKey[i].getText();
			else sEkran+=bKey[i].getText();
			
		text.setText(sEkran);
		}
		else if (i==3) {
				sEkran="0";
				reset();
				text.setText(sEkran);
		}// co jesli raz dodaje raz odejmuje, mieszane dzialania
		else if(i==7){
				
			if(plus) {
				numer2 = Long.parseLong(sEkran);
				numer1+=numer2;
				sEkran = String.valueOf(numer1);
				text.setText(sEkran);
				sEkran="0";
				
			}
			else {
				reset();
				plus = true;
				numer1 = Long.parseLong(sEkran);
				sEkran="0";
				
			}
		}
		else if(i==11){
			
			if(minus) {
				numer2 = Long.parseLong(sEkran);
				numer1-=numer2;
				sEkran = String.valueOf(numer1);
				text.setText(sEkran);
				sEkran="0";
				
			}
			else {
				reset();
				minus = true;
				numer1 = Long.parseLong(sEkran);
				sEkran="0";
				
			}
		}
		else if(i==13){
			
			if(razy) {
				numer2 = Long.parseLong(sEkran);
				numer1*=numer2;
				sEkran = String.valueOf(numer1);
				text.setText(sEkran);
				sEkran="0";
				
			}
			else {
				reset();
				razy = true;
				numer1 = Long.parseLong(sEkran);
				sEkran="0";
				
			}
		}
		else if(i==14){
			
			if(dziel) {
				numer2 = Long.parseLong(sEkran);
				numer1/=numer2;
				sEkran = String.valueOf(numer1);
				text.setText(sEkran);
				sEkran="0";
				
			}
			else {
				reset();
				dziel = true;
				numer1 = Long.parseLong(sEkran);
				sEkran="0";
				
			}
		}
		else if(cKey[i]==Color.GREEN){
			
			if(plus) {
				numer2 = Long.parseLong(sEkran);
				numer1+=numer2;
			}
			else if(minus) {
				numer2 = Long.parseLong(sEkran);
				numer1-=numer2;
			}
			else if(razy) {
				numer2 = Long.parseLong(sEkran);
				numer1*=numer2;
			}
			else if(dziel) {
				numer2 = Long.parseLong(sEkran);
				numer1/=numer2;
			}
				
		sEkran = String.valueOf(numer1);
		text.setText(sEkran);
		sEkran="0";
		}
		
	}
	
	
}
