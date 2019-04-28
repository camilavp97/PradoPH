package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.DetalleUsuarioPropiedad;

public interface IDetalleUsuarioPropiedadServices {
	
	void guardar(DetalleUsuarioPropiedad detalleUsuarioPropiedad);
	void eliminar(Long id);
	DetalleUsuarioPropiedad consultar(Long id);
	List<DetalleUsuarioPropiedad> listar();
	boolean existeDetallePorUsuarioYPropiedad(Long idUsuario,Long idPropiedad);

}
