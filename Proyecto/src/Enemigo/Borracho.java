package Enemigo;

import java.awt.Color;
import javax.swing.JPanel;

import Arma.ArmaEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColisionadorKamikaze;
import Inteligencia.IABorracho;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Borracho extends Kamikaze
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Borracho(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IABorracho( map );
		this.dificultad		= dificultad;
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 2) );
		this.tamano			= new Size(30, 15);
		this.arma			= new ArmaEnemigo(map);
		
		this.puntaje		= (int) (dificultad * 50);
		this.explosionDmg	= 10 * dificultad;
		this.vida			= 250 * dificultad;
		
		actualizarPanel( true, new Color( 0, 100, 0 ) );
		
		panel.add( arma.obtenerPanel() );
		colisionador = new ColisionadorKamikaze();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col) {
		col.afectar(this);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}


