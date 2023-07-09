package Main;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.*;

public class MainProg {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(MainProg.class);
		
		// Creazione e Aggiunto nuovi elementi (book and magazine)
		BookList books = new BookList();

		ClassBook book1 = new ClassBook("9780123456789", "Book 1", 2022, 200, "Autor 1", "Horror");
		books.addBook(book1);

		ClassMagazine magazine1 = new ClassMagazine("9789876543210", "Magazine 1", 2023, 50, Periodicity.Monthly);
		books.addBook(magazine1);

		ClassBook book2 = new ClassBook("9789999999999", "Book 2", 2021, 300, "Autor 2", "Fantasy");
		books.addBook(book2);

		// Esempio di rimozione elemento
		books.removeBookISBN("9780123456789");

		// Esempio di ricerca per ISBN
		Optional<ClassPropShared> element = books.searchBookISBN("9789999999999");
		element.ifPresent(value -> System.out.println("Ricerca per ISBN: " + value.getTitle()));

		// Esempio di ricerca per anno pubblicazione
		List<ClassPropShared> elementYP = books.searchByYP(2023);
		System.out.print("Search by Published Year: ");
		for (ClassPropShared elementoCatalogo : elementYP) {
			System.out.println(elementoCatalogo.getTitle());
		}

		// Esempio di ricerca per autore
		List<ClassPropShared> elementAutor = books.searchByAutor("Autor 2");
		System.out.print("Search by Autor: ");
		for (ClassPropShared elementoCatalogo : elementAutor) {
			System.out.println(elementoCatalogo.getTitle());
		}

		// Esempio di ricerca per periodicità (applicabile solo alle riviste)
		List<ClassMagazine> elementByPeriod = books.searchPeriodicity(Periodicity.Monthly);
		System.out.print("Search by Period: ");
		for (ClassMagazine rivista : elementByPeriod) {
			System.out.println(rivista.getTitle());
		}

		// Salvataggio e caricamento dati
		
		books.saveOnDisk("archive.dat");
		
		books.loadFromDisk("archive.dat");
		
		// Stampa del documento salvato
		List<ClassPropShared> archiveBooks = books.getA();
		for (ClassPropShared elemento : archiveBooks) {
			System.out.println(elemento.toString());
			System.out.println("-----------------------------");
		}
	}
}
