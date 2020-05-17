package vista.info;

import java.awt.Color;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Ejercito;
import vista.FichaBatallon;

public class BatallonFichaFactory implements FichaFactory {
	int id, units;
	Ejercito ejercito;
	
	


	public BatallonFichaFactory(int id, int units,Ejercito ejercito) {
		super();
		this.id = id;
		this.units = units;
		this.ejercito = ejercito;
	}




	@Override
	public JPanel getPanel() {
		Batallon batallon = this.ejercito.getBatallonActual();
		String rutaImagen = ejercito.getIcon();
		int army = -1;
		int idBatallon = batallon.getAtaqueTotal();
		int experiencia = batallon.getExperienciaTotal();
		int ataque = batallon.getAtaqueTotal();
		int defensa = batallon.getDefensaTotal();
		int stamina = batallon.getStaminaTotal();
		int unidades = batallon.getMaximoSoldados();
		boolean heroe = false;
		Color colorEnemigo = batallon.getColorAtacante();
		Color colorArmy = batallon.getColorArmy();
	
		return new FichaBatallon(rutaImagen, army, idBatallon, experiencia, ataque,
				defensa, stamina, unidades, heroe, colorEnemigo, colorArmy);
	}

}
