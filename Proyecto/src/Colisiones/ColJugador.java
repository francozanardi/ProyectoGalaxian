package Colisiones;

import Enemigo.Kamikaze;



public class ColJugador extends Colisionador
{
	public ColJugador( )
	{
	}
	
	
	
	public void afectar(Kamikaze kamikaze)
	{
		kamikaze.explotar();
	}
}
