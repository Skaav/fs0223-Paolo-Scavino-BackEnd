package com.epicode.IntroSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.IntroSpring.Configuration.Config_bean.ConfigurationTest;
import com.IntroSpring.Configuration.Config_bean.Test;

@SpringBootApplication
public class IntroSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringApplication.class, args);
		
		//Metodo 1
		//Configurazione dei beans tramite una classe Configuration
		configWith_Beans1();
		
		//Metodo 2
		
		//Metodo 3
		
		
	}
	
	public static void configWith_Beans1() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext (ConfigurationTest.class);
		
		//Recupero un bean Singleton
		Test t1 = (Test) appContext.getBean("test");
		//invoco un bean di nome test e mi faccio restituire e mi faccio 
		//restituire l'oggetto
		t1.info();
		System.out.println(t1);//senza il tostring nel test mi restituisce la zona di memoria
		System.out.println(t1.info());
		
		//Recupero un bean Prototype
		Test t3 = (Test) appContext.getBean("testParam", "Il secondo valore è il parametro testParam Bean");//invoco un bean di nome testParam e mi faccio restituire un oggetto
		System.out.println(t3);//Stampa la zona di memoria
		System.out.println(t3.info());
		
		
	}
	

}
