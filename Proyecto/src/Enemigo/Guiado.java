package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaSniper;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPGuiado;
import Escudo.Escudo;
import Inteligencia.IAKamikaze;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import visitor.ColDispEnemigo;
import visitor.ColKamikaze;



public class Guiado extends Kamikaze
{	
	public Guiado(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IAKamikaze( this );
		this.dificultad		= dificultad;
		
		this.rand			= Randomizador.create( );
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (50 + (10.0 * dificultad));
		this.explosionDmg	= 100 + (12.5 * dificultad);
		this.vida			= 400 + (66.6 * dificultad);

		this.colisionador	= new ColKamikaze( explosionDmg );
			
		actualizarPanel( true, new Color( 100, 0, 0 ) );
		setArma( new ArmaSniper(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		CreadorPowerUP drop = new CreadorPowerUPGuiado(map, dificultad);
		powerUp = drop.crearPowerUP();
	}
}