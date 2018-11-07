package Disparo;

import Arma.Arma;
import Colisiones.Colisionador;
import Colisiones.ColDisparo;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Logica.Juego;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;



public abstract class Disparo extends Entidad
{
	protected double				dmg;
	protected Vector				dir;
	protected ColDisparo	colisionador;


	
	protected void inicializar( Sprite spr, ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion, double dmgBase )
	{
		colisionador	= col;
		map				= arma.getMapa();
		
		cargarSprite( spr );
		pos				= posInicial;
		dmg				= dmgBase * arma.getMultDmg( );
		dir				= vectorDireccion;
		
		inicializarColisionador( arma.getOwner() );
	}



	public void colisionar(Entidad e)
	{		
		e.serChocado(colisionador);
	}
	
	public void serChocado(Colisionador col)
	{
		colisionador.afectar( this );
	}


	
	public double getDmg( )
	{
		return dmg;
	}
	
	
	
	protected void inicializarColisionador( EntidadConVida tirador )
	{
		this.colisionador.setDisparo( this );
		this.colisionador.setLanzador( tirador );
	}


	
	public void avanzar( double msDesdeUltActualizacion )
	{
		pos.setX( pos.getX() + conversionEnTiempo( dir.getX(), msDesdeUltActualizacion) );
		
		pos.setY( pos.getY() + conversionEnTiempo( dir.getY(), msDesdeUltActualizacion) );
		
		actualizarPosicion();
	}


	
	public void actualizar( double msDesdeUltActualizacion )
	{
		final int offset = 100;
		
		
		avanzar( msDesdeUltActualizacion );
		
		// eliminar el disparo si se fue de la pantalla
		if ((pos.getY() < (0 - offset)) ||
			(pos.getY() > (Juego.GAME_HEIGHT + offset)) ||
			(pos.getX() < (0 - offset)) ||
			(pos.getX() > (Juego.GAME_WIDTH + offset)))
		{
			remove();
		}
	}
}