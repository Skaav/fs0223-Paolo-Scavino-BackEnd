package com.epicode.IntroSpring.DipendecyInjection;

public class TestDependecyInjection {

	public static void main(String[] args) {

		Phone p = new Phone("Tim", "123456789");
		AmericanAddress aa = new AmericanAddress("New York", "5th avenue", "New York");
		EuropeanAddress ea = new EuropeanAddress("Roma", "Via Epicode", "Roma");
		EuropeanAddress ea2 = new EuropeanAddress ("Milano", "via abc", "Milano");
				
		//Qui se mettiamo aa non lo prende perché manca un costruttore,
		//ma facendo così si rischia di incappare nella duplicazione del codice
		//in agiunta non funzionerebbe
		
		//Dependecy injection tramite costruttore
		Persona pers1 = new Persona("Mario Rossi", aa, p);
		Persona pers2 = new Persona("Giuseppe Verdi", ea, p);
		
		//Terzo metodo sconsigliato perché viola in concetto di incapsulamento
		//Meglio evitarlo
		
		//pers2.address = new AmericanAddress("New York", "5th avenue", "New York");
		
		//Dependency Injection tramite metodo set;
		Persona pers3 = new Persona("Francesca Neri");
		pers3.setAddress(ea2);
		pers3.setPhone(new Phone ("Vodafone", "987654321"));
	}

}
