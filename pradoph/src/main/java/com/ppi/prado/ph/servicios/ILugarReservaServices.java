package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.LugarReserva;

public interface ILugarReservaServices {
	void guardar(LugarReserva lugarReserva);
	void eliminar(Long id);
	LugarReserva consultar(Long id);
	List<LugarReserva> listar();
}
