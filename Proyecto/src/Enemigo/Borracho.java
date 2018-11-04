package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaDefaultEnemigo;
import Colisiones.ColDispEnemigo;
import Colisiones.ColKamikaze;
import Escudo.Escudo;
import Inteligencia.IABorracho;
import Logica.Juego;
import Mapa.Mapa;
import PowerUp.PUEscudoExplosion;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;



public class Borracho extends Kamikaze
{	
	public Borracho(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IABorracho( this );
		this.dificultad		= dificultad;
		
		this.rand			= Randomizador.create( );
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 6) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (50 + (10 * dificultad));
		this.explosionDmg	= 100 + (10.0 * dificultad);
		this.vida			= 600.0 + (100.0 * dificultad);
		
		this.colisionador	= new ColKamikaze( explosionDmg );
		
		actualizarPanel( true, new Color( 0, 100, 0 ) );
		
		setArma( new ArmaDefaultEnemigo(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI ) );
		setPowerUp( new PUEscudoExplosion(map) );
	}
}