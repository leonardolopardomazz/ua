package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

public class GenericoWrapper {

	@Autowired
	private ParametrosRepository repository;

	public GenericoResponseDTO result(List<String> data) {
		
		GenericoResponseDTO dto = new GenericoResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setNombres(data.get(1));
		dto.setNombrePreferido(data.get(2));
		dto.setFechaNacimiento(data.get(3));
		dto.setGeneracion(data.get(4));
		dto.setNacionalidad(data.get(5));
		dto.setGenero(data.get(6));
		dto.setCuil(data.get(7));
		dto.setDni(data.get(8));
		dto.setDomicilio(data.get(9));
		dto.setNumeroResidencia(data.get(10));
		dto.setPisoResidencia(data.get(11));
		dto.setLocalidadResidencia(data.get(12));
		dto.setProvincia(data.get(13));
		dto.setEmailPersonal(data.get(14));
		dto.setFechaIngreso(data.get(15));
		dto.setFechaIngresoReconocida(data.get(16));
		dto.setTipoContratacion(data.get(17));
		dto.setHorasSemanales(data.get(18));
		dto.setFte(data.get(19));
		dto.setFrecuenciaLiquidacion(data.get(20));
		dto.setTipoEmpleo(data.get(21));
		dto.setTipoJornada(data.get(22));
		dto.setPais(data.get(23));
		dto.setEmailLaboral(data.get(24));
		dto.setPuesto(data.get(25));
		dto.setCategoria(data.get(26));
		dto.setDireccion(data.get(27));
		dto.setGerencia(data.get(28));
		dto.setJefatura(data.get(29));
		dto.setDivision(data.get(30));
		dto.setCentroDeCosto(data.get(31));
		dto.setPrepaga(data.get(32));
		dto.setObraSocial(data.get(33));
		dto.setPlanPrepaga(data.get(34));
		dto.setBanco(data.get(35));
		dto.setCbu(data.get(36));
		dto.setConvenio(data.get(37));
		dto.setAfiliadoSindicato(data.get(38));
		dto.setFinFechaContrato(data.get(39));
		dto.setFechaEgreso(data.get(40));
		dto.setTipoEgreso(data.get(41));
		dto.setEstadoCivil(data.get(42));
		dto.setGrado(data.get(43));

		return dto;
	}

}
