package modelo;

import java.awt.Color;
import java.util.LinkedList;

public class Ejercito {
	private int id;
	private static int infanteria = 1;
	private static int caballeria = 1;
	private static int arqueria = 1;
	private int idBatallonActual = 0;
	private Batallon primerBatallon;
	// Aunque tiene caracteristicas de SET (los batallones no se repiten)
	// me conviene una list porque puedo hacer get(i)
	//Esta implementacion me permite usar la coleccion como lista o cola
	LinkedList<Batallon> batallones = new LinkedList<Batallon>();

	public Ejercito(int id) {
		super();
		this.id = id;
		crearEjercito();
	}

	public boolean setSiguienteBatallon() {
		batallones.offer(batallones.poll());
		return !batallones.peek().equals(primerBatallon);
	}

	private void crearEjercito() {
		int j=0;
		for (int i = 0; i < infanteria; i++) {
			batallones.offer(new Batallon(j++,Tipo.infanteria));
		}
		for (int i = 0; i < caballeria; i++) {
			batallones.offer(new Batallon(j++,Tipo.caballeria));

		}
		for (int i = 0; i < arqueria; i++) {
			batallones.offer(new Batallon(j++,Tipo.arqueria));
		}
		this.primerBatallon=batallones.peek();
	}

	public int getId() {
		return id;
	}

	public static int getInfanteria() {
		return infanteria;
	}

	public static int getCaballeria() {
		return caballeria;
	}

	public static int getArqueria() {
		return arqueria;
	}


	public Tipo getTipoBatallon() {
		return getBatallonActual().getTipo();
	}


	public Batallon getBatallonActual() {
		return batallones.get(idBatallonActual);
	}

	public int getIdBatallonActual() {
		return getBatallonActual().getId();
	}

	public void cambiarColorAlBatallon(Color color) {
		for (Batallon batallon : batallones) {
			batallon.setColorAtacante(color);
		}
	}

	public LinkedList<Batallon> getBatallones() {
		return batallones;
	}
	
	public String getIcon() {
		
		/*Lo mio que aqu� no funciona
		 * Soldado soldado = this.primerBatallon.getSoldado(1);
		Especialidad especialidad = soldado.getEspecialidad();
		String rutaImagen = especialidad.getRutaImagen();*/
		return " ";
	}

	public Color getColor() {
		return Color.black;
	}

}
