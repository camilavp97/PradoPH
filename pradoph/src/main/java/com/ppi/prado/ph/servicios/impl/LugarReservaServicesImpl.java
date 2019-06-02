package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.LugarReserva;
import com.ppi.prado.ph.persistencia.LugarReservaRepository;
import com.ppi.prado.ph.servicios.ILugarReservaServices;

@Service
public class LugarReservaServicesImpl implements ILugarReservaServices{
	
	@Autowired
	private LugarReservaRepository lugarReservaRepository;

	@Override
	public void guardar(LugarReserva lugarReserva) {
		lugarReservaRepository.save(lugarReserva);
	}

	@Override
	public void eliminar(Long id) {
		lugarReservaRepository.deleteById(id);
		
	}

	@Override
	public LugarReserva consultar(Long id) {
		Optional<LugarReserva> lugarReservaCosultado = lugarReservaRepository.findById(id);
		if(lugarReservaCosultado.isPresent()) {
			return lugarReservaCosultado.get();
		}
		return null;
	}

	@Override
	public List<LugarReserva> listar() {
		return (List<LugarReserva>) lugarReservaRepository.findAll();
	}
}
