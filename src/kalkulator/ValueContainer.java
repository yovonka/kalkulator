package kalkulator;

import javax.swing.JTextField;

public class ValueContainer {

	JTextField text;
	String sEkran;
	String sign;
	
	double recentValue;
	double currentValue;

	public ValueContainer(JTextField text, String sEkran) {
		this.text=text;
		this.sEkran=sEkran;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(String Ekran) {
		text.setText(Ekran);
	}
	public void setText() {
		text.setText(sEkran);
	}

	public String getsEkran() {
		return sEkran;
	}

	public void setsEkran(String sEkran) {
		this.sEkran = sEkran;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public double getRecentValue() {
		return recentValue;
	}

	public void setRecentValue(double recentValue) {
		this.recentValue = recentValue;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

}
