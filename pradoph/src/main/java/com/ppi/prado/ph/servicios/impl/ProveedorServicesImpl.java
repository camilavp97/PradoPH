package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.Proveedor;
import com.ppi.prado.ph.persistencia.ProveedorRepository;
import com.ppi.prado.ph.servicios.IProveedorServices;

@Service
public class ProveedorServicesImpl implements IProveedorServices{

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public void guardar(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}
	
	@Override
	public void eliminar(Long id) {
		proveedorRepository.deleteById(id);
	}
	
	@Override
	public Proveedor consultar(Long id) {
		Optional<Proveedor> proveedorConsultado = proveedorRepository.findById(id);
		if(proveedorConsultado.isPresent()) {
			return proveedorConsultado.get();
		}
		return null;
	}

	@Override
	public List<Proveedor> listar() {
		return (List<Proveedor>) proveedorRepository.findAll();
	}
}
