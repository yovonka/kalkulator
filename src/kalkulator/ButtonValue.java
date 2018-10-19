package kalkulator;

import java.util.Optional;
import java.util.stream.Stream;

public enum ButtonValue {

    B_1("1", 1),
    B_2("2", 2),
    B_3("3", 3),
    B_C("C", null),
    B_4("4", 4),
    B_5("5", 5),
    B_6("6", 6),
    B_PLUS("+", null),
    B_7("7", 7),
    B_8("8", 8),
    B_9("9", 9),
    B_MINUS("-", null),
    B_0("0", 0),
    B_MULTIPLY("*", null),
    B_DIVIDE("/", null),
    B_EQUALS("=", null);

    private String name;
    private Integer numericValue;

    ButtonValue(String name, Integer value) {
        this.name = name;
        this.numericValue = value;
    }

    public String getName() {
        return name;
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public static Optional<ButtonValue> find(String x) {
        return Stream.of(ButtonValue.values()).filter(value -> value.getName().equals(x)).findFirst();
    }
}
