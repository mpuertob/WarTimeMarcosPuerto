package modelo;

import java.awt.Color;
import java.util.LinkedList;

import vista.info.BatallonFichaFactory;
import vista.info.FichaFactory;

public class Batallon implements Casilla {
	private int id;
	private final int maximoSoldados = 10;
	private Tipo tipo;
	private LinkedList<Soldado> soldados = new LinkedList<Soldado>();
	private Color colorAtacante = Color.RED;
	private Color colorArmy = Color.GREEN;

	public Batallon(int id, Tipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public Batallon(int id, Tipo tipo, LinkedList<Soldado> soldados) {
		this(id, tipo);
		this.soldados = soldados;
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
		assert soldado.getEspecialidad().getTipo().equals(tipo) : "epecialidad no compatible";
		return soldados.add(soldado);
	}

	public LinkedList<Soldado> getSoldados() {
		return soldados;
	}

	public Color getColorAtacante() {
		return colorAtacante;
	}

	public Color getColorArmy() {
		return colorArmy;
	}

	public void setColorAtacante(Color colorAtacante) {
		this.colorAtacante = colorAtacante;
	}

	public int getStaminaTotal() {
		int staminaTotal = 0;
		for (Soldado soldado : soldados) {
			staminaTotal += soldado.getStamina();
		}
		return staminaTotal;
	}

	public int getExperienciaTotal() {
		int experienciaTotal = 0;
		for (Soldado soldado : soldados) {
			experienciaTotal += soldado.getExperiencia();
		}
		return experienciaTotal;
	}

	public int getAtaqueTotal() {
		int ataqueTotal = 0;
		for (Soldado soldado : soldados) {
			ataqueTotal += soldado.getAtaque();
		}
		return ataqueTotal;
	}

	public int getDefensaTotal() {
		int defensaTotal = 0;
		for (Soldado soldado : soldados) {
			defensaTotal += soldado.getDefensa();
		}
		return defensaTotal;
	}

	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		return new BatallonFichaFactory(getId(), getCantidadSoldados(), ejercito);
	}

	public Soldado getSoldado() {
		return soldados.pop();
	}
	// si curamos soldados, los que tengan stamina critica pero mayor que cero
//	public Soldado getSoldado() {
//		Soldado pop = soldados.pop();
//		//usar la cola de soldados como una lista y preguntar (recorrer) si hay algun
//		//elemento no critico
//		while(pop.isCriticaStamina()) {
//			soldados.offer(pop);
//			pop=soldados.pop();
//		}
//		return pop;
//	}

	public void tratarSoldado(Soldado soldado) {
		// TODO Auto-generated method stub
		// nivel de stamina? critico o no
		if (!soldado.isCriticaStamina()) {
			soldados.offer(soldado);
		}
	}

	public boolean haySoldados() {
		return !soldados.isEmpty();
	}

	/*@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		String rutaImagen = ejercito.getIcon();
		int army = -1;
		int idBatallon = this.getAtaqueTotal();
		int experiencia = this.getExperienciaTotal();
		int ataque = this.getAtaqueTotal();
		int defensa = this.getDefensaTotal();
		int stamina = this.getStaminaTotal();
		int unidades = this.getMaximoSoldados();
		boolean heroe = false;
		Color colorEnemigo = this.getColorAtacante();
		Color colorArmy = this.getColorArmy();
		return new FichaBatallonFactory(new FichaBatallonInfo(rutaImagen, army, idBatallon, experiencia, ataque,
				defensa, stamina, unidades, heroe, colorEnemigo, colorArmy));
	}*/
}
