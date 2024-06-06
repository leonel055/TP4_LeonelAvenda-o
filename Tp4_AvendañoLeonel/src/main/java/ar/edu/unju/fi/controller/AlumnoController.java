package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		
		ModelAndView modelView = new ModelAndView("formAlumno");
		
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		return modelView;
	}
	
	
	@PostMapping("/guardarAlumno")
	
	public ModelAndView guardarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoAGuardar) {
		
		ListadoAlumno.agregarAlumno(alumnoAGuardar);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		
		modelView.addObject("ListadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
	
	
	
	@GetMapping("/borrarAlumno/{dni}")
	
	public ModelAndView BorrarAlumno(@PathVariable(name="dni") String dni) {
		
		ListadoAlumno.eliminarAlumno(dni);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		
		modelView.addObject("ListadoAlumnos", ListadoAlumno.listarAlumnos());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView formModificarAlumnoa(@PathVariable("dni") String dni) {
		
		Alumno alumno1 = ListadoAlumno.buscarAlumnoPorDNI(dni);

		ModelAndView modelView = new ModelAndView("modificarAlumno");
		
		modelView.addObject("alumnoModificado", alumno1);

		return modelView;
	}

	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute("alumnoModificado") Alumno alumno) {

		ListadoAlumno.modificarAlumno(alumno);

		return mostrarLista();
	}

	@GetMapping("/listaDeAlumnos")
	public ModelAndView mostrarLista() {
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());

		return modelView;
	}

}
