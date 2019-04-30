package com.ppi.prado.ph.persistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ppi.prado.ph.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.nombreUsuario =:nombreUsuario AND u.clave =:clave")
    public Usuario buscarUsurioPorNombreUsuarioYClave(@Param("nombreUsuario") String nombreUsuario,@Param("clave") String clave);

}
