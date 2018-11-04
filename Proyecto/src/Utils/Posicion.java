package Utils;

public class Posicion
{
	private double x;
	private double y;
	
	public Posicion( double x, double y )
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX( double x )
	{
		this.x = x;
	}
	
	public void setY( double y )
	{
		this.y = y;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public Posicion clone( )
	{
		return new Posicion( this.x, this.y );
	}	
}
