package Utils;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Vector
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private double	x,
					y;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
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

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public double getX( )
	{
		return x;
	}
	
	public double getY( )
	{
		return y;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setEnCartesianas( double x, double y )
	{
		this.x = x;
		this.y = y;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setEnPolares( double theta, double r )
	{
		this.x = (Math.cos( theta ) * r);
		this.y = (Math.sin( theta ) * r);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public double getNorma( )
	{
		return Math.sqrt( x*x + y*y );
	}
	
	public void setNorma( double n )
	{
		normalizar();
		x *= n;
		y *= n;
	}
	
	public void normalizar( )
	{
		double norma = getNorma();
		x /= norma;
		y /= norma;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////