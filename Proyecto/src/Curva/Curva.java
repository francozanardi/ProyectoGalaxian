package Curva;

import Utils.Posicion;



public abstract class Curva
{	
	protected double	oldX = 0.0,
						oldY = 0.0,
						tiempoMS = 0.0;


	
	protected abstract Posicion parametrizar( double t );


	
	public Posicion obtenerCambio( double tiempoTranscurridoMS )
	{
		double	x,
				y;
		Posicion pos;
		
		// Obtener la posición de la parametrización
		tiempoMS += tiempoTranscurridoMS;
		pos = parametrizar( tiempoMS / 1000.0 ); // escala: 1000ms = 1 segundo = 1 unidad
		
		x = pos.getX();
		y = pos.getY();
		
		// Si es el primer paso, ignorar el cambio, ya que el punto de comienzo
		// no tiene un punto anterior para obtener el cambio.
		if (oldX == 0 && oldY == 0)
		{
			oldX = x;
			oldY = y;
		}
		
		// Calculamos el desplazamiento entre este momento y la última actualización.
		pos = new Posicion( x - oldX, y - oldY );
		
		oldX = x;
		oldY = y;
		
		return pos;
	}

}