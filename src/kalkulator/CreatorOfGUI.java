package kalkulator;

import kalkulator.button.Button;
import kalkulator.button.MyButton;
import kalkulator.button.SignButton;
import kalkulator.button.ValueButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Stream;


public class CreatorOfGUI {

    private static final String LABEL = "Kalkulator";
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    private static final JTextField textField = new JTextField("");

    private static final Button[] buttons = {
            ValueButton.B_1, ValueButton.B_2, ValueButton.B_3, SignButton.B_CLEAR,
            ValueButton.B_4, ValueButton.B_5, ValueButton.B_6, SignButton.B_ADD,
            ValueButton.B_7, ValueButton.B_8, ValueButton.B_9, SignButton.B_MINUS,
            ValueButton.B_0, SignButton.B_MULTIPLY, SignButton.B_DIVIDE, SignButton.B_EQUALS,
    };

    private JFrame mainFrame = new JFrame(LABEL);
    private Font font = new Font("System", Font.BOLD, 25);
    private MathOperator mathOperator = new MathOperator();
    private CalculateMemory memory = new CalculateMemory();

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
                    but.addActionListener(this::doOnClick);
                    buttonsPanel.add(but);
                });
        return buttonsPanel;
    }

    private void doOnClick(ActionEvent action) {
        Button button = ((MyButton) action.getSource()).getButtonEnum();
        if (button.isFunctional()) {
            setSign((SignButton) button);
        } else {
            addDigitToScreen((ValueButton) button);
        }
    }
//TODO Math operator in memory
    private void addDigitToScreen(ValueButton valueButton) {
        String currentNumber =
                (memory.hasCurrentValue() && memory.getCurrentValue().length() < 16)
                ? memory.getCurrentValue() + valueButton.getName()
                : valueButton.getName();
        memory.setCurrentValue(currentNumber);
        textField.setText(currentNumber);
    }

    private void setSign(SignButton buttonValue) {
        switch (buttonValue) {
            case B_CLEAR:
                memory = new CalculateMemory();
                textField.setText(null);
                break;
            case B_EQUALS:
                if (memory.hasSign() && memory.hasCurrentValue()) {
                    Double calculatedNumber = mathOperator.calculate(memory);
                    memory.setPrevNumber(calculatedNumber);
                    memory.resetSign();
                    memory.resetCurrentValue();
                    textField.setText(MathOperator.cutShortValueLength(calculatedNumber));
        }
                break;
            default:
                if (memory.hasCurrentValue()) {
                    if (memory.hasSign()) {
                        Double calculatedNumber = mathOperator.calculate(memory);
                        memory.setCurrentNumber(calculatedNumber);
                        textField.setText(MathOperator.cutShortValueLength(calculatedNumber));
                    }
                    memory.setPrevNumber(memory.getCurrentNumber());
                    memory.resetCurrentValue();
                }
                memory.setSign(buttonValue);
                break;
        }
    }
}
