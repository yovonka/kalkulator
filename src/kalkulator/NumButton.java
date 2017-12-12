package kalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumButton implements  ActionListener{
	ActionExecutor buttonEx;
	
public NumButton(ActionExecutor buttonExecutor) {
	buttonEx=buttonExecutor;
	}

	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		buttonEx.addDigitToScreen((String)b.getText());
		}
}
