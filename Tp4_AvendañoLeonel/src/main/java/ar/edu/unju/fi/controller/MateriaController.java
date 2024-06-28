package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		
		ModelAndView modelView = new ModelAndView("formMateria");
		
		modelView.addObject("nuevaMateria", nuevaMateria);
		
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
		
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
		
		modelView.addObject("band", false);	
		
		return modelView;
	}
	
	
	@PostMapping("/guardarMateria")
	
	public ModelAndView guardarMateria(@ModelAttribute("nuevaMateria")  Materia MateriaAguardar) {
		
		MateriaAguardar.setDocente(ListadoDocentes.buscarDocentePorLegajo(MateriaAguardar.getDocente().getLegajo()));
		
		MateriaAguardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(MateriaAguardar.getCarrera().getCodigo()));
		
		ListadoMateria.agregarMateria(MateriaAguardar);
		
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		
		modelView.addObject("ListadoMaterias", ListadoMateria.ListarMaterias());
		
		return modelView;
	}
	
	
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView BorrarMateria(@PathVariable(name="codigo") String codigo) {
		
		ListadoMateria.eliminarMateria(codigo);
		
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		
		modelView.addObject("ListadoMaterias", ListadoMateria.ListarMaterias());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView formModificarMateria(@PathVariable("codigo") String codigo) {
		
		Materia materia = ListadoMateria.buscarMateriaPorCodigo(codigo);

		ModelAndView modelView = new ModelAndView("formMateria");
		
		modelView.addObject("nuevaMateria", materia);
		
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());
		
		modelView.addObject("listadoCarreras", ListadoCarreras.ListarCarreras());
		
		modelView.addObject("band", true);

		return modelView;
	}

	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("materiaModificada") Materia materia) {

		materia.setDocente(ListadoDocentes.buscarDocentePorLegajo(materia.getDocente().getLegajo()));
		
		materia.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materia.getCarrera().getCodigo()));
		
		ListadoMateria.modificarMateria(materia);
		
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		
		modelView.addObject("ListadoMaterias", ListadoMateria.ListarMaterias());

		return modelView;
	}
	
}
