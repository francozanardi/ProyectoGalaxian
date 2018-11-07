package Enemigo;

import java.util.LinkedList;

import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Enemigo.Estados.EstadoComun;
import Escudo.Escudo;
import Logica.Juego;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;



public class Camuflado extends Transformable
{
	public Camuflado(Mapa mapa, double dificultad)
	{
		this.map			= mapa;
		this.dificultad		= dificultad;
		this.rand			= Randomizador.create( );

		setSprite( new Sprite( "/GameSprites/Comun.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.escudo			= new LinkedList<Escudo>( );
		this.vida			= 400.0 + (100.0 * dificultad); //tiene más vida que un común normal.
		this.puntaje		= (int) (30 + (10.0 * dificultad));
		
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
