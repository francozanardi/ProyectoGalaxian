package Colisiones;

import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Obstaculo.Barricada;
import Obstaculo.Obstaculo;
import Obstaculo.Destructible;
import PowerUp.PowerUp;



public class ColDispJugador extends ColDisparo
{	
	public ColDispJugador( )
	{
	}


	
	public ColDisparo clone( )
	{
		return new ColDispJugador( );
	}
	
	private void afectarAEnemigo( Enemigo e )
	{
		e.recibirDMG( disparo.getDmg() );
		disparo.remove();
		
		// Si el enemigo murió, transferirle su puntaje al jugador
		if (e.getVida() <= 0)
			tirador.givePuntaje( e.getPuntaje() );
	}


	
	public void afectar(Enemigo enemigo)
	{
		afectarAEnemigo( enemigo );
	}

	public void afectar(Kamikaze kamikaze)
	{
		afectarAEnemigo( kamikaze );
	}


	
	public void afectar(PowerUp powerup)
	{
		powerup.recibirDMG( disparo.getDmg() );
		disparo.remove();
	}


	
	private void afectarAObstaculo( Obstaculo obj )
	{
		obj.recibirDMG( disparo.getDmg() );
		disparo.remove();
		
		if (obj.getVida() <= 0.0)
		{
			tirador.givePuntaje( obj.getPuntaje() );
		}
	}
	
	public void afectar(Destructible obstaculo)
	{
		afectarAObstaculo( obstaculo );
	}

	public void afectar(Barricada barricada)
	{
		afectarAObstaculo( barricada );
	}
}