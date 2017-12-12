package kalkulator;

import javax.swing.JTextField;

public class KalkulatorApp {

	public static void main(String[] args) {
		new KalkulatorApp();

	}
	
	CreatorOfGUI GUIcreator;
	ValueContainer valueContainer;
	ActionExecutor actionExecutor;
	ButtonActionCreator buttonActionCreator;

	
	KalkulatorApp(){
		GUIcreator = new CreatorOfGUI();
		GUIcreator.setGuiParameters();
		valueContainer = new ValueContainer(GUIcreator.getText(),GUIcreator.getsEkran());
		
		actionExecutor = new ActionExecutor(valueContainer);
		buttonActionCreator = new ButtonActionCreator(actionExecutor, GUIcreator.makeButtons());
		buttonActionCreator.createObjButton();
	}
	
}
