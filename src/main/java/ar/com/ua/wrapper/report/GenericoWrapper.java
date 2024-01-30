package ar.com.ua.wrapper.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class GenericoWrapper {

	@Autowired
	private ParametrosRepository repository;

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
		dto.setGeneracion(repository.descripcion(data.get(4)));
		dto.setNacionalidad(repository.descripcion(data.get(5)));
		dto.setGenero(repository.descripcion(data.get(6)));
		dto.setDenominacion(repository.texto1(data.get(6)));
		dto.setCuil(data.get(7));
		dto.setDni(data.get(8));
		dto.setDomicilio(data.get(9));
		dto.setNumeroResidencia(data.get(10));
		dto.setPisoResidencia(data.get(11));
		dto.setLocalidadResidencia(data.get(12));
		dto.setProvincia(repository.descripcion(data.get(13)));
		dto.setEmailPersonal(data.get(14));
		dto.setFechaIngreso(data.get(15));
		dto.setFechaIngresoReconocida(data.get(16));
		dto.setTipoContratacion(repository.descripcion(data.get(17)));
		dto.setHorasSemanales(data.get(18));
		dto.setFte(repository.texto2(data.get(19)));
		dto.setFrecuenciaLiquidacion(repository.descripcion(data.get(20)));
		dto.setTipoEmpleo(repository.descripcion(data.get(21)));
		dto.setTipoJornada(repository.descripcion(data.get(22)));
		dto.setPais(repository.descripcion(data.get(23)));
		dto.setLugarDeTrabajo(data.get(24));
		dto.setEmailLaboral(data.get(25));
		dto.setPuesto(data.get(26));
		dto.setCategoria(repository.descripcion(data.get(27)));
		dto.setDireccion(repository.descripcion(data.get(28)));
		dto.setGerencia(repository.descripcion(data.get(29)));
		dto.setJefatura(repository.descripcion(data.get(30)));
		dto.setDivision(repository.descripcion(data.get(31)));
		dto.setCentroDeCosto(repository.descripcion(data.get(32)));
		dto.setPrepaga(repository.descripcion(data.get(33)));
		dto.setObraSocial(repository.descripcion(data.get(34)));
		dto.setPlanPrepaga(repository.descripcion(data.get(35)));
		dto.setBanco(repository.descripcion(data.get(36)));
		dto.setCbu(data.get(37));
		dto.setConvenio(repository.descripcion(data.get(38)));
		dto.setAfiliadoSindicato(data.get(39));
		dto.setFinFechaContrato(data.get(40));
		dto.setFechaEgreso(data.get(41));
		dto.setTipoEgreso(repository.descripcion(data.get(42)));
		dto.setEstadoCivil(repository.descripcion(data.get(43)));
		dto.setGrado(repository.descripcion(data.get(44)));
		dto.setCargoManager(data.get(45));
		dto.setManager(data.get(46));
		dto.setCargasDeFamilia(data.get(47));
		return dto;
	}

}
