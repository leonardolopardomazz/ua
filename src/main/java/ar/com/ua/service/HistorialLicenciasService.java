package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Empleado;
import ar.com.ua.model.HistorialLicencias;


public interface HistorialLicenciasService extends JpaRepository<HistorialLicencias, Long> {
	
	HistorialLicencias findOneByEmpleadoAndActivoTrue(Empleado empleado);

}
