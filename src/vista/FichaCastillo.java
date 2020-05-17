package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import java.awt.Font;

public class FichaCastillo extends JPanel{
	public FichaCastillo(int idEjercito) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCastlloEjercito = new JLabel("Castillo Ejercito");
		lblCastlloEjercito.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCastlloEjercito.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCastlloEjercito, BorderLayout.CENTER);
		
		JLabel lblIdEjercito = new JLabel(String.valueOf(idEjercito));
		lblIdEjercito.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(lblIdEjercito, BorderLayout.EAST);
	}
}
