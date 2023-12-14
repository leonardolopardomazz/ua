package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.DirectoresDTO;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.GenericoDTO;
import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.InternationalDataCollectionDTO;
import ar.com.ua.dto.report.LicenciaDTO;
import ar.com.ua.dto.report.VueltaAlColegioDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional(readOnly = false)
public class ReportRepositoryImpl implements ReportRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<?> reportVueltaAlColegio(VueltaAlColegioDTO dto) {
		String queryParam = addGroupBy(addConstantFilter(addFilters(basicQuery(), dto)));
		Query query = entityManager.createNativeQuery(queryParam);
		
		return query.getResultList();
	}

	private String basicQuery() {
		final String query = "SELECT emp.nro_legajo, emp.apellido, emp.nombre, GROUP_CONCAT(cdf.fecha_nacimiento) "
				+ "FROM ua.empleados emp, ua.cargas_de_familia cdf, ua.pais pais "
				+ "WHERE emp.nro_legajo = cdf.nro_legajo AND emp.cod_pais = pais.id ";

		return query;
	}

	private String addFilters(String basicQuery, VueltaAlColegioDTO dto) {

		String pais = dto.getPais();
		if (!pais.equals("") & pais != null) {
			basicQuery = basicQuery.concat(" AND emp.cod_pais IN (" + pais + ")");
		}
		String apellido = dto.getApellido();
		if (!apellido.equals("") & apellido != null) {
			basicQuery = basicQuery.concat(" AND emp.apellido= " + "'" + apellido + "'");
		}

		String numeroLegajo = dto.getNumeroLegajo();
		if (!numeroLegajo.equals("") & numeroLegajo != null) {
			basicQuery = basicQuery.concat(" AND emp.nro_legajo= " + numeroLegajo);
		}

		Long codigoPuesto = dto.getCodigoPuesto();
		if (codigoPuesto != null) {
			basicQuery = basicQuery.concat(" AND emp.cod_puesto= " + codigoPuesto);
		}

		Long codigoDireccion = dto.getCodigoDireccion();
		if (codigoDireccion != null) {
			basicQuery = basicQuery.concat(" AND emp.cod_direccion= " + codigoDireccion);
		}

		return basicQuery;
	}

	private String addConstantFilter(String basicQuery) {
		return basicQuery.concat(" AND cdf.activo = 1 AND cdf.tipo_familiar = 'hijo' ");
	}

	private String addGroupBy(String query) {
		return query.concat(" GROUP BY  emp.nro_legajo, emp.apellido, emp.nombre");
	}

	@Override
	public String reportCentroDeCosto(CentroDeCostoDTO dto) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public String reportHistorialLaboral(HistorialLaboralDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportInternationalDataCollection(InternationalDataCollectionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportExternos(ExternosDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportDirectores(DirectoresDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportGenerico(GenericoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportLicencia(LicenciaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
