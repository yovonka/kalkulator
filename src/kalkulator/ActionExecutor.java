package kalkulator;

public class ActionExecutor {

	ValueContainer valueContainer;
	MathOperator mathOperator;
	
	public ActionExecutor(ValueContainer theValueContainer) {
		this.valueContainer=theValueContainer;
		this.mathOperator=new MathOperator(valueContainer);
	}
	public void addDigitToScreen(String buttonValue) {
		
		String sEkran = valueContainer.getsEkran();
		
		if(sEkran!=null&&sEkran.length()<16) 
			 sEkran+=buttonValue;
		
		else sEkran=buttonValue;
		
		valueContainer.setsEkran(sEkran);
		valueContainer.setText(sEkran);
	}
	

	
	//Metoda do refactoryzacji
	void setSign(String sKey) {
		
		String sign = valueContainer.getSign();
		if(sKey=="C") {
			valueContainer.setSign(null);
			valueContainer.setsEkran(null);
			valueContainer.setText();
		}
		else if(sKey=="=") {
			if(sign!=null&&valueContainer.getsEkran()!=null) {
				valueContainer.setCurrentValue(Double.parseDouble(valueContainer.getsEkran()));
				mathOperator.calculate(sign);
				valueContainer.setSign(null);
				valueContainer.setRecentValue(Double.parseDouble(valueContainer.getsEkran()));
				valueContainer.setsEkran(null);
			}
		}
		else {	
		 if(valueContainer.getsEkran()!=null) {
			
			if(sign!=null) {
				valueContainer.setCurrentValue(Double.parseDouble(valueContainer.getsEkran()));
				mathOperator.calculate(sign);
			}
			valueContainer.setRecentValue(Double.parseDouble(valueContainer.getsEkran()));
			valueContainer.setsEkran(null);
		 }
		valueContainer.setSign(sKey);
		}
	}

}
