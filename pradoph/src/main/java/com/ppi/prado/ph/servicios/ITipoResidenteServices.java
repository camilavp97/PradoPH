package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.TipoResidente;

public interface ITipoResidenteServices {

	void guardar(TipoResidente tipoResidente);
	void eliminar(Long id);
	TipoResidente consultar(Long id);
	List<TipoResidente> listar();
	
}
