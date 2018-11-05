package kalkulator;

public class MathOperator {

    private static int MAX_LENGTH = 16;

    public MathOperator() {
    }

    static Double calculate(CalculateMemory memory) {
        switch (memory.getSign()) {
            case B_ADD: {
                return memory.getPrevNumber() + memory.getCurrentNumber();
            }
            case B_MINUS: {
                return memory.getPrevNumber() - memory.getCurrentNumber();
            }
            case B_DIVIDE: {
                return memory.getPrevNumber() / memory.getCurrentNumber();
            }
            case B_MULTIPLY: {
                return memory.getPrevNumber() * memory.getCurrentNumber();
            }
            default: {
                return null;
            }
        }
    }

    //TODO
    public static String cutShortValueLength(Double checkedNumber) {
        String prefix = null;
        String checkedValue = String.valueOf(checkedNumber);
        if (checkedValue.contains("E")) {

            prefix = checkedValue.substring(checkedValue.indexOf("E"));
            checkedValue = checkedValue.substring(0, checkedValue.indexOf("E"));
            MAX_LENGTH = MAX_LENGTH - prefix.length();
            System.out.println(MAX_LENGTH);
        }

        if (checkedValue.length() > MAX_LENGTH) {
            int valueOfLastIndex = Integer.parseInt(checkedValue.substring(MAX_LENGTH + 1, MAX_LENGTH + 2));
            if (valueOfLastIndex >= 5)
                checkedValue = checkedValue.substring(0, MAX_LENGTH) + String.valueOf(Integer.parseInt(checkedValue.substring(MAX_LENGTH, MAX_LENGTH + 1)) + 1);
            else checkedValue = checkedValue.substring(0, MAX_LENGTH + 1);
        }
        if (prefix != null) {
            checkedValue += prefix;
        }
        return clearUnneededSigns(checkedValue);
    }

    public static String clearUnneededSigns(String checkedValue) {
        int valueLength = checkedValue.length();
        while ((checkedValue.contains(".")) && (checkedValue.charAt(valueLength - 1) == '0' || checkedValue.charAt(valueLength - 1) == '.')) {
            checkedValue = checkedValue.substring(0, valueLength - 1);
            valueLength = checkedValue.length();
        }

        return checkedValue;
    }
}
