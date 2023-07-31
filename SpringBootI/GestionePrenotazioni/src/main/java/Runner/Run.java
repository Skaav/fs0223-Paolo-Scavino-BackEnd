package Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Service.PrenotazioneService;
import Service.PostazioneService;
import Service.UtenteService;
import Model.Edificio;
import Model.Postazione;
import Model.Prenotazioni;
import Model.TipoPostazione;
import Model.Utente;

import java.time.LocalDate;
import java.util.List;

@Component
public class Run implements CommandLineRunner {

    private final PrenotazioneService prenotazioneService;
    private final PostazioneService postazioneService;
    private final UtenteService utenteService;

    @Autowired
    public Run(PrenotazioneService prenotazioneService, PostazioneService postazioneService, UtenteService utenteService) {
        this.prenotazioneService = prenotazioneService;
        this.postazioneService = postazioneService;
        this.utenteService = utenteService;
    }

    @Override
    public void run(String... args) {
        // Creazione degli edifici
        Edificio edificio1 = creaNuovoEdificio("Edificio A", "Via Roma 123", "Roma");
        Edificio edificio2 = creaNuovoEdificio("Edificio B", "Via Venezia 456", "Venezia");

        // Creazione delle postazioni negli edifici
        Postazione postazione1 = creaNuovaPostazione("POST-001", "Postazione privata", TipoPostazione.PRIVATO, 1, edificio1);
        Postazione postazione2 = creaNuovaPostazione("POST-002", "Postazione openspace", TipoPostazione.OPENSPACE, 4, edificio1);
        Postazione postazione3 = creaNuovaPostazione("POST-003", "Postazione sala riunioni", TipoPostazione.SALA_RIUNIONI, 10, edificio2);

        // Esecuzione degli esempi
        esempioCreazionePrenotazione(postazione1);
        esempioRicercaPostazioniPerTipoECitta(edificio1);
        esempioGetPrenotazioniByUtenteAndData();
    }

    public Edificio creaNuovoEdificio(String nome, String indirizzo, String citta) {
        Edificio edificio = new Edificio();
        edificio.setNome(nome);
        edificio.setIndirizzo(indirizzo);
        edificio.setCitta(citta);
        return edificio;
    }

    public Postazione creaNuovaPostazione(String codice, String descrizione, TipoPostazione tipo, int numeroMassimoOccupanti, Edificio edificio) {
        Postazione postazione = new Postazione();
        postazione.setCodice(codice);
        postazione.setDescrizione(descrizione);
        postazione.setTipo(tipo);
        postazione.setNumeroMassimoOccupanti(numeroMassimoOccupanti);
        postazione.setEdificio(edificio);
        return postazione;
    }

    public void esempioCreazionePrenotazione(Postazione postazione) {
        // Esempio creazione Utente
        Utente utente = utenteService.utente();
        utente.setUsername("Mross");
        utente.setNomeCompleto("Mario Rossi");
        utente.setEmail("mariorossi@example.com");

        // Data di prenotazione
        LocalDate dataPrenotazione = LocalDate.of(2023, 8, 1);

        // Verifica se la postazione è libera per la data specificata, se libera prenotala per l'Utente
        boolean isLibera = prenotazioneService.isPostazioneLibera(postazione, dataPrenotazione);

        if (isLibera) {
            Prenotazioni prenotazione = prenotazioneService.creaPrenotazione(postazione, utente, dataPrenotazione);
            System.out.println("Prenotazione effettuata con successo: " + prenotazione);
        } else {
            System.out.println("La postazione non è disponibile per la data specificata.");
        }
    }

    public void esempioRicercaPostazioniPerTipoECitta(Edificio edificio) {
        // Ricerca postazioni per tipo e città nell'edificio specificato
        List<Postazione> postazioni = postazioneService.ricercaPostazioniPerTipoECitta(TipoPostazione.PRIVATO, edificio.getCitta());

        if (!postazioni.isEmpty()) {
            System.out.println("Postazioni trovate nell'edificio " + edificio.getNome() + ":");
            for (Postazione postazione : postazioni) {
                System.out.println(postazione);
            }
        } else {
            System.out.println("Nessuna postazione trovata per il tipo e la città specificati nell'edificio " + edificio.getNome() + ".");
        }
    }

    public void esempioGetPrenotazioniByUtenteAndData() {
        // Creazione di un utente
        Utente utente = utenteService.utente();
        utente.setUsername("Mross");
        utente.setNomeCompleto("Mario Rossi");
        utente.setEmail("mariorossi@example.com");

        // Creazione di una data di prenotazione
        LocalDate dataPrenotazione = LocalDate.of(2023, 8, 1);

        // Ottenere le prenotazioni dell'utente per la data specificata
        List<Prenotazioni> prenotazioni = prenotazioneService.getPrenotazioniByUtenteAndData(utente, dataPrenotazione);

        if (!prenotazioni.isEmpty()) {
            System.out.println("Prenotazioni dell'utente per la data " + dataPrenotazione + ":");
            for (Prenotazioni prenotazione : prenotazioni) {
                System.out.println(prenotazione);
            }
        } else {
            System.out.println("Nessuna prenotazione trovata per l'utente e la data specificati.");
        }
    }
}