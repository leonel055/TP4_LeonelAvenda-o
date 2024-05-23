package ar.edu.unju.fi.model;

public class Carrera {
	private String codigo;
    private String nombre;
    private int cant_anios;
    private String estado;
    
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
		return cant_anios;
	}
	public void setCant_anios(int cant_anios) {
		this.cant_anios = cant_anios;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Carrera(String codigo, String nombre, int cant_anios, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cant_anios = cant_anios;
		this.estado = estado;
	}
    
}
