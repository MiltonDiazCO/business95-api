package repository;

import org.springframework.data.repository.CrudRepository;

import com.business95.api.business95_api.entities.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
