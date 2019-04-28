package com.ppi.prado.ph.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppi.prado.ph.entidades.Proveedor;
import com.ppi.prado.ph.servicios.IProveedorServices;

@Controller
@RequestMapping("/proveedores")
public class ProveedorControlador {

	@Autowired
	private IProveedorServices proveedorServices;

	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("proveedorEntidad", new Proveedor());
		modelo.addAttribute("proveedores", proveedorServices.listar());
		return "proveedorformulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		proveedorServices.eliminar(id);
		return "redirect:/proveedores/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model modelo) {
		Proveedor proveedorExistente = proveedorServices.consultar(id);
		modelo.addAttribute("proveedores", proveedorServices.listar());
		modelo.addAttribute("proveedorEntidad", proveedorExistente);
		return "proveedorformulario";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("proveedorEntidad") Proveedor proveedor, BindingResult bindingResult,
			Model modelo) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("proveedores", proveedorServices.listar());
			modelo.addAttribute("proveedorEntidad", proveedor);
			return "proveedorformulario";
		}
		proveedorServices.guardar(proveedor);
		return "redirect:/proveedores/listar";
	}
}