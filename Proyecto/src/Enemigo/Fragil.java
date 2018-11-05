package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Enemigo.Estados.EstadoGuiado;
import Escudo.Escudo;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;



public class Fragil extends Transformable
{	
	public Fragil( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.dificultad		= dificultad;
		
		this.rand			= Randomizador.create( );
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (50 + (dificultad * 10));
		this.vida			= 400 + (66.6 * dificultad);
		this.estado			= new EstadoGuiado(this); //la inteligencia y demás caracteristicas faltantes las determina su estado.

		setArma( new ArmaSniper(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		actualizarPanel( true, new Color( 100, 100, 100 ) );
		
		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearDrop();
	}
	
	

	public void recibirDMG(double dmg)
	{
		super.recibirDMG(dmg);
		estado.controlarTransformacion();
	}

	public void explotar()
	{
		estado.explotar();		
	}

	public void transformar()
	{
		estado = estado.transformar();
	}
}