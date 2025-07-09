package repository;

import org.springframework.data.repository.CrudRepository;

import com.business95.api.business95_api.entities.Inversion;

public interface InversionRepository extends CrudRepository<Inversion, Long> {

}
