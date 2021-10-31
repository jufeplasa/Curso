package model;

public class Estudiante {

	private String codigo;
	private String nombre;
	
	private Estudiante siguiente;
	private Estudiante anterior;
	

	public Estudiante(String n, String c) {
		codigo=c;
		nombre=n;
	}
	
	public Estudiante getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Estudiante siguiente) {
		this.siguiente = siguiente;
	}

	public Estudiante getAnterior() {
		return anterior;
	}

	public void setAnterior(Estudiante anterior) {
		this.anterior = anterior;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "El estudiante "+nombre+" de codigo "+codigo+"\n";
	}
	
}	
