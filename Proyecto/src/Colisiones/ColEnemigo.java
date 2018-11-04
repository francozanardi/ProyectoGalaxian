package Colisiones;

import Disparo.Disparo;



public class ColEnemigo extends Colisionador
{	
	public ColEnemigo()
	{
	}
	
	
	
	public void afectar( Disparo disparo )
	{
		disparo.remove();
	}
}