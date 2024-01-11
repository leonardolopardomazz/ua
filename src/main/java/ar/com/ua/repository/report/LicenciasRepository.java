package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;

@Repository
@Transactional(readOnly = true)
public interface LicenciasRepository extends JpaRepository<Empleado, Long> {
	
	@Query(value = "", nativeQuery = true)
	List<String> reporte(@Param("idDireccion") String idDireccion, @Param("idGerencia") String idGerencia,
			@Param("estado") String estado);

}
