package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
    private String nombre;
    private String curso;
    private int cantHoras;
    private String modalidad;
    private String docente;
    private String carrera;
    
    

	public Materia(String codigo, String nombre, String curso, int cantHoras, String modalidad, String docente,
			String carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCurso() {
		return curso;
	}



	public void setCurso(String curso) {
		this.curso = curso;
	}



	public int getCantHoras() {
		return cantHoras;
	}



	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}



	public String getModalidad() {
		return modalidad;
	}



	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}



	public String getDocente() {
		return docente;
	}



	public void setDocente(String docente) {
		this.docente = docente;
	}



	public String getCarrera() {
		return carrera;
	}



	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}



	public Materia() {

	}
		
    
}
