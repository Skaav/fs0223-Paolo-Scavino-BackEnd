package com.IntroSpring.Configuration.Config_bean;

//Classe POJO che non deve implementare o estendere nessuna interfaccia
//o classe predefinita
public class Test {
	
	private String txt;

	public Test(String txt) {
		super();
		this.txt = txt;
	}

	public Test() {
		super();
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public String info() {
		return "INFO: " + txt;
	}

	@Override
	public String toString() {
		return "Test [txt=" + txt + "]";
	}

}
