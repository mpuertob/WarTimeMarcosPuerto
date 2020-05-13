package vista.info;

import javax.swing.JPanel;

import vista.FichaBatallon;

public class FichaBatallonFactory implements FichaInfo {
	private FichaBatallonInfo fichaBatallonInfo;

	public FichaBatallonFactory(FichaBatallonInfo fichaBatallonInfo) {
		super();
		this.fichaBatallonInfo = fichaBatallonInfo;
	}

	@Override
	public JPanel getPanel() {
		return new FichaBatallon(this.fichaBatallonInfo);
	}

}
