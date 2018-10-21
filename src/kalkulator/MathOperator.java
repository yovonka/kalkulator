package kalkulator;

public class MathOperator {

    private static int MAX_LENGTH = 16;

    public MathOperator() {
    }

    double calculate(String sign, double recentValue, String value) {
       double currentValue = Double.parseDouble(value);
        switch (sign) {
            case "+": {
                recentValue += currentValue;
                break;
            }
            case "-": {
                recentValue -= currentValue;
                break;
            }
            case "/": {
                recentValue = recentValue / currentValue;
                break;
            }
            case "*": {
                recentValue *= currentValue;
                break;
            }
        }
        return recentValue;
    }

    public static String cutShortValueLength(String checkedValue) {
        String prefix = null;
        System.out.println(checkedValue);
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
        if (prefix != null) checkedValue += prefix;
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
