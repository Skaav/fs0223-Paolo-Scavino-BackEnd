package esercizioDay2;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner tr = new Scanner(System.in);
		System.out.print("Altezza:");
		String altezza = tr.nextLine();
		int aInt = Integer.parseInt(altezza);
		System.out.print("Larghezza:");
		String larghezza = tr.nextLine();
		int bInt = Integer.parseInt(larghezza);
		
		Rettangolo ret1 = new Rettangolo(aInt, bInt);
		stampaRettangolo(ret1);
		Rettangolo ret2 = new Rettangolo(5, 10);
		stampaRettangolo(ret2);
		
		stampaDueRettangoli(ret1, ret2);
	}
	
	public static void stampaRettangolo(Rettangolo ret) {
		int area=ret.calcolaArea();
		int perimetro=ret.calcolaPerimetro();
		System.out.println("Il Perimetro è: " + perimetro );
		System.out.println("L'Area è: " + area);
	}
	
	public static void stampaDueRettangoli(Rettangolo ret, Rettangolo ret2) {
		int area=ret.calcolaArea();
		int perimetro=ret.calcolaPerimetro();
		int area2=ret2.calcolaArea();
		int perimetro2=ret2.calcolaPerimetro();
		int sArea=area+area2;
		int sPerimetro=perimetro+perimetro2;
		
		System.out.println("Il Perimetro di ret1 è: " + perimetro );
		System.out.println("L'Area di ret1 è: " + area);
		
		System.out.println("Il Perimetro di ret2 è: " + perimetro2 );
		System.out.println("L'Area di ret2 è: " + area2);
		
		System.out.println("La somma dei Perimetri è: " + sPerimetro);
		System.out.println("La somma delle Aree è: " + sArea);
		
	}

}
