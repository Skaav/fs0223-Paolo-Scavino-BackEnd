package Main;

import java.util.Date;
import java.util.List;

import Class.ArchivioBibliotecario;
import Class.ElementoCatalogo;
import Class.Libro;
import Class.Prestito;
import Class.Utente;
import org.apache.commons.lang.time.DateUtils;

public class Main {

	public static void main(String[] args) {
		
		ArchivioBibliotecario archivio = new ArchivioBibliotecario();

		Libro libro1 = new Libro();
		libro1.setIsbn("978-1234567890");
		libro1.setTitolo("Il signore degli anelli");
		libro1.setAnnoPubblicazione(1954);
		libro1.setNumeroPagine(1178);
		libro1.setAutore("J.R.R. Tolkien");
		libro1.setGenere("Fantasy");
		archivio.aggiungiElemento(libro1);

		ElementoCatalogo elemento = archivio.ricercaPerISBN("978-1234567890");
		if (elemento != null) {
			System.out.println("Elemento trovato: " + elemento.getTitolo());
		}

		List<ElementoCatalogo> elementiPerAutore = archivio.ricercaPerAutore("J.R.R. Tolkien");
		System.out.println("Elementi scritti da J.R.R. Tolkien:");
		for (ElementoCatalogo elem : elementiPerAutore) {
			System.out.println(elem.getTitolo());
		}

		List<ElementoCatalogo> elementiPerTitolo = archivio.ricercaPerTitolo("anelli");
		System.out.println("Elementi con titolo che contiene 'anelli':");
		for (ElementoCatalogo elem : elementiPerTitolo) {
			System.out.println(elem.getTitolo());
		}

		Utente utente1 = new Utente();
		utente1.setNome("Mario");
		utente1.setCognome("Rossi");
		utente1.setDataNascita(new Date());
		utente1.setNumeroTessera("00001");

		Prestito prestito1 = new Prestito();
		prestito1.setUtente(utente1);
		prestito1.setElemento(libro1);
		prestito1.setDataInizioPrestito(new Date());
		prestito1.setDataRestituzionePrevista(DateUtils.addDays(new Date(), 30));

		archivio.aggiungiPrestito(prestito1);

		List<Prestito> prestitiUtente = archivio.ricercaPrestitiUtente("00001");
		System.out.println("Prestiti dell'utente:");
		for (Prestito p : prestitiUtente) {
			System.out.println(
					p.getElemento().getTitolo() + " - Restituzione prevista: " + p.getDataRestituzionePrevista());
		}

		List<Prestito> prestitiScaduti = archivio.ricercaPrestitiScadutiNonRestituiti();
		System.out.println("Prestiti scaduti e non restituiti:");
		for (Prestito p : prestitiScaduti) {
			System.out.println(
					p.getElemento().getTitolo() + " - Restituzione prevista: " + p.getDataRestituzionePrevista());
		}

		archivio.chiudi();
	}

}
