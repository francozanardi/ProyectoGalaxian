package Enemigo.Estados;

import Enemigo.Enemigo;
import Enemigo.Transformable;

public abstract class Estado {
	protected Transformable contenedor;
	protected double vidaMaxima;
	
	public abstract void controlarTransformacion();
	public abstract void choque();
	protected abstract void transformar();
}
