package com.ppi.prado.ph.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ppi.prado.ph.servicios.ITipoResidenteServices;

@Controller
public class TipoResidenteControlador {

	@Autowired
	private ITipoResidenteServices tipoResidenteServicesImpl;
	
	public String prueba() {
		return "Hola Mundo";
	}
	
}
