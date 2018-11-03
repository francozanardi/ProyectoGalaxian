package Jugador;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import Arma.*;
import Colisiones.Colisionador;
import Colisiones.ColDispJugador;
import Colisiones.ColJugador;
import Disparo.Disparo;
import Entidad.Personaje;
import Escudo.*;
import Logica.Juego;
import Utils.Posicion;
import Utils.Size;



public class Jugador extends Personaje
{	
	private int dir;


	
	public Jugador()
	{
		final int	PLAYER_WIDTH	= 20,
					PLAYER_HEIGHT	= 40;
		
		this.panel			= new JPanel( );
		this.pos			= new Posicion((Juego.GAME_WIDTH / 2) - (PLAYER_WIDTH / 2), Juego.GAME_HEIGHT - PLAYER_HEIGHT - 30);
		this.tamano			= new Size(PLAYER_WIDTH, PLAYER_HEIGHT);
		this.vida			= 1000;
		this.escudo			= new LinkedList<Escudo>( );
		this.colisionador	= new ColJugador();
		
		actualizarPanel( true, new Color( 255, 255, 255 ) );
		
		setArma( new ArmaComun(this, new ColDispJugador(), 0.5 * Math.PI) );
	}



	protected void morir( )
	{
		map.perder();
	}



	public void explosionKamikaze( double dmg )
	{
		dmg = utilizarEscudosExplosion( dmg );
		recibirDMG( dmg );
	}


	
	public void setPos( int posX )
	{
		pos.setX(posX);
	}

	public void setDireccion( int dir )
	{
		this.dir = dir;
	}


	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}


	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
		mover( msDesdeUltAct );
	}


	
	public void disparar( )
	{
		if (arma != null)
		{
			List<Disparo> lista = arma.lanzarDisparo();
			
			for (Disparo d : lista)
				map.addEntity( d );
		}
	}


	
	public void mover( double msDesdeUltActualizacion )
	{
		final double VELOCIDAD_HORIZONTAL = 40.0;
		
		double futuraPosX = pos.getX() + dir * conversionEnTiempo(VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion);
		
		if(futuraPosX > 5 && futuraPosX < Juego.GAME_WIDTH - tamano.getWidth()-10) {
			pos.setX(futuraPosX);
		}
		actualizarPosicion();
	}
}