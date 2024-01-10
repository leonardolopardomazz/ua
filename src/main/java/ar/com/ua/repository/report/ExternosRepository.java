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

	@Query(value = "SELECT ext.nro_legajo as nro_legajo, "
			+ "(select descripcion from parametros where id = :cod_tipo_doc) as tipo_documento, "
			+ "ext.nro_doc as nro_documento, "
			+ "(select descripcion from parametros where id = :cod_pais) as country, "
			+ "(select descripcion from parametros where id = :cod_proveedor) as ext_company, "
			+ "(select descripcion from parametros where id = :cod_puesto) as position_title, "
			+ "(select descripcion from parametros where id = :cod_jefatura) as departament, "
			+ "(select descripcion from parametros where id = :cod_division) as division, "
			+ "CONCAT (ext.apellido, \" \", ext.nombre) as apellido_nombre, "
			+ "CONCAT ("
			+ "		  	(select descripcion from parametros where id = :cod_direccion), "
			+ "			(select descripcion from parametros where id = :cod_gerencia), "
			+ "        	(select descripcion from parametros where id = :cod_jefatura) " 
			+ "        	) as manager, "
			+ "ext.fecha_ingreso as start_date, "
			+ "(select descripcion from parametros where id = :cod_genero) as Gender, "
			+ "ext.activo, "
			+ "ext.fecha_egreso, "
			+ "ext.email_personal "
			+ "FROM externos as ext, parametros "
			+ "WHERE ext.activo = :activo OR ext.activo IS NULL "
			+ "GROUP BY ext.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("cod_tipo_doc") String codigoTipoDocumento, @Param("cod_pais") String codigoPais,
			@Param("cod_proveedor") String codigoProveedor, @Param("cod_puesto") String codigoPuesto, 
			@Param("cod_jefatura") String codigoJefatura , @Param("cod_division") String codigoDivision,
			@Param("cod_direccion") String codigoDireccion , @Param("cod_gerencia") String codigoGerencia,
			@Param("cod_genero") String codigoGenero, @Param("activo") String activo);

}
