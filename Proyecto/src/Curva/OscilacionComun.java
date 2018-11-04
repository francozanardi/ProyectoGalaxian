package Curva;

import Utils.Posicion;



public class OscilacionComun extends Curva
{
	public OscilacionComun( double tiempoInicial )
	{
		tiempoMS = tiempoInicial;
	}


	
	protected Posicion parametrizar( double t )
	{
		final double ESCALA = 2.0;// / 15.0;
		double x, y;
		
		t *= ESCALA;
		
		x = 20 * Math.sin( t );
		y = 10.0 * t;
		
		return new Posicion(x, y);
	}
}