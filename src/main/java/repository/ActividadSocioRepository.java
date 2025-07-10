package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.entities.ActividadSocio;

@Repository
public interface ActividadSocioRepository extends CrudRepository<ActividadSocio, Long> {

}
