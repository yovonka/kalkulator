package kalkulator;

import kalkulator.button.SignButton;

public class CalculateMemory {

    private SignButton sign;
    private String currentValue;
    private Double prevNumber;


    public SignButton getSign() {
        return sign;
    }

    public void setSign(SignButton sign) {
        this.sign = sign;
    }

    public boolean hasSign() {
        return sign != null;
    }

    public void resetSign() {
        sign = null;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public boolean hasCurrentValue() {
        return currentValue != null;
    }

    public void resetCurrentValue() {
        currentValue = null;
    }

    public Double getCurrentNumber() {
        return Double.parseDouble(currentValue);
    }

    public void setCurrentNumber(double currentNumber) {
        currentValue = String.valueOf(currentNumber);
    }

    public Double getPrevNumber() {
        return prevNumber;
    }

    public void setPrevNumber(Double prevNumber) {
        this.prevNumber = prevNumber;
    }
}
