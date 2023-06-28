package esercizioDay2;

public class Rettangolo {
	public int aInt;
	public int bInt;
	
	public Rettangolo(int aInt, int bInt) {
		this.aInt =aInt;
		this.bInt = bInt;
	}
	
	public int calcolaArea() {
		return aInt*bInt;
	}
	
	public int calcolaPerimetro() {
		return (aInt*2)+(bInt*2);
	}
	
	public void stampaRettangolo(Rettangolo ret) {
		int area=ret.calcolaArea();
		int perimetro=ret.calcolaPerimetro();
		System.out.println("Il Perimetro è: " + perimetro );
		System.out.println("L'Area è: " + area);
	}
	
	public void stampaDueRettangoli(Rettangolo ret, Rettangolo ret2) {
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
