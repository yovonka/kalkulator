package kalkulator;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;


public class CreatorOfGUI {

    private static final String LABEL = "Kalkulator";
    private static final int WINDOW_WIDTH = 250;
    private static final int WINDOW_HEIGHT = 250;

    private JFrame mainFrame = new JFrame(LABEL);
    private JTextField textField = new JTextField("");
    private Font font = new Font("System", Font.BOLD, 25);
    private ValueContainer valueContainer = new ValueContainer(textField, "0");
    private MathOperator mathOperator = new MathOperator(valueContainer);

    public CreatorOfGUI() {
        setGuiParameters();
    }


    private void setGuiParameters() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        BorderLayout borderLayout = new BorderLayout();
        mainFrame.setLayout(borderLayout);

        textField.setFont(font);
        textField.setSize(250, 10);
        textField.setEditable(false);
        textField.setBackground(Color.CYAN);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        mainFrame.add(textField, BorderLayout.NORTH);
        mainFrame.add(getButtonsPanel(), BorderLayout.CENTER);
    }

    private Container getButtonsPanel() {
        Container buttonsPanel = new Container();
        buttonsPanel.setLayout(new GridLayout(4, 3, 1, 1));

        Stream.of(ButtonValue.values())
                .forEach(button -> {
                    JButton but = new JButton(button.getName());
                    but.setSize(5, 5);
                    but.addActionListener(e -> {
                        String text = ((JButton) e.getSource()).getText();
                        Integer value = ButtonValue.find(text).map(ButtonValue::getValue).orElse(null);
                        System.out.println(value);
                        if (value != null) {
                            addDigitToScreen(text);
                        } else {
                            setSign(text);
                        }

                    });
                    buttonsPanel.add(but);
                });
        return buttonsPanel;
    }

    private void addDigitToScreen(String buttonValue) {
        String sEkran = textField.getText();
        if (sEkran != null && sEkran.length() < 16) {
            sEkran += buttonValue;
        } else {
            sEkran = buttonValue;
        }
        textField.setText(sEkran);
    }

    void setSign(String buttonValue) {

        String sign = valueContainer.getSign();
        if (buttonValue.equals("C")) {
            valueContainer.setSign(null);
            valueContainer.setsEkran(null);
            valueContainer.setText();
        } else if (buttonValue.equals("=")) {
            if (sign != null && valueContainer.getsEkran() != null) {
                valueContainer.setCurrentValue(Double.parseDouble(valueContainer.getsEkran()));
                mathOperator.calculate(sign);
                valueContainer.setSign(null);
                valueContainer.setRecentValue(Double.parseDouble(valueContainer.getsEkran()));
                valueContainer.setsEkran(null);
            }
        } else {
            if (valueContainer.getsEkran() != null) {
                if (sign != null) {
                    valueContainer.setCurrentValue(Double.parseDouble(valueContainer.getsEkran()));
                    mathOperator.calculate(sign);
                }
                valueContainer.setRecentValue(Double.parseDouble(valueContainer.getsEkran()));
                valueContainer.setsEkran(null);
            }
            valueContainer.setSign(buttonValue);
        }
    }
}
