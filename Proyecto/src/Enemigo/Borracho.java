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
import PowerUp.PowerUpEscudoExplosion;
import PowerUp.PowerUpHeal;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Borracho extends Kamikaze
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
		
		this.puntaje		= (int) (50 + (10 * dificultad));
		this.explosionDmg	= 100 + (10.0 * dificultad);
		this.vida			= 600.0 + (100.0 * dificultad);
		
		this.colisionador	= new ColisionadorKamikaze( explosionDmg );
		
		actualizarPanel( true, new Color( 0, 100, 0 ) );
		
		setArma( new ArmaDefaultEnemigo(map, this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI ) );
		setPowerUp( new PowerUpEscudoExplosion(map) );
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////