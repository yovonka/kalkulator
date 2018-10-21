package kalkulator.button;

public enum ButtonValue implements Button {

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


    ButtonValue(String name, int value) {
        this.name = name;
        this.numericValue = value;

    }

    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public String getName() {
        return name;
    }

}
