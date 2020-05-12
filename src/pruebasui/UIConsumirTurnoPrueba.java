package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ComenzarController;
import control.Juego;
import vista.TableroUI;
import vista.info.TableroUIInfo;

public class UIConsumirTurnoPrueba extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;

	/**
	 * Create the frame.
	 */
	public UIConsumirTurnoPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	public void crearTablero(Juego juego) {
		TableroUIInfo tableroUIInfo=new TableroUIInfo(juego);
		tableroUI = new TableroUI(juego.getAncho(), juego.getAlto());
		contentPane.add(tableroUI, BorderLayout.CENTER);
	}
	public TableroUI getTableroUI() {
		return tableroUI;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaUIConsumirTurnoPrueba frame = new ParaUIConsumirTurnoPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
