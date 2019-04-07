package utn.tacs.grupo3.model;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private int cantidadDeListas;
	private int cantidadDeLugaresVisitados;
	private String ultimoAcceso;

	public Usuario(String nombre, String apellido, int cantidadDeListas, int cantidadDeLugaresVisitados, String ultimoAcceso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantidadDeListas = cantidadDeListas;
		this.cantidadDeLugaresVisitados = cantidadDeLugaresVisitados;
		this.ultimoAcceso = ultimoAcceso;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



}
