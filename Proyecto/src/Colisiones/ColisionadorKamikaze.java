package Colisiones;

import Disparo.Disparo;
import Disparo.DisparoJugador;
import Enemigo.Enemigo;
import Jugador.Jugador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColisionadorKamikaze extends Colisionador
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private double dmgExplosion;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ColisionadorKamikaze( double danoExplosion )
	{
		this.dmgExplosion = danoExplosion;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Jugador jugador)
	{
		jugador.recibirDMG(dmgExplosion);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(DisparoJugador disparo)
	{
		disparo.remove();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////