package kalkulator.button;

import kalkulator.CalculateMemory;

public enum ValueButton implements Button {

    B_1("1", 1),
    B_2("2", 2),
    B_3("3", 3),
    B_4("4", 4),
    B_5("5", 5),
    B_6("6", 6),
    B_7("7", 7),
    B_8("8", 8),
    B_9("9", 9),
    B_0("0", 0);

    private final String name;
    private final int numericValue;


    ValueButton(String name, int value) {
        this.name = name;
        this.numericValue = value;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void updateMemory(CalculateMemory memory) {
        memory.addDigit(name);
    }

}
