package com.epicode.IntroSpring.DipendecyInjection;

public class Phone {
	
	private String operator;
	private String numero;
	
	public Phone(String operator, String numero) {
		super();
		this.operator = operator;
		this.numero = numero;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Phone [operator=" + operator + ", numero=" + numero + "]";
	}

	
}
