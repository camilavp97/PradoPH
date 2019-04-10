package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.PerfilUsuario;

public interface IPerfilUsuarioServices {
	void guardar(PerfilUsuario perfilUsuario);
	void eliminar(Long id);
	PerfilUsuario consultar(Long id);
	List<PerfilUsuario> listar();
}
