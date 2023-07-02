package Classi;

import java.util.Scanner;

import Interface.*;

public class Video extends Elementi implements Luminosità, Volume {

	Scanner scan = new Scanner(System.in);
	protected int lum = 3;
	protected int vol = 3;
	protected int dur;

	public Video(String title, int dur) {
		super(title);
		this.dur = dur;
	}

	public int getLum() {
		return lum;
	}

	public void setLum(int lum) {
		this.lum = lum;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public int getDur() {
		return dur;
	}

	@Override
	public void aumentaVol() {
		if (this.vol == 5) {
			this.vol = 5;
			System.out.println("Il volume non può essere aumentato!");
		} else {
			this.vol++;
			System.out.println("Volume: " + this.vol);
		}
	}

	@Override
	public void riduciVol() {
		if (this.vol == 0) {
			this.vol = 0;
			System.out.println("Il volume non può essere ridotto!");
		} else {
			this.vol--;
			System.out.println("Volume: " + this.vol);
		}
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
	public void play() {
		for (int d = 0; d < this.dur; d++) {
			System.out.print(this.title);

			for (int l = 0; l < this.lum; l++) {
				System.out.print(" * ");
			}

			for (int v = 0; v < this.vol; v++) {
				System.out.print(" ! ");
			}
			System.out.println();
		}
	}

	@Override
	public void gestioneVol() {
		int gVol;
		do {
			System.out.println("Premere: 1 per aumentare il volume, 2 per diminuirlo, 0 per fermare tutto");
			gVol = Integer.parseInt(scan.nextLine());

			switch (gVol) {
			case 1:
				if (vol < 5) {
					this.vol++;
					System.out.println("Hai aumentato il volume a: " + vol);
				} else {

					System.out.println("Il volume è al MASSIMO!");
				}
				break;
			case 2:
				if (vol > 0) {
					this.vol--;
					System.out.println("Hai diminuito il volume a: " + vol);
				} else {
					System.out.println("Il volume è al MINIMO!");
				}
				break;
			case 0:
				System.out.println("Sei uscito dal controllo volume!");
				break;
			default:
				System.out.println("Seleziona un numero tra 1, 2 e 0!");
			}
		} while (gVol != 0);
	}

	@Override
	public void gestioneLum() {
		int gLum;
		do {
			System.out.println("Premere: 1 per aumentare la luminosità, 2 per diminuirla, 0 per fermare tutto");
			gLum = Integer.parseInt(scan.nextLine());

			switch (gLum) {
			case 1:
				if (this.lum < 5) {
					this.lum++;
					System.out.println("Hai aumentato la luminosità a: " + this.lum);
				} else {
					System.out.println("La luminosità è al MASSIMO!");
				}
				break;
			case 2:
				if (this.lum > 0) {
					this.lum--;
					System.out.println("Hai diminuito la luminosità a: " + this.lum);
				} else {
					System.out.println("La luminosità è al MINIMO!");
				}
				break;

			case 0:
				System.out.println("Sei uscito dal controllo luminosità!");
				break;
			default:
				System.out.println("Seleziona un numero tra 1, 2 e 0!");
			}
		} while (gLum != 0);
	}
}
