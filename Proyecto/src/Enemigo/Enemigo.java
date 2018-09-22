package Enemigo;

import java.util.Random;

import Disparo.Disparo;
import Entidad.Personaje;
import Inteligencia.Inteligencia;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Enemigo extends Personaje
{
	///////////////////////////////////////////////////////////////////////////////////////////////

	protected Inteligencia	ia;
	protected double		dificultad;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( double msDesdeUltActualizacion )
	{
		ia.mover( this, msDesdeUltActualizacion );
		
		actualizarPosicion();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void setDificultad( double dif )
	{
		dificultad = dif;
	}
	
	public double getDificultad( )
	{
		return dificultad;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*public void colisionar(EntidadConVida e) { //aca lo volvemos a poner porque sino toma que colisionador es nulo, ya que en entidadconvida lo es
		e.serChocado(colisionador);
	}
	*/
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void disparar( )
	{
		Disparo d = ia.disparar( this );
				
		if (d != null)
			map.agregarEntidad(d);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion )
	{
		mover( msDesdeUltActualizacion );
		
		disparar( );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////