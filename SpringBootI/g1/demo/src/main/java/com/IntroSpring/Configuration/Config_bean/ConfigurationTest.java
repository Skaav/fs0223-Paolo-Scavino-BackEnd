package com.IntroSpring.Configuration.Config_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//File di configurazione che mi permette di definire i BEAN della classe test
@Configuration
public class ConfigurationTest {
	
	//Crea un BEAN di tipo Test con il valore "Ciao Mondo"
	@Bean
	@Scope ("singleton") 
	//@Scope ("singleton")  = Pattern che permette di farmi restituire sempre la stessa istanza della classe test
	public Test test() {
		return new Test("Ciao Mondo");
	}
	
	//Crea un BEAN di tipo Test che passo tramite parametro
	@Bean
	@Scope ("prototype")
	//@Scope ("prototype") = Crea un bean di tipo Test con il valore che passo tramite parametro
	public Test testParam(String txt) {
		return new Test(txt);
	}
	
}
