package pruebasui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import control.Controller;
import control.Juego;
import modelo.Coordenada;
import modelo.Dimension;
import utiles.Utiles;
import vista.Conversores.Generador;

public class ParaUIPruebaTablero extends TableroUIPrueba {

	private Controller controller;
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
			Coordenada coordenada = Utiles.getCoordenada(panel.getName());
			if(!controller.localizar(coordenada)) {
				System.out.println("algo va mal");
			}
			getTableroUI().actualizarTablero(Generador.getTableroUIInfo(controller.getJuego()));
		}
	};

	public ParaUIPruebaTablero() {
		super();
		getTableroUI().setMouseAdapter(mouseAdapter);
		Dimension dimension = new Dimension(6,12);
		Juego juego=new Juego(dimension);
		controller=new Controller(juego);
		getTableroUI().actualizarTablero(Generador.getTableroUIInfo(juego));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaUIPruebaTablero frame = new ParaUIPruebaTablero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
