package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.Casilla;
import modelo.Coordenada;
import utiles.Utiles;
import vista.Advertencia;
import vista.MercadoSoldadoDialog;
import vista.UserInterface;
import vista.Conversores.Generador;
import vista.info.TableroUIInfo;

public class ParaUI extends UserInterface {
	private ComenzarController comenzarController;
	private ConsumirTurnoController consumirTurnoController;
	private int ancho = 12, alto = 6;

	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			Coordenada coordenada = Utiles.getCoordenada(panel.getName());
			if (!comenzarController.localizar(coordenada)) {
				// new Advertencia(comenzarController.getError());
			}
			getTableroUI().actualizarTablero(getTableroUIInfo(comenzarController.getJuego()));
			if (comenzarController.isLocalizarEstado()) {
				getBordeArmada().getBtnPoblar().setEnabled(true);
				getBordeArmada().update(Generador.getEjercitoInfo(comenzarController.getEjercitoActual()));
			} else {

				Casilla casilla = comenzarController.getTablero().getCasilla(Utiles.getCoordenada(panel.getName()));
				if (casilla != null) {
					consumirTurnoController.setPanel(panel);
				} else {
					JPanel panelGuardado = consumirTurnoController.getPanel();
					Coordenada coordenadaOrigen = Utiles.getCoordenada(panelGuardado.getName());
					Coordenada coordenadaDestino = Utiles.getCoordenada(panel.getName());
					consumirTurnoController.moverBatallon(coordenadaOrigen, coordenadaDestino);
					getTableroUI().actualizarTablero(getTableroUIInfo(consumirTurnoController.getJuego()));
				}
				getBordeArmada().setVisible(false);
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
