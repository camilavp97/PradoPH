package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.Solicitud;

public interface ISolicitudServices {
	void guardar(Solicitud solicitud);
	void eliminar(Long id);
	Solicitud consultar(Long id);
	List<Solicitud> listar();
}
