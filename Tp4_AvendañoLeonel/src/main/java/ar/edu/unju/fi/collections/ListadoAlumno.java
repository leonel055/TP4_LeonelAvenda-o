package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumno {
	
	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	
    public static List<Alumno> listarAlumnos(){
    	Predicate<Alumno> activo = n -> n.getDni()!="-1";
		List<Alumno> alumnosActivos = alumnos.stream().filter(activo).collect(Collectors.toList());

		return alumnosActivos;
	}
    
    
    public static Alumno buscarAlumnoPorDNI(String dni) {
		 for (Alumno a : alumnos) {
			 if (a.getDni().equals(dni)) {
				 return a;
			 }
	     }
	     return null;
	 }
    
	 public static void agregarAlumno(Alumno alumno) {
		 alumnos.add(alumno);
	 }
	 
	 
	 public static void modificarAlumno(Alumno alumnoModificado) {
		 for (int i = 0; i < alumnos.size() ; i++) {
		        Alumno alumno = alumnos.get(i);
		        if (alumno.getDni().equals(alumnoModificado.getDni())) {
		            alumnos.set(i, alumnoModificado);
		            break;
		        }
		    }
	 }
	 
	 
	 public static void eliminarAlumno(String dni) {
	    alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
	 }
}
