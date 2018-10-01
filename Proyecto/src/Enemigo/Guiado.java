package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaSniper;
import Colisiones.Colisionador;
import Colisiones.ColisionadorKamikaze;
import Escudo.Escudo;
import Inteligencia.IAKamikaze;
import Logica.Juego;
import Mapa.Mapa;
import PowerUp.PowerUpHeal;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Guiado extends Kamikaze
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Guiado(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IAKamikaze( map );
		this.dificultad		= dificultad;
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (dificultad * 50);
		this.explosionDmg	= 100 * dificultad;
		this.vida			= 100 * dificultad;

		this.colisionador	= new ColisionadorKamikaze( explosionDmg );
		
		setPowerUp( new PowerUpHeal(map) );
		
		actualizarPanel( true, new Color( 100, 0, 0 ) );
		
		setArma( new ArmaSniper(map) );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////