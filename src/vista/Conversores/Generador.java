package vista.Conversores;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import control.Juego;
import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Tablero;
import modelo.Tipo;
import vista.EspecialidadSoldado;
import vista.Ficha;
import vista.FichaBlanca;
import vista.info.EjercitoInfo;
import vista.info.EspecialidadSoldadoInfo;
import vista.info.FichaInfo;
import vista.info.MercadoSoldadoInfo;
import vista.info.TableroUIInfo;

public class Generador {

	public static ArrayList<EspecialidadSoldado> getEspecialidades(Tipo tipo, FocusAdapter focusAdapter) {
		ArrayList<EspecialidadSoldado> panelesEspecialidadSoldadosEnsayos = new ArrayList<EspecialidadSoldado>();
		for (Especialidad especialidad : Arrays.asList(Especialidad.values())) {
			if (especialidad.getTipo() == tipo) {
				panelesEspecialidadSoldadosEnsayos
						.add(new EspecialidadSoldado(new EspecialidadSoldadoInfo(especialidad), focusAdapter));
			}
		}
		return panelesEspecialidadSoldadosEnsayos;
	}

	public static MercadoSoldadoInfo getMercadoSoldadoInfo(Batallon batallon) {
		return new MercadoSoldadoInfo(batallon);
		}

	public static EjercitoInfo getEjercitoInfo(Ejercito ejercito) {
		return new EjercitoInfo(ejercito.getId(), ejercito.getIdBatallonActual(), ejercito.getTipoBatallon(),
				ejercito.getInfanteria(), ejercito.getCaballeria(), ejercito.getArqueria());
	}

	public static FichaInfo getFichaInfo(Tablero tablero, Coordenada coordenada) {
		Casilla casilla = tablero.getCasilla(coordenada);
		FichaInfo fichaInfo = null;
		if (casilla != null) {
			Batallon batallon = (Batallon) casilla;
			// datos necesarios para crear el fichaInfo
			String rutaImagen = batallon.getSoldados().get(0).getEspecialidad().getRutaImagen();
			int army = -1;
			int idBatallon = batallon.getAtaqueTotal();
			int experiencia = batallon.getExperienciaTotal();
			int ataque = batallon.getAtaqueTotal();
			int defensa = batallon.getDefensaTotal();
			int stamina = batallon.getStaminaTotal();
			int unidades = batallon.getMaximoSoldados();
			boolean heroe = false;
			Color colorEnemigo = batallon.getColorAtacante();
			Color colorArmy = batallon.getColorArmy();

			fichaInfo = new FichaInfo(rutaImagen, army, idBatallon, experiencia, ataque, defensa, stamina, unidades,
					heroe, colorEnemigo,colorArmy);
		}
		return fichaInfo;
	}

	public static TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego.getTablero());
		}
}
