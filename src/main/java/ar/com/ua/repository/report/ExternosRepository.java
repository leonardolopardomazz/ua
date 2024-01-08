package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ExternosRepository {

	/*
	 * Permitir seleccionar Activo (selección múltiple: verdadero, falso, ambos).
	 * Recuperar datos de la tabla “Externos” Activo = selección. Tabla “Parámetros”
	 * para tipo_parámetro = 6 (dirección), 12 (gerencia), 7 (División),11 (género),
	 * 13 (horas semanales), 29 (tipo_documento) Tabla “Puesto”. Tabla “País”. Tabla
	 * “Proveedores”. El reporte estará ordenado por País, Dirección, Gerencia,
	 * Jefatura, F_ingreso ascendente y estará compuesto por los siguientes campos:
	 * 
	 * Número de legajo del externo Tipo documento Nro. documento Country Ext-
	 * Company Position Title Department Divition Apellido del empleado + Nombre
	 * del empleado Manager (Dirección, Gerencia, Jefatura) Estado Start Date
	 * Gender Fecha egreso Mail
	 */

	@Query(value = "SELECT ext.nro_legajo, (select descripcion from parametros where id = 2) as tipo_documento,			ext.nro_doc,			(select descripcion from parametros where id = 2) as country,			ext.fecha_ingreso as start_date,(	select descripcion	from parametros	where id = 2)	as Gender, ext.fecha_egreso,	ext.email_personal FROM	externos as ext,parametros	GROUP BY nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("apellido") String apellido, @Param("numeroLegajo") String numeroLegajo,
			@Param("codigoPuesto") Long codigoPuesto, @Param("codigoDireccion") Long codigoDireccion);

}
