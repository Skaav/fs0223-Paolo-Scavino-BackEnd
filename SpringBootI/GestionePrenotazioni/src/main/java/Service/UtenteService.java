package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Utente;
import Repository.UtenteRepository;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente creaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void eliminaUtente(Long utenteId) {
        utenteRepository.deleteById(utenteId);
    }

	public Utente utente() {
		return null;
	}
}