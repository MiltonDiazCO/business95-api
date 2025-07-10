package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.entities.TipoActividad;

@Repository
public interface TipoActividadRepository extends CrudRepository<TipoActividad, Long> {

}
