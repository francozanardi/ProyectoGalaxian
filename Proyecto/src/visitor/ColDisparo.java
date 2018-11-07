package visitor;

import Disparo.Disparo;
import Entidad.EntidadConVida;



public abstract class ColDisparo extends Colisionador
{	
	protected Disparo disparo;
	protected EntidadConVida tirador;


	
	public abstract ColDisparo clone( );


	
	public void setDisparo( Disparo d )
	{
		this.disparo = d;
	}
	
	public Disparo getDisparo( )
	{
		return this.disparo;
	}


	
	public void setLanzador( EntidadConVida p )
	{
		this.tirador = p;
	}
	
	public EntidadConVida getLanzador( )
	{
		return this.tirador;
	}
}