package ar.edu.unju.fi.model;

public class Carrera {
	private String codigo;
    private String nombre;
    private int cantAnios;
    private Boolean estado;
    
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
	public int getCant_anios() {
		return cantAnios;
	}
	public void setCant_anios(int cant_anios) {
		this.cantAnios = cant_anios;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Carrera(String codigo, String nombre, int cant_anios, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAnios = cant_anios;
		this.estado = estado;
	}
	public Carrera() {
		// TODO Auto-generated constructor stub
	}
    
}
