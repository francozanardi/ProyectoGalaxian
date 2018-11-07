package Enemigo;

import Enemigo.Estados.Estado;
import visitor.Colisionador;



public abstract class Transformable extends Kamikaze
{
	protected Estado estado;
	
	public abstract void transformar();
	
	public void setColisionador(Colisionador col)
	{
		colisionador = col;
	}
}
