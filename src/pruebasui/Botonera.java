package pruebasui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botonera extends JPanel{
	private int filas = 6, columnas = 11;
	private JButton botonera[][];

	public Botonera() {
		crearBotonera();
	}

	private void crearBotonera() {
		this.botonera = new JButton[filas][columnas];
		int x = 0;
		int y = 0;
		int ladoBoton = 60;
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera[i].length; j++) {
				botonera[i][j] = new JButton();
				botonera[i][j].setName(String.valueOf(i) + String.valueOf(j));
				botonera[i][j].setBounds(x, y, 60, 60);
				this.add(botonera[i][j]);
				x += ladoBoton;
			}
			x = 0;
			y += ladoBoton;
		}
	}

}
