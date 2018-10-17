package Jugador;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import Arma.ArmaComun;
import Arma.ArmaDefaultEnemigo;
import Arma.ArmaTriple;
import Colisiones.Colisionador;
import Colisiones.ColDispJugador;
import Colisiones.ColisionadorJugador;
import Disparo.Disparo;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Escudo.Escudo;
import Escudo.EscudoAbsoluto;
import Escudo.EscudoBasico;
import Escudo.EscudoHealer;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Jugador extends Personaje
{	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	VELOCIDAD_HORIZONTAL = 50.0;
	
	private final int		PLAYER_WIDTH = 20,
							PLAYER_HEIGHT = 40;
	
	private int dir;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Jugador()
	{
		this.panel			= new JPanel( );
		this.pos			= new Posicion((Juego.GAME_WIDTH / 2) - (PLAYER_WIDTH / 2), Juego.GAME_HEIGHT - PLAYER_HEIGHT - 30);
		this.tamano			= new Size(PLAYER_WIDTH, PLAYER_HEIGHT);
		this.vida			= 1000;
		this.escudo			= new LinkedList<Escudo>( );
		this.colisionador	= new ColisionadorJugador();
		
		actualizarPanel( true, new Color( 255, 255, 255 ) );
		
		setArma( new ArmaComun(map, this, new ColDispJugador(), 0.5 * Math.PI) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void morir( )
	{
		map.perder();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void explosionKamikaze( double dmg )
	{
		dmg = utilizarEscudosExplosion( dmg );
		recibirDMG( dmg );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setPos( int posX )
	{
		pos.setX(posX);
	}

	public void setDireccion( int dir )
	{
		this.dir = dir;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
		mover( msDesdeUltAct );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void disparar( )
	{
		if (arma != null)
		{
			List<Disparo> lista = arma.lanzarDisparo(this);
			
			for (Disparo d : lista)
				map.addEntity( d );
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( double msDesdeUltActualizacion )
	{
		double futuraPosX = pos.getX() + dir * conversionEnTiempo(VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion);
		
		if(futuraPosX > 5 && futuraPosX < Juego.GAME_WIDTH - tamano.getWidth()-10) {
			pos.setX(futuraPosX);
		}
		actualizarPosicion();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////