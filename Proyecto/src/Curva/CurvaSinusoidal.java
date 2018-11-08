package Curva;

import Utils.Posicion;



public class CurvaSinusoidal extends Curva
{
	private double	amplitudHorizontal,
					velocidadVertical,
					velocidadHorizontal;
	
	
	
	public CurvaSinusoidal( double tiempoInicial, double amplitud, double velocidadVertical, double velocidadHorizontal )
	{
		this.tiempoMS			= tiempoInicial;
		this.amplitudHorizontal	= amplitud;
		this.velocidadVertical	= velocidadVertical;
		this.velocidadHorizontal=velocidadHorizontal;
	}


	
	protected Posicion parametrizar( double t )
	{
		double x, y;
				
		x = amplitudHorizontal * Math.sin( t * velocidadHorizontal );
		y = velocidadVertical * t;
		
		return new Posicion(x, y);
	}
}