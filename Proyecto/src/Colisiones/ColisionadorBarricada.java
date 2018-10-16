package Colisiones;

import Disparo.Disparo;
import Jugador.Jugador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColisionadorBarricada extends Colisionador
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Disparo disparo, Jugador personaje)
	{
		disparo.remove();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////