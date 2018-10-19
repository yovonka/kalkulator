package kalkulator;

public class CalculatorApp {

    private CreatorOfGUI GUIcreator;
    private ValueContainer valueContainer;
    private ActionExecutor actionExecutor;
    private ButtonActionCreator buttonActionCreator;

    public static void main(String[] args) {
        new CalculatorApp();

    }


    private CalculatorApp() {
        GUIcreator = new CreatorOfGUI();
        GUIcreator.setGuiParameters();
        valueContainer = new ValueContainer(GUIcreator.getText(), GUIcreator.getsEkran());

        actionExecutor = new ActionExecutor(valueContainer);
        buttonActionCreator = new ButtonActionCreator(actionExecutor, GUIcreator.makeButtons());
        buttonActionCreator.createObjButton();
    }

}
