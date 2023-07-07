package es1s2;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	public static void main(String[] args) {

		Logger log = LoggerFactory.getLogger(MainProject.class);

//		log.info("");
//		log.debug("dawdawd");
//		log.warn("messaggio");
//		log.error("error");

		int[] array = new int[5];
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		// Inizializza l'array con valori casuali tra 1 e 10
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10) + 1;
		}

		// Stampa l'array iniziale
		System.out.println("Array iniziale:");
		printArray(array);

		// Chiede all'utente di inserire un numero in una posizione specificata
		int posizione;
		int numero = -1;
		do {
			try {
				System.out.print("Inserisci una posizione (1-5): ");
				posizione = scanner.nextInt()-1;
				if (posizione < 0 || posizione >= array.length) {
					throw new IndexOutOfBoundsException();
				}

				System.out.print("Inserisci il numero (0 per terminare): ");
				numero = scanner.nextInt();
				if (numero < 0 || numero > 10) {
					throw new IllegalArgumentException();
				}

				// Aggiorna il valore dell'array nella posizione specificata
				array[posizione] = numero;

				// Stampa il nuovo stato dell'array
				System.out.println("Nuovo stato dell'array:");
				printArray(array);
			} catch (IndexOutOfBoundsException e) {
				log.info("Errore: Posizione non valida. Riprova.");
			} catch (IllegalArgumentException e) {
				log.info("Errore: Numero non valido. Riprova.");
			}
		} while (numero != 0);

		System.out.println("Programma terminato.");
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

}
