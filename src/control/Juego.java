package control;

import java.util.ArrayDeque;
import java.util.LinkedList;

import modelo.Batallon;
import modelo.Blanca;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Error;
import modelo.Soldado;
import modelo.Tablero;

public class Juego {
	private Tablero tablero;
	private Dimension dimension;
	private ArrayDeque<Ejercito> ejercitos = new ArrayDeque<Ejercito>();
	private boolean localizarEstado = true;
	private Ejercito primerEjercito;
	private Error errorActualError = null;
	private int turno;

	public int getTurno() {
		return turno;
	}

	public boolean isLocalizarEstado() {
		return localizarEstado;
	}

	public Juego(Dimension dimension) {
		super();
		this.dimension = dimension;
		this.tablero = new Tablero(dimension);
		this.ejercitos.add(new Ejercito(0));
		this.ejercitos.add(new Ejercito(1));
		Ejercito ejercitoCero = new Ejercito(0);
		this.tablero.insertar(new Castillo(ejercitoCero), new Coordenada(3, 1));
		this.ejercitos.offer(ejercitoCero);
		Ejercito ejercitoUno = new Ejercito(1);
		this.tablero.insertar(new Castillo(ejercitoUno), new Coordenada(3, getAncho()-2));
		this.ejercitos.offer(ejercitoUno);
		this.primerEjercito = ejercitos.peek();
		turno=primerEjercito.getId();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean localizarBatallon(Coordenada coordenada) {
		boolean insertar = comprobarLocalizacion(coordenada);
		if (!insertar) {
			errorActualError = Error.posicion;
		} else if (localizarEstado) {
			Ejercito ejercito = ejercitos.peek();
			Batallon batallonActual = ejercito.getBatallonActual();
			insertar = tablero.insertar(batallonActual, coordenada);
			if (insertar) {
				if (!ejercito.setSiguienteBatallon()) {
					setSiguienteEjercito();
				}
			} else {
				errorActualError = Error.ocupada;
			}
		}
		return insertar && localizarEstado;
	}

	public Error getErrorActual() {
		Error response = errorActualError;
		errorActualError = Error.noerror;
		return response;
	}

	private boolean comprobarLocalizacion(Coordenada coordenada) {
		return getTablero().isEnSuMitad(getEjercitoActual(), coordenada);
	}

	private void setSiguienteEjercito() {
		ejercitos.offer(ejercitos.poll());
		this.turno=ejercitos.peek().getId();
		if (ejercitos.peek().equals(primerEjercito)) {
			localizarEstado = false;
		}
	}

	public Ejercito getEjercitoActual() {
		return ejercitos.peek();
	}

	public void alistarSoldadoBatallonActual(Soldado soldado) {
		// Demeter
		getEjercitoActual().getBatallonActual().alistarSoldado(soldado);
	}
	public Batallon getBatallonActual() {
		return getEjercitoActual().getBatallonActual();
	}

	public int getAncho() {
		return this.dimension.getAncho();
	}

	public int getAlto() {
		return this.dimension.getAlto();
	}

	public Casilla getCasilla(Coordenada coordenada) {
		Casilla casilla = tablero.getCasilla(coordenada);
		if(casilla==null) {
			return new Blanca();
		}
		return casilla;
	}
	public void siguienteTurno() {
		setSiguienteEjercito();
	}
}
