package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		
		System.out.println("This is my first Epicode Java Project!");
		
		
		//Esercizi 2
		moltiplica(4,5);
		concatena("Pippo", 10);
		String [] array = {"uno","due","tre","quattro","cinque"};
		Scanner string = new Scanner(System.in);
		System.out.println("Scrivi la stringa che vuoi aggiungere:");
		String nuovaStringa = string.nextLine();
		String[] nuovoArray = inserisciInArray(array, nuovaStringa);
		for (String elemento : nuovoArray) {
            System.out.println(elemento);
        }
		
		
		//Esercizio 3
		Scanner sc = new Scanner(System.in);
		System.out.print("Colore preferito: ");
		String colore = sc.nextLine();
		System.out.print("Numero preferito: ");
		String numero = sc.nextLine();
		System.out.print("Animale preferito: ");
		String animale = sc.nextLine();
		System.out.println(colore + " " + numero + " " + animale);		
		
		
		// Esercizio 4
		System.out.println(perimetroRettangolo(3.0, 5.0));
		System.out.println(pariDispari(3));
		
		Scanner tr = new Scanner(System.in);
		System.out.print("A:");
		String a = tr.nextLine();
		double aDouble = Double.parseDouble(a);
		System.out.print("B:");
		String b = tr.nextLine();
		double bDouble = Double.parseDouble(b);
		System.out.print("C:");
		String c = tr.nextLine();
		double cDouble = Double.parseDouble(c);
		
		System.out.println(perimetroTriangolo(aDouble,bDouble,cDouble));
		
		}

public static void moltiplica (int x, int y) {
int result = x * y;
System.out.println(result);
}


public static void concatena (String x, int y) {
String result = x + ' ' + y;
System.out.println(result);
}

public static String[] inserisciInArray(String[] array, String nuovaStringa) {
    String[] nuovoArray = new String[6];
    
    for (int i = 0; i < 4; i++) {
        nuovoArray[i] = array[i];}
    
    nuovoArray[2] = nuovaStringa;
    nuovoArray[4] = array[3];
    nuovoArray[5] = array[4];
    
    return nuovoArray;
}

public static double perimetroRettangolo(double x, double y) {
	double result = (x+y)*2;
	return result;
}

public static int pariDispari(int x) {
	int result = x % 2;
	return result;
}

public static double perimetroTriangolo(double a, double b, double c) {
	double semiPerimentro = (a+b+c)/2;
	return Math.sqrt(semiPerimentro*(semiPerimentro-a)*(semiPerimentro-b)*(semiPerimentro-c));	
}
}


