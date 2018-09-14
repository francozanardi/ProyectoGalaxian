package Jugador;

import java.awt.Color;
import javax.swing.JPanel;

import Arma.ArmaCuadrado2;
import Colisiones.Colisionador;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Entidad.EntidadConVida;
import Entidad.Personaje;
import Grafica.Posicion;
import Grafica.Size;
import Grafica.Juego;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Jugador extends Personaje
{	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final int	PLAYER_WIDTH = 20,
							PLAYER_HEIGHT = 40;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Jugador( )
	{
		this.panel	= new JPanel( );
		this.pos	= new Posicion((Juego.GAME_WIDTH / 2) - (PLAYER_WIDTH / 2), Juego.GAME_HEIGHT - PLAYER_HEIGHT - 30);
		this.tamano	= new Size(PLAYER_WIDTH, PLAYER_HEIGHT);
		this.vida = 1000;
		this.arma = new ArmaCuadrado2();
		
		
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
	
	public void mover()
	{
	}

	@Override
	public void hacerDMG(Colisionador c, EntidadConVida receptor, Disparo disparo) {
		receptor.recibirDMG(c, this, disparo);	
	}


	@Override
	public void recibirDMG(Colisionador c, Jugador lanzador, Disparo disparo) {
		c.huboColision(lanzador, this, disparo);
		
	}

	@Override
	public void recibirDMG(Colisionador c, Enemigo lanzador, Disparo disparo) {
		c.huboColision(lanzador, this, disparo);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////