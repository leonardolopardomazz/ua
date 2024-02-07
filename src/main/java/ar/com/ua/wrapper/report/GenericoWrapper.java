package ar.com.ua.wrapper.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.service.ParametroService;

@Component
public class GenericoWrapper {

	@Autowired
	private ParametroService parametroService;

	private String descripcion(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getDescripcion();
		}
		return "";
	}

	private String texto1(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getTexto1();
		}
		return "";
	}

	private String texto2(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getTexto2();
		}
		return "";
	}

	private int calcularEdad(String fecha) {
		if (fecha == null)
			return 0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();
	}

	public GenericoResponseDTO result(List<String> data) {
		GenericoResponseDTO dto = new GenericoResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setNombres(data.get(1));
		dto.setNombrePreferido(data.get(2));
		dto.setFechaNacimiento(data.get(3));
		dto.setEdad(String.valueOf(calcularEdad(data.get(3))));
		dto.setGeneracion(descripcion(data.get(4)));
		dto.setNacionalidad(descripcion(data.get(5)));
		dto.setGenero(descripcion(data.get(6)));
		dto.setDenominacion(texto1(data.get(6)));
		dto.setCuil(data.get(7));
		dto.setDni(data.get(8));
		dto.setDomicilio(data.get(9));
		dto.setNumeroResidencia(data.get(10));
		dto.setPisoResidencia(data.get(11));
		dto.setLocalidadResidencia(data.get(12));
		dto.setProvincia(descripcion(data.get(13)));
		dto.setEmailPersonal(data.get(14));
		dto.setFechaIngreso(data.get(15));
		dto.setFechaIngresoReconocida(data.get(16));
		dto.setTipoContratacion(descripcion(data.get(17)));
		dto.setHorasSemanales(data.get(18));
		dto.setFte(texto2(data.get(19)));
		dto.setFrecuenciaLiquidacion(descripcion(data.get(20)));
		dto.setTipoEmpleo(descripcion(data.get(21)));
		dto.setTipoJornada(descripcion(data.get(22)));
		dto.setPais(data.get(23));
		dto.setLugarDeTrabajo(descripcion(data.get(24)));
		dto.setEmailLaboral(data.get(25));
		dto.setPuesto(data.get(26));
		dto.setCategoria(descripcion(data.get(27)));
		dto.setDireccion(descripcion(data.get(28)));
		dto.setGerencia(descripcion(data.get(29)));
		dto.setJefatura(descripcion(data.get(30)));
		dto.setDivision(descripcion(data.get(31)));
		dto.setCentroDeCosto(descripcion(data.get(32)));
		dto.setPrepaga(descripcion(data.get(33)));
		dto.setObraSocial(descripcion(data.get(34)));
		dto.setPlanPrepaga(descripcion(data.get(35)));
		dto.setBanco(descripcion(data.get(36)));
		dto.setCbu(data.get(37));
		dto.setConvenio(descripcion(data.get(38)));
		dto.setAfiliadoSindicato(data.get(39));
		dto.setFinFechaContrato(data.get(40));
		dto.setFechaEgreso(data.get(41));
		dto.setTipoEgreso(descripcion(data.get(42)));
		dto.setEstadoCivil(descripcion(data.get(43)));
		dto.setGrado(descripcion(data.get(44)));
		dto.setCargoManager(data.get(45));
		dto.setManager(data.get(46));
		dto.setCargasDeFamilia(data.get(47));
		return dto;
	}

}
