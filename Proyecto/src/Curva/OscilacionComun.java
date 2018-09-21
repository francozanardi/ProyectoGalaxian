package Curva;

import Utils.Posicion;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class OscilacionComun extends Curva
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public OscilacionComun( double tiempoInicial )
	{
		time = tiempoInicial;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Posicion obtenerCambio(double tiempoTranscurridoMS)
	{
		double x, y;
		Posicion pos;
		time += tiempoTranscurridoMS;
		
		x = 10.0 * Math.sin(time / 300.0);
		y = time / 50.0;
		
		pos = new Posicion( x - oldX, y - oldY );
		
		oldX = x;
		oldY = y;
		
		return pos;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////