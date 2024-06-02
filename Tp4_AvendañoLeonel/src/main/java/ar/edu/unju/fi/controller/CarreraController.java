package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Carrera;


@Controller
public class CarreraController {
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		
		ModelAndView modelView = new ModelAndView("formCarrera");
		
		modelView.addObject("nuevaCarrera", new Carrera());
		
		return modelView;
	}
}
