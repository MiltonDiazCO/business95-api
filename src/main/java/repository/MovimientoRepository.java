package repository;

import org.springframework.data.repository.CrudRepository;

import com.business95.api.business95_api.entities.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

}
