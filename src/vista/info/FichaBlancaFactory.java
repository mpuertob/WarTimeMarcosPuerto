package vista.info;

import javax.swing.JPanel;

import vista.FichaBlanca;

public class FichaBlancaFactory implements FichaInfo {

	@Override
	public JPanel getPanel() {
		return new FichaBlanca();
	}

}