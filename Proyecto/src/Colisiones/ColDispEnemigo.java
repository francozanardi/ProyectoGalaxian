package Colisiones;

import Jugador.Jugador;
import Obstaculo.Destructible;



public class ColDispEnemigo extends ColDisparo
{	
	public ColDispEnemigo( )
	{
	}



	public ColDisparo clone()
	{
		return new ColDispEnemigo( );
	}


	
	public void afectar(Jugador jugador)
	{
		jugador.recibirDMG( disparo.getDmg() );
		disparo.remove();
	}
	
	
	
	public void afectar(Destructible obstaculo)
	{
		obstaculo.recibirDMG( disparo.getDmg() );
		disparo.remove();
	}
}