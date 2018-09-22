package Jugador;

import java.awt.Color;
import javax.swing.JPanel;

import Arma.ArmaJugador;
import Colisiones.Colisionador;
import Colisiones.ColisionadorJugador;
import Disparo.Disparo;
import Entidad.EntidadConVida;
import Entidad.Personaje;
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
		this.colisionador	= new ColisionadorJugador();
		
		actualizarPanel( true, new Color( 255, 255, 255 ) );
		
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
	
	public void actualizar( double msDesdeUltActualizacion )
	{
		mover( msDesdeUltActualizacion );
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
		double futuraPosX = pos.getX() + dir * calcularVelocidad(VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion);
		
		if(futuraPosX > 5 && futuraPosX < Juego.GAME_WIDTH - tamano.getWidth()-10) {
			pos.setX(futuraPosX);
		}
		actualizarPosicion();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////