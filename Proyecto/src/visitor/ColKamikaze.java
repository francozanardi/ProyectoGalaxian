package visitor;

import Jugador.Jugador;



public class ColKamikaze extends Colisionador
{	
	private double dmgExplosion;
	
	
	
	public ColKamikaze( double danoExplosion )
	{
		this.dmgExplosion = danoExplosion;
	}
	
	
	
	public void visit(Jugador jugador)
	{
		jugador.explosionKamikaze( dmgExplosion );
	}
}