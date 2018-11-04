package Enemigo;

import Colisiones.Colisionador;
import Enemigo.Estados.Estado;



public abstract class Transformable extends Kamikaze
{
	protected Estado estado;
	
	

	public abstract void transformar();
	
	
	
	public void setColisionador(Colisionador col)
	{
		colisionador = col;
	}
}
