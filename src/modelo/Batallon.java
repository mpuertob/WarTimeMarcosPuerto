package modelo;

import java.awt.Color;
import java.util.LinkedList;

public class Batallon implements Casilla {
	private int id;
	private final int maximoSoldados = 10;
	private Tipo tipo;
	private LinkedList<Soldado> soldados = new LinkedList<Soldado>();
	private Color colorAtacante;
	private Color colorArmy;

	public Batallon(int id, Tipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public Batallon(int id, Tipo tipo, LinkedList<Soldado> soldados, Color colorEjercitoAtacante,Color colorArmy) {
		this(id, tipo);
		this.soldados = soldados;
		this.colorAtacante = colorEjercitoAtacante;
		this.colorArmy=colorArmy;
	}

	public int getId() {
		return id;
	}

	public int getMaximoSoldados() {
		return maximoSoldados;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getCantidadSoldados() {
		return soldados.size();
	}

	public boolean alistarSoldado(Soldado soldado) {
//		//programacion por contrato
		assert soldado.getEspecialidad().getTipo().equals(tipo) : "epecialidad no compatible";
		return soldados.add(soldado);
		// programacion defensiva
//		boolean response = false;
//		if (soldado.getEspecialidad().getTipo().equals(tipo)) {
//			response = soldados.add(soldado);
//		}
//		return response;
	}

	public int getStaminaTotal() {
		int vida = 0;
		for (Soldado soldado : soldados) {
			vida += soldado.getStamina();
		}
		return vida;
	}

	public int getAtaqueTotal() {
		int ataque = 0;
		for (Soldado soldado : soldados) {
			ataque += soldado.getAtaque();
		}
		return ataque;
	}

	public int getDefensaTotal() {
		int defensa = 0;
		for (Soldado soldado : soldados) {
			defensa += soldado.getDefensa();
		}
		return defensa;
	}

	public int getExperienciaTotal() {
		int experiencia = 0;
		for (Soldado soldado : soldados) {
			experiencia += soldado.getExperiencia();
		}
		return experiencia;
	}

	public Color getColorAtacante() {
		return colorAtacante;
	}

	public Color getColorArmy() {
		return colorArmy;
	}

}
