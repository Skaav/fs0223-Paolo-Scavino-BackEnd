package Repository;

import org.springframework.data.repository.CrudRepository;

import Model.Edificio;

public interface EdificioRepository extends CrudRepository<Edificio, Long> {
	
}