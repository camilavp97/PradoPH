package com.ppi.prado.ph.persistencia;

import org.springframework.data.repository.CrudRepository;

import com.ppi.prado.ph.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
