package Classi;

import java.util.Scanner;

import Interface.Luminosità;

public class Immagini extends Elementi implements Luminosità {

	Scanner scan = new Scanner(System.in);
	protected int lum = 3;

	public Immagini(String title) {
		super(title);
	}

	public int getLum() {
		return lum;
	}

	public void setLum(int lum) {
		this.lum = lum;
	}

	public void show() {
		System.out.print(title);
		for (int l = 0; l < this.lum; l++) {
			System.out.print(" * ");
		}
		System.out.println();
	}

	@Override
	public void aumentaLum() {
		if (this.lum == 5) {
			this.lum = 5;
			System.out.println("La luminosità non può essere aumentata!");
		} else {
			this.lum++;
			System.out.println("Luminosità: " + this.lum);
		}
	}

	@Override
	public void riduciLum() {
		if (this.lum == 0) {
			this.lum = 0;
			System.out.println("La luminosità non può essere diminuita!");
		} else {
			this.lum--;
			System.out.println("Luminosità: " + this.lum);
		}
	}

	@Override
	public void gestioneLum() {

		while (true) {
			System.out.println("Premere: 1 per aumentare la luminosità, 2 per diminuirla, 0 per fermare tutto");
			int gLum = Integer.parseInt(scan.nextLine());

			switch (gLum) {
			case 0:
				System.out.println("Sei uscito dal controllo luminosità!");
				return;
			case 1:
				if (lum < 5) {
					lum++;
					System.out.println("Hai aumentato la luminosità a: " + lum);
				} else {
					System.out.println("La luminosità è al MASSIMO!");
				}
				break;
			case 2:
				if (this.lum > 0) {
					this.lum--;
					System.out.println("Hai diminuito la luminosità a: " + lum);
				} else {
					System.out.println("La luminosità è al MINIMO!");
				}
				break;
			default:
				System.out.println("Seleziona un numero tra 1, 2 e 0!");
			}
		}
	}

	@Override
	public void play() {
		this.show();
	}

	@Override
	public void gestioneVol() {
	}
}
