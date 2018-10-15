package Colisiones;

import Disparo.Disparo;
import Enemigo.Borracho;
import Enemigo.Enemigo;
import Enemigo.Guiado;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColisionadorJugador extends Colisionador
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Borracho kamikaze)
	{
		kamikaze.recibirDMG(kamikaze.getVida());
	}
	
	public void afectar(Guiado kamikaze)
	{
		kamikaze.recibirDMG(kamikaze.getVida());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Disparo disparo, Enemigo tirador)
	{
		disparo.remove();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////