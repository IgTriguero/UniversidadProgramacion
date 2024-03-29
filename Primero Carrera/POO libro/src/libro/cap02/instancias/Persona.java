package libro.cap02.instancias;

import libro.cap02.fechas.Fecha;

public class Persona {
	private String nombre;
	private String dni;
	private Fecha fechaNacimiento;
	
	private int cont = 0;
	
	public Persona(String nombre, String dni, Fecha fecNac) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fecNac;
	}
	public String toString() {
		cont++;
		return nombre + ", DNI: " + dni + ", nacido el: " + fechaNacimiento + " (" + cont + ")";
	}
}