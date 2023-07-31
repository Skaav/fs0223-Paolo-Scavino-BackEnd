package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Edificio;
import Repository.EdificioRepository;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio creaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void eliminaEdificio(Long edificioId) {
        edificioRepository.deleteById(edificioId);
    }
}