package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.Apartamento;
import com.ppi.prado.ph.persistencia.ApartamentoRepository;
import com.ppi.prado.ph.servicios.IApartamentoServices;

@Service
public class ApartamentoServicesImpl implements IApartamentoServices{
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;

	@Override
	public void guardar(Apartamento apartamento) {
		apartamentoRepository.save(apartamento);
	}

	@Override
	public void eliminar(Long id) {
		apartamentoRepository.deleteById(id);
		
	}

	@Override
	public Apartamento consultar(Long id) {
		Optional<Apartamento> apartamentoConsultado = apartamentoRepository.findById(id);
		if(apartamentoConsultado.isPresent()) {
			return apartamentoConsultado.get();
		}
		return null;
	}

	@Override
	public List<Apartamento> listar() {
		return (List<Apartamento>) apartamentoRepository.findAll();
	}
}
