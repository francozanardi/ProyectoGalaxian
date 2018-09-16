package Disparo;

import Colisiones.Colisionador;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Grafica.Juego;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Disparo extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected float fuerza;
	protected Vector vecDireccion;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void avanzar()
	{
		pos.setX( pos.getX() + 1.0 * vecDireccion.getX() );
		
		// Aquí restamos ya que el eje Y del JFrame aumenta hacia abajo, y hay que corregir la trayectoria.
		pos.setY( pos.getY() - 1.0 * vecDireccion.getY() );
		
		actualizarPosicion();
	}
	
	public void actualizar() {
		avanzar();
		final int offset = 100;
		
		
		// eliminar el disparo si se fue de la pantalla
		if ((pos.getY() < (0 - offset)) ||
			(pos.getY() > (Juego.GAME_HEIGHT + offset)) ||
			(pos.getX() < (0 - offset)) ||
			(pos.getX() > (Juego.GAME_WIDTH + offset)))
		{
			eliminar();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public float getFuerza( )
	{
		return fuerza;
	}
	
	public void setFuerza( float fuerza )
	{
		this.fuerza = fuerza;
	}
	
	public void serChocado(Colisionador col) {
		col.afectar(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////