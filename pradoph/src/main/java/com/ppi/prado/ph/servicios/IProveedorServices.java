package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.Proveedor;

public interface IProveedorServices {
	void guardar(Proveedor proveedor);
	void eliminar(Long id);
	Proveedor consultar(Long id);
	List<Proveedor> listar();
}
