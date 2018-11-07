package visitor;

import Jugador.Jugador;
import PowerUp.PowerUp;



public class ColPowerUp extends Colisionador
{
	private PowerUp powerup;

	
	
	public ColPowerUp( PowerUp me )
	{
		powerup = me;
	}


	
	public void visit(Jugador jugador)
	{
		powerup.afectar( jugador );
		
		powerup.remove( );
	}
}