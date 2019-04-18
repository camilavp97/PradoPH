package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.TipoSolicitud;
import com.ppi.prado.ph.persistencia.TipoSolicitudRepository;
import com.ppi.prado.ph.servicios.ITipoSolicitudServices;

@Service
public class TipoSolicitudServicesImpl implements ITipoSolicitudServices {
	
	@Autowired
	private TipoSolicitudRepository tipoSolicitudRepository;

	@Override
	public void guardar(TipoSolicitud tipoSolicitud) {
		tipoSolicitudRepository.save(tipoSolicitud);
	}

	@Override
	public void eliminar(Long id) {
		tipoSolicitudRepository.deleteById(id);
		
	}

	@Override
	public TipoSolicitud consultar(Long id) {
		Optional<TipoSolicitud> tipoSolicitudConsultada = tipoSolicitudRepository.findById(id);
		if(tipoSolicitudConsultada.isPresent()) {
			return tipoSolicitudConsultada.get();
		}
		return null;
	}

	@Override
	public List<TipoSolicitud> listar() {
		return (List<TipoSolicitud>) tipoSolicitudRepository.findAll();
	}

}
