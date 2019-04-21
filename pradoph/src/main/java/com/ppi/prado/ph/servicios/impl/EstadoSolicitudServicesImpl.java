package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.EstadoSolicitud;
import com.ppi.prado.ph.persistencia.EstadoSolicitudRepository;
import com.ppi.prado.ph.servicios.IEstadoSolicitudServices;

@Service
public class EstadoSolicitudServicesImpl implements IEstadoSolicitudServices{

	@Autowired
	private EstadoSolicitudRepository estadoSolicitudRepository;
	
	@Override
	public void guardar(EstadoSolicitud estadoSolicitud) {
		estadoSolicitudRepository.save(estadoSolicitud);
		
	}

	@Override
	public void eliminar(Long id) {
		estadoSolicitudRepository.deleteById(id);
		
	}

	@Override
	public EstadoSolicitud consultar(Long id) {
		Optional<EstadoSolicitud> estadoSolicitudConsultado = estadoSolicitudRepository.findById(id);
		if(estadoSolicitudConsultado.isPresent()){
			return estadoSolicitudConsultado.get();
		}
		return null;
	}

	@Override
	public List<EstadoSolicitud> listar() {
		return (List<EstadoSolicitud>) estadoSolicitudRepository.findAll();
	}

}
