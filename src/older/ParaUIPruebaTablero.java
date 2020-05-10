package older;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import control.Juego;
import modelo.Coordenada;
import modelo.Dimension;
import utiles.Utiles;
import vista.Advertencia;
import vista.Conversores.Generador;

public class ParaUIPruebaTablero extends TableroUIPrueba {

	private LocalizadorController localizadorController;
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
			Coordenada coordenada = Utiles.getCoordenada(panel.getName());
			if(!localizadorController.localizar(coordenada)) {
				new Advertencia(localizadorController.getError());
			}
			getTableroUI().actualizarTablero(Generador.getTableroUIInfo(localizadorController.getJuego()));
		}
	};

	public ParaUIPruebaTablero() {
		super();
		getTableroUI().setMouseAdapter(mouseAdapter);
		Dimension dimension = new Dimension(6,12);
		Juego juego=new Juego(dimension);
		localizadorController=new LocalizadorController(juego);
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
