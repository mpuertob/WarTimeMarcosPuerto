package modelo;

import java.util.Arrays;

public enum Especialidad {

	espada(Tipo.infanteria, "/Imagenes/espada.png"), lanza(Tipo.infanteria, "/Imagenes/lanza.png"),
	arco(Tipo.arqueria, "/Imagenes/arco.png"), ballesta(Tipo.arqueria, "/Imagenes/ballesta.png"),
	ligera(Tipo.caballeria, "/Imagenes/ligera.png"), pesada(Tipo.caballeria, "/Imagenes/pesada.png");
	private Tipo tipo;
	private String rutaImagen;

	private Especialidad(Tipo tipo, String rutaImagen) {
		this.tipo = tipo;
		this.rutaImagen = rutaImagen;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public static Especialidad getTipoPorNombre(String especialidad) {

		for (Especialidad especial : Arrays.asList(Especialidad.values())) {
			if (especial.toString().equals(especialidad)) {
				return especial;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
