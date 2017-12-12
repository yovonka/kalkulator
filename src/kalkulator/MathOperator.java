package kalkulator;

public class MathOperator {

	private static int _MAX_LENGTH = 16;
	
	ValueContainer valueContainer;
	
	public MathOperator(ValueContainer theValueContainer) {
		valueContainer=theValueContainer;
		}
	
	
	void calculate(String sign) {  
		double recentValue = valueContainer.getRecentValue();
		double currentValue = valueContainer.getCurrentValue();

		 switch(sign){
			 case "+":{
				 recentValue+=currentValue; break;
			 }
			 case "-" :{
				 recentValue-=currentValue; break;
			 }
			 case "/" : {
				 recentValue=recentValue/currentValue; break;
			 }
			 case "*" : {
				 recentValue*=currentValue; break;
			 }	 
		 }
		 valueContainer.setRecentValue(recentValue);
		 valueContainer.setsEkran(String.valueOf(recentValue));
		 valueContainer.setText(cutShortValueLength(clearUnneededSigns(valueContainer.getsEkran()))); 
	 }
	
	//Metoda do refactoryzacji
	String cutShortValueLength(String checkedValue) {
		String prefix=null;
		System.out.println(checkedValue);
		if(checkedValue.indexOf("E")!=-1) {
			
			prefix=checkedValue.substring(checkedValue.indexOf("E"));
			checkedValue=checkedValue.substring(0, checkedValue.indexOf("E"));			
			_MAX_LENGTH=_MAX_LENGTH-prefix.length();
			System.out.println(_MAX_LENGTH);	
		}
		
		if(checkedValue.length()>_MAX_LENGTH)
		{
			int valueOfLastIndex =Integer.parseInt(checkedValue.substring(_MAX_LENGTH+1,_MAX_LENGTH+2));
			if(valueOfLastIndex>=5) checkedValue=checkedValue.substring(0, _MAX_LENGTH)+String.valueOf(Integer.parseInt(checkedValue.substring(_MAX_LENGTH,_MAX_LENGTH+1))+1);	
			else checkedValue=checkedValue.substring(0, _MAX_LENGTH+1);
		}
		if(prefix!=null) checkedValue+=prefix;
		return checkedValue;
	}	
	
	String clearUnneededSigns(String checkedValue) {
		int valueLength = checkedValue.length();
		while((checkedValue.contains(".")) && (checkedValue.charAt(valueLength-1)=='0'||checkedValue.charAt(valueLength-1)=='.')){
				checkedValue=checkedValue.substring(0, valueLength-1);
				valueLength = checkedValue.length();
			}
		
		return checkedValue;
	}	
}
