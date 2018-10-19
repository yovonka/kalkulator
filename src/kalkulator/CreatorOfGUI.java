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
    private MathOperator mathOperator = new MathOperator();
    private String sign;
    private String saved;
    private double last;
    private double curr;

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
                        Integer value = ButtonValue.find(text).map(ButtonValue::getNumericValue).orElse(null);
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
        String sEkran = saved;
        if (sEkran != null && sEkran.length() < 16) {
            sEkran += buttonValue;
        } else {
            sEkran = buttonValue;
        }
        System.out.println(sEkran);
        textField.setText(sEkran);
        saved = sEkran;
    }

    void setSign(String buttonValue) {
        System.out.println(sign);
        switch (buttonValue) {
            case "C":
                sign = null;
                saved = null;
                textField.setText(saved);
                break;
            case "=":
                if (sign != null && saved != null) {
                    last = mathOperator.calculate(sign, last, Double.parseDouble(saved));
                    textField.setText(MathOperator.cutShortValueLength(String.valueOf(last)));
                    sign = null;
                    saved = null;
                }
                break;
            default:
                System.out.println(saved);
                if (saved != null) {
                    if (sign != null) {
                        last = mathOperator.calculate(sign, last, Double.parseDouble(saved));
                        saved = String.valueOf(last);
                        textField.setText(MathOperator.cutShortValueLength(saved));
                        System.out.println(last);
                    }
                    last = Double.valueOf(saved);
                    saved = null;
                }
                sign = buttonValue;
                break;
        }
    }
}
