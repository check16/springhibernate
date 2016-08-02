package com.asanast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asanast.pojo.Admin;
import com.asanast.pojo.Direccion;
import com.asanast.service.AdminService;
import com.asanast.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private DireccionService direccionService;

	@RequestMapping(value = "/direccion/{idAd}")
	public String showAllDirections(Model model, @PathVariable("idAd") int idAd, @ModelAttribute("resultado") String resultado) {
		Admin admin = adminService.findById(idAd);
		model.addAttribute("admin", admin);
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("resultado", resultado);
		model.addAttribute("direcciones", direccionService.findAll(idAd));
		return "direccion";
	}

	@RequestMapping(value = "/direccion/save")
	public String handleDireccion(Model model, RedirectAttributes ra, @ModelAttribute("direccion") Direccion direccion,
			@ModelAttribute("admin") Admin admin) {
		
		direccionService.saveOrUpdate(admin, direccion);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");
		return "redirect:/direccion/" + admin.getIdAd();
	}
	
	@RequestMapping("/direccion/{idDireccion}/update")
	public String showUpdate(Model model, @PathVariable("idDireccion") int idDir) {
		Direccion direccion = direccionService.findById(idDir);
		model.addAttribute("direccion", direccion);
		
		return "direccion";
	}

	@RequestMapping("/direccion/{idDireccion}/delete")
	public String delete(@PathVariable("idDireccion") int idDir, @ModelAttribute("admin") Admin admin, RedirectAttributes ra) {
		direccionService.delete(idDir);
		ra.addFlashAttribute("resultado", "Dirección eliminada correctamente");
		return "redirect:/direccion/" + admin.getIdAd();
	}

}
