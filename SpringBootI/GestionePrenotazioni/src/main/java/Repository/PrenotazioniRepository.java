package Repository;

import org.springframework.data.repository.CrudRepository;

import Model.Prenotazioni;


import java.time.LocalDate;
import java.util.List;

public interface PrenotazioniRepository extends CrudRepository<Prenotazioni, Long> {
	
    List<Prenotazioni> findByPostazioneAndDataPrenotazione(Model.Postazione postazione, LocalDate dataPrenotazione);
    List<Prenotazioni> findByUtenteAndDataPrenotazione(Model.Utente utente, LocalDate dataPrenotazione);
    
}