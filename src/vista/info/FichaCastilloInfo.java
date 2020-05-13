package vista.info;

import javax.swing.JPanel;

import vista.FichaCastillo;

public class FichaCastilloInfo implements Info {
	private int idEjercito;

	public FichaCastilloInfo(int idEjercito) {
		super();
		this.idEjercito = idEjercito;
	}

	public int getIdEjercito() {
		return idEjercito;
	}

}
