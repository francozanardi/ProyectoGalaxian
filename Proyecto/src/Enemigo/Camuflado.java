package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Enemigo.Estados.EstadoComun;
import Escudo.Escudo;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;



public class Camuflado extends Transformable
{
	public Camuflado(Mapa mapa, double dificultad)
	{
		this.map			= mapa;
		this.dificultad		= dificultad;
		
		this.rand			= Randomizador.create( );
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.tamano 		= new Size(15, 15);
		this.escudo			= new LinkedList<Escudo>( );
		this.vida			= 400.0 + (100.0 * dificultad); //tiene más vida que un común normal.
		this.puntaje		= (int) (30 + (10.0 * dificultad));

		actualizarPanel( true, new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ) );
		
		this.estado 		= new EstadoComun(this); //la inteligencia y demás caracteristicas faltantes las determina su estado.

		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearPowerUP();
	}


	public void explotar()
	{
		estado.explotar();
	}
	
	public void recibirDMG(double dmg)
	{
		super.recibirDMG(dmg);
		estado.controlarTransformacion();
	}

	public void transformar()
	{
		estado = estado.transformar();
	}
}
