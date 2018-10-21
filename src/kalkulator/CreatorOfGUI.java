package kalkulator;

import kalkulator.button.Button;
import kalkulator.button.ButtonValue;
import kalkulator.button.MyButton;
import kalkulator.button.SignButton;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;


public class CreatorOfGUI {

    private static final String LABEL = "Kalkulator";
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    private static final JTextField textField = new JTextField("");

    private static final Button[] buttons = {
            ButtonValue.B_1, ButtonValue.B_2, ButtonValue.B_3, SignButton.B_C,
            ButtonValue.B_4, ButtonValue.B_5, ButtonValue.B_6, SignButton.B_PLUS,
            ButtonValue.B_7, ButtonValue.B_8, ButtonValue.B_9, SignButton.B_MINUS,
            ButtonValue.B_0, SignButton.B_MULTIPLY, SignButton.B_DIVIDE, SignButton.B_EQUALS,
    };

    private JFrame mainFrame = new JFrame(LABEL);
    private Font font = new Font("System", Font.BOLD, 25);
    private MathOperator mathOperator = new MathOperator();
    private CalculateMemory memory = new CalculateMemory();
    private String sign;
    private String memoryValue;
    private Double prevValue;

    public CreatorOfGUI() {
        setGuiParameters();
    }

    private void setGuiParameters() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());

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
        buttonsPanel.setLayout(new GridLayout(4, 4, 0, 0));
        Stream.of(buttons)
                .forEach(button -> {
                    MyButton but = new MyButton(button);
                    but.addActionListener(e -> {
                        String text = ((JButton) e.getSource()).getText();
                        addDigitToScreen(text);
                        //TODO second listtener
                    });
                    buttonsPanel.add(but);
                });
        return buttonsPanel;
    }

    private void addDigitToScreen(String buttonValue) {
        memoryValue = (memoryValue != null && memoryValue.length() < 16)
                ? memoryValue + buttonValue
                : buttonValue;
        textField.setText(memoryValue);
    }
//TODO value container
    void setSign(String buttonValue) {
        switch (buttonValue) {
            case "C":
                sign = null;
                memoryValue = null;
                prevValue = null;
                textField.setText(null);
                break;
            case "=":
                if (sign != null && memoryValue != null) {
                    prevValue = mathOperator.calculate(sign, prevValue, memoryValue);
                    textField.setText(MathOperator.cutShortValueLength(String.valueOf(prevValue)));
                    sign = null;
                    memoryValue = null;
                }
                break;
            default:
                if (memoryValue != null) {
                    if (sign != null) {
                        prevValue = mathOperator.calculate(sign, prevValue, memoryValue);
                        memoryValue = String.valueOf(prevValue);
                        textField.setText(MathOperator.cutShortValueLength(memoryValue));
                    }
                    prevValue = Double.valueOf(memoryValue);
                    memoryValue = null;
                }
                sign = buttonValue;
                break;
        }
    }
}
