package ar.com.ua.repository.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Parametro;

@Repository
@Transactional(readOnly = true)
public interface ParametrosRepository extends JpaRepository<Parametro, Long> {

	@Query(value = "SELECT param.descripcion as descripcion "
			+ "FROM parametros param "
			+ "WHERE param.id = :id ", nativeQuery = true)
	String descripcion (String id);

}
