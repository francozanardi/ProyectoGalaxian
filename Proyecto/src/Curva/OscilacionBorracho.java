package Curva;

import Utils.Posicion;



public class OscilacionBorracho extends Curva
{	
	public OscilacionBorracho( double tiempoInicial )
	{
		tiempoMS = tiempoInicial;
	}


	
	protected Posicion parametrizar( double t )
	{
		final double ESCALA = 1.0 / 15.0;
		double x, y;
		
		t *= ESCALA;
		
		x = 40.0 * (Math.cos(t) + Math.cos(7*t) + Math.cos(13*t) + Math.cos(17*t));
		y = 30 * (t / ESCALA);
		
		return new Posicion(x, y);
	}
}