package modelo;

public enum Tipo {

	infanteria(new Rango(1, 1), new Rango(1, 1), "/Imagenes/infanteria.png"),
	arqueria(new Rango(1, 1), new Rango(2, 2), "/Imagenes/arqueria.png"),
	caballeria(new Rango(1, 2), new Rango(1, 2), "/Imagenes/caballeria.png");

	private Rango movilidad, ataque;
	private String ruta;

	private Tipo(Rango movilidad, Rango ataque, String ruta) {
		this.movilidad = movilidad;
		this.ataque = ataque;
		this.ruta = ruta;
	}

	public Rango getMovilidad() {
		return movilidad;
	}

	public Rango getAtaque() {
		return ataque;
	}

	public String getRuta() {
		return ruta;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
