package com.ppi.prado.ph.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppi.prado.ph.entidades.TipoResidente;
import com.ppi.prado.ph.persistencia.ITipoResidente;
import com.ppi.prado.ph.servicios.ITipoResidenteServices;

@Service
public class TipoResidenteServicesImpl implements ITipoResidenteServices{

	//Se comunica con la BD 
	@Autowired
	private ITipoResidente tipoResidenteDao;
	
	@Override
	public void guardar(TipoResidente tipoResidente) {
		//Validaciones
		
		//Guardar en BD
		tipoResidenteDao.save(tipoResidente);
	}

	@Override
	public void eliminar(Long id) {
		//Validaciones
		
		//Guardar en BD
		tipoResidenteDao.deleteById(id);
	}

	@Override
	public TipoResidente consultar(Long id) {
		Optional<TipoResidente> tipoResidenteConsultado = tipoResidenteDao.findById(id);
		if (tipoResidenteConsultado.isPresent()) {
			return tipoResidenteConsultado.get();
		}
		return null;
	}

	@Override
	public List<TipoResidente> listar() {
		return (List<TipoResidente>) tipoResidenteDao.findAll();
	}

	
	
}
