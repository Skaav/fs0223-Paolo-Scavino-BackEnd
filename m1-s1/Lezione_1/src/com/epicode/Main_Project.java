package com.epicode;

public class Main_Project {
	
	public static void main (String[] args) {
		// istruzioni del mio programma
		
		boolean b = true; // la variabile di tipo boolean può contenere true/false
		char c = 'c'; // apici singoli, un carattere
		int i = 25; // valore numerico non decimale, senza virgola
		double d = 25.5; // valore numerico decimale (separati da un punto)	
		String s = "ciao"; // apici doppi, una stringa
		
		int val1 = 10; //Dichiarare ed inizializzare una variabile
		int val2; // Dichiarare una variabile
		val2 = 10; // Inizializzato una variabile
		final int VAL3 = 15; // Definisco ed inizializzo una costante
		
		int [] arrNum = new int[5];// creo un array di valori numerici di dimensione fissa [5]
		arrNum[0] = 25; // inizializzo un valore nell'indice 0 del mio arrNum
		arrNum[1] = 10; // inizializzo un valore nell'indice 1 del mio arrNum
		System.out.println(arrNum[1]);
		String [] arrString = new String [3]; // creo un array di valori String di dimensione fissa [3]
		
		char [] arrChar = {'a', 'b', 'c'}; // creo un array e lo popolo immediatamente con dei valori
	
		for (int j=0; j<arrChar.length; j++) {
			System.out.println(arrChar[j]);
		}
		
		int num1 = 25;
		int num2 = num1;
		long num3 = num1;
		int num4 = (int) num3;
		double num5 = num4; // 193.0
		int num6 = (int) num5; // 193
		
		
		
	}
}