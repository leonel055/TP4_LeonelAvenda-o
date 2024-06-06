package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Materia;

public class ListadoMateria {

	public static List<Materia> materias = new ArrayList<Materia>();
		
		public static List<Materia> ListarMaterias(){
			Predicate<Materia> activo = n -> n.getCodigo()!="-1";
			List<Materia> materiasActivas = materias.stream().filter(activo).collect(Collectors.toList());

			return materiasActivas;
		}
		
		public static Materia buscarMateriaPorCodigo(String codigo) {
			for(Materia m : materias) {
				if(m.getCodigo().equals(codigo)) {
				return m;	
				}
			}
			return null;
	}

		public static void agregarMateria(Materia materia) {		
			materias.add(materia);
		}


		public static void eliminarMateria(String codigo) {
			for(Materia i : materias) {
				if(i.getCodigo().equals(codigo)) {
					i.setCodigo("-1");
					break;
				}
			}
		}
		
		public static void modificarMateria(Materia m) {		
			for (int i = 0; i < materias.size(); i++) {
		        Materia materia = materias.get(i);
		        if (materia.getCodigo().equals(m.getCodigo())) {
		            materias.set(i, m);
		            break;
		        }
		    }
		}

}
