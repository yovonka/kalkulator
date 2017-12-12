package kalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalButton implements  ActionListener{
	
	ActionExecutor buttonEx;
	
	public CalButton(ActionExecutor buttonExecutor) {
		buttonEx=buttonExecutor;
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		buttonEx.setSign((String)b.getText());	
		}
}
