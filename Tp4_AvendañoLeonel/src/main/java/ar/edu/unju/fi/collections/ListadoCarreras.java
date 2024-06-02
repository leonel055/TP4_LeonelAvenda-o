package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	
	public static List<Carrera> carreras = new ArrayList<Carrera>();
		
		//LISTA CARRERAS
		public static List<Carrera> ListarCarreras(){
			return carreras;
		}
		
		//BUSCA CARRERA POR ID
		public static Carrera buscarCarreraPorCodigo(String codigo) {
			for (Carrera c: carreras) {
				if(c.getCodigo().equals(codigo)) {
					return c;
				}
			}
			return null;
		}
		
		//AGREGAR CARRERA
		public static void agregarCarrera(Carrera c) {
			carreras.add(c);
		}
		
		//MODIFICAR CARRERA
		public static void modificarCarrera(Carrera carreraModificada) {
			for(int i=0 ; i<carreras.size() ; i++) {
				Carrera carrera = carreras.get(i);
				if(carrera.getCodigo().equals(carreraModificada.getCodigo()));{
					carreras.set(i, carreraModificada);
				}
				
			}
			
		}
		
		//ELIMINAR CARRERA	
		public static void eliminarCarrera(String codigo) {
			carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
		}		
		
		
		
}
