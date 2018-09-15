package Enemigo;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

import Arma.ArmaCuadrado;
import Colisiones.Colisionador;
import Colisiones.ColisionadorKamikaze;
import Grafica.Juego;
import Inteligencia.IAKamikaze;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Kamikaze extends Enemigo
{
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Kamikaze( Mapa map, float dificultad )
	{
		this.map = map;
		
		this.ia = new IAKamikaze( map );
		
		this.dificultad = dificultad;
		
		this.puntaje = (int) (dificultad * 50);
		
		this.rand	= new Randomizador();
		this.panel	= new JPanel( );
		this.pos	= new Posicion(rand.nextInt(Juego.GAME_WIDTH), rand.nextInt( Juego.GAME_HEIGHT ));
		this.tamano	= new Size(30, 15);
		this.arma	= new ArmaCuadrado( );
		this.vida	= 100;
		
		actualizarPanel( true, new Color( 100, 0, 0 ) );
		
		panel.add( arma.obtenerPanel() );
		colisionador = new ColisionadorKamikaze();
	}

	@Override
	public void serChocado(Colisionador col) {
		col.afectarKamikaze(this);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}


