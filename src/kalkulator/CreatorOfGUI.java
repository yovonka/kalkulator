package kalkulator;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class CreatorOfGUI {

	String sEkran;
	String[] sKey = {"1","2","3","C","4","5","6","+","7","8","9","-","0","*","/","="};
	JFrame okno;
	JTextField text;
	JButton[] bKey;
	Font font;;	
	
	public CreatorOfGUI() {
		sEkran =null;
		okno = new JFrame("Kalkulator");
		text = new JTextField(sEkran);
		bKey = new JButton [16];
		font = new Font ("System",Font.BOLD,15);
	}
	

	
	public String getsEkran() {
		return sEkran;
	}

	public JTextField getText() {
		return text;
	}
	
	
	
	void setGuiParameters() {

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
	
	JButton[] makeButtons() {
		
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
	return bKey;
	}

}
