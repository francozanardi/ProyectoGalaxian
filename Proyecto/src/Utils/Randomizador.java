package Utils;

import java.util.Random;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Randomizador extends Random
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Randomizador( )
	{
		super( );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Genera un entero aleatorio en el rango [min, max] incluyendo los extremos.
	 * 
	 * @param min
	 * 	Valor m�nimo que puede tomar el resultado.
	 * 
	 * @param max
	 * 	Valor m�ximo que puede tomar el resultado.
	 * 
	 * @return
	 * 	Entero aleatorio en el rango [min, max]
	 */
	public int nextInt( int min, int max )
	{
		return min + nextInt( max - min + 1 );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Genera un double aleatorio en el rango [min, max] incluyendo los extremos.
	 * 
	 * @param min
	 * 	Valor m�nimo que puede tomar el resultado.
	 * 
	 * @param max
	 * 	Valor m�ximo que puede tomar el resultado.
	 * 
	 * @return
	 * 	Double aleatorio en el rango [min, max]
	 */
	public double nextDouble( double min, double max )
	{
		return (nextDouble( ) * (max - min)) + min;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////