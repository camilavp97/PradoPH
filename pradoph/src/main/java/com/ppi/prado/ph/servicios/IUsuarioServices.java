package com.ppi.prado.ph.servicios;

import java.util.List;

import com.ppi.prado.ph.entidades.Usuario;

public interface IUsuarioServices {
	void guardar(Usuario usuario);
	void eliminar(Long id);
	Usuario consultar(Long id);
	List<Usuario> listar();
	Usuario consultarUsuarioPorNombreUsuarioYClave(String nombre,String clave);
}
