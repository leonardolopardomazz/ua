package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class GenericoWrapper {

	@Autowired
	private ParametrosRepository repository;

	public GenericoResponseDTO result(List<String> data) {
		
		GenericoResponseDTO dto = new GenericoResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setNombres(data.get(1));
		dto.setNombrePreferido(data.get(2));
		dto.setFechaNacimiento(data.get(3));
		dto.setGeneracion(repository.descripcion(data.get(4)));
		dto.setNacionalidad(repository.descripcion(data.get(5)));
		dto.setGenero(repository.descripcion(data.get(6)));
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
		dto.setTipoContratacion(data.get(17));
		dto.setHorasSemanales(data.get(18));
		dto.setFte(data.get(19));
		dto.setFrecuenciaLiquidacion(data.get(20));
		dto.setTipoEmpleo(data.get(21));
		dto.setTipoJornada(data.get(22));
		dto.setPais(repository.descripcion(data.get(23)));
		dto.setEmailLaboral(data.get(24));
		dto.setPuesto(repository.descripcion(data.get(25)));
		dto.setCategoria(repository.descripcion(data.get(26)));
		dto.setDireccion(repository.descripcion(data.get(27)));
		dto.setGerencia(repository.descripcion(data.get(28)));
		dto.setJefatura(repository.descripcion(data.get(29)));
		dto.setDivision(repository.descripcion(data.get(30)));
		dto.setCentroDeCosto(repository.descripcion(data.get(31)));
		dto.setPrepaga(repository.descripcion(data.get(32)));
		dto.setObraSocial(repository.descripcion(data.get(33)));
		dto.setPlanPrepaga(repository.descripcion(data.get(34)));
		dto.setBanco(repository.descripcion(data.get(35)));
		dto.setCbu(repository.descripcion(data.get(36)));
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
