package Jugador;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaJugador;
import Colisiones.Colisionador;
import Colisiones.ColisionadorJugador;
import Disparo.Disparo;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Escudo.Escudo;
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
		this.vida			= 400;
		this.arma			= new ArmaJugador(map);
		this.escudo			= new LinkedList<Escudo>( );
		this.colisionador	= new ColisionadorJugador();
		
		actualizarPanel( true, new Color( 255, 255, 255 ) );
		
		addEscudo( new EscudoHealer(this) );
		
		panel.add(arma.obtenerPanel());
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
	
	public void colisionar(EntidadConVida e) { //agregado
		e.serChocado(colisionador);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col) {
		col.afectar(this);
		
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltAct )
	{
		for (Escudo e: escudo)
		{
			e.actualizar( msDesdeUltAct );
		}
		
		mover( msDesdeUltAct );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void disparar( )
	{		
		Disparo d = arma.lanzarDisparo(this);
		
		if (d != null)
			map.agregarEntidad(d);
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