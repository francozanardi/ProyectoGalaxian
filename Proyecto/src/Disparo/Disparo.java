package Disparo;

import java.awt.Color;

import Colisiones.Colisionador;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Logica.Juego;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Disparo extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double VELOCIDAD_MOVIMIENTO = 25.0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected float fuerza;
	protected Vector vecDireccion;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void avanzar( double msDesdeUltActualizacion )
	{
		pos.setX( pos.getX() + conversionEnTiempo(VELOCIDAD_MOVIMIENTO * vecDireccion.getX(), msDesdeUltActualizacion) );
		
		// Aqu� restamos ya que el eje Y del JFrame aumenta hacia abajo, y hay que corregir la trayectoria.
		pos.setY( pos.getY() - conversionEnTiempo(VELOCIDAD_MOVIMIENTO * vecDireccion.getY(), msDesdeUltActualizacion) );
		
		actualizarPosicion();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion ) {
		avanzar( msDesdeUltActualizacion );
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

	///////////////////////////////////////////////////////////////////////////////////////////////

	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////