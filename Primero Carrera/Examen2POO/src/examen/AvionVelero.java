package examen;

public class AvionVelero extends Avion{
	
	private double autonomia;
	
	public AvionVelero(String avionId, int numPasajeros, double autonomia) {
		super(avionId, numPasajeros);
		this.autonomia = autonomia;
	}

	public boolean tieneMotor() {
		return false;
	}
	
	public double calcularAutonomia() {
		return this.autonomia;
	}
}