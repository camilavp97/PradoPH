package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.TipoSolicitud;

public interface ITipoSolicitudServices {
	void guardar(TipoSolicitud tipoSolicitud);
	void eliminar(Long id);
	TipoSolicitud consultar(Long id);
	List<TipoSolicitud> listar();
}
