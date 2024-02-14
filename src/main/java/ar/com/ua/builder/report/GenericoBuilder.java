package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.projection.report.GenericoProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class GenericoBuilder implements IBuilderResponse<List<GenericoProjection>, List<GenericoResponseDTO>> {
	
	@Autowired
	private CommonsRepository commonsRepository;
	
	@Override
	public List<GenericoResponseDTO> listToDto(List<GenericoProjection> listProjection) {
		
		List<GenericoResponseDTO> listDto = new ArrayList<>();

		try {
			for (GenericoProjection genericoProjection : listProjection) {
				GenericoResponseDTO dto = new GenericoResponseDTO(); 
				
				dto.setNumeroLegajo(genericoProjection.getNumeroLegajo());
				dto.setNombres(genericoProjection.getApellidoNombre());
				dto.setNombrePreferido(genericoProjection.getNombrePreferido());
				dto.setFechaNacimiento(genericoProjection.getFechaNacimiento());
				dto.setEdad(String.valueOf(commonsRepository.calcularEdad(genericoProjection.getFechaNacimiento())));
				dto.setGeneracion(commonsRepository.descripcion(genericoProjection.getCodigoGeneracion()));
				dto.setNacionalidad(commonsRepository.descripcion(genericoProjection.getCodigoNacionalidad()));
				dto.setGenero(commonsRepository.descripcion(genericoProjection.getCodigoGenero()));
				dto.setDenominacion(commonsRepository.texto1(genericoProjection.getCodigoGenero()));
				dto.setCuil(genericoProjection.getNumeroDocumentoLaboral());
				dto.setDni(genericoProjection.getNumeroDocumentoPersonal());
				dto.setDomicilio(genericoProjection.getDomicilio());
				dto.setNumeroResidencia(genericoProjection.getNumeroResidencia());
				dto.setPisoResidencia(genericoProjection.getPisoResidencia());
				dto.setLocalidadResidencia(genericoProjection.getLocalidadResidencia());
				dto.setProvincia(commonsRepository.descripcion(genericoProjection.getProvincia()));
				dto.setEmailPersonal(genericoProjection.getEmailPersonal());
				dto.setFechaIngreso(genericoProjection.getFechaIngreso());
				dto.setFechaIngresoReconocida(genericoProjection.getFechaIngresoReconocida());
				dto.setTipoContratacion(commonsRepository.descripcion(genericoProjection.getTipoContratacion()));
				dto.setHorasSemanales(commonsRepository.descripcion(genericoProjection.getHorasSemanales()));
				dto.setFte(commonsRepository.texto2(genericoProjection.getFte()));
				dto.setFrecuenciaLiquidacion(commonsRepository.descripcion(genericoProjection.getFrecuenciaLiquidacion()));
				dto.setTipoEmpleo(commonsRepository.descripcion(genericoProjection.getTipoDeEmpleo()));
				dto.setTipoJornada(commonsRepository.descripcion(genericoProjection.getTipoDeJornada()));
				dto.setPais(genericoProjection.getPais());
				dto.setLugarDeTrabajo(commonsRepository.descripcion(genericoProjection.getCodigoOficina()));
				dto.setEmailLaboral(genericoProjection.getEmailLaboral());
				dto.setPuesto(genericoProjection.getPuesto());
				dto.setCategoria(commonsRepository.descripcion(genericoProjection.getCodigoCategoria()));
				dto.setDireccion(commonsRepository.descripcion(genericoProjection.getCodigoDireccion()));
				dto.setGerencia(commonsRepository.descripcion(genericoProjection.getCodigoGerencia()));
				dto.setJefatura(commonsRepository.descripcion(genericoProjection.getCodigoJefatura()));
				dto.setDivision(commonsRepository.descripcion(genericoProjection.getCodigoDivision()));
				dto.setCentroDeCosto(commonsRepository.descripcion(genericoProjection.getCodigoCentroDeCosto()));
				dto.setPrepaga(commonsRepository.descripcion(genericoProjection.getCodigoPrepaga()));
				dto.setObraSocial(commonsRepository.descripcion(genericoProjection.getCodigoObraSocial()));
				dto.setPlanPrepaga(commonsRepository.descripcion(genericoProjection.getCodigoPlanPrepaga()));
				dto.setBanco(commonsRepository.descripcion(genericoProjection.getCodigoBanco()));
				dto.setCbu(genericoProjection.getCbu());
				dto.setConvenio(commonsRepository.descripcion(genericoProjection.getCodigoConvenio()));
				dto.setAfiliadoSindicato(genericoProjection.getAfiliadoSindicato());
				dto.setFinFechaContrato(genericoProjection.getfechaFinContrato());
				dto.setFechaEgreso(genericoProjection.getFechaEgreso());
				dto.setTipoEgreso(commonsRepository.descripcion(genericoProjection.getCodigoTipoEgreso()));
				dto.setEstadoCivil(commonsRepository.descripcion(genericoProjection.getCodigoEstadoCivil()));
				dto.setGrado(commonsRepository.descripcion(genericoProjection.getCodigoGrado()));
				dto.setCargoManager(genericoProjection.getPuestoManager());
				dto.setManager(genericoProjection.getApellidoNombreManager());
				dto.setCargasDeFamilia(genericoProjection.getCargasDeFamilia());
				
				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}
