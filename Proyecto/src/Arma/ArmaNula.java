package Arma;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Sprite.Sprite;
import Utils.Posicion;

public class ArmaNula extends Arma {
	
	public ArmaNula() {
		pos = new Posicion(0, 0);
		Image imgNula = null;
		setSprite(new Sprite(imgNula));
		sprite.setVisible(false);
		sprite.setSize(1, 1);
	}

	@Override
	protected List<Disparo> crearDisparo() {
		return new LinkedList<Disparo>();
	}

}
