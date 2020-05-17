package modelo;

import vista.info.FichaFactory;
import vista.info.FichaTrincheraInfo;

public class Trinchera implements Casilla {

	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		return new FichaTrincheraInfo();
	}

}
