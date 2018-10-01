package Colisiones;

import Disparo.DisparoEnemigo;
import Enemigo.Kamikaze;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColisionadorJugador extends Colisionador
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Kamikaze kamikaze)
	{
		kamikaze.recibirDMG(kamikaze.getVida());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(DisparoEnemigo disparo)
	{
		disparo.remove();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////