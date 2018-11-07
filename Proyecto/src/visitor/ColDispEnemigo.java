package visitor;

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


	
	public void visit(Jugador jugador)
	{
		jugador.recibirDMG( disparo.getDmg() );
		disparo.remove();
	}
	
	
	
	public void visit(Destructible obstaculo)
	{
		obstaculo.recibirDMG( disparo.getDmg() );
		disparo.remove();
	}
}