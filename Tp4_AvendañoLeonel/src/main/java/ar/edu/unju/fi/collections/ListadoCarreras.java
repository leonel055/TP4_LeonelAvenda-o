package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	
	public static List<Carrera> carreras = new ArrayList<Carrera>();
		
		//LISTA CARRERAS
		public static List<Carrera> ListarCarreras(){
			Predicate<Carrera> activo = n -> n.getEstado();
			List<Carrera> carrerasActivas = carreras.stream().filter(activo).collect(Collectors.toList());

			return carrerasActivas;
		}
		
		//BUSCA CARRERA POR ID
		public static Carrera buscarCarreraPorCodigo(String codigo) {
			for (Carrera c: carreras) {
				if(c.getCodigo().equals(codigo))  {
					return c;
				}	
			}	
			return null;
		}
		
		//AGREGAR CARRERA
		public static void agregarCarrera(Carrera c) {
			c.setEstado(true);
			carreras.add(c);
		}
		
		//MODIFICAR CARRERA
		public static void modificarCarrera(Carrera carreraModificada) {

			carreraModificada.setEstado(true);

			for (int i=0 ; i<carreras.size() ; i++) {
		        Carrera carrera = carreras.get(i);
		        if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
		            carreras.set(i, carreraModificada);
		            break;
		        }
		    }
		}
		
		//ELIMINAR CARRERA	
		public static void eliminarCarrera(String codigo) {
			  for (int i = 0; i < carreras.size(); i++) {
			      Carrera carrera = carreras.get(i);
			      if (carrera.getCodigo().equals(codigo)) {
			        carrera.setEstado(false);;
			        break;
			      }
			    }
		}		
		
		
		
}
