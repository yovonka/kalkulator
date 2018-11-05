package kalkulator;

import kalkulator.button.SignButton;

public class CalculateMemory {

    private SignButton sign;
    private String currentValue;
    private Double prevNumber;
    private String actualView;

    public String getActualView() {
        return actualView;
    }

    private void setActualView(String actualView) {
        this.actualView = actualView;
    }

    public void addDigit(String buttonValue) {
        currentValue = (hasCurrentValue() && getCurrentValue().length() < 16)
                ? getCurrentValue() + buttonValue
                : buttonValue;
       setActualView(currentValue);
    }

    public void addSign(SignButton buttonValue) {
        switch (buttonValue) {
            case B_CLEAR:
                resetSign();
                resetCurrentValue();
                prevNumber = null;
                setActualView(currentValue);
                break;
            case B_EQUALS:
                if (hasSign() && hasCurrentValue()) {
                    Double calculatedNumber = MathOperator.calculate(this);
                    setPrevNumber(calculatedNumber);
                    resetSign();
                    resetCurrentValue();
                    setActualView(MathOperator.cutShortValueLength(calculatedNumber));
                }
                break;
            default:
                if (hasCurrentValue()) {
                    if (hasSign()) {
                        Double calculatedNumber = MathOperator.calculate(this);
                        setCurrentNumber(calculatedNumber);
                        setActualView(MathOperator.cutShortValueLength(calculatedNumber));
                    }
                    setPrevNumber(getCurrentNumber());
                    resetCurrentValue();
                }
                setSign(buttonValue);
                break;
        }
    }


    public SignButton getSign() {
        return sign;
    }

    private void setSign(SignButton sign) {
        this.sign = sign;
    }

    private boolean hasSign() {
        return sign != null;
    }

    private void resetSign() {
        sign = null;
    }

    private String getCurrentValue() {
        return currentValue;
    }


    private boolean hasCurrentValue() {
        return currentValue != null;
    }

    private void resetCurrentValue() {
        currentValue = null;
    }

    public Double getCurrentNumber() {
        return Double.parseDouble(currentValue);
    }

    private void setCurrentNumber(Double currentNumber) {
        currentValue = String.valueOf(currentNumber);
    }

    public Double getPrevNumber() {
        return prevNumber;
    }

    private void setPrevNumber(Double prevNumber) {
        this.prevNumber = prevNumber;
    }
}
