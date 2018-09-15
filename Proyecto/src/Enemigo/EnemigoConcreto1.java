package Enemigo;

import java.awt.Color;
import javax.swing.JPanel;

import Arma.ArmaCuadrado;
import Colisiones.Colisionador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Inteligencia.IAComun;
import Grafica.Juego;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class EnemigoConcreto1 extends Enemigo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
		
	public EnemigoConcreto1( Mapa map, float dificultad )
	{
		this.map = map;
		
		this.ia = new IAComun( map );
		
		this.dificultad = dificultad;
		
		this.puntaje = (int) (dificultad * 30);
		
		this.rand	= new Randomizador();
		this.panel	= new JPanel( );
		this.pos	= new Posicion(rand.nextInt(Juego.GAME_WIDTH), rand.nextInt( Juego.GAME_HEIGHT ));
		this.tamano	= new Size(15, 15);
		this.arma	= new ArmaCuadrado( );
		this.vida	= 50;

		actualizarPanel( true, new Color( rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) ) );
		
		panel.add( arma.obtenerPanel() );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col)
	{
		col.afectarEnemigo(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	

}
