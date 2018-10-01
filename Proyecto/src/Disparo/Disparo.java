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
	
	protected double dmg;
	protected Vector vecDireccion;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void avanzar( double msDesdeUltActualizacion )
	{
		pos.setX( pos.getX() + conversionEnTiempo( vecDireccion.getX(), msDesdeUltActualizacion) );
		
		// Aquí restamos ya que el eje Y del JFrame aumenta hacia abajo, y hay que corregir la trayectoria.
		pos.setY( pos.getY() - conversionEnTiempo( vecDireccion.getY(), msDesdeUltActualizacion) );
		
		actualizarPosicion();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion )
	{
		avanzar( msDesdeUltActualizacion );
		final int offset = 100;
		
		// eliminar el disparo si se fue de la pantalla
		if ((pos.getY() < (0 - offset)) ||
			(pos.getY() > (Juego.GAME_HEIGHT + offset)) ||
			(pos.getX() < (0 - offset)) ||
			(pos.getX() > (Juego.GAME_WIDTH + offset)))
		{
			remove();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public double getDmg( )
	{
		return dmg;
	}
	
	public void setDmg( double dmg )
	{
		this.dmg = dmg;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////