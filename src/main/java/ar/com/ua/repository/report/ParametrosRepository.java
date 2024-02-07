package ar.com.ua.repository.report;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Parametro;

@Repository
@Transactional(readOnly = true)
@Cacheable(value = "paramCache")
public interface ParametrosRepository extends JpaRepository<Parametro, Long> {

	@Query(value = "Select * FROM parametros param WHERE param.id = :id", nativeQuery = true)
	Parametro getParametro(String id);

	@Query(value = "SELECT param.descripcion as descripcion "
			+ "FROM parametros param "
			+ "WHERE param.id = :id order by description ", nativeQuery = true)
	String descripcion(String id);

	@Query(value = "SELECT param.cod_parametro as codigo "
			+ "FROM parametros param "
			+ "WHERE param.id = :id order by codigo ", nativeQuery = true)
	String codigo(String id);

	@Query(value = "SELECT param.texto1 as texto1 "
			+ "FROM parametros param "
			+ "WHERE param.id = :id order by texto1 ", nativeQuery = true)
	String texto1(String id);

	@Query(value = "SELECT param.texto2 as texto2 "
			+ "FROM parametros param "
			+ "WHERE param.id = :id order by texto2 ", nativeQuery = true)
	String texto2(String id);

}
