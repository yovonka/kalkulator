package kalkulator.button;

import javax.swing.*;

public class MyButton extends JButton {

    private Button buttonEnum;

    public MyButton(Button buttonEnum) {
        super(buttonEnum.getName());
        this.buttonEnum = buttonEnum;
    }

    public Button getButtonEnum() {
        return buttonEnum;
    }

    public void setButtonEnum(Button buttonEnum) {
        this.buttonEnum = buttonEnum;
    }
}
