package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.Solicitud;
import com.ppi.prado.ph.persistencia.SolicitudRepository;
import com.ppi.prado.ph.servicios.ISolicitudServices;

@Service
public class SolicitudServicesImpl implements ISolicitudServices{

	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Override
	public void guardar(Solicitud solicitud) {
		solicitudRepository.save(solicitud);
		
	}

	@Override
	public void eliminar(Long id) {
		solicitudRepository.deleteById(id);
		
	}

	@Override
	public Solicitud consultar(Long id) {
		Optional<Solicitud> solicitudConsultada = solicitudRepository.findById(id);
		if(solicitudConsultada.isPresent()) {
			return solicitudConsultada.get();
		}
		return null;
	}

	@Override
	public List<Solicitud> listar() {
		return (List<Solicitud>) solicitudRepository.findAll();
	}

}
