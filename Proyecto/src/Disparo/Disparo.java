package Disparo;

import java.awt.Color;

import javax.swing.JPanel;

import Arma.Arma;
import Colisiones.Colisionador;
import Colisiones.ColisionadorDisparo;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Disparo extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected double				dmg;
	protected Vector				vecDireccion;
	protected ColisionadorDisparo	colisionador;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void inicializar( Size size, Mapa mapa, ColisionadorDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion, double dmgBase )
	{
		colisionador	= col;
		map				= mapa;
		panel			= new JPanel();
		pos				= posInicial;
		tamano			= size;
		dmg				= dmgBase * arma.getMultiplicadorDmg( );
		vecDireccion	= vectorDireccion;
		
		inicializarColisionador( arma.getOwner() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void colisionar(Entidad e)
	{		
		e.serChocado(colisionador);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		colisionador.afectar( this );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void inicializarColisionador( Personaje tirador )
	{
		this.colisionador.setDisparo( this );
		this.colisionador.setLanzador( tirador );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void avanzar( double msDesdeUltActualizacion )
	{
		pos.setX( pos.getX() + conversionEnTiempo( vecDireccion.getX(), msDesdeUltActualizacion) );
		
		pos.setY( pos.getY() + conversionEnTiempo( vecDireccion.getY(), msDesdeUltActualizacion) );
		
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