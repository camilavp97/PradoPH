package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.EstadoReserva;
import com.ppi.prado.ph.persistencia.EstadoReservaRepository;
import com.ppi.prado.ph.servicios.IEstadoReservaServices;

@Service
public class EstadoReservaServicesImpl implements IEstadoReservaServices{
	
	@Autowired
	private EstadoReservaRepository estadoReservaRepository;
	
	@Override
	public void guardar(EstadoReserva estadoReserva) {
		estadoReservaRepository.save(estadoReserva);
	}
	
	@Override
	public void eliminar(Long id) {
		estadoReservaRepository.deleteById(id);
	}
	
	@Override
	public EstadoReserva consultar(Long id) {
		Optional<EstadoReserva> estadoReservaConsultado = estadoReservaRepository.findById(id);
		if(estadoReservaConsultado.isPresent()) {
			return estadoReservaConsultado.get();
		}
		return null;
	}

	@Override
	public List<EstadoReserva> listar() {
		return (List<EstadoReserva>) estadoReservaRepository.findAll();
	}
}
