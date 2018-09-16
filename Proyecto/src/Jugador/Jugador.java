package Jugador;

import java.awt.Color;
import javax.swing.JPanel;

import Arma.ArmaJugador;
import Colisiones.Colisionador;
import Colisiones.ColisionadorJugador;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Grafica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Jugador extends Personaje
{	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final int	PLAYER_WIDTH = 20,
							PLAYER_HEIGHT = 40;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Jugador()
	{
		this.panel	= new JPanel( );
		this.pos	= new Posicion((Juego.GAME_WIDTH / 2) - (PLAYER_WIDTH / 2), Juego.GAME_HEIGHT - PLAYER_HEIGHT - 30);
		this.tamano	= new Size(PLAYER_WIDTH, PLAYER_HEIGHT);
		this.vida = 1000;
		this.arma = new ArmaJugador(map);
		colisionador = new ColisionadorJugador();
		
		
		actualizarPanel( true, new Color( 255, 255, 255 ) );
		
		panel.add(arma.obtenerPanel());
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setPos( int posX )
	{
		pos.setX(posX);
	}
	
	public void mover( int direccion )
	{
		pos.setX(pos.getX() + (direccion * 2));
		actualizarPosicion();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void colisionar(EntidadConVida e) { //agregado
		e.serChocado(colisionador);
	}


	@Override
	public void serChocado(Colisionador col) {
		col.afectar(this);
		
	}


	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}


	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////