package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.Apartamento;


public interface IApartamentoServices {

	void guardar(Apartamento apartamento);
	void eliminar(Long id);
	Apartamento consultar(Long id);
	List<Apartamento> listar();
}
