package control;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;
import utiles.Utiles;
import vista.MercadoSoldadoDialog;
import vista.UI;
import vista.Conversores.Generador;

public class ParaUI extends UI {

	private Controller control;
	private boolean colocar = false;
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			if (colocar) {

				Coordenada coordenada = Utiles.getCoordenada(panel.getName());
				if (!control.localizar(coordenada)) {
					System.out.println("algo va mal");
				} else {
					colocar = false;
					getBordeArmada()
							.update(Generador.getEjercitoInfo(getEjercitos().get(getJuego().getIdEjercitoActual())));
					getTableroUI().actualizarTablero(Generador.getTableroUIInfo(getJuego()));
					getBtnPoblar().setEnabled(true);
					getBtnLocate().setEnabled(false);
				}

			}
		}
	};

	public ParaUI() {
		super();
		Dimension dimension = new Dimension(6, 12);
		Juego juego = new Juego(dimension);
		control = new Controller(juego);
		getTableroUI().setMouseAdapter(mouseAdapter);
		getTableroUI().actualizarTablero(Generador.getTableroUIInfo(juego));
		
		getBordeArmada().cargarEjercito(Generador.getEjercitoInfo(juego.getEjercitos().get(juego.getIdEjercitoActual())));
		getBtnPoblar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mercadoSoldado = new MercadoSoldadoDialog(
						Generador.getMercadoSoldadoInfo(getBatallonActual()));
				mercadoSoldado.setVisible(true);
				mercadoSoldado.getBtnOk().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (mercadoSoldado.compruebaMax()) {
							control.poblarBatallon(mercadoSoldado.getListaEjercito());
							getBtnPoblar().setEnabled(false);
							getBtnLocate().setEnabled(true);
							mercadoSoldado.dispose();
						}
					}
				});
			}
		});
			getBtnLocate().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					colocar=true;
				}
			});
	}

	public Juego getJuego() {
		return control.getJuego();
	}

	public LinkedList<Ejercito> getEjercitos() {
		return control.getEjercitos();
	}
	public Batallon getBatallonActual() {
		Juego juego = control.getJuego();
		return juego.getEjercitos().get(juego.getIdEjercitoActual()).getBatallonActual();
	}
}
