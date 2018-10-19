package kalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumButton implements ActionListener {
    private ActionExecutor buttonEx;

    public NumButton(ActionExecutor buttonExecutor) {
        buttonEx = buttonExecutor;
    }


    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        buttonEx.addDigitToScreen((String) b.getText());
    }
}
