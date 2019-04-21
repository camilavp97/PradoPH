package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.Propiedad;
import com.ppi.prado.ph.persistencia.PropiedadRepository;
import com.ppi.prado.ph.servicios.IPropiedadServices;

@Service
public class PropiedadServicesImpl implements IPropiedadServices {

	@Autowired
	private PropiedadRepository propiedadRepository;
	
	@Override
	public void guardar(Propiedad propiedad) {
		propiedadRepository.save(propiedad);
		
	}

	@Override
	public void eliminar(Long id) {
		propiedadRepository.deleteById(id);
		
	}

	@Override
	public Propiedad consultar(Long id) {
		Optional<Propiedad> propiedadConsultada = propiedadRepository.findById(id);
		if(propiedadConsultada.isPresent()) {
			return propiedadConsultada.get();
		}
		return null;
	}

	@Override
	public List<Propiedad> listar() {
		return (List<Propiedad>) propiedadRepository.findAll();
	}

}
