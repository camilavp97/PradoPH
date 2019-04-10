package com.ppi.prado.ph.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.PerfilUsuario;
import com.ppi.prado.ph.persistencia.PerfilUsuarioRepository;
import com.ppi.prado.ph.servicios.IPerfilUsuarioServices;

@Service
public class PerfilUsuarioServicesImpl implements IPerfilUsuarioServices{

	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	@Override
	public void guardar(PerfilUsuario perfilUsuario) {
		perfilUsuarioRepository.save(perfilUsuario);
		
	}

	@Override
	public void eliminar(Long id) {
		perfilUsuarioRepository.deleteById(id);
		
	}

	@Override
	public PerfilUsuario consultar(Long id) {
		return perfilUsuarioRepository.findById(id).get();
	}

	@Override
	public List<PerfilUsuario> listar() {
		return (List<PerfilUsuario>) perfilUsuarioRepository.findAll();
	}

}
