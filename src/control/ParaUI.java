package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vista.Advertencia;
import vista.FichaBatallon;
import vista.MercadoSoldadoDialog;
import vista.UserInterface;
import vista.Conversores.Generador;
import vista.info.TableroUIInfo;

public class ParaUI extends UserInterface {
	private ComenzarController comenzarController;
	private ConsumirTurnoController consumirTurnoController;
	boolean sePuedeMover = false;
	private int ancho = 12, alto = 6;

	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			Coordenada coordenada = Utiles.getCoordenada(panel.getName());
			if (sePuedeMover) {
				moverBatallones(panel);
			}
			if (!comenzarController.localizar(coordenada)) {
				// new Advertencia(comenzarController.getError());
			}
			getTableroUI().actualizarTablero(getTableroUIInfo(comenzarController.getJuego()));
			if (comenzarController.isLocalizarEstado()) {
				getBordeArmada().getBtnPoblar().setEnabled(true);
				getBordeArmada().update(Generador.getEjercitoInfo(comenzarController.getEjercitoActual()));
			} else {
				getBordeArmada().setVisible(false);
				sePuedeMover = true;
			}

		}

		private void moverBatallones(JPanel panel) {
			Casilla casilla = comenzarController.getTablero().getCasilla(Utiles.getCoordenada(panel.getName()));
			JPanel panelGuardado = consumirTurnoController.getPanel();
			boolean isVacio = panelGuardado == null;
			if ((casilla != null) && isVacio) {
				consumirTurnoController.setPanel(panel);
			} else if (!isVacio) {
				Coordenada coordenadaOrigen = Utiles.getCoordenada(panelGuardado.getName());
				Coordenada coordenadaDestino = Utiles.getCoordenada(panel.getName());
				consumirTurnoController.moverBatallon(coordenadaOrigen, coordenadaDestino);
				getTableroUI().actualizarTablero(getTableroUIInfo(consumirTurnoController.getJuego()));
			}
		}
	};

	public ParaUI() {
		super();
		comenzarController = new ComenzarController(ancho, alto);
		Juego juego = comenzarController.getJuego();
		consumirTurnoController = new ConsumirTurnoController(juego);
		crearTablero(comenzarController);
		getTableroUI().setMouseAdapter(mouseAdapter);
		getTableroUI().actualizarTablero(getTableroUIInfo(comenzarController.getJuego()));
		getBordeArmada().cargarEjercito(Generador.getEjercitoInfo(comenzarController.getEjercitoActual()));
		getBtnPoblar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MercadoSoldadoDialog mercadoSoldado = new MercadoSoldadoDialog(
						Generador.getMercadoSoldadoInfo(comenzarController.getBatallonActual()));
				mercadoSoldado.setVisible(true);
				mercadoSoldado.getBtnOk().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (mercadoSoldado.compruebaMax()) {
							comenzarController.poblarBatallon(mercadoSoldado.getListaEspecificacion());
							getBordeArmada().getBtnPoblar().setEnabled(false);
						}
						mercadoSoldado.dispose();
					}
				});
			}
		});
	}

	public TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego);
	}
}
