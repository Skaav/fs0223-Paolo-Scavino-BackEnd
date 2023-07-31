package Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Model.Postazione;
import Model.TipoPostazione;

public interface PostazioneRepository extends CrudRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

}