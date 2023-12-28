package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.model.Empleado;

@Repository
@Transactional(readOnly = false)
public interface VueltaAlColegioRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo as numeroLegajo, emp.apellido, emp.nombre, GROUP_CONCAT(cdf.fecha_nacimiento) as fechaNacimiento "
			+ "FROM ua.empleados emp, ua.cargas_de_familia cdf, ua.pais pais "
			+ "WHERE emp.nro_legajo = cdf.nro_legajo " 
			+ "AND emp.cod_pais = pais.id OR emp.cod_pais IS NULL "
			+ "AND emp.apellido= :apellido OR emp.apellido IS NULL "
			+ "AND emp.nro_legajo= :numeroLegajo OR emp.nro_legajo IS NULL "
			+ "AND emp.cod_puesto= :codigoPuesto OR emp.cod_puesto IS NULL " 
			+ "AND emp.cod_direccion= :codigoDireccion OR emp.cod_direccion IS NULL "
			+ "AND cdf.activo = 1 AND cdf.tipo_familiar = 'hijo' "
			+ "GROUP BY  emp.nro_legajo, emp.apellido, emp.nombre", nativeQuery = true)
	List<String> reportVueltaAlColegio(@Param("apellido") String apellido, @Param("numeroLegajo") String numeroLegajo,
			@Param("codigoPuesto") Long codigoPuesto, @Param("codigoDireccion") Long codigoDireccion);

	//:parameterOne is null or parameter1 = :parameterOne
	
	/*
	 * String reportCentroDeCosto(CentroDeCostoDTO dto);
	 * 
	 * String reportHistorialLaboral(HistorialLaboralDTO dto);
	 * 
	 * String reportInternationalDataCollection(InternationalDataCollectionDTO dto);
	 * 
	 * String reportExternos(ExternosDTO dto);
	 * 
	 * String reportDirectores(DirectoresDTO dto);
	 * 
	 * String reportGenerico(GenericoDTO dto);
	 * 
	 * String reportLicencia(LicenciaDTO dto);
	 */
}
