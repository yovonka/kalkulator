package kalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalButton implements ActionListener {

    private ActionExecutor buttonEx;

    public CalButton(ActionExecutor buttonExecutor) {
        buttonEx = buttonExecutor;
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        buttonEx.setSign((String) b.getText());
    }
}
