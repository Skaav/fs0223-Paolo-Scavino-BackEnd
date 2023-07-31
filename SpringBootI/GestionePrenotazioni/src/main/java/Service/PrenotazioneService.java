package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Postazione;
import Model.Prenotazioni;
import Model.Utente;
import Repository.PrenotazioniRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    private final PrenotazioniRepository prenotazioniRepository;

    @Autowired
    public PrenotazioneService(PrenotazioniRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }

    public Prenotazioni creaPrenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        Prenotazioni prenotazione = new Prenotazioni();
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);
        prenotazione.setDataPrenotazione(dataPrenotazione);
        return prenotazioniRepository.save(prenotazione);
    }

    public boolean isPostazioneLibera(Postazione postazione, LocalDate dataPrenotazione) {
        List<Prenotazioni> prenotazioni = prenotazioniRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        return prenotazioni.isEmpty();
    }

    public List<Prenotazioni> getPrenotazioniByUtenteAndData(Utente utente, LocalDate dataPrenotazione) {
        return prenotazioniRepository.findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
    }
}