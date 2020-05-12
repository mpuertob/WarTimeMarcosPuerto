package modelo;

public enum Tipo {
	infanteria(1), caballeria(2), arqueria(1);
	private int numeroCasillas;

	private Tipo(int numeroCasillas) {
		this.numeroCasillas = numeroCasillas;
	}

	public int getNumeroCasillas() {
		return numeroCasillas;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
