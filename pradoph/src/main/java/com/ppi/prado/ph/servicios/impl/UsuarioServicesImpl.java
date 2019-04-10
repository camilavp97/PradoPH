package com.ppi.prado.ph.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.Usuario;
import com.ppi.prado.ph.persistencia.UsuarioRepository;
import com.ppi.prado.ph.servicios.IUsuarioServices;

@Service
public class UsuarioServicesImpl implements IUsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);
		
	}

	@Override
	public Usuario consultar(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
}
