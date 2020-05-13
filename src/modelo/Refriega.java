package modelo;

public class Refriega {
	private Soldado defensor, atacante;
	private int incrementoExperiencia = 1, incrementoDefensa = 1, incrementoArque = 1;

	public Refriega(Soldado defensor, Soldado atacante) {
		super();
		this.defensor = defensor;
		this.atacante = atacante;
	}

	public void figth() {
		// TODO
	}

	public Soldado getVencedor() {
		// TODO
		return null;
	}

	public boolean isVencedorAtacante() {
		// TODO
		return false;
	}

	public Soldado getDefensor() {
		return defensor;
	}

	public Soldado getAtacante() {
		return atacante;
	}
}
