package ar.com.ua.model;


import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

	@CreatedBy
	@Column(name = "usuario_creacion")
    protected String usuarioCreacion;
    
	@CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
    protected Date fechaCreacion;
	
    @LastModifiedBy
    @Column(name = "usuario_modificacion")
    protected String usuarioModificacion;
    
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    protected Date fechaModificacion;
}
