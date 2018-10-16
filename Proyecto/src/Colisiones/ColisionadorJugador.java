package Colisiones;

import Disparo.Disparo;
import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Enemigo;
import Enemigo.Guiado;
import Enemigo.KamikazeFragil;

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
	
	public void afectar(KamikazeFragil kamikaze)
	{
		kamikaze.choque();
	}
	
	public void afectar(Camuflado camuflado) {
		camuflado.choque();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Disparo disparo, Enemigo tirador)
	{
		disparo.remove();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////