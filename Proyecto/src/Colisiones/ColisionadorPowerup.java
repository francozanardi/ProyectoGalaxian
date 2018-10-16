package Colisiones;

import Disparo.Disparo;
import Jugador.Jugador;
import PowerUp.PowerUp;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColisionadorPowerup extends Colisionador
{
	
	private PowerUp powerup;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ColisionadorPowerup( PowerUp me )
	{
		powerup = me;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// PowerUp choca a Jugador
	public void afectar(Jugador jugador)
	{
		powerup.afectar( jugador );
		
		powerup.remove( );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// PowerUp choca con un DisparoJugador
	public void afectar(Disparo disparo, Jugador tirador)
	{
		powerup.recibirDMG( disparo.getDmg( ) );
		
		disparo.remove();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////


}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////