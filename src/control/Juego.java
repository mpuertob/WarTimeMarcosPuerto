package control;

import java.awt.Color;
import java.util.LinkedList;

import modelo.Batallon;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Soldado;
import modelo.Tablero;
import modelo.Tipo;

public class Juego {
	private Tablero tablero;
	private LinkedList<Batallon> batallonesJugadorUno = new LinkedList<Batallon>();
	private LinkedList<Batallon> batallonesJugadorDos = new LinkedList<Batallon>();
	private Dimension dimension = new Dimension(6, 12);
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
		Color colorArmy = Color.GREEN;
		Color colorEnemigo = Color.RED;
		int idBatallon = 0;
		int numeroTiposBatallones = 2;
		// Batallon Infanteria
		LinkedList<Soldado> soldadosBatallonInfanteria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.espada));
			} else {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.lanza));
			}
		}
		for (int i = 0; i < numeroTiposBatallones; i++) {
			Batallon batallonUno = new Batallon(idBatallon, Tipo.infanteria, soldadosBatallonInfanteria, colorEnemigo,
					colorArmy);
			this.batallonesJugadorUno.add(batallonUno);
			idBatallon += 1;
		}
		// Batallon Arqueria
		LinkedList<Soldado> soldadosBatallonArqueria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.arco));
			} else {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.ballesta));
			}
		}
		for (int i = 0; i < numeroTiposBatallones; i++) {
			Batallon batallonDos = new Batallon(idBatallon, Tipo.arqueria, soldadosBatallonArqueria, colorEnemigo,
					colorArmy);
			this.batallonesJugadorUno.add(batallonDos);
			idBatallon += 1;
		}
		// Batallon Caballeria
		LinkedList<Soldado> soldadosBatallonCaballeria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.ligera));
			} else {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.pesada));
			}
		}
		for (int i = 0; i < numeroTiposBatallones; i++) {
			Batallon batallonTres = new Batallon(idBatallon, Tipo.caballeria, soldadosBatallonCaballeria, colorEnemigo,
					colorArmy);
			this.batallonesJugadorUno.add(batallonTres);
			idBatallon += 1;
		}
	}

	public void rellenarBatallonesJugadorDos() {
		int tamanoSoldados = 10;
		int mitad = tamanoSoldados / 2;
		Color colorArmy = Color.RED;
		Color colorEnemigo = Color.GREEN;
		int idBatallon = 0;
		int numeroTiposBatallones = 2;
		// Batallon Infanteria
		LinkedList<Soldado> soldadosBatallonInfanteria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.espada));
			} else {
				soldadosBatallonInfanteria.add(new Soldado(Especialidad.lanza));
			}
		}
		for (int i = 0; i < numeroTiposBatallones; i++) {
			Batallon batallonUno = new Batallon(idBatallon, Tipo.infanteria, soldadosBatallonInfanteria, colorEnemigo,
					colorArmy);
			this.batallonesJugadorUno.add(batallonUno);
			idBatallon += 1;
		}
		// Batallon Arqueria
		LinkedList<Soldado> soldadosBatallonArqueria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.arco));
			} else {
				soldadosBatallonArqueria.add(new Soldado(Especialidad.ballesta));
			}
		}
		for (int i = 0; i < numeroTiposBatallones; i++) {
			Batallon batallonDos = new Batallon(idBatallon, Tipo.arqueria, soldadosBatallonArqueria, colorEnemigo,
					colorArmy);
			this.batallonesJugadorUno.add(batallonDos);
			idBatallon += 1;
		}
		// Batallon Caballeria
		LinkedList<Soldado> soldadosBatallonCaballeria = new LinkedList<Soldado>();
		for (int i = 0; i < tamanoSoldados; i++) {
			if (i < mitad) {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.ligera));
			} else {
				soldadosBatallonCaballeria.add(new Soldado(Especialidad.pesada));
			}
		}
		for (int i = 0; i < numeroTiposBatallones; i++) {
			Batallon batallonTres = new Batallon(idBatallon, Tipo.caballeria, soldadosBatallonCaballeria, colorEnemigo,
					colorArmy);
			this.batallonesJugadorUno.add(batallonTres);
			idBatallon += 1;
		}
	}

	public Ejercito getEjercitoUno() {
		return ejercitoUno;
	}

	public Ejercito getEjercitoDos() {
		return ejercitoDos;
	}

}
