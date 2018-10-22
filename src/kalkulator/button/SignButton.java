package kalkulator.button;

public enum SignButton implements Button {

    B_CLEAR("C"),
    B_ADD("+"),
    B_MINUS("-"),
    B_MULTIPLY("*"),
    B_DIVIDE("/"),
    B_EQUALS("=");

    private final String name;

    SignButton(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean isFunctional() {
        return true;
    }
}
