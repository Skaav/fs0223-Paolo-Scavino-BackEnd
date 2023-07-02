package Main;

import java.util.Scanner;

import Classi.*;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Elementi[] rip = generateArray();
		riproduciElemento(rip, scan);
		scan.close();
	}

	private static void riproduciElemento(Elementi[] rip, Scanner scan) {
		System.out.println("Scegliere una valore da 1 a 5. Premere 0 per uscire!");

		while (scan.hasNextInt()) {
			int input = Integer.parseInt(scan.nextLine());

			if (input == 0) {
				break;
			}
			if (input >= 1 && input <= 5) {
				if (rip[input - 1] instanceof Audio) {
					rip[input - 1].play();
					System.out.println("Premi 1 per cambiare il volume. Premi 0 per andare avanti!");
					int m = Integer.parseInt(scan.nextLine());
					switch (m) {
					case 0:
						break;
					case 1:
						rip[input - 1].gestioneVol();
						rip[input - 1].play();
						break;
					default:
						System.out.println("Inserisci un valore valido!");
					}
				} else if (rip[input - 1] instanceof Video) {
					boolean opzioni = true;
					rip[input - 1].play();
					while (opzioni) {
						System.out.println("1 Cambia Volume, 2 Cambia Luminosità, 0 Se le impostazioni sono ok!");
						int p = Integer.parseInt(scan.nextLine());
						switch (p) {
						case 0:
							opzioni = false;
							break;
						case 1:
							System.out.println("Cambia Volume!");
							rip[input - 1].gestioneVol();
							rip[input - 1].play();
							break;
						case 2:
							System.out.println("Cambia Luminosità!");
							rip[input - 1].gestioneLum();
							rip[input - 1].play();
							break;
						default:
							System.out.println("Inserisci un valore valido!");
						}
					}
				} else if (rip[input - 1] instanceof Immagini) {
					rip[input - 1].play();
					System.out.println("Premi 1 per cambiare la Luminosità. Premi 0 per annullare.");
					int n = Integer.parseInt(scan.nextLine());
					switch (n) {
					case 0:
						break;
					case 1:
						rip[input - 1].gestioneLum();
						rip[input - 1].play();
						break;
					default:
						System.out.println("Inserisci un valore valido!");
					}
				}
			} else {
				System.out.println("Inserisci un valore valido!");
			}
			System.out.println("Scegliere una valore da 1 a 5. Premere 0 per uscire!");
		}
		System.out.println("Sei uscito correttamente dal riproduttore!");
	}

	public static Elementi[] generateArray() {
		Elementi[] e = new Elementi[5];
		int media;
		String title;
		int dur;

		for (int i = 0; i < 5; i++) {
			System.out.println("Scegli che file vuoi creare 1. Audio, 2. Video, 3. Immagine: ");
			media = Integer.parseInt(scan.nextLine());

			switch (media) {
			case 1:
				System.out.println("Inserisci il titolo del tuo file Audio: ");
				title = scan.nextLine();
				System.out.println("Inserisci la durata: ");
				dur = Integer.parseInt(scan.nextLine());
				e[i] = new Audio(title, dur);
				break;
			case 2:
				System.out.println("Inserisci il titolo del tuo file Video: ");
				title = scan.nextLine();
				System.out.println("Inserisci la durata: ");
				dur = Integer.parseInt(scan.nextLine());
				e[i] = new Video(title, dur);
				break;
			case 3:
				System.out.println("Inserisci il titolo del tuo file Immagine: ");
				title = scan.nextLine();
				e[i] = new Immagini(title);
				break;
			default:
				System.out.println("Inserisci un valore valido!");
				i--;
			}
		}
		return e;
	}
}
