package com.ppi.prado.ph.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@ManyToOne
	private PerfilUsuario perfilUsuario;
	
	@NotEmpty
	@Column
	@Size(max = 30)
	private String nombre;
	
	@NotEmpty
	@Column
	@Size(max = 30)
	private String apellido;
	
//	@Pattern(regexp = "([0-9])")
	@Column
	@Size(max = 10)
	private String telefono;
	
	@Column
	private String fotoPerfil;

	@Column
	@NotEmpty
	@Size(max = 8)
	private String nombreUsuario;

	@Column
	@NotEmpty
	@Size (max = 10)
	private String clave;
	
	@Column
	@NotEmpty
	@Size (max = 10)
	@Transient
	private String confirmacionClave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConfirmacionClave() {
		return confirmacionClave;
	}

	public void setConfirmacionClave(String confirmacionClave) {
		this.confirmacionClave = confirmacionClave;
	}

}
