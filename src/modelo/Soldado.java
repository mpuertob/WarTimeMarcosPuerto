package modelo;

public class Soldado {
	private Especialidad especialidad;
	private int stamina = 100;
	private int ataque = 1;
	private int defensa = 1;
	private int experiencia = 1;

	public Soldado(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public int getStamina() {
		return stamina;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getExperiencia() {
		return experiencia;
	}

}