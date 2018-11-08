package Enemigo;


import java.util.List;

import Arma.Arma;
import Disparo.Disparo;
import Entidad.Personaje;
import PowerUp.PowerUp;
import Utils.Posicion;



public abstract class Enemigo extends Personaje
{
	protected double	dificultad;
	protected PowerUp	powerUp;
	
	
	
	public double getDificultad( )
	{
		return dificultad;
	}
		
	public void setPowerUp( PowerUp powerUp )
	{
		this.powerUp = powerUp;
	}
	
	public void setArma( Arma arma )
	{
		super.setArma( arma );
		arma.setMultCadencia( 10 );
	}
	
	private void dropearPowerUp( )
	{
		if (powerUp != null)
		{
			Posicion posInicial = new Posicion( pos.getX(), pos.getY() );
			
			powerUp.caer( posInicial );
		}
	}
	
	public void disparar( )
	{
		if (this.arma != null && ia != null)
		{
			List<Disparo> disparos = arma.lanzarDisparo( );
			
			// Añadir disparos al mapa
			for (Disparo d : disparos)
				map.addEntity(d);
		}
			
	}
	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
		mover( msDesdeUltAct );
		
		disparar( );
	}
	
	public void recibirDMG(double dmg)
	{
		super.recibirDMG(dmg);
		if(vida <= 0) {
			dropearPowerUp();
		}
	}
	
	public void mover( double msDesdeUltActualizacion )
	{
		if (ia != null)
			ia.mover( msDesdeUltActualizacion );
		
		actualizarPosicion();
	}
}