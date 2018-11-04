package Colisiones;

import Jugador.Jugador;



public class ColKamikaze extends Colisionador
{	
	private double dmgExplosion;
	
	
	
	public ColKamikaze( double danoExplosion )
	{
		this.dmgExplosion = danoExplosion;
	}
	
	
	
	public void afectar(Jugador jugador)
	{
		jugador.explosionKamikaze( dmgExplosion );
	}
}