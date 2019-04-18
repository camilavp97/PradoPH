package com.ppi.prado.ph.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class TipoSolicitud {
	
	@Id
	private Long id;
	
	@Column
	@NotEmpty
	private String nombreSolicitud;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreSolicitud() {
		return nombreSolicitud;
	}

	public void setNombreSolicitud(String nombreSolicitud) {
		this.nombreSolicitud = nombreSolicitud;
	}
	
}
