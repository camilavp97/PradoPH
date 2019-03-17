package com.ppi.prado.ph.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class TipoResidente {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@NotEmpty
	private String nombreTipoResidente;

	public TipoResidente() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTipoResidente() {
		return nombreTipoResidente;
	}

	public void setNombreTipoResidente(String nombreTipoResidente) {
		this.nombreTipoResidente = nombreTipoResidente;
	}

}
