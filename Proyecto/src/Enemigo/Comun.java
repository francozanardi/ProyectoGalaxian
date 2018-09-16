package Enemigo;

import java.awt.Color;
import javax.swing.JPanel;

import Arma.ArmaEnemigo;
import Colisiones.Colisionador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Inteligencia.IAComun;
import Grafica.Juego;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Comun extends Enemigo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
		
	public Comun( Mapa map, float dificultad )
	{
		this.map = map;
		
		this.ia = new IAComun( map );
		
		this.dificultad = dificultad;
		
		this.puntaje = (int) (dificultad * 30);
		
		this.rand	= new Randomizador();
		this.panel	= new JPanel( );
		this.pos	= new Posicion(rand.nextInt(Juego.GAME_WIDTH), rand.nextInt( Juego.GAME_HEIGHT ));
		this.tamano	= new Size(15, 15);
		this.arma	= new ArmaEnemigo(map);
		this.vida	= 50;

		actualizarPanel( true, new Color( rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) ) );
		
		panel.add( arma.obtenerPanel() );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////
	

}
