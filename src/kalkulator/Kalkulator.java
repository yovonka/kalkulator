package kalkulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Kalkulator {

	public static void main(String[] args) {
		Kalkulator k = new Kalkulator();
		System.out.println(k.usunNiepotrzebneZera("3.0"));

	}
	
String sEkran =null;
String[] sKey = {"1","2","3","C","4","5","6","+","7","8","9","-","0","*","/","="};
	
Buttons[] numButtons = new NumericButton[10];
Buttons[] calButtons = new ComputeButton[6];
	
	
JFrame okno = new JFrame("Niezawodny kalkulator");
JTextField text = new JTextField(sEkran);
JButton[] bKey = new JButton [16];
Font font = new Font ("System",Font.BOLD,15);
	
double whatWas;
double whatIs;
String znak=null;
	
	
	Kalkulator(){
		
		for(byte i=0;i<16;i++) {
			bKey[i]=new JButton(sKey[i]);
			okno.add(bKey[i]);
		}
		
		byte index = 0;
		for(byte y=0; y<4;y++) {
			for(byte x=0;x<4;x++) {
				bKey[index].setBounds(10+(x*50),55+(y*50),45,45);
				bKey[index].setFont(font);	
				index++;
			}
			
		}
		
		int j = 0, k = 0;
		for(byte i = 0;i<16;i++) {
			if((i%4==3)||i>12) {
				calButtons[j]=new ComputeButton(sKey[i],bKey[i]);
				j++;
			}
			else {
				numButtons[k]=new NumericButton(sKey[i],bKey[i]);
				k++;
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
		okno.setVisible(true); 
	}
	
class NumericButton implements Buttons, ActionListener{
		
		String sKey;
		Color cKey;
		JButton bKey;

		public Color getColorValue() {
			return cKey;
		}

		public NumericButton(String sKey,  JButton bKey) {
			this.sKey = sKey;
			this.cKey = Color.BLACK;
			this.bKey = bKey;
			bKey.setForeground(cKey);
			bKey.addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			addNumber(sKey);
			}
}

class ComputeButton implements Buttons, ActionListener{
		
		String sKey;
		Color cKey;
		JButton bKey;
		
		public ComputeButton(String sKey,JButton bKey) {
			super();
			this.sKey = sKey;
			this.cKey = Color.RED;
			this.bKey = bKey;
			bKey.setForeground(cKey);
			bKey.addActionListener(this);
		}
		public String getsKey() {
			return sKey;
		}
		public Color getColorValue() {
			return cKey;
		}
		
		public void actionPerformed(ActionEvent e) {
			setZnak(sKey);	
			}
}

	private void addNumber(String sKey) {
		if(sEkran!=null&&sEkran.length()<16) 
			 sEkran+=sKey;
			else  sEkran=sKey;
		
		text.setText(sEkran);
	}

	void setZnak(String sKey) {
		if(sKey=="C") {
			znak=null;
			sEkran=null;
			text.setText(sEkran);
		}
		else if(sKey=="=") {
			if(znak!=null&&sEkran!=null) {
				whatIs=Double.parseDouble(sEkran);
				oblicz();
				text.setText(usunNiepotrzebneZera(sEkran));
				znak=null;
				whatWas=Double.parseDouble(sEkran);
				sEkran=null;
			}
		}
		else {	
		 if(sEkran!=null) {
			
			if(znak!=null) {
				whatIs=Double.parseDouble(sEkran);
				oblicz();
				text.setText(usunNiepotrzebneZera(sEkran));
			}
			whatWas=Double.parseDouble(sEkran);
			sEkran=null;
		 }
		znak=sKey;
		}
	}
	
	 void oblicz() {  
		 switch(znak){
			 case "+":{
				 whatWas+=whatIs; break;
			 }
			 case "-" :{
				 whatWas-=whatIs; break;
			 }
			 case "/" : {
				 whatWas=whatWas/whatIs; break;
			 }
			 case "*" : {
				 whatWas*=whatIs; break;
			 }	 
		 }
		 sEkran = zaokraglij(String.valueOf(whatWas)); 
	 }
	String zaokraglij(String x) {
		if(x.length()>16)
		{
			int i =Integer.parseInt(x.substring(16,17));
			
			if(i>=5) x=x.substring(0, 15)+String.valueOf(Integer.parseInt(x.substring(15,16))+1);
			
			else x=x.substring(0, 16);
		}
		return x;
	}	
	
	String usunNiepotrzebneZera(String x) {
		int i = x.length();
		while((x.contains(".")) && (x.charAt(i-1)=='0'||x.charAt(i-1)=='.')){
				x=x.substring(0, i-1);
				i = x.length();
			}
		
		return x;
	}	
}
