package Colisiones;

import Disparo.DisparoJugador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColisionadorEnemigo extends Colisionador
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(DisparoJugador disparo)
	{
		disparo.remove();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////