package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaDefaultEnemigo;
import Arma.ArmaTriple;
import Colisiones.ColDispEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColisionadorKamikaze;
import Escudo.Escudo;
import Inteligencia.IABorracho;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Borracho extends Enemigo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected double explosionDmg;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Borracho(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IABorracho( map );
		this.dificultad		= dificultad;
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 6) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (dificultad * 50);
		this.explosionDmg	= 100 * dificultad;
		this.vida			= 1000.0 * dificultad;
		
		this.colisionador	= new ColisionadorKamikaze( explosionDmg );
		
		actualizarPanel( true, new Color( 0, 100, 0 ) );
		
		setArma( new ArmaTriple(map, this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI ) );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////