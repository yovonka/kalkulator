package kalkulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Kalkulator {

	private static final int _MAX_LENGTH = 16;

	public static void main(String[] args) {
		Kalkulator k = new Kalkulator();
	}
	
String sEkran =null;
String[] sKey = {"1","2","3","C","4","5","6","+","7","8","9","-","0","*","/","="};
	
Buttons[] numButtons = new NumericButton[10];
Buttons[] calButtons = new ComputeButton[6];
	
	
JFrame okno = new JFrame("Kalkulator");
JTextField text = new JTextField(sEkran);
JButton[] bKey = new JButton [16];
Font font = new Font ("System",Font.BOLD,15);
	
double recentValue;
double currentValue;
String znak=null;

Kalkulator(){
	
	setGuiInterface();
	createObjButton();
		
}
	
void setGuiInterface() {
	
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
	
void createObjButton() {
	
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
			addDigitToScreen(sKey);
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

	private void addDigitToScreen(String buttonValue) {
		if(sEkran!=null&&sEkran.length()<16) 
			 sEkran+=buttonValue;
		
		else sEkran=buttonValue;	
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
				currentValue=Double.parseDouble(sEkran);
				oblicz();
				text.setText(clearUnneededSigns(sEkran));
				znak=null;
				recentValue=Double.parseDouble(sEkran);
				sEkran=null;
			}
		}
		else {	
		 if(sEkran!=null) {
			
			if(znak!=null) {
				currentValue=Double.parseDouble(sEkran);
				oblicz();
				text.setText(clearUnneededSigns(sEkran));
			}
			recentValue=Double.parseDouble(sEkran);
			sEkran=null;
		 }
		znak=sKey;
		}
	}
	
	 void oblicz() {  
		 switch(znak){
			 case "+":{
				 recentValue+=currentValue; break;
			 }
			 case "-" :{
				 recentValue-=currentValue; break;
			 }
			 case "/" : {
				 recentValue=recentValue/currentValue; break;
			 }
			 case "*" : {
				 recentValue*=currentValue; break;
			 }	 
		 }
		 //czy warunek if nie lepiej w tej metodzie
		 sEkran = cutShortValueLength(String.valueOf(recentValue)); 
	 }
	String cutShortValueLength(String checkedValue) {
		if(checkedValue.length()>_MAX_LENGTH)
		{
			int valueOfLastIndex =Integer.parseInt(checkedValue.substring(_MAX_LENGTH+1,_MAX_LENGTH+2));
			
			if(valueOfLastIndex>=5) checkedValue=checkedValue.substring(0, _MAX_LENGTH-1)+String.valueOf(Integer.parseInt(checkedValue.substring(_MAX_LENGTH-1,_MAX_LENGTH))+1);	
			else checkedValue=checkedValue.substring(0, _MAX_LENGTH);
		}
		return checkedValue;
	}	
	
	String clearUnneededSigns(String checkedValue) {
		int valueLength = checkedValue.length();
		while((checkedValue.contains(".")) && (checkedValue.charAt(valueLength-1)=='0'||checkedValue.charAt(valueLength-1)=='.')){
				checkedValue=checkedValue.substring(0, valueLength-1);
				valueLength = checkedValue.length();
			}
		
		return checkedValue;
	}	
}
