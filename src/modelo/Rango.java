package modelo;

public class Rango {
	private int minimo, maximo;

	public Rango(int minimo, int maximo) {
		super();
		assert maximo>=minimo && minimo>0: "rango incorrecto";
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public int getMaximo() {
		return maximo;
	}

}
