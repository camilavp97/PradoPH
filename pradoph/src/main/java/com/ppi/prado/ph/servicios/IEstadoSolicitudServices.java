package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.EstadoSolicitud;

public interface IEstadoSolicitudServices {
	void guardar(EstadoSolicitud estadoSolicitud);
	void eliminar(Long id);
	EstadoSolicitud consultar(Long id);
	List<EstadoSolicitud> listar();
}
