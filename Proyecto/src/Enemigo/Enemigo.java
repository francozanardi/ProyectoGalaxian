package Enemigo;


import Entidad.Personaje;
import Inteligencia.IAEnemigo;
import PowerUp.PowerUp;
import Utils.Posicion;



public abstract class Enemigo extends Personaje
{
	protected IAEnemigo ia;
	protected double	dificultad;
	protected PowerUp	powerUp;


			
	public double getDificultad( )
	{
		return dificultad;
	}
	
	public IAEnemigo getIA( )
	{
		return this.ia;
	}
	
	public void setIA( IAEnemigo ia )
	{
		this.ia = ia;
	}
	
	public void setPowerUp( PowerUp powerUp )
	{
		this.powerUp = powerUp;
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
			ia.disparar( );
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