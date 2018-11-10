package Enemigo;

import java.util.LinkedList;

import Arma.ArmaNula;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Enemigo.Estados.EstadoGuiado;
import Escudo.Escudo;
import Logica.Juego;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;


public class Fragil extends Transformable
{	
	public Fragil( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.dificultad		= dificultad;
		this.rand			= Randomizador.create( );
		
		setSprite( new Sprite( "/GameSprites/Guiado.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (50 + (dificultad * 10));
		this.vida			= 400 + (66.6 * dificultad);
		this.estado			= new EstadoGuiado(this); //la inteligencia y demás caracteristicas faltantes las determina su estado.

		setArma(new ArmaNula());
		
		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearPowerUP();
		
		actualizarPosicion();
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