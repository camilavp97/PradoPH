package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.EstadoReserva;

public interface IEstadoReservaServices {
	void guardar(EstadoReserva estadoReserva);
	void eliminar(Long id);
	EstadoReserva consultar(Long id);
	List<EstadoReserva> listar();
}
