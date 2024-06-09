package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	
	
    public static List<Docente> ListarDocentes(){
    	Predicate<? super Docente> activo = n -> !n.getLegajo().equals("-1");
        List<Docente> docentesActivos = docentes.stream().filter(activo).collect(Collectors.toList());
        return docentesActivos;
	}
    
    
    public static Docente buscarDocentePorLegajo(String legajo) {
		 for (Docente d : docentes) {
			 if (d.getLegajo().equals(legajo)){
				 return d;
			 }
	     }
	     return null;
	 }
    

	 public static void agregarDocente(Docente docente) {
		 docentes.add(docente);
	 }
	 
	 
	 public static void modificarDocente(Docente docenteModificado) {
		 for (int i = 0; i < docentes.size(); i++) {
		        Docente docente = docentes.get(i);
		        if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
		            docentes.set(i, docenteModificado);
		            break;
		        }
		    }
		 
	 }
	 
	 
	 public static void eliminarDocente(String legajo) {
	     docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
	 }
}
