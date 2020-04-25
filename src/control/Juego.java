package control;

import java.awt.Color;
import java.util.LinkedList;

import modelo.Batallon;
import modelo.DimensionesTablero;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Soldado;
import modelo.Tablero;
import modelo.Tipo;

public class Juego {
	private Tablero tablero;
	private LinkedList<Batallon> batallonesJugadorUno = new LinkedList<Batallon>();
	private LinkedList<Batallon> batallonesJugadorDos = new LinkedList<Batallon>();
	private DimensionesTablero dimension = new DimensionesTablero(6, 12);
	private Ejercito ejercitoUno = new Ejercito(0);
	private Ejercito ejercitoDos = new Ejercito(1);

	public Juego() {
		super();
		this.tablero = new Tablero(this.dimension);
		rellenarBatallonesJugadorUno();
		ejercitoUno.setGroup(batallonesJugadorUno);
		rellenarBatallonesJugadorDos();
		ejercitoDos.setGroup(batallonesJugadorDos);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void rellenarBatallonesJugadorUno() {
		int tamanoSoldados = 10;
		int mitad = tamanoSoldados / 2;
		Color color = Color.green;
		int idBatallon = 0;
		// Batallon Infanteria
		LinkedList<Soldado> soldadosBatallonInfanteria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.espada));
			} else {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.lanza));
			}
		}
		Batallon batallonUno = new Batallon(idBatallon, Tipo.infanteria, soldadosBatallonInfanteria, color);
		idBatallon += 1;
		// Batallon Arqueria
		LinkedList<Soldado> soldadosBatallonArqueria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.arco));
			} else {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.ballesta));
			}
		}
		Batallon batallonDos = new Batallon(idBatallon, Tipo.arqueria, soldadosBatallonArqueria, color);
		idBatallon += 1;
		// Batallon Caballeria
		LinkedList<Soldado> soldadosBatallonCaballeria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.ligera));
			} else {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.pesada));
			}
		}
		Batallon batallonTres = new Batallon(idBatallon, Tipo.caballeria, soldadosBatallonCaballeria, color);
		this.batallonesJugadorUno.add(batallonUno);
		this.batallonesJugadorUno.add(batallonDos);
		this.batallonesJugadorUno.add(batallonTres);
	}

	public void rellenarBatallonesJugadorDos() {
		int tamanoSoldados = 10;
		int mitad = tamanoSoldados / 2;
		Color color = Color.RED;
		int idBatallon = 0;
		// Batallon Infanteria
		LinkedList<Soldado> soldadosBatallonInfanteria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.espada));
			} else {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.lanza));
			}
		}
		Batallon batallonUno = new Batallon(idBatallon, Tipo.infanteria, soldadosBatallonInfanteria, color);
		idBatallon += 1;
		// Batallon Arqueria
		LinkedList<Soldado> soldadosBatallonArqueria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.arco));
			} else {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.ballesta));
			}
		}
		Batallon batallonDos = new Batallon(idBatallon, Tipo.arqueria, soldadosBatallonArqueria, color);
		idBatallon += 1;
		// Batallon Caballeria
		LinkedList<Soldado> soldadosBatallonCaballeria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.ligera));
			} else {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.pesada));
			}
		}
		Batallon batallonTres = new Batallon(idBatallon, Tipo.caballeria, soldadosBatallonCaballeria, color);
		this.batallonesJugadorDos.add(batallonUno);
		this.batallonesJugadorDos.add(batallonDos);
		this.batallonesJugadorDos.add(batallonTres);
	}

	public Ejercito getEjercitoUno() {
		return ejercitoUno;
	}

	public Ejercito getEjercitoDos() {
		return ejercitoDos;
	}
	
}
