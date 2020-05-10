package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ParaUI;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Tablero;
import modelo.Tipo;
import vista.info.TableroUIInfo;

public class UI extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private BordeArmada bordeArmada;
	protected MercadoSoldadoDialog mercadoSoldado;
	private Dimension dimension = new Dimension(6, 12);
	private Tablero tablero = new Tablero(dimension);
	private TableroUIInfo tableroUIInfo;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tableroUI = new TableroUI(6,12);
		contentPane.add(tableroUI);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		bordeArmada = new BordeArmada();
		contentPane.add(bordeArmada, BorderLayout.WEST);
	}

	public BordeArmada getBordeArmada() {
		return bordeArmada;
	}

	public TableroUI getTableroUI() {
		return tableroUI;
	}

	public JButton getBtnPoblar() {
		return bordeArmada.getBtnPoblar();
	}

	public JButton getBtnLocate() {
		return bordeArmada.getBtnLocate();
	}

}
