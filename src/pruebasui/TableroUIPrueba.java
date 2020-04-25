package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Juego;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Tablero;
import vista.TableroUI;
import vista.info.TableroUIInfo;

public class TableroUIPrueba extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private Juego juego = new Juego();
	private TableroUIInfo tableroUIInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroUIPrueba frame = new TableroUIPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableroUIPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JPanel panel = (JPanel) e.getSource();
				Coordenada coordenada = obtenerCoordenadaActual(panel.getName());
				if (obtenerListaBatallonUno().size() > 0) {
					Batallon batallon = obtenerListaBatallonUno().get(0);
					getTablero().insertar(batallon, coordenada);
					obtenerListaBatallonUno().remove(0);
				} else if (obtenerListaBatallonDos().size() > 0) {
					Batallon batallon = obtenerListaBatallonDos().get(0);
					getTablero().insertar(batallon, coordenada);
					obtenerListaBatallonDos().remove(0);
				}
				tableroUI.actualizarTablero(tableroUIInfo);
			}

			private LinkedList<Batallon> obtenerListaBatallonUno() {
				return juego.getEjercitoUno().getGroup();
			}

			private LinkedList<Batallon> obtenerListaBatallonDos() {
				return juego.getEjercitoDos().getGroup();
			}

			private Coordenada obtenerCoordenadaActual(String name) {
				int posicion = name.indexOf("-");
				int x = Integer.parseInt(name.substring(0, posicion));
				int y = Integer.parseInt(name.substring(posicion + 1, name.length()));
				Coordenada coordenada = new Coordenada(x, y);
				return coordenada;
			}
		};

		tableroUIInfo = new TableroUIInfo(juego.getTablero());
		tableroUI = new TableroUI(6, 12, mouseAdapter, tableroUIInfo);
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	public Tablero getTablero() {
		return juego.getTablero();
	}

}
