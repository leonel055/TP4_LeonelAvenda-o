package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@Autowired
	Docente nuevoDocente = new Docente ();
	
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		
		ModelAndView modelView = new ModelAndView("formDocente");
		
		modelView.addObject("nuevoDocente", nuevoDocente);
		return modelView;
	}
	
	
	@PostMapping("/guardarDocente")
	public ModelAndView guardarDocente(@ModelAttribute("nuevoDocente")  Docente DocenteAguardar) {
		
		ListadoDocentes.agregarDocente(DocenteAguardar);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		
		modelView.addObject("ListadoDocentes", ListadoDocentes.ListarDocentes());
		
		return modelView;
	}
	
	
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView BorrarDocente(@PathVariable(name="legajo") String legajo) {
		
		ListadoDocentes.eliminarDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		
		modelView.addObject("ListadoDocentes", ListadoDocentes.ListarDocentes());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarDocente/{legajo}")
    public ModelAndView formModificarDocente(@PathVariable("legajo") String legajo) {
        Docente docente1 = ListadoDocentes.buscarDocentePorLegajo(legajo);
        
        ModelAndView modelView = new ModelAndView("modificarDocente");
        modelView.addObject("docenteModificado", docente1);
        
        return modelView;
    }

    @PostMapping("/modificarDocente")
    public ModelAndView modificarDocente(@ModelAttribute("docenteModificado") Docente docente) {

        ListadoDocentes.modificarDocente(docente);

        return mostrarLista();
    }

	@GetMapping("/listaDeDocentes")
	public ModelAndView mostrarLista() {
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.ListarDocentes());

		return modelView;
	}

}