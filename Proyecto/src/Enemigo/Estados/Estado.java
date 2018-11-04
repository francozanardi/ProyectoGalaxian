package Enemigo.Estados;

import Enemigo.Transformable;



public abstract class Estado
{
	protected Transformable contenedor;
	protected double vidaMaxima;
	
	

	public abstract void controlarTransformacion();
	public abstract void explotar();
	public abstract Estado transformar();
}
