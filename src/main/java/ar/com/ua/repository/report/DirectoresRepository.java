package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;
import ar.com.ua.projection.report.DirectoresProjection;

@Repository
@Transactional(readOnly = true)
public interface DirectoresRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo as numeroLegajo, "
			+ "CONCAT(emp.apellido, \" \", emp.nombre) AS apellidoNombre, "
			+ "emp.fecha_ingreso AS fechaIngreso, "
			+ "emp.fecha_ingreso_reconocida AS fechaIngresoReconocida, "
			+ "pais.descripcion AS codigoPais, "
			+ "emp.email_laboral AS emailLaboral, "
			+ "emp.cod_oficina as codigoOficina, "
			+ "p.descripcion AS codigoPuesto, "
			+ "p.cod_categoria as codigoCategoria, "
			+ "emp.cod_direccion as codigoDireccion, "
			+ "p.cod_gerencia as codigoGerencia, "
			+ "p.cod_jefatura as codigoJefatura, "
			+ "puesto_manager.descripcion AS puestoManager, "
			+ "emp.cod_division as codigoDivision, "
			+ "emp.cod_centro_de_costo as codigoCentroDeCosto, "
			+ "emp.cod_convenio as codigoConvenio, "
			+ "CONCAT(manager.apellido, \" \", manager.nombre) AS apellidoNombreManager "
			+ "FROM empleados emp JOIN pais pais ON emp.cod_pais = pais.id JOIN puesto p ON emp.cod_puesto = p.id LEFT JOIN puesto puesto_manager ON p.cod_puesto_al_que_reporta = puesto_manager.id "
			+ "LEFT JOIN empleados manager ON manager.cod_puesto = puesto_manager.id "
			+ "WHERE emp.cod_estado_empleado IN :estado "
			+ "AND (emp.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND (p.cod_gerencia = :idGerencia OR :idGerencia IS NULL) "
			+ "AND (emp.cod_pais = :idPais OR :idPais IS NULL) ", 
			nativeQuery = true)
	List<DirectoresProjection> reporte(@Param("estado") List<String> estado, @Param("idDireccion") String idDireccion,
			@Param("idGerencia") String idGerencia, @Param("idPais") String idPais);

}
