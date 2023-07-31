package Repository;

import org.springframework.data.repository.CrudRepository;

import Model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
	
}