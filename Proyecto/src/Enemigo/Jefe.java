package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaMinigun;
import Escudo.Escudo;
import Inteligencia.IAComun;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import visitor.ColDispEnemigo;
import visitor.ColEnemigo;
import visitor.Visitor;



public class Jefe extends Enemigo
{	
	public Jefe( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IAComun( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		
		this.rand			= Randomizador.create( );
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.tamano			= new Size(50, 50);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 2000.0 + (100.0 * dificultad);
		this.puntaje		= (int) (200 + (10 * dificultad));

		setArma( new ArmaMinigun(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		actualizarPanel( true, new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ) );
	}
	
	
	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
}