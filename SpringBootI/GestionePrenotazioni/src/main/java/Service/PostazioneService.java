package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Postazione;
import Model.TipoPostazione;
import Repository.PostazioneRepository;

import java.util.List;

@Service
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public List<Postazione> ricercaPostazioniPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}