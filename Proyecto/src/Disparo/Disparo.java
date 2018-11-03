package Disparo;

import javax.swing.JPanel;

import Arma.Arma;
import Colisiones.Colisionador;
import Colisiones.ColDisparo;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Logica.Juego;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;



public abstract class Disparo extends Entidad
{
	protected double				dmg;
	protected Vector				dir;
	protected ColDisparo	colisionador;


	
	protected void inicializar( Size size, ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion, double dmgBase )
	{
		colisionador	= col;
		map				= arma.getMapa();
		panel			= new JPanel();
		pos				= posInicial;
		tamano			= size;
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