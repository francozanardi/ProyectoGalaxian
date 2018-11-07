package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaDefaultEnemigo;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Escudo.Escudo;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import visitor.ColDispEnemigo;
import visitor.ColEnemigo;
import visitor.Visitor;
import Inteligencia.IAComun;
import Logica.Juego;



public class Comun extends Enemigo
{
	public Comun( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IAComun( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		
		this.rand			= Randomizador.create( );
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.tamano			= new Size(15, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 200.0 + (50.0 * dificultad);
		this.puntaje		= (int) (30 + (10 * dificultad));

		setArma( new ArmaDefaultEnemigo(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		actualizarPanel( true, new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ) );
		
		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearPowerUP();
	}


	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
}