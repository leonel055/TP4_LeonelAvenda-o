package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	@Autowired
	Carrera nuevaCarrera = new Carrera ();
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		
		ModelAndView modelView = new ModelAndView("formCarrera");
		
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		modelView.addObject("band", false);
		return modelView;
	}
	
	
	@PostMapping("/guardarCarrera")
	
	public ModelAndView guardarCarrera(@ModelAttribute("nuevaCarrera")  Carrera carreraAguardar) {
		
		ListadoCarreras.agregarCarrera(carreraAguardar);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		
		modelView.addObject("ListadoCarreras", ListadoCarreras.ListarCarreras());
		
		return modelView;
	}
	
	
	
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView BorrarCarrera(@PathVariable(name="codigo") String codigo) {
		
		ListadoCarreras.eliminarCarrera(codigo);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("ListadoCarreras", ListadoCarreras.ListarCarreras());	
		
		return modelView;		
		}
	
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView formModificarCarrera(@PathVariable("codigo") String codigo) {
		
		Carrera carrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);

		ModelAndView modelView = new ModelAndView("formCarrera");
		
		modelView.addObject("nuevaCarrera", carrera);
		
		modelView.addObject("band", true);
		
		return modelView;
	}

	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
		
		ListadoCarreras.modificarCarrera(carrera);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		
		modelView.addObject("ListadoCarreras", ListadoCarreras.ListarCarreras());
		return modelView;
	}
	
}

