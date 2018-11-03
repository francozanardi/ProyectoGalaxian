package Utils;

/**
 * Esta clase modela un vector inmóbil en el plano.
 */
public class Vector
{	
	private double	x,
					y;
	
	public Vector( )
	{
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Vector( double x, double y )
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX( )
	{
		return x;
	}
	
	public double getY( )
	{
		return y;
	}
	
	
	
	/**
	 * Establece las coordenadas utilizando coordenadas cartesianas.
	 * 
	 * @param x
	 * 	Coordenada del eje X.
	 * 
	 * @param y
	 *  Coordenada del eje Y.
	 */
	public void setCartesianas( double x, double y )
	{
		this.x = x;
		this.y = y;
	}
	
	
	
	/**
	 * Establece las coordenadas utilizando coordenadas polares.
	 * 
	 * @param ang
	 * 	Ángulo del vector respecto al eje X positivo.
	 * 
	 * @param dist
	 *  Norma del vector.
	 */
	public void setPolares( double ang, double dist )
	{
		this.x = (Math.cos( ang ) * dist);
		this.y = (Math.sin( ang ) * dist);
	}
	
	
	
	/**
	 * Devuelve la norma euclídea del vector.
	 * 
	 * @return
	 *	La norma euclídea del vector.
	 */
	public double getNorma( )
	{
		return Math.sqrt( x*x + y*y );
	}
	
	
	
	/**
	 * Establece la norma euclídea del vector.
	 * 
	 * @param
	 *  Nueva norma para el vector.
	 */
	public void setNorma( double n )
	{
		normalizar();
		x *= n;
		y *= n;
	}
	
	
	
	/**
	 * Convierte al vector en un vector normal (es decir, cuya norma euclídea es igual a 1)
	 */
	public void normalizar( )
	{
		double norma = getNorma();
		x /= norma;
		y /= norma;
	}
}