package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.EmpleadoExterno;

@Repository
@Transactional(readOnly = true)
public interface ExternosRepository extends JpaRepository<EmpleadoExterno, Long> {

	@Query(value = "SELECT ext.nro_legajo, "
			+ "ext.cod_tipo_doc, "
			+ "ext.nro_doc, "
			+ "pais.descripcion as country, "
			+ "ext.cod_proveedor as ext_company, "
			+ "p.descripcion as position_title, "
			+ "ext.cod_direccion as department, "
			+ "ext.cod_division as division, "
			+ "CONCAT (ext.apellido, \" \", ext.nombre) as apellido_nombre, "
			+ "ext.cod_direccion, "
			+ "ext.cod_gerencia, "
			+ "ext.cod_jefatura,  "
			+ "ext.activo, "
			+ "ext.fecha_ingreso as start_date, "
			+ "ext.cod_genero as gender, "
			+ "ext.fecha_egreso, "
			+ "ext.email_personal "
			+ "FROM externos ext JOIN puesto p ON ext.cod_puesto = p.id JOIN pais pais ON ext.cod_pais = pais.id "
			+ "WHERE ext.activo IN :activo "
			+ "GROUP BY ext.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("activo") List<String> activo);

}
