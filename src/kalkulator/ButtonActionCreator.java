package kalkulator;

import java.awt.Color;
import javax.swing.JButton;


public class ButtonActionCreator {


	JButton[] bKey = new JButton [16];
	ActionExecutor buttonExecutor;
	
		public ButtonActionCreator(ActionExecutor buttonEx, JButton[] addButtons) {
		buttonExecutor = buttonEx;
		bKey = addButtons;
	}
	
	void createObjButton() {
		
		for(byte i = 0;i<16;i++) {
			if((i%4==3)||i>12) {
				bKey[i].setForeground(Color.RED);
				bKey[i].addActionListener(new CalButton(buttonExecutor));
			}
			else {
				bKey[i].setForeground(Color.BLACK);
				bKey[i].addActionListener(new NumButton(buttonExecutor));
			}
		
		}	
	}
	
}
