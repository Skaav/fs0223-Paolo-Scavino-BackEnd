package Classi;

import java.util.Scanner;

import Interface.Volume;

public class Audio extends Elementi implements Volume {
	
	Scanner scan = new Scanner(System.in);
	protected int vol = 3;
	protected int dur;

	public Audio(String title, int dur) {
		super(title);
		this.dur = dur;
		
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
	public void play() {
		for (int d = 0; d < this.dur; d++) {
			System.out.print(this.title);
			
			for (int v = 0; v < this.vol; v++) {
				System.out.print(" ! ");
			}
			System.out.println();
		}
	}
	
	@Override
	public void gestioneVol() {
		
		while (true) {
			System.out.println("Premere: 1 per aumentare il volume, 2 per diminuirlo, 0 per fermare tutto");
			 int gVol = Integer.parseInt(scan.nextLine());

			switch (gVol) {
			case 0:
				System.out.println("Sei uscito dal controllo volume!");
				return;
			case 1:
				if (vol < 5) {
					this.vol++;
					System.out.println("Hai aumentato il volume a: " + vol );
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
			default:
				System.out.println("Seleziona un numero tra 1, 2 e 0!");
			}
		} 
	}
	
	@Override
	public void gestioneLum() {
	}

}
