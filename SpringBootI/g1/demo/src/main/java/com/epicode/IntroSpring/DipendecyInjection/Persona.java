package com.epicode.IntroSpring.DipendecyInjection;

public class Persona {
	
	private String fullName;
	private IAddress address;
	private Phone phone;
	
	//Potrei creare un nuovo costruttore
	public Persona(String fullName) {
		super();
		this.fullName = fullName;
		//Accoppiamento FORTE tra persona e indirizzo e telefono
		this.address = new EuropeanAddress ("Roma", "Via Epicode 11", "Roma");
		this.phone = new Phone ("Tim", "123456789");
	}
	//Il costruttore sopra viene chiamato "ACCOPPIAMENTO FORTE"
	
	//Nel caso sotto andiamo a fare un iniettamento dei dati in fase di costruzione
	//rendendolo un accoppiamento "un po' più debole"
	
	
	//Dependency Injection sul costruttore
	//Dependecy Injection inietto una dipendenza dall'esterno
	//Accoppiamento debole basato su interfacce
	public Persona(String fullName, IAddress address, Phone phone) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public IAddress getAddress() {
		return address;
	}
	
	//Dependency Injection sul metodo set
	public void setAddress(IAddress address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Persona [fullName=" + fullName + ", phone=" + phone + "]";
	}

}
