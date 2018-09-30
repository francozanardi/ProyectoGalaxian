package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaCannon;
import Arma.ArmaEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColisionadorKamikaze;
import Escudo.Escudo;
import Inteligencia.IABorracho;
import Inteligencia.IAKamikaze;
import Logica.Juego;
import Mapa.Mapa;
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
		this.colisionador	= new ColisionadorKamikaze();
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (dificultad * 50);
		this.explosionDmg	= 10 * dificultad;
		this.vida			= 100 * dificultad;
		
		actualizarPanel( true, new Color( 100, 0, 0 ) );
		
		setArma( new ArmaCannon(map) );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col) {
		col.afectar(this);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}


