package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaDefaultEnemigo;
import Arma.ArmaMinigun;
import Colisiones.ColDispEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColisionadorEnemigo;
import Escudo.Escudo;
import Mapa.Mapa;
import PowerUp.PowerUpMultiplicador;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Inteligencia.IAComun;
import Inteligencia.Inteligencia;
import Logica.Juego;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Comun extends Enemigo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
		
	public Comun( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IAComun( map );
		this.dificultad		= dificultad;
		this.colisionador	= new ColisionadorEnemigo();
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.tamano			= new Size(15, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 200.0 + (50.0 * dificultad);
		this.puntaje		= (int) (30 + (10 * dificultad));

		setArma( new ArmaDefaultEnemigo(map, this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		actualizarPanel( true, new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ) );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////