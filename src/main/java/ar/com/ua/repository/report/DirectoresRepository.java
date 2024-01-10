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
public interface DirectoresRepository extends JpaRepository<Empleado, Long>  {

	@Query(value = "SELECT emp.nro_legajo as nro_legajo, "
			+ "CONCAT (emp.apellido, \" \", emp.nombre) as apellido_nombre,  "
			+ "emp.fecha_ingreso as fecha_ingreso, "
			+ "emp.fecha_ingreso_reconocida as fecha_ingreso_reconocida, "
			+ "(SELECT descripcion FROM pais WHERE id= :idPais) as pais, "
			+ "(SELECT descripcion FROM pais WHERE id= idLugarTrabajo) as lugar_de_trabajo, "
			+ "emp.email_laboral as email_laboral, "
			+ "puesto.descripcion, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idCategoria) as categoria, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idManager) as manager_jefe, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idCargoManager) as cargo_manager_jefe, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idDireccion) as direccion, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idGerencia) as gerencia, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idJefatura) as jefatura, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idDivision) as division, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idCentroDeCostos) as centro_de_costos, "
			+ "(SELECT descripcion FROM parametros WHERE id= :idConvenio) as convenio "
			+ "FROM empleados emp, pais pais, puesto puesto "
			+ "GROUP BY nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("idPais") String idPais, @Param("idLugarTrabajo") String idLugarTrabajo,
			@Param("idCategoria") String idCategoria, @Param("idManager") String idManager,
			@Param("idCargoManager") String idCargoManager, @Param("idDireccion") String idDireccion, 
			@Param("idGerencia") String idGerencia,  @Param("idJefatura") String idJefatura, 
			@Param("idDivision") String idDivision,  @Param("idCentroDeCostos") String idCentroDeCostos,
			@Param("idConvenio") String idConvenio);

}
