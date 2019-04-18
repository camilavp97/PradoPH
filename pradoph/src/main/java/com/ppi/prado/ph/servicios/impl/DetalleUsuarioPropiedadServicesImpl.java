package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.DetalleUsuarioPropiedad;
import com.ppi.prado.ph.persistencia.DetalleUsuarioPropiedadRepository;
import com.ppi.prado.ph.servicios.IDetalleUsuarioPropiedadServices;

@Service
public class DetalleUsuarioPropiedadServicesImpl implements IDetalleUsuarioPropiedadServices {

	@Autowired
	private DetalleUsuarioPropiedadRepository detalleUsuarioPropiedadRepository;
	
	@Override
	public void guardar(DetalleUsuarioPropiedad detalleUsuarioPropiedad) {
		detalleUsuarioPropiedadRepository.save(detalleUsuarioPropiedad);
		
	}

	@Override
	public void eliminar(Long id) {
		detalleUsuarioPropiedadRepository.deleteById(id);
		
	}

	@Override
	public DetalleUsuarioPropiedad consultar(Long id) {
		Optional<DetalleUsuarioPropiedad> detalleConsultado = detalleUsuarioPropiedadRepository.findById(id);
		if(detalleConsultado.isPresent()) {
			return detalleConsultado.get();
		}
		return null;
	}

	@Override
	public List<DetalleUsuarioPropiedad> listar() {
		return (List<DetalleUsuarioPropiedad>) detalleUsuarioPropiedadRepository.findAll();
	}

}
