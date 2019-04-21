package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.Propiedad;

public interface IPropiedadServices {
	void guardar(Propiedad propiedad);
	void eliminar(Long id);
	Propiedad consultar(Long id);
	List<Propiedad> listar();
}
