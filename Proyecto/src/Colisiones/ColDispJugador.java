package Colisiones;

import Disparo.Disparo;
import Enemigo.Borracho;
import Enemigo.Enemigo;
import Enemigo.Guiado;
import Enemigo.KamikazeFragil;
import Jugador.Jugador;
import Obstaculo.Barricada;
import Obstaculo.Obstaculo;
import Obstaculo.ObstaculoDestructible;
import PowerUp.PowerUp;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ColDispJugador extends ColisionadorDisparo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ColDispJugador( )
	{
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ColisionadorDisparo clone( )
	{
		return new ColDispJugador( );
	}
	
	private void afectarAEnemigo( Enemigo e )
	{
		e.recibirDMG( disparo.getDmg() );
		disparo.remove();
		
		// Si el enemigo muri�, transferirle su puntaje al jugador
		if (e.getVida() <= 0)
			tirador.setPuntaje(tirador.getPuntaje() + e.getPuntaje());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Enemigo enemigo)
	{
		afectarAEnemigo( enemigo );
	}

	public void afectar(Borracho kamikaze)
	{
		afectarAEnemigo( kamikaze );
	}
	
	public void afectar(Guiado kamikaze)
	{
		afectarAEnemigo( kamikaze );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(PowerUp powerup)
	{
		powerup.recibirDMG( disparo.getDmg() );
		disparo.remove();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void afectarAObstaculo( Obstaculo obj )
	{
		obj.recibirDMG( disparo.getDmg() );
		disparo.remove();
		
		if (obj.getVida() <= 0.0)
		{
			tirador.setPuntaje( tirador.getPuntaje() + 10 );
			System.out.println("Destruiste un obstaculo! +10 puntos");
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(ObstaculoDestructible obstaculo)
	{
		afectarAObstaculo( obstaculo );
	}

	public void afectar(Barricada barricada)
	{
		afectarAObstaculo( barricada );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////