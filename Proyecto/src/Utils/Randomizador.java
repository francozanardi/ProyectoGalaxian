package Utils;

import java.util.Random;



/**
 * Clase que extiende a Random, aplica el patrón Singleton por lo que para obtener una instancia de este objeto se debe utilizar
 * Randomizar.create()
 */
@SuppressWarnings("serial")
public class Randomizador extends Random
{
	private static Randomizador instancia = null;
	
	
	
	/**
	 * Constructor por defecto, invoca al constructor de la clase Random.
	 */
	private Randomizador( )
	{
		super( );
	}
	
	
	
	/**
	 * Devuelve una instancia de objeto Randomizador (la única).
	 * En caso de que ésta no exista, la crea.
	 * 
	 * @return
	 * 	Una instancia de objeto Randomizador.
	 */
	public static Randomizador create( )
	{
		if (instancia == null)
		{
			instancia = new Randomizador( );
		}
		
		return instancia;
	}
	
	
	
	/**
	 * Genera un entero aleatorio en el rango [min, max] incluyendo los extremos.
	 * 
	 * @param min
	 * 	Valor mínimo que puede tomar el resultado.
	 * 
	 * @param max
	 * 	Valor máximo que puede tomar el resultado.
	 * 
	 * @return
	 * 	Entero aleatorio en el rango [min, max]
	 */
	public int nextInt( int min, int max )
	{
		return min + nextInt( max - min + 1 );
	}
	
	
	
	/**
	 * Genera un double aleatorio en el rango [min, max] incluyendo los extremos.
	 * 
	 * @param min
	 * 	Valor mínimo que puede tomar el resultado.
	 * 
	 * @param max
	 * 	Valor máximo que puede tomar el resultado.
	 * 
	 * @return
	 * 	Double aleatorio en el rango [min, max]
	 */
	public double nextDouble( double min, double max )
	{
		return (nextDouble( ) * (max - min)) + min;
	}
}