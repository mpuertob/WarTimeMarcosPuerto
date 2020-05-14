package modelo;

public enum Tipo {
	infanteria(1,"/Imagenes/infanteria.png"), caballeria(2,"/Imagenes/caballeria.png"), arqueria(1,"/Imagenes/arqueria.png");
	private int numeroCasillas;
	private String ruta;
	private Tipo(int numeroCasillas,String ruta) {
		this.numeroCasillas = numeroCasillas;
		this.ruta=ruta;
	}

	public int getNumeroCasillas() {
		return numeroCasillas;
	}
	public String getRuta() {
		return ruta;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
