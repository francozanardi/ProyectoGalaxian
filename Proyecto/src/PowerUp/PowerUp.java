package PowerUp;

import Colisiones.Colisionador;
import Entidad.EntidadConVida;
import Jugador.Jugador;
import Logica.Juego;
import Utils.Posicion;
import Utils.Vector;



public abstract class PowerUp extends EntidadConVida
{
	protected Vector vecDir;
	
	
	
	public abstract void afectar( Jugador player );
	
	
	
	public void caer( Posicion posInicial )
	{		
		final double VELOCIDAD_CAIDA = 75.0;
		
		pos = posInicial;
		
		vecDir = new Vector( );
		vecDir.setCartesianas( 0.0, -1.0 );
		vecDir.setNorma( VELOCIDAD_CAIDA );
		
		map.addEntity( this );
	}

	public void recibirDMG( double dmg )
	{
		vida -= dmg;
		
		if (vida <= 0.0)
			remove();
	}

	public void actualizar( double msDesdeUltAct )
	{		
		pos.setX( pos.getX() + conversionEnTiempo( vecDir.getX(), msDesdeUltAct) );
		
		// Aquí restamos ya que el eje Y del JFrame aumenta hacia abajo, y hay que corregir la trayectoria.
		pos.setY( pos.getY() - conversionEnTiempo( vecDir.getY(), msDesdeUltAct) );
		
		actualizarPosicion();
		
		// Si el powerUp se fue por abajo, destruirlo.
		if (pos.getY() > (Juego.GAME_HEIGHT + 50))
			remove( );
	}
	
	public void serChocado( Colisionador col )
	{
		col.afectar(this);
	}
}