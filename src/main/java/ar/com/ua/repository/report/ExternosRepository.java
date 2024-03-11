package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.EmpleadoExterno;
import ar.com.ua.projection.report.ExternosProjection;

@Repository
@Transactional(readOnly = true)
public interface ExternosRepository extends JpaRepository<EmpleadoExterno, Long> {

	@Query(value = "SELECT ext.nro_legajo as numeroLegajo, "
			+ "ext.cod_tipo_doc as codigoTipoDocumento, "
			+ "ext.nro_doc as numeroDocumento, "
			+ "pais.descripcion as codigoPais, "
			+ "ext.cod_proveedor as codigoProveedor, "
			+ "p.descripcion as codigoPuesto, "
			+ "p.cod_direccion as departamento, "
			+ "ext.cod_division as codigoDivision, "
			+ "CONCAT (ext.apellido, \" \", ext.nombre) as apellidoNombre, "
			+ "puesto_manager.cod_direccion as codigoDireccion, "
			+ "puesto_manager.cod_gerencia as codigoGerencia, "
			+ "puesto_manager.cod_jefatura as codigoJefatura,  "
			+ "ext.activo as activo, "
			+ "ext.fecha_ingreso as fechaIngreso, "
			+ "ext.cod_genero as codigoGenero, "
			+ "ext.fecha_egreso as fechaEgreso, "
			+ "ext.email_personal as email "
			+ "FROM externos ext JOIN pais pais ON ext.cod_pais = pais.id JOIN puesto p ON ext.cod_puesto = p.id  "
			+ "LEFT JOIN puesto puesto_manager ON p.cod_puesto_al_que_reporta = puesto_manager.id "
			+ "WHERE ext.activo IN :activo "
			+ "GROUP BY ext.nro_legajo", nativeQuery = true)
	List<ExternosProjection> reporte(@Param("activo") List<String> activo);

}
